// Programa que muestra el uso de las tres instrucciones iterativas de Java
//import static java.lang.Math.*;

public class Iteratives

   public static void main(String[] args) 
   {     

      int counter = 1; // control variable
      while (counter <= 10){
         System.out.printf("%d  ", counter);
         ++counter; // increment control variable 
      }
      
      
      for (int counter = 1; counter <= 10; counter++) 
      	System.out.printf("%d  ", counter);


      int sum = 0;
      for (int number = 2; number <= 20; number += 2)
         sum += number;
      System.out.printf("Sum is %d%n", sum);

     
      double amount; // amount on deposit at end of each year
      double principal = 1000; // initial amount before interest
      double rate = 0.05; // interest rate
      // display headers
      System.out.printf("%s%20s%n", "Year", "Amount on deposit");
      // calculate amount on deposit for each of ten years
      for (int year = 1; year <= 10; year++) {
         // calculate new amount for specified year
         amount = principal * Math.pow(1.0 + rate, year);
         // display the year and the amount
         System.out.printf("%4d%,20.2f%n", year, amount);
      } 
 

      int counter = 1; 
      do {
         System.out.printf("%d  ", counter);
         ++counter;
      } while (counter <= 10); // end do...while 

 
      System.out.println();
       
   } 
}
