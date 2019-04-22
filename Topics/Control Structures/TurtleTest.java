
public class TurtleTest {
	public static void main(String[] args) {
		Turtle turtle = new Turtle();
		//turtle.printFloor();
		turtle.draw(3);
		turtle.turnRight();
		turtle.draw(3);
		turtle.printFloor();	
	}
}

class Turtle {
   	private int[][] floor = new int[20][20]; 
   	private int[] currentPlace = new int[2];
   	private int[] direction = new int[2];   	
	private enum Pen {UP, DOWN};
	Pen penPosition;
		
	public Turtle() {
    	penPosition = penPosition.UP; 
    	direction[0] = 1; direction[1] = 0;
	}
   
	public void printFloor() {
 		for(int x = 0 ; x < 20; x++) {
 			for(int y = 0; y < 20; y++) {
 				if(floor[x][y] == 0) System.out.printf(" ");
 				else System.out.printf("*");
 			}
 			System.out.println();
 		}
	}
	
	public void draw(int l) {
		for(int j = 0; j < l; j++) {
			floor[currentPlace[0]][currentPlace[1]] = 1;
			currentPlace[0] += direction[0];
			currentPlace[1] += direction[1];
		}
		floor[currentPlace[0]][currentPlace[1]] = 1;
	} 
 
	public void turnRight() {
		int aux = direction[0];
		direction[0] = direction[1];
		direction[1] = aux; 
	}
}
