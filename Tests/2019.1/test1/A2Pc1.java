import java.util.Scanner;

public class Pc1 {

   public static void main(String[] args){
      Scanner entrada = new Scanner(System.in);
      int opcion;
      while(true){
         System.out.printf("%n%s%n%s%n%s%n%s%n%s%n%n%s", 
         "Menu", "1.- salir", "2.- pregunta 2",
         "3.- pregunta 3", "4.- pregunta 4", 
         "Seleccione una de las opciones: ");
         opcion = entrada.nextInt();
         if(opcion == 1) break;
         else if(opcion == 2) pregunta2(); 
         else if(opcion == 3) pregunta3(); 
         else if(opcion == 4) pregunta4(); 
         else System.out.printf("Seleccion incorrecta%n");
      };
   } 

   public static void pregunta2(){
		Scanner entrada = new Scanner(System.in);
		double masa, altura;
   	System.out.printf(" Ingrese su masa en Kg: ");
		masa = entrada.nextDouble();
   	System.out.printf(" Ingrese su altura en m.: ");
		altura = entrada.nextDouble();
   	System.out.printf(" Su IMC es %.2f%n", masa/Math.pow(altura,2));
		System.out.printf(" VALORES DE IMC%n");
		System.out.printf(" %-15s: %-15s%n", "Bajo peso", "menos de 18.5");
		System.out.printf(" %-15s: %-15s%n", "Normal", "entre 18.5 y 24.9");
		System.out.printf(" %-15s: %-15s%n", "Sobrepeso", "entre 25 y 29.9");
		System.out.printf(" %-15s: %-15s%n", "Obeso", "30 o más");
   }

   public static void pregunta3(){ 
      Scanner entrada = new Scanner(System.in);
      int n, aux, m = 0, a;	
   	System.out.printf("ingrese un entero positivo: ");
      n = entrada.nextInt();
		aux = n;
      while(true){
      	a = aux%10;
			m = 10*m + a;
			if(aux/10 == 0) break;
			aux = aux/10;
		}
      if (m == n) 
      	System.out.printf("Es un palindromo%n");
      else 
      	System.out.printf("NO es un palindromo%n");
   }

   public static void pregunta4(){
   	Scanner entrada = new Scanner(System.in);
   	int n, x, y;
		System.out.printf("Ingrese n: ");
		n = entrada.nextInt();
		y = n;
		while(y >= -n){
			x = -n;
			while(x <= n){
				if(Math.abs(x) + Math.abs(y) >= n+1)
					System.out.printf(" *");
				else
					System.out.printf("  ");
				x++;
			}
			System.out.printf("%n");
			y--;
		}
  }
}
