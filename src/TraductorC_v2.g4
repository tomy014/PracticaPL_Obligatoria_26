grammar TraductorC_v2;
// Traducción dirigida por sintaxis: Lenguaje fuente (Fortran-like) -> Lenguaje final (C-like)

@parser::members {
  private String inputFileName;
  private StringBuilder definesBuffer = new StringBuilder();

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
}

// --------------------
// Reglas sintácticas
// --------------------

prg returns [String s]
  : 'PROGRAM' IDENT ';' dcllist cabecera sentlist 'END' 'PROGRAM' IDENT subproglist
    { $s = definesBuffer.toString()
           + $cabecera.s
           + $subproglist.s
           + "void main(void)\n{\n" + $dcllist.s + $sentlist.s + "}\n"; }
  ;

dcllist returns [String s]
  : dcl dcllist { $s = $dcl.s + $dcllist.s; }
  |             { $s = ""; }
  ;

cabecera returns [String s]
  : 'INTERFACE' cablist 'END' 'INTERFACE'
    { $s = $cablist.s + "\n"; }
  |
    { $s = ""; }
  ;

cablist returns [String s]
  : cab cablistP { $s = $cab.s + $cablistP.s; }
  ;

cablistP returns [String s]
  : cab cablistP { $s = $cab.s + $cablistP.s; }
  |              { $s = ""; }
  ;

cab returns [String s]
  : decproc { $s = $decproc.s; }
  | decfun  { $s = $decfun.s; }
  ;

sentlist returns [String s]
  : sent sentlistP { $s = $sent.s + $sentlistP.s; }
  ;

sentlistP returns [String s]
  : sent sentlistP { $s = $sent.s + $sentlistP.s; }
  |                { $s = ""; }
  ;

dcl returns [String s]
  : tipo dclP[$tipo.ctype, $tipo.arraydim] { $s = $dclP.s; }
  ;

dclP[String ctype, String arraydim] returns [String s]
  : defcte[$ctype]             { $s = ""; }
  | defvar[$ctype, $arraydim]  { $s = $defvar.s; }
  ;

defcte[String ctype] returns [String s]
  : ',' 'PARAMETER' '::' IDENT '=' simpvalue ctelist ';'
    { definesBuffer.append("#define " + $IDENT.text + " " + $simpvalue.s + "\n");
      definesBuffer.append($ctelist.s);
      $s = ""; }
  ;

defvar[String ctype, String arraydim] returns [String s]
  : '::' varlist[$ctype, $arraydim] ';'
    { $s = "\t" + $ctype + " " + $varlist.s + ";\n"; }
  ;

ctelist returns [String s]
  : ',' IDENT '=' simpvalue ctelist
    { $s = "#define " + $IDENT.text + " " + $simpvalue.s + "\n" + $ctelist.s; }
  |
    { $s = ""; }
  ;

simpvalue returns [String s]
  : NUM_INT_CONST  { $s = $NUM_INT_CONST.text; }
  | NUM_REAL_CONST { $s = $NUM_REAL_CONST.text; }
  | STRING_CONST   { $s = convertString($STRING_CONST.text); }
  ;

tipo returns [String ctype, String arraydim]
  : 'INTEGER'              { $ctype = "int";   $arraydim = ""; }
  | 'REAL'                 { $ctype = "float"; $arraydim = ""; }
  | 'CHARACTER' charlength { $ctype = "char";  $arraydim = $charlength.s; }
  ;

charlength returns [String s]
  : '(' NUM_INT_CONST ')' { $s = "[" + $NUM_INT_CONST.text + "]"; }
  |                       { $s = ""; }
  ;

varlist[String ctype, String arraydim] returns [String s]
  : IDENT init varlistP[$ctype, $arraydim]
    { $s = $IDENT.text + $arraydim + $init.s + $varlistP.s; }
  ;

varlistP[String ctype, String arraydim] returns [String s]
  : ',' IDENT init varlistP[$ctype, $arraydim]
    { $s = ", " + $IDENT.text + $arraydim + $init.s + $varlistP.s; }
  |
    { $s = ""; }
  ;

init returns [String s]
  : '=' simpvalue { $s = " = " + $simpvalue.s; }
  |               { $s = ""; }
  ;

decproc returns [String s]
  : 'SUBROUTINE' fname=IDENT formal_paramlist dec_s_paramlist 'END' 'SUBROUTINE' IDENT
    { $s = "void " + $fname.text + "(" + ($dec_s_paramlist.s.isEmpty() ? "void" : $dec_s_paramlist.s) + ");\n"; }
  ;

formal_paramlist returns [String s]
  : '(' nomparamlist ')' { $s = $nomparamlist.s; }
  |                      { $s = ""; }
  ;

nomparamlist returns [String s]
  : IDENT nomparamlistP { $s = $IDENT.text + $nomparamlistP.s; }
  ;

nomparamlistP returns [String s]
  : ',' IDENT nomparamlistP { $s = ", " + $IDENT.text + $nomparamlistP.s; }
  |                         { $s = ""; }
  ;

dec_s_paramlist returns [String s]
  : dec_s_param dec_s_paramlistP
    { $s = $dec_s_param.s + $dec_s_paramlistP.s; }
  |
    { $s = ""; }
  ;

dec_s_paramlistP returns [String s]
  : dec_s_param dec_s_paramlistP
    { $s = ", " + $dec_s_param.s + $dec_s_paramlistP.s; }
  |
    { $s = ""; }
  ;

dec_s_param returns [String s]
  : tipo ',' 'INTENT' '(' tipoparam ')' IDENT ';'
    { $s = $tipo.ctype + " " + $IDENT.text + ($tipo.arraydim.isEmpty() ? "" : "[]"); }
  ;

dec_d_paramlist returns [String s]
  : tipo ',' 'INTENT' '(' tipoparam ')' IDENT ';'
    { $s = $tipo.ctype + " " + $IDENT.text + ($tipo.arraydim.isEmpty() ? "" : "[]"); }
  ;

tipoparam : 'IN' | 'OUT' | 'INOUT' ;

decfun returns [String s]
  : 'FUNCTION' fname=IDENT '(' nomparamlist ')' tipo '::' retvar=IDENT ';'
    dec_f_paramlist dec_d_paramlist 'END' 'FUNCTION' IDENT
    { $s = $tipo.ctype + " " + $fname.text + "(" +
           ($dec_f_paramlist.s.isEmpty() ? "" : $dec_f_paramlist.s + ", ") +
           $dec_d_paramlist.s + ");\n"; }
  ;

dec_f_paramlist returns [String s]
  : dec_f_paramlistP { $s = $dec_f_paramlistP.s; }
  ;

dec_f_paramlistP returns [String s]
  : tipo ',' 'INTENT' '(' 'IN' ')' IDENT ';' rest=dec_f_paramlistP
    { $s = $tipo.ctype + " " + $IDENT.text + ($tipo.arraydim.isEmpty() ? "" : "[]") +
           ($rest.s.isEmpty() ? "" : ", " + $rest.s); }
  |
    { $s = ""; }
  ;

sent returns [String s]
  : IDENT '=' exp ';' { $s = "\t" + $IDENT.text + " = " + $exp.s + ";\n"; }
  | proc_call ';'     { $s = "\t" + $proc_call.s + ";\n"; }
  ;

exp returns [String s]
  : factor expP { $s = $factor.s + $expP.s; }
  ;

expP returns [String s]
  : op factor expP { $s = " " + $op.s + " " + $factor.s + $expP.s; }
  |                { $s = ""; }
  ;

op returns [String s]
  : '+' { $s = "+"; }
  | '-' { $s = "-"; }
  | '*' { $s = "*"; }
  | '/' { $s = "/"; }
  ;

factor returns [String s]
  : simpvalue       { $s = $simpvalue.s; }
  | '(' exp ')'     { $s = "(" + $exp.s + ")"; }
  | IDENT factorP   { $s = $IDENT.text + $factorP.s; }
  ;

factorP returns [String s]
  : '(' exp explist ')' { $s = "(" + $exp.s + $explist.s + ")"; }
  |                     { $s = ""; }
  ;

explist returns [String s]
  : ',' exp explist { $s = ", " + $exp.s + $explist.s; }
  |                 { $s = ""; }
  ;

proc_call returns [String s]
  : 'CALL' IDENT subpparamlist { $s = $IDENT.text + $subpparamlist.s; }
  ;

subpparamlist returns [String s]
  : '(' exp explist ')' { $s = "(" + $exp.s + $explist.s + ")"; }
  |                     { $s = "()"; }
  ;

subproglist returns [String s]
  : subprog subproglist { $s = $subprog.s + $subproglist.s; }
  |                     { $s = ""; }
  ;

subprog returns [String s]
  : codproc { $s = $codproc.s; }
  | codfun  { $s = $codfun.s; }
  ;

codproc returns [String s]
  : 'SUBROUTINE' fname=IDENT formal_paramlist dec_s_paramlist dcllist sentlist
    'END' 'SUBROUTINE' IDENT
    { $s = "void " + $fname.text + "(" + ($dec_s_paramlist.s.isEmpty() ? "void" : $dec_s_paramlist.s) + ")\n{\n"
           + $dcllist.s + $sentlist.s + "}\n\n"; }
  ;

codfun returns [String s]
  : 'FUNCTION' fname=IDENT '(' nomparamlist ')' tipo '::' retvar=IDENT ';'
    dec_f_paramlist dcllist sentlist retname=IDENT '=' exp ';'
    'END' 'FUNCTION' IDENT
    { $s = $tipo.ctype + " " + $fname.text + "(" + $dec_f_paramlist.s + ")\n{\n"
           + $dcllist.s + $sentlist.s + "\treturn " + $exp.s + ";\n}\n\n"; }
  ;


// --------------------
// Léxico
// --------------------
fragment Letras  : [a-zA-Z] ;
fragment Digitos : [0-9] ;
IDENT          : Letras (Letras | Digitos | '_')* ;
NUM_REAL_CONST : [+-]? (Digitos+ '.' Digitos* | '.' Digitos+ | Digitos+ [eE] [+-]? Digitos+) ([eE] [+-]? Digitos+)? ;
NUM_INT_CONST  : [+-]? Digitos+ ;
STRING_CONST   : '\'' ( ~['\r\n] | '\'\'' )* '\''
               | '"'  ( ~["\r\n] | '\\"'  )* '"'  ;
COMMENT        : '!' ~[\r\n]* -> skip ;
IGNORE         : [ \t\r\n]+ -> skip ;