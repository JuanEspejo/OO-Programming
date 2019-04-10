import java.security.SecureRandom;

public class FrequencyException {

   public static void main(String[] args) {
/*
      SecureRandom randomNumbers = new SecureRandom();
      int[] frequency = new int[7]; // array of frequency counters
      // roll die 6,000,000 times; use die value as frequency index
      for (int roll = 1; roll <= 6000000; roll++) 
         ++frequency[1 + randomNumbers.nextInt(6)];  
      System.out.printf("%s%10s%n", "Face", "Frequency");
      // output each array element's value
      for (int face = 1; face < frequency.length; face++)
         System.out.printf("%4d%10d%n", face, frequency[face]);
         
*/         
      // student response array (more typically, input at run time)
      int[] responses = {1, 2, 5, 4, 3, 5, 2, 1, 3, 3, 1, 4, 3, 3, 3, 
         2, 3, 3, 2, 14};
      int[] frequency = new int[6]; // array of frequency counters
      // for each answer, select responses element and use that value 
      // as frequency index to determine element to increment
      for (int answer = 0; answer < responses.length; answer++) {
         try {
            ++frequency[responses[answer]];
         } 
         catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e); // invokes toString method
            System.out.printf("   responses[%d] = %d%n%n", 
               answer, responses[answer]);
         } 
      } 
      System.out.printf("%s%10s%n", "Rating", "Frequency");
      // output each array element's value
      for (int rating = 1; rating < frequency.length; rating++)
         System.out.printf("%6d%10d%n", rating, frequency[rating]);
   
   } 

}
