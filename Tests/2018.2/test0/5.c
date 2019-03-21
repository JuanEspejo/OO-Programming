#include <stdio.h>

struct profe
{
	char *Nombre;
	int sueldo;
	int edad;
};

int main()
{
	struct profe profesores[] = {"Juan", 1000, 27, "Pedro", 4000, 40, "Carlos", 120, 1200, "Martín", 2000, 21};
	printf("  Tabla inicial:\n");
	printf("\tNombre\tSueldo\tEdad\n");
	int i;
	for(i = 0; i < 4; i++)
	{
		printf("\t%s\t%d\t%d\n", profesores[i].Nombre, profesores[i].sueldo, profesores[i].edad);
	}
	printf("\n  Tabla actualizada:\n");
	printf("\tNombre\tSueldo\tEdad\n");
	for(i = 0; i < 4; i++)
	{
		profesores[i].sueldo = profesores[i].sueldo * 2;
	}
	profesores[2].sueldo = 20000;
	profesores[2].edad = 25;
	for(i = 0; i < 4; i++)
	{
		printf("\t%s\t%d\t%d\n", profesores[i].Nombre, profesores[i].sueldo, profesores[i].edad);
	}
	return 0;
}
