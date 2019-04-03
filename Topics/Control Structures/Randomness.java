import java.util.Scanner;
import java.security.SecureRandom; // program uses class SecureRandom

public class Randomness 
{

   public static void main(String[] args)
   {
 /*   
      Scanner input = new Scanner(System.in);
      System.out.print("Enter three floating-point values separated by spaces: ");
      double number1 = input.nextDouble(); // read first double
      double number2 = input.nextDouble(); // read second double
      double number3 = input.nextDouble(); // read third double
		// determine the maximum value
      double result = maximum(number1, number2, number3); 
      // display maximum value 
      System.out.println("Maximum is: " + result);
      
     
      // randomNumbers object will produce secure random numbers
      SecureRandom randomNumbers = new SecureRandom(); 
      for (int counter = 1; counter <= 20; counter++) {
         // pick random integer from 1 to 6
         int face = 1 + randomNumbers.nextInt(6);
         System.out.printf("%4d", face); // display generated value
         // if counter is divisible by 5, start a new line of output
         if (counter % 5 == 0) System.out.println();
      } 

*/    
		// randomNumbers object will produce secure random numbers
      SecureRandom randomNumbers = new SecureRandom();  
      int frequency1 = 0; // count of 1s rolled
      int frequency2 = 0; // count of 2s rolled
      int frequency3 = 0; // count of 3s rolled
      int frequency4 = 0; // count of 4s rolled
      int frequency5 = 0; // count of 5s rolled
      int frequency6 = 0; // count of 6s rolled
      // tally counts for 6,000,000 rolls of a die
      for (int roll = 1; roll <= 6000000; roll++) {
         int face = 1 + randomNumbers.nextInt(6); // number from 1 to 6
         // use face value 1-6 to determine which counter to increment
         switch (face) {   
            case 1:
               ++frequency1; // increment the 1s counter
               break; 
            case 2:
               ++frequency2; // increment the 2s counter
               break;
            case 3:
               ++frequency3; // increment the 3s counter
               break;
            case 4:
               ++frequency4; // increment the 4s counter
               break;
            case 5:
               ++frequency5; // increment the 5s counter
               break;
            case 6:
               ++frequency6; // increment the 6s counter
               break;
         } 
      } 
      System.out.println("Face\tFrequency"); // output headers
      System.out.printf("1\t%9d%n2\t%9d%n3\t%9d%n4\t%9d%n5\t%9d%n6\t%9d%n",
         frequency1, frequency2, frequency3, 
         frequency4, frequency5, frequency6);
                
   } 


   // returns the maximum of its three double parameters
   public static double maximum(double x, double y, double z) {
      double maximumValue = x; // assume x is the largest to start
      if (y > maximumValue)
         maximumValue = y; 
      if (z > maximumValue)
         maximumValue = z;
      return maximumValue;
   } 
   
}
