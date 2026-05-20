PROGRAM prog6 ;
INTEGER, PARAMETER :: base = 10;
REAL :: media = 0.0;
INTEGER :: a, b = 3
CHARACTER(6) :: nombre = 'FALLO';

    a = b + base;
    media = a / 2.0;
    CALL Mostrar(nombre);

END PROGRAM prog6

SUBROUTINE Mostrar(nombre)
    CHARACTER(6), INTENT(IN) nombre;
    nombre = 'OK';
END SUBROUTINE Mostrar
