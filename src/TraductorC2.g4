grammar TraductorC2;

@parser::members { private String inputFileName; public TraductorCParser(TokenStream input, String fileName) { this(input); this.inputFileName = fileName; } }

// BNF (todas las reglas con ε a la derecha, homogéneo):
// <prg> ::= 'PROGRAM' IDENT ';' dcllist cabecera sentlist 'END'
// <dcllist> ::= dcl dcllist | ε
// <cabecera> ::= 'INTERFACE' cablist 'END' 'INTERFACE' | ε
// <cablist> ::= decproc decsubprog | decfun decsubprog
// <decsubprog> ::= decproc decsubprog | decfun decsubprog | ε
// <sentlist> ::= sent sentlist | sent
// <dcl> ::= defcte | defvar
// <defcte> ::= tipo ',' 'PARAMETER' '::' IDENT '=' simpvalue ctelist ';' defcte | ε
// <ctelist> ::= IDENT '=' simpvalue ',' ctelist | ε
// <simpvalue> ::= NUM_INT_CONST | NUM_REAL_CONST | STRING_CONST
// <mixedvalue> ::= NUM_INT_CONST '::' NUM_REAL_CONST
// <defvar> ::= tipo '::' varlist ';' defvar | ε
// <tipo> ::= 'INTEGER' | 'REAL' | 'CHARACTER' charlength
// <charlength> ::= '(' NUM_INT_CONST ')' | ε
// <varlist> ::= varlist ',' IDENT init | IDENT init
// <init> ::= '=' simpvalue | ε
// <decproc> ::= 'SUBROUTINE' IDENT formal_paramlist dec_s_paramlist 'END' 'SUBROUTINE' IDENT
// <formal_paramlist> ::= '(' nomparamlist ')' | ε
// <nomparamlist> ::= IDENT ',' nomparamlist | IDENT
// <dec_s_paramlist> ::= tipo ',' 'INTENT' '(' tipoparam ')' IDENT ';' dec_s_paramlist | ε
// <tipoparam> ::= 'IN' | 'OUT' | 'INOUT'
// <decfun> ::= 'FUNCTION' IDENT '(' nomparamlist ')' tipo '::' IDENT ';' dec_f_paramlist 'END' 'FUNCTION' IDENT
// <dec_f_paramlist> ::= dec_f_paramlist tipo ',' 'INTENT' '(' 'IN' ')' IDENT ';' | ε
// <sent> ::= IDENT '=' exp ';' | proc_call ';'
// <exp> ::= exp op exp | factor
// <op> ::= oparit
// <oparit> ::= '+' | '-' | '*' | '/'
// <factor> ::= simpvalue | '(' exp ')' | IDENT '(' exp explist ')' | IDENT
// <explist> ::= ',' exp explist | ε
// <proc_call> ::= 'CALL' IDENT subpparamlist
// <subpparamlist> ::= '(' exp explist ')' | ε
// <subproglist> ::= codproc subproglist | codfun subproglist | ε
// <codproc> ::= 'SUBROUTINE' IDENT formal_paramlist dec_s_paramlist dcllist sent sentlist 'END' 'SUBROUTINE' IDENT
// <codfun> ::= 'FUNCTION' IDENT '(' nomparamlist ')' tipo '::' IDENT ';' dec_f_paramlist dcllist sent sentlist IDENT '=' exp ';' 'END' 'FUNCTION' IDENT
// <type> ::= IDENT | 'integer' | 'real' | 'char'

prg : 'PROGRAM' IDENT ';' dcllist cabecera sentlist 'END' ;
dcllist : dcl dcllist | /* empty */ ;
cabecera : 'INTERFACE' cablist 'END' 'INTERFACE' | /* empty */ ;
cablist : decproc decsubprog | decfun decsubprog ;
decsubprog : decproc decsubprog | decfun decsubprog | /* empty */ ;
sentlist : sent sentlist | sent ;
dcl : defcte | defvar ;
// defcte: lista (0 o más) de declaraciones de constantes
defcte : tipo ',' 'PARAMETER' '::' IDENT '=' simpvalue ctelist ';' defcte | /* empty */ ;
ctelist : IDENT '=' simpvalue ',' ctelist | /* empty */ ;

// defvar: cero o más declaraciones de variable (convertido a forma iterativa)
defvar : ( tipo '::' varlist ';' )* ;
varlist : IDENT init (',' IDENT init)* ;
init : '=' simpvalue | /* empty */ ;

simpvalue : NUM_INT_CONST | NUM_REAL_CONST | STRING_CONST ;
mixedvalue : NUM_INT_CONST '::' NUM_REAL_CONST ;

tipo : 'INTEGER' | 'REAL' | 'CHARACTER' charlength ;
charlength : '(' NUM_INT_CONST ')' | /* empty */ ;

// parámetros y subprogramas
decproc : 'SUBROUTINE' IDENT formal_paramlist dec_s_paramlist 'END' 'SUBROUTINE' IDENT ;
formal_paramlist : '(' nomparamlist ')' | /* empty */ ;
nomparamlist : IDENT (',' IDENT)* ;
dec_s_paramlist : ( tipo ',' 'INTENT' '(' tipoparam ')' IDENT ';' )* ;
tipoparam : 'IN' | 'OUT' | 'INOUT' ;

// decfun y lista repetitiva de parámetros de función
decfun : 'FUNCTION' IDENT '(' nomparamlist ')' tipo '::' IDENT ';' dec_f_paramlist 'END' 'FUNCTION' IDENT ;
dec_f_paramlist : ( tipo ',' 'INTENT' '(' 'IN' ')' IDENT ';' )* ;

// sentencias
sent : IDENT '=' expr ';' | proc_call ';' ;
//sentlist : ( sent )+ ;
proc_call : 'CALL' IDENT subpparamlist ;
subpparamlist : '(' expr explist ')' | /* empty */ ;
explist : ( ',' expr )* ;

// expresiones (eliminar recursión izquierda y usar precedencia explícita)
expr : addExpr ;
addExpr : mulExpr ( ('+' | '-') mulExpr )* ;
mulExpr : unaryExpr ( ('*' | '/') unaryExpr )* ;
unaryExpr : ('+' | '-') unaryExpr | factor ;
factor : simpvalue | '(' expr ')' | IDENT '(' expr explist ')' | IDENT ;

// subprogramas
subproglist : ( codproc | codfun )* ;
codproc : 'SUBROUTINE' IDENT formal_paramlist dec_s_paramlist dcllist sent sentlist 'END' 'SUBROUTINE' IDENT ;
codfun : 'FUNCTION' IDENT '(' nomparamlist ')' tipo '::' IDENT ';' dec_f_paramlist dcllist sent sentlist IDENT '=' expr ';' 'END' 'FUNCTION' IDENT ;

type : IDENT | 'integer' | 'real' | 'char' ;

// fragmentos y tokens léxicos
fragment Letras: [a-zA-Z];
fragment Digitos: [0-9];
IDENT: Letras (Letras | Digitos | '_')*;
NUM_INT_CONST: [+-]? Digitos+;
NUM_REAL_CONST: [+-]? Digitos* '.' Digitos+ ([eE] [+-]? Digitos+)?;
STRING_CONST: '\'' ( ~['\r\n] | '\'\'' )* '\'' ;
LINE: '{' ~('}')* '}' -> skip;
COMMENT: '(*' .*? '*)' -> skip;
IGNORE: [ \t\r\n]+ -> skip;
