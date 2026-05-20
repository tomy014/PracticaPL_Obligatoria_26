PROGRM prog5 ;
INTEGER, PARAMETER :: maximo = 20;
REAL :: total = 0.0;
INTEGER :: contador = 1, acumulador;
CHARACTER(8) :: etiqueta = 'ERROR';

    INTERFACE
        SUBROUTINE Escribir(texto)
            CHARACTER(8), INTENT(IN) texto;
        END SUBROUTINE Escribir
    END INTERFACE

    acumulador = contador + maximo;
    total = acumulador / 2.0;
    CALL Escribir(etiqueta);

END PROGRAM prog5

SUBROUTINE Escribir(texto)
    CHARACTER(8), INTENT(IN) texto;
    contador = 0;
END SUBROUTINE Escribir
