// Example 2
// Handling ArithmeticExceptions and InputMismatchExceptions.
import java.util.InputMismatchException;
import java.util.Scanner;

public class Example2
{
   // demonstrates throwing an exception when a divide-by-zero occurs
   public static int quotient(int numerator, int denominator)
      //throws ArithmeticException
   {
      return numerator / denominator; // possible division by zero
   } 

   public static void main(String[] args)
   {
      Scanner scanner = new Scanner(System.in); 
		int i = 0;

      while(true)
      {
         try // read two numbers and calculate quotient
         {
         	i++;
         	if(i == 3) break;
         	System.out.printf("execution%3d...%n", i);
         	System.out.print("Please enter an integer numerator: ");
            int numerator = scanner.nextInt();
            System.out.print("Please enter an integer denominator: ");
            int denominator = scanner.nextInt();

            int result = quotient(numerator, denominator);
            System.out.printf("%nResult: %d / %d = %d%n", numerator,
               denominator, result);
	         break;
         }
         catch (InputMismatchException e)
         {
            System.err.printf("%nException: %s%n", e);
            scanner.nextLine(); // discard input so user can try again
            System.out.printf(
               "You must enter integers. Please try again.%n%n");
         }
         catch (ArithmeticException e)
         {
            System.err.printf("%nException: %s%n", e);
            System.out.printf(
               "Zero is an invalid denominator. Please try again.%n%n");
         } 
      } 
   } 
}
