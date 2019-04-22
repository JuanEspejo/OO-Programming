
public class Main {
	public static void main(String[] args) {
		Turtle turtle = new Turtle();
		turtle.draw(2,5,12,3,5,12,1,6,9);	
	}
}

class Turtle {
   	private int[][] floor = new int[20][20]; 
   	private int[] currentPlace = new int[2];
   	private int[] direction = new int[2];   	
	private enum Pen {UP, DOWN};
	private boolean isMoving = false;
	Pen penPosition;
		
	public Turtle() {
    	penPosition = penPosition.UP; 
    	direction[0] = 1; direction[1] = 0;
	}
   
   	public void draw(int... command) {
   		for(int com : command) {
   			if(isMoving) { 
   				if(penPosition == Pen.DOWN) drawSegment(com); 
   				else {
   					currentPlace[0] += com*direction[1];
   					currentPlace[1] += com*direction[0];
   				}
   				isMoving = false; 	
   				continue;
   			}
   			switch(com) {
   				case 1: 
   					penPosition = Pen.UP;
   					break;
   				case 2:
   					penPosition = Pen.DOWN;
   					break;
   				case 3:
   					turnRight();
   					break;
   				case 5:
   					isMoving = true;
   					break;
   				case 6:
   					printFloor();
   					break;
   				case 9:
   					;
   			}	
   		}
   	}	
   	
	private void printFloor() {
 		for(int y = 0 ; y < 20; y++) {
 			for(int x = 0; x < 20; x++) {
 				if(floor[y][x] == 0) System.out.printf("  ");
 				else System.out.printf("* ");
 			}
 			System.out.println();
 		}
	}
	
	public void drawSegment(int l) {
		for(int j = 0; j < l; j++) {
			floor[currentPlace[0]][currentPlace[1]] = 1;
			currentPlace[0] += direction[1];
			currentPlace[1] += direction[0];
		}
		floor[currentPlace[0]][currentPlace[1]] = 1;
	} 
 
	private void turnRight() {
		int aux = direction[0];
		direction[0] = direction[1];
		direction[1] = aux; 
	}
}
