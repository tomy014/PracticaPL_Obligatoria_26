grammar TraductorC_v2;
// Traducción dirigida por sintaxis: Lenguaje fuente (Fortran-like) -> Lenguaje final (C-like)

@parser::members {
  private String inputFileName;
  private StringBuilder definesBuffer = new StringBuilder();
  private java.util.Map<String, Integer> interfaceParams = new java.util.HashMap<>();

  public TraductorC_v2Parser(org.antlr.v4.runtime.TokenStream input, String fileName) {
    this(input);
    this.inputFileName = fileName;
  }

  private String convertString(String s) {
    if (s.startsWith("\"")) return s;
    String inner = s.substring(1, s.length() - 1);
    inner = inner.replace("''", "'");
    inner = inner.replace("\"", "\\\"");
    return "\"" + inner + "\"";
  }

  private void checkClosingName(String kind, org.antlr.v4.runtime.Token start, org.antlr.v4.runtime.Token end) {
    if (!start.getText().equals(end.getText())) {
      notifyErrorListeners(end, "el nombre de cierre de " + kind + " '" + end.getText()
        + "' no coincide con '" + start.getText() + "'", null);
    }
  }

  private void saveInterfaceParams(String name, int count) {
    interfaceParams.put(name, count);
  }

  private void checkDeclaredParamCount(String kind, org.antlr.v4.runtime.Token name, int formalCount, int declaredCount) {
    if (formalCount != declaredCount) {
      notifyErrorListeners(name, "la declaracion de " + kind + " '" + name.getText()
        + "' tiene " + formalCount + " parametros en la cabecera y " + declaredCount
        + " parametros tipados", null);
    }
  }

  private void checkCallParamCount(org.antlr.v4.runtime.Token name, int actualCount) {
    Integer expectedCount = interfaceParams.get(name.getText());
    if (expectedCount != null && expectedCount != actualCount) {
      notifyErrorListeners(name, "la llamada a '" + name.getText() + "' tiene "
        + actualCount + " parametros, pero su declaracion tiene " + expectedCount, null);
    }
  }

  private void checkReturnVarName(org.antlr.v4.runtime.Token functionName, org.antlr.v4.runtime.Token returnVar) {
    if (!functionName.getText().equals(returnVar.getText())) {
      notifyErrorListeners(returnVar, "el nombre de la variable de retorno '" + returnVar.getText()
        + "' no coincide con el nombre de la funcion '" + functionName.getText() + "'", null);
    }
  }
}

// --------------------
// Reglas sintácticas
// --------------------
// Traduce el programa principal, establece cabecera y lista de sentencias.
prg returns [String s]
  : 'PROGRAM' pname=IDENT ';' dcllist cabecera sentlist 'END' 'PROGRAM' endname=IDENT subproglist
    { checkClosingName("programa", $pname, $endname);
      $s = definesBuffer.toString()
           + $cabecera.s
           + $subproglist.s
           + "void main(void)\n{\n" + $dcllist.s + $sentlist.s + "}\n"; }
  ;
// Lista de declaraciones.
dcllist returns [String s]
  : dcl dcllist { $s = $dcl.s + $dcllist.s; }
  |             { $s = ""; }
  ;
// Traduce una cabecera INTERFACE con sus subprogramas o la omite si no existe.
cabecera returns [String s]
  : 'INTERFACE' cablist 'END' 'INTERFACE'
    { $s = $cablist.s + "\n"; }
  |
    { $s = ""; }
  ;
// Lista de cabeceras de subprogramas, concatenando sus traducciones.
cablist returns [String s]
  : cab cablistP { $s = $cab.s + $cablistP.s; }
  ;
// Lista prima de cabeceras de subprogramas, continuando la lista o terminándola.
cablistP returns [String s]
  : cab cablistP { $s = $cab.s + $cablistP.s; }
  |              { $s = ""; }
  ;
// Decide si la cabecera corresponde a un subprograma o a una función.
cab returns [String s]
  : decproc { $s = $decproc.s; }
  | decfun  { $s = $decfun.s; }
  ;
// Concatena la traducción de las sentencias ejecutables del bloque.
sentlist returns [String s]
  : sent sentlistP { $s = $sent.s + $sentlistP.s; }
  ;
// Lista prima de sentencias. Continúa la lista o la termina.
sentlistP returns [String s]
  : sent sentlistP { $s = $sent.s + $sentlistP.s; }
  |                { $s = ""; }
  ;
// Declaración de variables o constantes, traducida según el tipo declarado.
dcl returns [String s]
  : tipo dclP[$tipo.ctype, $tipo.arraydim] { $s = $dclP.s; }
  ;
// Declaración prima, decide si se trata de constantes PARAMETER o variables normales.
dclP[String ctype, String arraydim] returns [String s]
  : defcte[$ctype]             { $s = ""; }
  | defvar[$ctype, $arraydim]  { $s = $defvar.s; }
  ;
// Traduce constantes PARAMETER a macros #define acumuladas al inicio del fichero.
defcte[String ctype] returns [String s]
  : ',' 'PARAMETER' '::' IDENT '=' simpvalue ctelist ';'
    { definesBuffer.append("#define " + $IDENT.text + " " + $simpvalue.s + "\n");
      definesBuffer.append($ctelist.s);
      $s = ""; }
  ;
// Traduce variables normales a declaraciones tipadas en C, incluyendo arrays e inicializaciones.
defvar[String ctype, String arraydim] returns [String s]
  : '::' varlist[$ctype, $arraydim] ';'
    { $s = "\t" + $ctype + " " + $varlist.s + ";\n"; }
  ;
// Lista de constantes en PARAMETER, concatenando sus traducciones a macros.
ctelist returns [String s]
  : ',' IDENT '=' simpvalue ctelist
    { $s = "#define " + $IDENT.text + " " + $simpvalue.s + "\n" + $ctelist.s; }
  |
    { $s = ""; }
  ;
// Traduce un literal simple.
simpvalue returns [String s]
  : NUM_INT_CONST  { $s = $NUM_INT_CONST.text; }
  | NUM_REAL_CONST { $s = $NUM_REAL_CONST.text; }
  | STRING_CONST   { $s = convertString($STRING_CONST.text); }
  ;
// Convierte los tipos fuente a sus tipos equivalentes en C.
tipo returns [String ctype, String arraydim]
  : 'INTEGER'              { $ctype = "int";   $arraydim = ""; }
  | 'REAL'                 { $ctype = "float"; $arraydim = ""; }
  | 'CHARACTER' charlength { $ctype = "char";  $arraydim = $charlength.s; }
  ;
// Traduce la longitud de CHARACTER a notación de array en C.
charlength returns [String s]
  : '(' NUM_INT_CONST ')' { $s = "[" + $NUM_INT_CONST.text + "]"; }
  |                       { $s = ""; }
  ;
// Traduce una lista de variables, incluyendo arrays e inicializaciones.
varlist[String ctype, String arraydim] returns [String s]
  : IDENT init varlistP[$ctype, $arraydim]
    { $s = $IDENT.text + $arraydim + $init.s + $varlistP.s; }
  ;
// Lista prima de variables, continuando la lista o terminándola.
varlistP[String ctype, String arraydim] returns [String s]
  : ',' IDENT init varlistP[$ctype, $arraydim]
    { $s = ", " + $IDENT.text + $arraydim + $init.s + $varlistP.s; }
  |
    { $s = ""; }
  ;
// Traduce una inicialización opcional al formato de asignación en C.
init returns [String s]
  : '=' simpvalue { $s = " = " + $simpvalue.s; }
  | { $s = ""; }
  ;
// Traduce la cabecera de una subrutina a un prototipo void en C.
decproc returns [String s]
  : 'SUBROUTINE' fname=IDENT formal_paramlist dec_s_paramlist 'END' 'SUBROUTINE' endname=IDENT
    { checkClosingName("subrutina", $fname, $endname);
      checkDeclaredParamCount("subrutina", $fname, $formal_paramlist.n, $dec_s_paramlist.n);
      saveInterfaceParams($fname.text, $formal_paramlist.n);
      $s = "void " + $fname.text + "(" + ($dec_s_paramlist.s.isEmpty() ? "void" : $dec_s_paramlist.s) + ");\n"; }
  ;
// Traduce la lista formal de nombres de parámetros si aparece entre paréntesis, o genera una lista vacía si no existe.
formal_paramlist returns [String s, int n]
  : '(' nomparamlist ')' { $s = $nomparamlist.s; $n = $nomparamlist.n; }
  | { $s = ""; $n = 0; }
  ;
// Traduce una lista de nombres de parámetros preservando su orden.
nomparamlist returns [String s, int n]
  : IDENT nomparamlistP { $s = $IDENT.text + $nomparamlistP.s; $n = 1 + $nomparamlistP.n; }
  ;
// Lista prima de nombres de parámetros, continuando la lista con comas o terminándola.
nomparamlistP returns [String s, int n]
  : ',' IDENT nomparamlistP { $s = ", " + $IDENT.text + $nomparamlistP.s; $n = 1 + $nomparamlistP.n; }
  |                         { $s = ""; $n = 0; }
  ;
// Declara y traduce la lista de parámetros de una subrutina, concatenando cada parámetro traducido.
dec_s_paramlist returns [String s, int n]
  : dec_s_param dec_s_paramlistP
    { $s = $dec_s_param.s + $dec_s_paramlistP.s; $n = 1 + $dec_s_paramlistP.n; }
  |
    { $s = ""; $n = 0; }
  ;
// Lista prima de parámetros de una subrutina, continuando la lista con comas o terminándola.
dec_s_paramlistP returns [String s, int n]
  : dec_s_param dec_s_paramlistP
    { $s = ", " + $dec_s_param.s + $dec_s_paramlistP.s; $n = 1 + $dec_s_paramlistP.n; }
  |
    { $s = ""; $n = 0; }
  ;
// Traduce un parámetro de una subrutina,a argumento de C, incluyendo tipo, nombre y posible dimensión de array.
dec_s_param returns [String s]
  : tipo ',' 'INTENT' '(' tipoparam ')' IDENT ';'
    { $s = $tipo.ctype + " " + $IDENT.text + ($tipo.arraydim.isEmpty() ? "" : "[]"); }
  ;
// Traduce un parámetro de una función, a argumento de C, incluyendo tipo, nombre y posible dimensión de array.
dec_d_paramlist returns [String s, int n]
  : tipo ',' 'INTENT' '(' tipoparam ')' IDENT ';'
    { $s = $tipo.ctype + " " + $IDENT.text + ($tipo.arraydim.isEmpty() ? "" : "[]"); $n = 1; }
  ;
// Declara el tipo de parámetro según su intención (IN, OUT, INOUT).
tipoparam : 'IN' | 'OUT' | 'INOUT' ;
// Traduce la cabecera de una función, incluyendo su tipo de retorno.
decfun returns [String s]
  : 'FUNCTION' fname=IDENT '(' nomparamlist ')' tipo '::' retvar=IDENT ';'
    dec_f_paramlist dec_d_paramlist 'END' 'FUNCTION' endname=IDENT
    { checkClosingName("funcion", $fname, $endname);
      checkReturnVarName($fname, $retvar);
      checkDeclaredParamCount("funcion", $fname, $nomparamlist.n, $dec_f_paramlist.n + $dec_d_paramlist.n);
      saveInterfaceParams($fname.text, $nomparamlist.n);
      $s = $tipo.ctype + " " + $fname.text + "(" +
           ($dec_f_paramlist.s.isEmpty() ? "" : $dec_f_paramlist.s + ", ") +
           $dec_d_paramlist.s + ");\n"; }
  ;
// Traduce la lista de parámetros de una función, concatenando cada parámetro traducido.
dec_f_paramlist returns [String s, int n]
  : dec_f_paramlistP { $s = $dec_f_paramlistP.s; $n = $dec_f_paramlistP.n; }
  ;
// Lista prima de parámetros de una función, continuando la lista con comas o terminándola. Solo se traducen parámetros de entrada (INTENT(IN)).
dec_f_paramlistP returns [String s, int n]
  : tipo ',' 'INTENT' '(' 'IN' ')' IDENT ';' rest=dec_f_paramlistP
    { $s = $tipo.ctype + " " + $IDENT.text + ($tipo.arraydim.isEmpty() ? "" : "[]") +
           ($rest.s.isEmpty() ? "" : ", " + $rest.s);
      $n = 1 + $rest.n; }
  |
    { $s = ""; $n = 0; }
  ;
// Sentencia ejecutable, traducida a asignación o llamada a función según corresponda.
sent returns [String s]
  : IDENT '=' exp ';' { $s = "\t" + $IDENT.text + " = " + $exp.s + ";\n"; }
  | proc_call ';'     { $s = "\t" + $proc_call.s + ";\n"; }
  ;
// Traduce una expresión, concatenando la traducción del factor inicial con la continuación de la expresión binaria.
exp returns [String s]
  : factor expP { $s = $factor.s + $expP.s; }
  ;
// Lista prima de operadores y factores, concatenando cada operador y factor con el resultado acumulado.
expP returns [String s]
  : op factor expP { $s = " " + $op.s + " " + $factor.s + $expP.s; }
  |                { $s = ""; }
  ;
// Operadores aritméticos traducidos.
op returns [String s]
  : '+' { $s = "+"; }
  | '-' { $s = "-"; }
  | '*' { $s = "*"; }
  | '/' { $s = "/"; }
  ;
// Traduce un factor, que puede ser un valor simple, una expresión entre paréntesis o un identificador con posible lista de argumentos.
factor returns [String s]
  : simpvalue       { $s = $simpvalue.s; }
  | '(' exp ')'     { $s = "(" + $exp.s + ")"; }
  | IDENT factorP   { if ($factorP.isCall) checkCallParamCount($IDENT, $factorP.n);
                      $s = $IDENT.text + $factorP.s; }
  ;
// Lista prima de argumentos de un identificador, traduciendo la lista de argumentos si aparece entre paréntesis o generando una cadena vacía si no existe.
factorP returns [String s, int n, boolean isCall]
  : '(' exp explist ')' { $s = "(" + $exp.s + $explist.s + ")"; $n = 1 + $explist.n; $isCall = true; }
  |                     { $s = ""; $n = 0; $isCall = false; }
  ;
// Traduce el resto de argumentos de una llamada o lista de expresiones.
explist returns [String s, int n]
  : ',' exp explist { $s = ", " + $exp.s + $explist.s; $n = 1 + $explist.n; }
  |                 { $s = ""; $n = 0; }
  ;
// Traduce una llamada a procedimiento, concatenando el nombre del procedimiento con la traducción de su lista de argumentos.
proc_call returns [String s]
  : 'CALL' IDENT subpparamlist { checkCallParamCount($IDENT, $subpparamlist.n);
                                 $s = $IDENT.text + $subpparamlist.s; }
  ;
// Traduce la lista de argumentos reales de una llamada; si falta, genera ().
subpparamlist returns [String s, int n]
  : '(' exp explist ')' { $s = "(" + $exp.s + $explist.s + ")"; $n = 1 + $explist.n; }
  |                     { $s = "()"; $n = 0; }
  ;
// Concatena la traducción de los subprogramas definidos en el programa principal, o genera una cadena vacía si no hay subprogramas.
subproglist returns [String s]
  : subprog subproglist { $s = $subprog.s + $subproglist.s; }
  |                     { $s = ""; }
  ;
// Decide si el subprograma es un procedimiento o una función, y concatena su traducción.
subprog returns [String s]
  : codproc { $s = $codproc.s; }
  | codfun  { $s = $codfun.s; }
  ;
// Función completa, traducida a un procedimiento void en C, incluyendo su cuerpo con declaraciones y sentencias.
codproc returns [String s]
  : 'SUBROUTINE' fname=IDENT formal_paramlist dec_s_paramlist dcllist sentlist
    'END' 'SUBROUTINE' endname=IDENT
    { checkClosingName("subrutina", $fname, $endname);
      checkDeclaredParamCount("subrutina", $fname, $formal_paramlist.n, $dec_s_paramlist.n);
      $s = "void " + $fname.text + "(" + ($dec_s_paramlist.s.isEmpty() ? "void" : $dec_s_paramlist.s) + ")\n{\n"
           + $dcllist.s + $sentlist.s + "}\n\n"; }
  ;
// Función completa, traducida a una función con tipo de retorno, incluyendo su cuerpo con declaraciones y sentencias, y la instrucción return al final.
codfun returns [String s]
  : 'FUNCTION' fname=IDENT '(' nomparamlist ')' tipo '::' retvar=IDENT ';'
    dec_f_paramlist dcllist sentlist retname=IDENT '=' exp ';'
    'END' 'FUNCTION' endname=IDENT
    { checkClosingName("funcion", $fname, $endname);
      checkReturnVarName($fname, $retvar);
      checkReturnVarName($fname, $retname);
      checkDeclaredParamCount("funcion", $fname, $nomparamlist.n, $dec_f_paramlist.n);
      $s = $tipo.ctype + " " + $fname.text + "(" + $dec_f_paramlist.s + ")\n{\n"
           + $dcllist.s + $sentlist.s + "\treturn " + $exp.s + ";\n}\n\n"; }
  ;


// --------------------
// Léxico
// --------------------
fragment Letras: [a-zA-Z] ;
fragment Digitos: [0-9] ;

IDENT: Letras (Letras | Digitos | '_')* ;
NUM_REAL_CONST: [+-]? (Digitos+ '.' Digitos* | '.' Digitos+ | Digitos+ [eE] [+-]? Digitos+) ([eE] [+-]? Digitos+)? ;
NUM_INT_CONST: [+-]? Digitos+ ;
STRING_CONST: '\'' ( ~['\r\n] | '\'\'' )* '\'' | '"' ( ~["\r\n] | '\\"' )* '"' ;
COMMENT: '!' ~[\r\n]* -> skip ;
IGNORE: [ \t\r\n]+ -> skip ;
