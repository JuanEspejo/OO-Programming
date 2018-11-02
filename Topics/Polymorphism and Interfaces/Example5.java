// Example of an abstract class that has 
// abstract and non-abstract methods  

//Creating a Test class which calls 
// abstract and non-abstract methods  
class Example5
{  
 	public static void main(String args[])
 	{  
  		Bike obj = new Honda();  
  		obj.run();  
  		obj.changeGear();  
 	}  
}  

//Creating a Child class which inherits Abstract class  
class Honda extends Bike
{  
 	void run(){System.out.println("Honda bike running safely...");}  
}  

abstract class Bike
{  
   Bike(){System.out.println("bike is created");}  
   abstract void run();  
   void changeGear(){System.out.println("gear changed");}  
}  
