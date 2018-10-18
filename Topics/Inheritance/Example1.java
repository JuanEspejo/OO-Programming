// CommissionEmployee class test program.
	
public class Example1 
{
	public static void main(String[] args) 
	{
		// instantiate CommissionEmployee object
		CommissionEmployee employee = new CommissionEmployee(
		"Fabio", "Pantoja", "78441202", 10000, .05);      
		
		// get commission employee data
		System.out.printf(
        	"%nEmployee information obtained by get methods:%n");
		System.out.printf("%n%s %s%n", "First name is",
			employee.getFirstName());
      	System.out.printf("%s %s%n", "Last name is", 
        	 employee.getLastName());
      	System.out.printf("%s %s%n", "Dni number is", 
        	 employee.getDni());
      	System.out.printf("%s %.2f%n", "Gross weekly sales is", 
      	   employee.getGrossSales());
      	System.out.printf("%s %.2f%n", "Commission rate is",
      	   employee.getCommissionRate());

      	employee.setGrossSales(5000); 
      	employee.setCommissionRate(.1); 
      
     	System.out.printf("%n%s:%n%n%s%n%n",                                
        	 "Updated employee information obtained by toString", employee);
   	} 
}     
 
class CommissionEmployee extends Object
{
   	private final String firstName;                        
   	private final String lastName;                         
   	private final String dni;             
   	private double grossSales; // gross weekly sales       
   	private double commissionRate; // commission percentage

   	// five-argument constructor                                       
   	public CommissionEmployee(String firstName, String lastName, 
      	String dni, double grossSales, 
      	double commissionRate)
   	{                                                                  
    	// implicit call to Object's default constructor occurs here              

      	// if grossSales is invalid throw exception
      	if (grossSales < 0.0) 
         	throw new IllegalArgumentException(
            	"Gross sales must be >= 0.0");

      	// if commissionRate is invalid throw exception
      	if (commissionRate <= 0.0 || commissionRate >= 1.0)
         	throw new IllegalArgumentException(
            	"Commission rate must be > 0.0 and < 1.0");

      	this.firstName = firstName;                                     
      	this.lastName = lastName;                                    
      	this.dni = dni;         
      	this.grossSales = grossSales;
      	this.commissionRate = commissionRate;
   	} 

   	public String getFirstName()
   	{
      	return firstName;
   	}

   	public String getLastName()
   	{
      	return lastName;
   	} 

   	public String getDni()
   	{
      	return dni;
   	} 

   	public double getGrossSales()
   	{
      	return grossSales;
   	} 

   	public double getCommissionRate()
   	{
      	return commissionRate;
   	} 

   	public void setGrossSales(double grossSales)
   	{
      	if (grossSales < 0.0) 
         	throw new IllegalArgumentException(
            	"Gross sales must be >= 0.0");

      	this.grossSales = grossSales;
   	} 

   	public void setCommissionRate(double commissionRate)
   	{
      	if (commissionRate <= 0.0 || commissionRate >= 1.0)
         	throw new IllegalArgumentException(
            	"Commission rate must be > 0.0 and < 1.0");

      	this.commissionRate = commissionRate;
   	} 

   	// return String representation of CommissionEmployee object         
   	@Override // indicates that this method overrides a superclass method
   	public String toString()                                             
   	{                                                                       
      	return String.format("%s: %s %s%n%s: %s%n%s: %.2f%n%s: %.2f",    
         	"commission employee", firstName, lastName,                    
         	"dni number", dni,                
         	"gross sales", grossSales,                                     
         	"commission rate", commissionRate);                           
   	} 
}
 
