// Exercise 9.8 program.

public class E9_8 
{
   public static void main(String[] args) 
   {
      // instantiate Trapezoid object
      Trapezoid trapezoid = new Trapezoid(1,2,3,2,6,0,0,0);
      
      System.out.printf("%s", trapezoid);

   } 
} 

 
class Trapezoid extends Quadrilateral
{
	public Trapezoid(int x1, int y1, int x2, int y2,
   	int x3, int y3, int x4, int y4)
	{
		super(x1,y1, x2,y2, x3,y3, x4,y4); 
	}
	
	public float area()
	{
		return geth()*(geta() + getb())/(float) 2;
	}
	
   @Override // indicates that this method overrides a superclass method
   public String toString()                                             
   {                                                                    
      return String.format("%s: %s:%5.2f%n%n",    
         " Trapezoid", " Area", area());                           
   } 	
}

class Quadrilateral extends Object
{
   private final Point point1;
   private final Point point2;
   private final Point point3;
   private final Point point4; 
                                
   public Quadrilateral(int x1, int y1, int x2, int y2,
   	int x3, int y3, int x4, int y4)
   {                                                                  
      // implicit call to Object constructor occurs here              
		point1 = new Point(x1,y1);
		point2 = new Point(x2,y2);
		point3 = new Point(x3,y3);
		point4 = new Point(x4,y4);
   }        

	public int geta()
	{
		return point2.getx() - point1.getx();
	}

	public int getb()
	{
		return point3.getx() - point4.getx();
	}

	public int geth()
	{
		return point1.gety() - point4.gety();
	}	
}

class Point extends Object
{
	private int x;
	private int y;
	
	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public int getx()
	{
		return x;
	}
	
	public int gety()
	{
		return y;
	}	
}
