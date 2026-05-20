#define max_val 100
#define min_val -50
#define pi 3.1415
#define e 2.71828
#define c 2e-6
int Sumar(int a, int b);
void ImprimirMensaje(char texto[]);

int Sumar(int a, int b)
{
	int suma;
	suma = a + b;
	return suma;
}

void ImprimirMensaje(char texto[])
{
	MostrarEnPantalla(texto);
}

void main(void)
{
	int contador = 0, acumulador;
	float promedio, total = 0.0;
	char mensaje1[10] = "Hola", mensaje2[10] = "Mundo";
	contador = contador + 1;
	total = total + 45.6;
	ImprimirMensaje("Bienvenido", 123);
	promedio = total / 2.0;
}
