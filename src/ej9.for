PROGRAM prog9 ;
INTEGER, PARAMETER :: limite = 10;
INTEGER :: contador = 'texto';
REAL :: total = 3.14;
CHARACTER(8) :: etiqueta = 'TIPOS';

    contador = contador + limite;
    total = total / 2.0;
    CALL Mostrar(etiqueta);

END PROGRAM prog9

SUBROUTINE Mostrar(etiqueta)
    CHARACTER(8), INTENT(IN) etiqueta;
    etiqueta = 'ERROR';
END SUBROUTINE Mostrar
