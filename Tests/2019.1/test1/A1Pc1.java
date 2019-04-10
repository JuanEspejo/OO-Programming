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
   	System.out.printf("El caracter %c tiene el valor %d%n", 'A', (int) 'A');
   	System.out.printf("El caracter %c tiene el valor %d%n", 'B', (int) 'B');
   	System.out.printf("El caracter %c tiene el valor %d%n", 'C', (int) 'C');
   	System.out.printf("El caracter %c tiene el valor %d%n", 'a', (int) 'a');
   	System.out.printf("El caracter %c tiene el valor %d%n", 'b', (int) 'b');
   	System.out.printf("El caracter %c tiene el valor %d%n", 'c', (int) 'c');
   	System.out.printf("El caracter %c tiene el valor %d%n", '0', (int) '0');
   	System.out.printf("El caracter %c tiene el valor %d%n", '1', (int) '1');
   	System.out.printf("El caracter %c tiene el valor %d%n", '2', (int) '2');
   	System.out.printf("El caracter %c tiene el valor %d%n", '$', (int) '$');
   	System.out.printf("El caracter %c tiene el valor %d%n", '*', (int) '*');
   	System.out.printf("El caracter %c tiene el valor %d%n", '+', (int) '+');
   	System.out.printf("El caracter %c tiene el valor %d%n", '/', (int) '/');
   	System.out.printf("El caracter %c tiene el valor %d%n", ' ', (int) ' ');  
   }

   public static void pregunta3(){ 
      Scanner entrada = new Scanner(System.in);
      int n, a, b, c, d;	
   	while(true){
         System.out.printf("ingrese un entero de 5 digitos: ");
         n = entrada.nextInt();
         if(9999 < n && n < 100000){
         	a = n/10000;
         	b = n/1000 - a*10;
         	d = n%10;
         	c = (n%100 - d)/10;
         	if (a == d && b == c) 
         		System.out.printf("Es un palindromo%n");
         	else 
         		System.out.printf("NO es un palindromo%n");
         	break;
         }
       	System.out.printf("El nro ingresado NO es de 5 cifras%n");
      }; 
   }

   public static void pregunta4(){
   	int x = 0, y;
   	while(x < 8){
   		y = 0;
   		if(x % 2 == 1) System.out.print(" ");
   		while(y++ < 8) System.out.print("* ");
   		System.out.println();
   		x++;
   	}
   }
}
