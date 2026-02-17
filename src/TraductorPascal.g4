grammar TraductorPascal;

//Para poder recibir el fichero por parámetro.
@parser::members {
    private String inputFileName;

    public TraductorPascalParser(TokenStream input, String fileName) {
        this(input);
        this.inputFileName = fileName;
    }
}

// Programa principal o librería
prg: programa | libreria;
programa: 'program' ID ';' blq '.' {
    System.out.println("#include <stdio.h>\n int main() {");
    System.out.println($blq.s);
    System.out.println("return 0;\n}");
};
libreria: 'unit' ID ';' dcllist '.' {
    System.out.println("// Librería " + $ID.text);
    System.out.println($dcllist.s);
};
blq returns [String s]: dcllist 'begin' sentlist 'end' { $s = $dcllist.s + $sentlist.s; };
dcllist returns [String s]: (dcl { $s = $dcl.s; })* { if ($s == null) $s = ""; };

// Zona de declaraciones
dcl returns [String s]
    : defcte { $s = $defcte.s; }
    | defvar { $s = $defvar.s; }
    | defproc { $s = $defproc.s; }
    | deffun { $s = $deffun.s; };
defcte returns [String s]: 'const' ctelist { $s = $ctelist.s; };
ctelist returns [String s]: ID '=' simpvalue ';' ctelistP { $s = "const " + $ID.text + " = " + $simpvalue.text + ";\n" + $ctelistP.s; };
ctelistP returns [String s]: ID '=' simpvalue ';' ctelistP { $s = "const " + $ID.text + " = " + $simpvalue.text + ";\n" + $ctelistP.s; } | { $s = ""; };
simpvalue: CONSTLIT | CONSTREAL | CONSTINT;
defvar returns [String s]: 'var' defvarlist (';')? { $s = $defvarlist.s; };
defvarlist returns [String s]: varlist ':' tbas ';' defvarlistP { $s = $tbas.s + " " + $varlist.s + ";\n" + $defvarlistP.s; };
defvarlistP returns [String s]: varlist ':' tbas ';' defvarlistP { $s = $tbas.s + " " + $varlist.s + ";\n" + $defvarlistP.s; } | { $s = ""; };
varlist returns [String s]: ID varlistP { $s = $ID.text + $varlistP.s; };
varlistP returns [String s]: ',' ID varlistP { $s = ", " + $ID.text + $varlistP.s; } | { $s = ""; };
defproc returns [String s]: 'procedure' ID formal_paramlist ';' blq ';' {
  $s = "void " + $ID.text + $formal_paramlist.s + " {\n" + $blq.s + "}\n";
};
deffun returns [String s]: 'function' ID formal_paramlist ':' tbas ';' blq ';' {
  $s = $tbas.s + " " + $ID.text + $formal_paramlist.s + " {\n" + $blq.s + "}\n";
};
formal_paramlist returns [String s]: '(' formal_param formal_param_tail ')' { $s = "(" + $formal_param.s + ")"; } | { $s = "()"; };
formal_param_tail returns [String s]: ';' formal_param formal_param_tail { $s = ", " + $formal_param.s + $formal_param_tail.s; } | { $s = ""; };
formal_param returns [String s]: varlist ':' tbas { $s = $tbas.s + " " + $varlist.s; };
tbas returns [String s]: 'INTEGER' { $s = "int"; } | 'REAL' { $s = "float"; };

// Zona de sentencias
sentlist returns [String s]: sent sentlistP { $s = $sent.s + $sentlistP.s; };
sentlistP returns [String s]: sent sentlistP { $s = $sent.s + $sentlistP.s; } | { $s = ""; };
sent returns [String s]
    : asig ';' { $s = $asig.s + ";\n"; }
    | proc_call ';' { $s = $proc_call.s + ";\n"; }
    | if_stmt { $s = $if_stmt.s; }
    | while_stmt { $s = $while_stmt.s; }
    | repeat_stmt { $s = $repeat_stmt.s; }
    | for_stmt { $s = $for_stmt.s; };

// Bloque o sentencia individual para estructuras de control
blq_or_sent returns [String s]
    : blq { $s = $blq.s; }
    | sent { $s = $sent.s; };

// Sentencias de control de flujo
if_stmt returns [String s]:
    'if' condicion=expcond 'then' cuerpo=blq_or_sent ('else' cuerpo_else=blq_or_sent)? {
        if ($cuerpo_else.s != null) {
            $s = "if (" + $condicion.s + ") {\n" +
                 $cuerpo.s +
                 "} else {\n" +
                 $cuerpo_else.s +
                 "}\n";
        } else {
            $s = "if (" + $condicion.s + ") {\n" +
                 $cuerpo.s +
                 "}\n";
        }
    };
while_stmt returns [String s]:
    'while' condicion=expcond 'do' cuerpo=blq_or_sent {
        $s = "while (" + $condicion.s + ") {\n" +
             $cuerpo.s +
             "}\n";
    };
repeat_stmt returns [String s]:
    'repeat' bloque=blq 'until' condicion=expcond ';' {
        $s = "do {\n" +
             $bloque.s +
             "} while (!(" + $condicion.s + "));\n";
    };
for_stmt returns [String s]:
    'for' ID ':=' inicio=exp inc fin=exp 'do' cuerpo=blq_or_sent {
        if ($inc.text.equals("to")) {
            $s = "for (" + $ID.text + " = " + $inicio.s + "; " + $ID.text + " <= " + $fin.s + "; " + $ID.text + "++) {\n" +
                 $cuerpo.s +
                 "}\n";
        } else { // downto
            $s = "for (" + $ID.text + " = " + $inicio.s + "; " + $ID.text + " >= " + $fin.s + "; " + $ID.text + "--) {\n" +
                 $cuerpo.s +
                 "}\n";
        }
    };
inc returns [String s]:
    'to' { $s = "to"; } |
    'downto' { $s = "downto"; };

// Expresiones condicionales
expcond returns [String s]:
    e1=factorcond oplog e2=expcond {
        $s = $e1.s + " " + $oplog.s + " " + $e2.s;
    } |
    factorcond {
        $s = $factorcond.s;
    };
oplog returns [String s]:
    'or' { $s = "||"; } |
    'and' { $s = "&&"; };
factorcond returns [String s]:
    e1=exp opcomp e2=exp {
        $s = $e1.s + " " + $opcomp.s + " " + $e2.s;
    } |
    '(' ec=expcond ')' {
        $s = "(" + $ec.s + ")";
    } |
    'not' fc=factorcond {
        $s = "!(" + $fc.s + ")";
    };
opcomp returns [String s]:
    '<' { $s = "<"; } |
    '>' { $s = ">"; } |
    '<=' { $s = "<="; } |
    '>=' { $s = ">="; } |
    '=' { $s = "=="; };

// Asignaciones y expresiones aritméticas
asig returns [String s]: ID ':=' exp { $s = $ID.text + " = " + $exp.s; };
exp returns[String s]: factor exp_tail { $s = $factor.s + $exp_tail.s; };
exp_tail returns[String s]: op factor exp_tail { $s = " " + $op.s + " " + $factor.s + $exp_tail.s; } | { $s = ""; };
op returns[String s]: '+' { $s = "+"; } | '-' { $s = "-"; } | '*' { $s = "*"; } | 'div' { $s = "/"; } | 'mod' { $s = "%"; };
factor returns[String s]: simpvalue { $s = $simpvalue.text; } | '(' exp ')' { $s = "(" + $exp.s + ")"; } | ID subparamlist { $s = $ID.text + $subparamlist.s; };
subparamlist returns[String s]: '(' explist ')' { $s = "(" + $explist.s + ")"; } | { $s = ""; };
explist returns[String s]: exp explist_tail { $s = $exp.s + $explist_tail.s; };
explist_tail returns[String s]: ',' exp explist_tail { $s = ", " + $exp.s + $explist_tail.s; } | { $s = ""; };
proc_call returns[String s]: ID subparamlist { $s = $ID.text + $subparamlist.s; };

// Definiciones léxicas
fragment Letras: [a-zA-Z];
fragment Digitos: [0-9];

ID: Letras (Letras | Digitos | '_')*;
CONSTINT: [+-]? Digitos+;
CONSTREAL: [+-]? Digitos* '.' Digitos+ ([eE] [+-]? Digitos+)?;
CONSTLIT: '\'' ( ~[\\'\r\n] | '\\\'' )* '\'';

// Ignorar comentarios y espacios en blanco
LINE: '{' ~('}')* '}' -> skip;
COMMENT: '(*' .*? '*)' -> skip;
IGNORE: [ \t\r\n]+ -> skip;
