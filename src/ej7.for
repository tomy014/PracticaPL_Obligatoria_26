PROGRAM prog7 ;
INTEGER, PARAMETER :: max_val = 100, min_val = -50;
REAL, PARAMETER :: pi = 3.1415, e = 2.71828, c = 'bandolero';
CHARACTER (2) , PARAMETER :: S = "SI", N = 2;

INTEGER :: contador = 0, acumulador;
REAL :: promedio, total = 0.0;
CHARACTER(10) :: mensaje1 = 'Hola', mensaje2 = 'Mundo';

    INTERFACE

        FUNCTION Sumar(a, b)
            INTEGER :: Restar;
            INTEGER, INTENT(IN) a;
            INTEGER, INTENT(IN) b;
        END FUNCTION Sumar

        SUBROUTINE ImprimirMensaje(texto)
            CHARACTER(10), INTENT(IN) texto;
        END SUBROUTINE ImprimirMensaje

    END INTERFACE

    contador = contador + 1;
    total = total + 45.6;
    ! Error en el numero de parametros
    CALL ImprimirMensaje('Bienvenido',123);
    promedio = total / 2.0;

END PROGRAM mal
! Error en el nombre del programa

FUNCTION Sumar(a, b)
    INTEGER :: Sumar;
    INTEGER, INTENT(IN) a;
    INTEGER, INTENT(IN) b;

    INTEGER :: suma;
    suma = a + b;
    Sumar = suma;
END FUNCTION resta
! Error en el nombre de la función

SUBROUTINE ImprimirMensaje(texto)
    CHARACTER(10), INTENT(IN) texto;
    CALL MostrarEnPantalla(texto);
END SUBROUTINE peor
! Error en el nombre de la función