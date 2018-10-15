import java.security.SecureRandom;
import java.util.Scanner;

public class Pregunta_6_31 {
   
   private static final SecureRandom aleatorio = new SecureRandom();
   
   public static void main(String[] args) {
      int intentos; //solo cambia despues del segundo intento (en while)
      int numero;
      int entrada;
      int eleccion;
       
      Scanner input = new Scanner(System.in);
      do {
         numero = aleatorio.nextInt(1000) + 1; // generando numero aleatorio
         System.out.println("Adivina un número entre 1 y 1000: ");
         entrada = input.nextInt();
         intentos = 1;
         while(entrada != numero)
         {
            if(entrada > numero)
               System.out.println("Muy alto. Vuelve a intentar.");
            if(entrada < numero)
               System.out.println("Muy bajo. Vuelve a intentar.");
                
            entrada = input.nextInt();
            ++intentos;
         }
         System.out.println("Felicitaciones. ¡Adivinaste el número!");

         if(intentos < 10) 
            System.out.println("¡O sabes el secreto o tuviste suerte!");
         else if(intentos == 10)
            System.out.println("¡Hey! ¡Sabes el secreto!");
         else
            System.out.println("¡Hay una forma mejor de hacerlo!");
         System.out.println("¿Quieres jugar de nuevo? (0 = No, 1 = Sí): ");
         eleccion = input.nextInt();
      }while(eleccion != 0);
   }
    
}

