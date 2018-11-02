class Example4
{    
	public static void main(String args[])
	{    
		Bank b = new BCP();  
		System.out.println("Rate of Interest is: "
			+b.getRateOfInterest()+" %");    
		b = new BBVA();  
		System.out.println("Rate of Interest is: "
			+b.getRateOfInterest()+" %");    
	}
} 
  
class BCP extends Bank
{    
	int getRateOfInterest(){return 7;}    
}   
 
class BBVA extends Bank
{    
	int getRateOfInterest(){return 8;}    
}    
    
abstract class Bank
{    
	abstract int getRateOfInterest();    
}  
