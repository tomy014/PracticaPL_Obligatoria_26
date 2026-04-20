grammar TraductorC_v2;
//Traducción a sintaxtis

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

programa : defines decfuns partes ;
defines: '#define' IDENT ctes defines | ;
ctes: CONSTINT | CONSTFLOAT | CONSTLIT;
decfuns : type restdecfun decfuns | ;
type : 'void' | typevar ;
typevar : 'char' | 'int' | 'float' ;
restdecfun : IDENT '(' listparam ')' ';' | IDENT '(' 'void' ')' ';' ;
listparam : type IDENT dim listparamP ;
listparamP : ',' type IDENT dim listparamP | ;
dim : '[' ']' | ;
partes : part partes | ;
part : type restpart ;
restpart : IDENT '(' listparam ')' blq | IDENT '(' 'void' ')' blq ;
blq : '{' sentlist '}' ;

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

sentlist : sent sentlistP ;
sentlistP : sent sentlistP | ;
sent : type lid ';' | IDENT '=' exp ';' | IDENT '(' lexp ')' ';' | IDENT '(' ')' ';' | 'return' exp ';' ;
lid : IDENT dims init lidP ;
lidP : ',' IDENT dims init lidP | ;
dims : '[' CONSTINT ']' | ;
init : '=' ctes | ;
lexp : exp lexpP ;
lexpP : ',' exp lexpP | ;
exp : factor expP ;
expP : op factor expP | ;
op : '+' | '-' | '*' | '/' ;
factor : IDENT '(' lexp ')' | IDENT '(' ')' | '(' exp ')' | IDENT | ctes ;


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
