public class VariableLengthCommandLine {

   public static void main(String[] args) {
/*
      double d1 = 10;
      double d2 = 20;
      double d3 = 30;
      double d4 = 40;

      System.out.printf("d1 = %.1f%nd2 = %.1f%nd3 = %.1f%nd4 = %.1f%n%n",
         d1, d2, d3, d4);
      System.out.printf("Average of d1 and d2 is %.1f%n", 
         average(d1, d2)); 
      System.out.printf("Average of d1, d2 and d3 is %.1f%n", 
         average(d1, d2, d3));
      System.out.printf("Average of d1, d2, d3 and d4 is %.1f%n", 
         average(d1, d2, d3, d4));
*/
		// check number of command-line arguments
      if (args.length != 3)
         System.out.printf(
            "Error: Please re-enter the entire command, including%n" + 
            "an array size, initial value and increment.%n");
      else {
         // get array size from first command-line argument
         int arrayLength = Integer.parseInt(args[0]); 
         int[] array = new int[arrayLength];

         // get initial value and increment from command-line arguments
         int initialValue = Integer.parseInt(args[1]);
         int increment = Integer.parseInt(args[2]);

         // calculate value for each array element
         for (int counter = 0; counter < array.length; counter++)
            array[counter] = initialValue + increment * counter;

         System.out.printf("%s%8s%n", "Index", "Value");
         
         // display array index and value
         for (int counter = 0; counter < array.length; counter++)
            System.out.printf("%5d%8d%n", counter, array[counter]);
      }
         
   } 

   public static double average(double... numbers) {
      double total = 0; 
      // calculate total using the enhanced for statement
      for (double d : numbers)
         total += d;
      return total / numbers.length;
   } 

}
