// Exercise 9.8 program.

public class E9_8 
{
   public static void main(String[] args) 
   {
      // instantiate BasePlusCommissionEmployee object
      BasePlusCommissionEmployee employee = 
         new BasePlusCommissionEmployee(
         "Fabio", "Pantoja", "89120054", 10000, .02, 300);
      
      System.out.printf("%n%s:%n%n%s", 
         "Employee information", employee.toString());
		employee.printEarnings();

      employee.setGrossSales(8000);
      employee.setCommissionRate(.5);
      employee.setBaseSalary(1000);

      System.out.printf("%n%s:%n%n%s", 
         "Updated employee information", employee);
      employee.printEarnings();
   } 
} 

 
class Trapezoid extends Quadrilateral
{
	public float area()
	{
		return 
	}
	
   @Override // indicates that this method overrides a superclass method
   public String toString()                                             
   {                                                                    
      return String.format("%s: %s %s%n%s: %s%n%s: %.2f%n%s: %.2f",    
         "commission employee", getFirstName(), 
         getLastName(),                    
         "dni number", getDni(),                
         "gross sales", getGrossSales(),                                     
         "commission rate", getCommissionRate());                           
   } 	
}

class Quadrilateral extends Object
{
   private final Point point1;
   private final Point point2;
   private final Point point3;
   private final Point point4; 
                                
   public quadrilateral(int x1, int y1, int x2, int y2,
   	int x3, int y3, int x4, int y4)
   {                                                                  
      // implicit call to Object constructor occurs here              
		point1 = new Point(x1,y1);
		point2 = new Point(x2,y2);
		point3 = new Point(x3,y3);
		point4 = new Point(x4,y4);
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
