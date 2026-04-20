grammar TraductorC_v2;
//Traducción dirigida por sintaxis a C

@parser::members {
  private String inputFileName;
  public TraductorCParser(org.antlr.v4.runtime.TokenStream input, String fileName) {
    this(input);
    this.inputFileName = fileName;
  }
}

/*
program ::= defines decfuns partes
defines ::= ʎ | "#define" IDENT ctes defines
ctes ::= CONSTINT | CONSTFLOAT | CONSTLIT
decfuns ::= ʎ | type restdecfun decfuns
type ::= "void" | typevar
restdecfun ::= IDENT "(" listparam ")" ";"
| IDENT "(" "void" ")" ";"
typevar ::= "char" | "int" | "float"
listparam ::= listparam "," type IDENT dim | type IDENT dim
dim ::= ʎ | "[""]"
partes ::= ʎ | part partes
part ::= type restpart
restpart ::= IDENT "(" listparam ")" blq
| IDENT "(" "void" ")" blq
blq ::= "{" sentlist "}"
*/

programa returns [String s]
  : defines decfuns partes
    { $s = $defines.s + $decfuns.s + $partes.s; }
  ;

defines returns [String s]
  : '#define' IDENT ctes defines
    { $s = "#define " + $IDENT.text + " " + $ctes.s + "\n" + $defines.s; }
  |
    { $s = ""; }
  ;

ctes returns [String s]
  : CONSTINT   { $s = $CONSTINT.text; }
  | CONSTFLOAT { $s = $CONSTFLOAT.text; }
  | CONSTLIT   { $s = $CONSTLIT.text; }
  ;

decfuns returns [String s]
  : type restdecfun decfuns
    { $s = $type.s + " " + $restdecfun.s + $decfuns.s; }
  |
    { $s = ""; }
  ;

type returns [String s]
  : 'void'   { $s = "void"; }
  | typevar  { $s = $typevar.s; }
  ;

typevar returns [String s]
  : 'char'  { $s = "char"; }
  | 'int'   { $s = "int"; }
  | 'float' { $s = "float"; }
  ;

restdecfun returns [String s]
  : IDENT '(' listparam ')' ';'
    { $s = $IDENT.text + "(" + $listparam.s + ");\n"; }
  | IDENT '(' 'void' ')' ';'
    { $s = $IDENT.text + "(void);\n"; }
  ;

listparam returns [String s]
  : type IDENT dim listparamP
    { $s = $type.s + " " + $IDENT.text + $dim.s + $listparamP.s; }
  ;

listparamP returns [String s]
  : ',' type IDENT dim listparamP
    { $s = ", " + $type.s + " " + $IDENT.text + $dim.s + $listparamP.s; }
  |
    { $s = ""; }
  ;

dim returns [String s]
  : '[' ']' { $s = "[]"; }
  |         { $s = ""; }
  ;

partes returns [String s]
  : part partes
    { $s = $part.s + $partes.s; }
  |
    { $s = ""; }
  ;

part returns [String s]
  : type restpart
    { $s = $type.s + " " + $restpart.s; }
  ;

restpart returns [String s]
  : IDENT '(' listparam ')' blq
    { $s = $IDENT.text + "(" + $listparam.s + ")\n" + $blq.s; }
  | IDENT '(' 'void' ')' blq
    { $s = $IDENT.text + "(void)\n" + $blq.s; }
  ;

blq returns [String s]
  : '{' sentlist '}'
    { $s = "{\n" + $sentlist.s + "}\n"; }
  ;

/*
sentlist ::= sentlist sent | sent
sent ::= type lid ";" | IDENT "=" exp ";" | IDENT "(" lexp ")" ";"
| IDENT "(" ")" ";" | "return" exp ";"
lid ::= IDENT dims init | lid "," IDENT dims init
dims ::= ʎ | "[" CONSTINT "]"
init ::= ʎ | "=" ctes
lexp ::= exp | lexp "," exp
exp ::= exp op exp | factor
op ::= "+" | "-" | "*" | "/"
factor ::= IDENT "(" lexp ")" | IDENT "(" ")"
| "(" exp ")" | IDENT | ctes
*/

sentlist returns [String s]
  : sent sentlistP
    { $s = $sent.s + $sentlistP.s; }
  ;

sentlistP returns [String s]
  : sent sentlistP
    { $s = $sent.s + $sentlistP.s; }
  |
    { $s = ""; }
  ;

sent returns [String s]
  : type lid ';'
    { $s = "\t" + $type.s + " " + $lid.s + ";\n"; }
  | IDENT '=' exp ';'
    { $s = "\t" + $IDENT.text + " = " + $exp.s + ";\n"; }
  | IDENT '(' lexp ')' ';'
    { $s = "\t" + $IDENT.text + "(" + $lexp.s + ");\n"; }
  | IDENT '(' ')' ';'
    { $s = "\t" + $IDENT.text + "();\n"; }
  | 'return' exp ';'
    { $s = "\treturn " + $exp.s + ";\n"; }
  ;

lid returns [String s]
  : IDENT dims init lidP
    { $s = $IDENT.text + $dims.s + $init.s + $lidP.s; }
  ;

lidP returns [String s]
  : ',' IDENT dims init lidP
    { $s = ", " + $IDENT.text + $dims.s + $init.s + $lidP.s; }
  |
    { $s = ""; }
  ;

dims returns [String s]
  : '[' CONSTINT ']'
    { $s = "[" + $CONSTINT.text + "]"; }
  |
    { $s = ""; }
  ;

init returns [String s]
  : '=' ctes { $s = " = " + $ctes.s; }
  |          { $s = ""; }
  ;

lexp returns [String s]
  : exp lexpP
    { $s = $exp.s + $lexpP.s; }
  ;

lexpP returns [String s]
  : ',' exp lexpP
    { $s = ", " + $exp.s + $lexpP.s; }
  |
    { $s = ""; }
  ;

exp returns [String s]
  : factor expP
    { $s = $factor.s + $expP.s; }
  ;

expP returns [String s]
  : op factor expP
    { $s = " " + $op.s + " " + $factor.s + $expP.s; }
  |
    { $s = ""; }
  ;

op returns [String s]
  : '+' { $s = "+"; }
  | '-' { $s = "-"; }
  | '*' { $s = "*"; }
  | '/' { $s = "/"; }
  ;

factor returns [String s]
  : IDENT '(' lexp ')' { $s = $IDENT.text + "(" + $lexp.s + ")"; }
  | IDENT '(' ')'      { $s = $IDENT.text + "()"; }
  | '(' exp ')'        { $s = "(" + $exp.s + ")"; }
  | IDENT              { $s = $IDENT.text; }
  | ctes               { $s = $ctes.s; }
  ;


// --------------------
// Léxico
// --------------------
fragment Letras : [a-zA-Z] ;
fragment Digitos : [0-9] ;
IDENT : Letras (Letras | Digitos | '_')* ;
CONSTFLOAT: [+-]? (Digitos+ '.' Digitos* | '.' Digitos+ | Digitos+ [eE] [+-]? Digitos+) ([eE] [+-]? Digitos+)? ;
CONSTINT : [+-]? Digitos+ ;
CONSTLIT : '\'' ( ~['\r\n] | '\'\'' )* '\'' ;
COMMENT : '!' ~[\r\n]* -> skip ;
IGNORE : [ \t\r\n]+ -> skip ;
