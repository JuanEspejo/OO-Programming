import java.security.SecureRandom;

public class Test2{

 	private static final int NUMBER_OF_PARTITIONS = 10000;
 	private static final int UNIQUE_SET_SIZE = 5;
	private static final SecureRandom randomNumbers = new SecureRandom();	
	private enum Status {UNIQUE,REPEATED};

   public static void main(String[] args){
   	int[] uniqueSet = new int[5];
   	int[] set1 = new int[4];
   	int[] set2 = new int[4];
   	fillUniqueSet(uniqueSet);
   	fillSet(set1);
   	fillSet(set2);
   	if(areDisjoint(set1, set2))
   		System.out.printf(" Both sets are disjoint.%n");
		System.out.printf("%n%n Integral equals %.5f%n", integral(-1,1));
   } 

   public static int rollTheDice(){
   	int die1 = 1 + randomNumbers.nextInt(6); // first die roll
      int die2 = 1 + randomNumbers.nextInt(6); // second die roll
      System.out.printf(" Player rolled %d + %d = %d%n", 
         die1, die2, die1 + die2);
 		  return die1 + die2;
   }

   public static void fillUniqueSet(int[] a){
   	int index = 0, aux;
   	Status rollStatus;
		for(int l = 0; l < UNIQUE_SET_SIZE; l++){
			aux = rollTheDice();
  			rollStatus = Status.UNIQUE;
  			for(int k = 0; k < index; k++)
  				if(a[k] == aux) {rollStatus = Status.REPEATED; break;}
  			if(rollStatus == Status.UNIQUE) {
  				a[index] = aux;		
  				for(int k = 0; k <= index; k++)
  					System.out.printf("%4d", a[k]);
  				System.out.println();
  				index++;
  			}
  		}
  		System.out.println();
   }

	public static void fillSet(int[] a){
		System.out.printf("###############%n");
		for(int j = 0; j < a.length; j++)
			a[j] = rollTheDice();
	}   
	
	public static boolean areDisjoint(int[] a, int[] b){
		for(int j : a)
			for(int k : b)
				if(j == k){
					System.out.printf(" The roll %d is repeated, %s.%n", 
					j, "so the generated sets are NOT disjoint");
					return false;
				}
		return true;		
	}   
	
	public static double f(double x){
		return Math.exp(-x*x/2) / Math.sqrt(2*Math.PI);
	}
			
	public static double integral(int a, int b){
		double h = (double)(b-a)/NUMBER_OF_PARTITIONS;
		double sum = h*(f(a) + f(b))/2;
		for(int j = 1; j < NUMBER_OF_PARTITIONS; j++)
			sum += h*f(a + j*h);
		return sum; 
	}

}

