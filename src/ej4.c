int Doble(int x);
int Triple(int x);
void Mostrar(char nombre[], int valor);
void SinUso(void);

int Doble(int x)
{
	int aux;
	aux = x * 2;
	return aux;
}

int Triple(int x)
{
	int aux;
	aux = x * 3;
	return aux;
}

void Mostrar(char nombre[], int valor)
{
	valor = valor + 0;
}

void main(void)
{
	int a = 4, b = 6, resultado;
	float escala = 2.5;
	char texto[30] = "comilla doble ” dentro";
	char texto2[30] = "comilla simple ' dentro";
	char texto3[30] = "comilla simple ' y doble ” dentro";
	resultado = Doble(a) + b;
	escala = escala * 2.0;
	Mostrar(texto, resultado);
}
