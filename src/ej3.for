PROGRAM prog3 ;
INTEGER, PARAMETER :: limite = 10;
REAL :: total = 1.5, media;
INTEGER :: contador = 2;
CHARACTER(8) :: etiqueta = 'SUMA';

    total = total + contador * 3;
    media = total / limite;
    CALL Reiniciar;

END PROGRAM prog3

SUBROUTINE Reiniciar
    INTEGER :: valor;
    valor = 0;
END SUBROUTINE Reiniciar
