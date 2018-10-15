import java.util.Random;

public class Pregunta_7_17 {
    
   private static final Random random = new Random();
	private static final int[] value = new int[13];
	private static final int times = 36000000;

   public static void main(String [] args){
        
   	int m,p;
        
   	for(int i = 0; i < times; i++){
            value[rollDice()] += 1;		            
		}
        
		for(int i = 2; i < value.length; i++){
      	System.out.printf("%2d salió:%9d veces%n", i, value[i]);
      }
      
	}

	public static int rollDice(){
   	int dice1 = 1 + random.nextInt(6); 
   	int dice2 = 1 + random.nextInt(6); 
   	return dice1 + dice2; 
	}
}
