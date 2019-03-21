#include <stdio.h>

int combinatoria(int n, int k);

int main()
{
	int n, k;
	printf("  Por favor introduzca los valores para n y k: ");
	scanf("%d %d", &n, &k);
	printf("  El número de combinaciones es: %d\n\n", combinatoria(n,k));
	return 0;
}

int combinatoria(int n, int k)
{
	if(k > n)
	{
		printf("\nCombinación imposible.\n\n");
		return 0;
	}
	if(k == n)
	{
		return 1;
	}
	if(k == 1)
	{
		return n;
	}
	return combinatoria(n-1, k-1) + combinatoria(n-1, k);
}
