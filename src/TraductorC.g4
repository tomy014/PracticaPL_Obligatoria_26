grammar TraductorC;

@parser::members {
    private String inputFileName;

    public TraductorCParser(TokenStream input, String fileName) {
        this(input);
        this.inputFileName = fileName;
    }
}


// Reglas sintácticas
// Programa principal o librería
prg ::= "PROGRAM" IDENT ";" dcllist cabecera sentlist "END"
"PROGRAM" IDENT subproglist
dcllist ::= ʎ | dcl dcllist
usa solo notación Extended BNF
cabecera ::= ʎ | "INTERFACE" cablist "END" "INTERFACE"
cablist ::= decproc decsubprog | decfun decsubprog
decsubprog ::= ʎ | decproc decsubprog | decfun decsubprog
sentlist ::= sent | sentlist sent


// Zona de declaraciones
dcl ::= defcte | defvar
defcte ::= ʎ
| tipo "," "PARAMETER" "::" IDENT "=" simpvalue ctelist ";"
defcte
ctelist ::= ʎ |  IDENT "=" simpvalue "," ctelist
simpvalue ::= NUM_INT_CONST | NUM_REAL_CONST | STRING_CONST
mixedvalue ::= NUM_INT_CONST "::" NUM_REAL_CONST
defvar ::= ʎ | tipo "::" varlist ";" defvar
usa  solo notación Extended BNF
tipo ::= "INTEGER" | "REAL" | "CHARACTER" charlength
charlength ::= ʎ | "(" NUM_INT_CONST ")"
varlist ::= IDENT init | varlist "," IDENT init
init ::= ʎ | "=" simpvalue


// Zona de sentencias
decproc ::=  "SUBROUTINE" IDENT formal_paramlist
dec_s_paramlist "END" "SUBROUTINE" IDENT
formal_paramlist ::= ʎ | "(" nomparamlist ")"
nomparamlist ::= IDENT | IDENT "," nomparamlist
dec_s_paramlist ::= ʎ | tipo "," "INTENT" "(" tipoparam ")" IDENT ";"
dec_s_paramlist
usa  solo notación Extended BNF
dec_c_paramlist ::= tipo "," "INTENT" "(" tipoparam ")" IDENT ";"
usa  solo notación Extended BNF  dec_c_paramlist
usa  solo notación Extended BNF
tipoparam ::= "IN" | "OUT" | "INOUT"
decfun ::=  "FUNCTION" IDENT "(" nomparamlist ")"
tipo "::" IDENT ";"
dec_f_paramlist
"END" "FUNCTION" IDENT
dec_f_paramlist ::= ʎ
| dec_f_paramlist tipo "," "INTENT" "(" "IN" ")"
IDENT ";"


// Zona de sentencias
sent ::= IDENT "=" exp ";" | proc_call ";"
exp ::= exp op exp | factor
op ::= oparit
oparit ::= "+" | "-" | "*" | "/"
factor ::= simpvalue | "(" exp ")" | IDENT "(" exp explist ")" | IDENT
explist ::= "," exp explist | ʎ
proc_call ::= "CALL" IDENT subpparamlist
subpparamlist ::= "(" exp explist ")" | ʎ


// Zona de subprogramas
subproglist ::= codproc subproglist | codfun subproglist | ʎ
codproc ::= "SUBROUTINE" IDENT formal_paramlist
dec_s_paramlist
dcllist sent sentlist
"END" "SUBROUTINE" IDENT
codfun ::= "FUNCTION" IDENT "(" nomparamlist ")"
tipo "::" IDENT ";"
dec_f_paramlist
dcllist sent sentlist
IDENT "=" exp ";"
"END" "FUNCTION" IDENT
