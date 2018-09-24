import java.util.Scanner;

public class Pc1 
{
   public static final double TASA = 0.0109, 
           POBLACION_INI = 7.632, 
           PI = 3.14159,
           PII = 3.1415999;
      
   public static void main(String[] args)
   {
      Scanner entrada = new Scanner(System.in);
      int opcion;
    
      do
      {
         System.out.printf("%n%s%n%s%n%s%n%s%n%s%n%n%s", 
         "Menu", "1.- salir", "2.- pregunta 2",
         "3.- pregunta 3", "4.- pregunta 4", 
         "Seleccione una de las opciones: ");
         opcion = entrada.nextInt();
         switch(opcion)
         {
            case 1: break;
            case 2: pregunta2(); break;
            case 3: pregunta3(); break;
            case 4: pregunta4(); break;
         }
      } while(opcion != 1);
   } 
   
   public static void pregunta2()
   {
      System.out.printf("ingrese un numero de 4 digitos: ");
      Scanner entrada = new Scanner(System.in);
      int n = entrada.nextInt();
      System.out.printf("numero cifrado: %d%n", cifrar(n));
      System.out.printf("numero descifrado: %d%n", descifrar(n));
   }
   
   public static void pregunta3()
   {
      int doble = 0;
      double poblacion = POBLACION_INI, delta;
      
      for(int i=2019; i <= 2100; i++){
         delta = TASA*poblacion;
         poblacion += delta;
         System.out.printf("%6d%10.3f%9.3f%n", i, poblacion, delta);
         if(poblacion > 2*POBLACION_INI && doble == 0) doble = i;
      }
      System.out.printf("%nEn el %d la poblacion sera el doble de la actual%n", doble);
   }
   
   public static void pregunta4()
   {
      double suma = 0;
      int n = 0;
      
      for(int i=1; i <= 200_000; i++){
         suma += Math.pow(-1,i+1)*(double)4/(2*i - 1);
         System.out.printf("%8d%12.7f%n", i, suma);
         if(PI < suma && suma < PII && n == 0) n = i;
      }
      System.out.printf("%nSe tiene que utilizar %d terminos%n", n);
   }
    
   public static int cifrar(int n)
   {
      int a = n/1000, b = (n/100)%10, c = (n/10)%10, d = n%10;
      a = (a + 7)%10; b = (b + 7)%10; c = (c + 7)%10; d = (d + 7)%10;
      return c*1000 + d*100 + a*10 + b;
   }
    
   public static int descifrar(int n)
   {
      int a = n/1000, b = (n/100)%10, c = (n/10)%10, d = n%10;
      a = t(a); b = t(b); c = t(c); d = t(d);
      return c*1000 + d*100 + a*10 + b;
   }
 
   public static int t(int n)
   {
      if(n < 7) return n + 3;
      else return n - 7;
   }
} 
