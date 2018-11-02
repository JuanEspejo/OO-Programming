// Example 2

class Example2
{
	public static void main(String args[])
	{  
 		Bike obj = new Honda4();  
 		obj.run();  
	}  

}

class Honda4 extends Bike
{  
	void run()
	{
		System.out.println("running safely");
	}  
}  


abstract class Bike
{  
  	abstract void run();  
}  
