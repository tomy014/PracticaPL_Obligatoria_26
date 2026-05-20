PROGRAM prog8 ;
INTEGER, PARAMETER :: limite = 8;
INTEGER :: a = 1, b = 2;
REAL :: resultado;
CHARACTER(5) :: texto = 'FINAL';

    INTERFACE
        SUBROUTINE Salida(texto)
            CHARACTER(5), INTENT(IN) texto;
        END SUBROUTINE Salida
    END INTERFACE

    a = a + b;
    resultado = a / limite;
    CALL Salida(texto);

END prog8

SUBROUTINE Salida(texto)
    CHARACTER(5), INTENT(IN) texto;
    texto = 'FIN';
END SUBROUTINE Salida
