#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main()
{
	srand(time(NULL));
	int i;
	int n;
	int veces[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	for(i = 0; i<100; i++)
	{
		n = rand()%10;
		printf("%d\n", n + 1);
		veces[n] = veces[n] + 1;
	}
	printf("\n  Veces que se repite cada número:\n");
	for(i = 0; i<10; i++)
	{
		printf(" %d: %d\n", i + 1, veces[i]);
	}
	return 0;
}
