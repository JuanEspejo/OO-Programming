
import java.security.SecureRandom;
import java.util.Scanner;

public class Pregunta_6_29 {
   
   private static final SecureRandom randomNumber = new SecureRandom();
   private enum Lado {HEADS, TAILS};
   
   public static void main(String[] args) {
      
      boolean status = true;
      int count[] = {0, 0};
      int menu;
      Lado lado;
      
      Scanner input = new Scanner(System.in);
      
      while(status) {
         System.out.printf("(1) Toss coin%n(2) Exit%n");
         menu = input.nextInt();
         
         if(menu == 2) break;
         else {
         	lado = flip();
            if (lado == Lado.HEADS)
            	++count[0];
            if (lado == Lado.TAILS)
            	++count[1];
            System.out.printf("%nReults:%nHeads:%3d%nTails:%3d%n", 
            	count[0], count[1]);
     		}
      
      }
      
   }

	    
   public static Lado flip() {
      switch (randomNumber.nextInt(2)) {
         case 0: return Lado.HEADS;
         default: return Lado.TAILS;
      }
   }
    
}


