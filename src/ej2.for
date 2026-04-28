PROGRAM prog2 ;
INTEGER , PARAMETER :: bloque = 1024;
REAL , PARAMETER :: PI = 3.141592, E = 2.718281;
CHARACTER (2) , PARAMETER :: S = "SI", N = "NO";

INTEGER :: var1, var2 = 24;
REAL :: var3;
CHARACTER :: var4, var5 = "-", var6;
CHARACTER (10):: var7, var8;

    INTERFACE
        ! Declaracion de funcion CON parametros
        FUNCTION fun1 ( a, b )
            INTEGER :: fun1;
            INTEGER, INTENT (IN) a;
            CHARACTER(4), INTENT (IN) b;
        END FUNCTION fun1

        ! Declaracion de procedimiento CON parametros
        SUBROUTINE proc1 ( c, d , e )
            REAL, INTENT (OUT) c;
            INTEGER, INTENT (IN) d;
            INTEGER, INTENT (INOUT) e;
        END SUBROUTINE proc1

        ! Declaracion de procedimiento SIN parametros
        SUBROUTINE proc2
        END SUBROUTINE proc2
    END INTERFACE

    var1 = var1;

END PROGRAM prog2