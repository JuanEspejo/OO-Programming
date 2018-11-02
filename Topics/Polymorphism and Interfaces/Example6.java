// how a class implements an interface

class Example6
{
	public static void main(String args[])
	{  
		Greeting obj = new Greeting();  
		obj.print();  
 	}  
}

class Greeting implements printable
{  
	public void print(){System.out.println("Hello");}  
  
}  

interface printable
{  
	void print();  
}
