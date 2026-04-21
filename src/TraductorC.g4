grammar TraductorC;

@parser::members {
  private String inputFileName;
  public TraductorCParser(org.antlr.v4.runtime.TokenStream input, String fileName) {
    this(input);
    this.inputFileName = fileName;
  }
}


prg : 'PROGRAM' IDENT ';' dcllist cabecera sentlist 'END' 'PROGRAM' IDENT subproglist ;
dcllist : dcl dcllist | ;
//Problema, dcl podría ser lambda. Solucionar más adelante,
cabecera : 'INTERFACE' cablist 'END' 'INTERFACE' | ;
cablist : cab cablistP ;
cablistP : cab cablistP | ;
cab : decproc | decfun ;

//desaparece decsubprog al inclurise ya en cablist'
/*
La producción decsubprog presentaba recursión y ambigüedad, por lo que se transformó en una estructura de lista LL(1)
mediante factorización, eliminando la recursión y unificando las alternativas en un único no terminal cab.
*/

sentlist : sent sentlistP ;
sentlistP : sent sentlistP | ;
//dcl : defcte | defvar ;
dcl : tipo dclP ;
dclP : defcte | defvar ;
// para evitar ambigüedad, se crea regla auxiliar. No es necesario crear aquí lista de declaraciones.
defcte : ',' 'PARAMETER' '::' IDENT '=' simpvalue ctelist ';' /*defcte |*/ ;
 //igual que defcte, se crea regla auxiliar para evitar ambigüedad
defvar : '::' varlist ';' /*defvar |*/ ;
ctelist : ',' IDENT '=' simpvalue ctelist | ;
simpvalue : NUM_INT_CONST | NUM_REAL_CONST | STRING_CONST ;
tipo : 'INTEGER' | 'REAL' | 'CHARACTER' charlength ;
charlength : '(' NUM_INT_CONST ')' | ;
varlist : IDENT init varlistP ;
varlistP : ',' IDENT init varlistP | ;
init : '=' simpvalue | ;
decproc : 'SUBROUTINE' IDENT formal_paramlist dec_s_paramlist 'END' 'SUBROUTINE' IDENT ;
formal_paramlist : '(' nomparamlist ')' | ;
nomparamlist : IDENT nomparamlistP ;
nomparamlistP : ',' IDENT nomparamlistP | ;
//dec_s_paramlist : tipo ',' 'INTENT' '(' tipoparam ')' IDENT ';' dec_s_paramlist | ;
dec_s_paramlist : dec_s_param dec_s_paramlistP ;
dec_s_paramlistP: dec_s_param dec_s_paramlistP | ;
dec_s_param : tipo ',' 'INTENT' '(' tipoparam ')' IDENT ';' ;
dec_d_paramlist : tipo ',' 'INTENT' '(' tipoparam ')' IDENT ';' ;
tipoparam : 'IN' | 'OUT' | 'INOUT' ;
decfun : 'FUNCTION' IDENT '(' nomparamlist ')' tipo '::' IDENT ';' dec_f_paramlist dec_d_paramlist 'END' 'FUNCTION' IDENT ;
dec_f_paramlist : dec_f_paramlistP ;
dec_f_paramlistP : tipo ',' 'INTENT' '(' 'IN' ')' IDENT ';' dec_f_paramlistP | ;
sent : IDENT '=' exp ';' | proc_call ';' ;
exp : factor expP ;
expP : op factor expP | ;
op : '+' | '-' | '*' | '/' ; //Se sustituye oparit por op, porque no aporta nada nuevo, solo extiende op.
factor : simpvalue | '(' exp ')' | IDENT factorP ;
factorP : '(' exp explist ')' | ;
explist : ',' exp explist | ;
proc_call : 'CALL' IDENT subpparamlist ;
subpparamlist : '(' exp explist ')' | ;
subproglist : subprog subproglist | ;
subprog : codproc | codfun ; //Para evitar ambigüedad, se crea regla auxiliar.
codproc : 'SUBROUTINE' IDENT formal_paramlist dec_s_paramlist dcllist sentlist 'END' 'SUBROUTINE' IDENT ;
codfun : 'FUNCTION' IDENT '(' nomparamlist ')' tipo '::' IDENT ';' dec_f_paramlist dcllist sentlist IDENT '=' exp ';' 'END' 'FUNCTION' IDENT ;


// --------------------
// Léxico
// --------------------
fragment Letras : [a-zA-Z] ;
fragment Digitos : [0-9] ;
IDENT : Letras (Letras | Digitos | '_')* ;
//Arreglado problema con las constantes reales.
NUM_REAL_CONST: [+-]? (Digitos+ '.' Digitos* | '.' Digitos+ | Digitos+ [eE] [+-]? Digitos+) ([eE] [+-]? Digitos+)? ;
NUM_INT_CONST : [+-]? Digitos+ ;
STRING_CONST : '\'' ( ~['\r\n] | '\'\'' )* '\'' ;
COMMENT : '!' ~[\r\n]* -> skip ;
IGNORE : [ \t\r\n]+ -> skip ;
