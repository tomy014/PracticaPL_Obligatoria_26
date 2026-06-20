PROGRAM prog4 ;
INTEGER :: a = 4, b = 6, resultado;
REAL :: escala = -000.64E77;
CHARACTER(30) :: texto = “comilla doble ”” dentro” ;
CHARACTER(30) :: texto2 = 'comilla simple '' dentro';
CHARACTER(30) :: texto3 = “comilla simple ' y doble ”” dentro”;

    INTERFACE
        FUNCTION Doble(x)
            INTEGER :: Doble;
            INTEGER, INTENT(IN) x;
        END FUNCTION Doble

        FUNCTION Triple(x)
            INTEGER :: Triple;
            INTEGER, INTENT(IN) x;
        END FUNCTION Triple

        SUBROUTINE Mostrar(nombre, valor)
            CHARACTER(12), INTENT(IN) nombre;
            INTEGER, INTENT(IN) valor;
        END SUBROUTINE Mostrar

        SUBROUTINE SinUso
        END SUBROUTINE SinUso
    END INTERFACE

    resultado = Doble(a) + b;
    escala = escala * 2.0;
    CALL Mostrar(texto, resultado);

END PROGRAM prog4

FUNCTION Doble(x)
    INTEGER :: Doble;
    INTEGER, INTENT(IN) x;

    INTEGER :: aux;
    aux = x * 2;
    Doble = aux;
END FUNCTION Doble

FUNCTION Triple(x)
    INTEGER :: Triple;
    INTEGER, INTENT(IN) x;

    INTEGER :: aux;
    aux = x * 3;
    Triple = aux;
END FUNCTION Triple

SUBROUTINE Mostrar(nombre, valor)
    CHARACTER(12), INTENT(IN) nombre;
    INTEGER, INTENT(IN) valor;
    valor = valor + 0;
END SUBROUTINE Mostrar
