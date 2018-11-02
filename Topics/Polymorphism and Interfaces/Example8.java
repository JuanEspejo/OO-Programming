class Example8
{  
	public static void main(String[] args)
	{  
		Bank b = new BCP();  
		System.out.println("ROI: "+b.rateOfInterest());  
	}
}  

class BCP implements Bank
{  
	public float rateOfInterest(){return 9.15f;}  
}
  
class BBVA implements Bank
{  
	public float rateOfInterest(){return 9.7f;}  
}  


interface Bank
{  
	float rateOfInterest();  
}  
