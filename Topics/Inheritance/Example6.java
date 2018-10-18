// BasePlusCommissionEmployee test program.

public class Example6 
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

 
class BasePlusCommissionEmployee extends CommissionEmployee
{
   private double baseSalary; // base salary per week

   // six-argument constructor
   public BasePlusCommissionEmployee(String firstName, String lastName, 
      String dni, double grossSales, 
      double commissionRate, double baseSalary)
   {
      // explicit call to superclass CommissionEmployee constructor
      super(firstName, lastName, dni, 
         grossSales, commissionRate);

      // if baseSalary is invalid throw exception
      if (baseSalary < 0.0)                      
         throw new IllegalArgumentException(    
            "Base salary must be >= 0.0");       

      this.baseSalary = baseSalary;
   } 
   
   public void setBaseSalary(double baseSalary)
   {
      if (baseSalary < 0.0)
         throw new IllegalArgumentException(
            "Base salary must be >= 0.0");

      this.baseSalary = baseSalary;
   } 

   public double getBaseSalary()
   {
      return baseSalary;
   } 

	@Override
   public double earnings()
   {
      return baseSalary + super.earnings();
   } 	
	
   public void printEarnings()
   {
      System.out.printf("%s:%9.2f%n%n",
      	"earnings", earnings());
   } 

   // return String representation of BasePlusCommissionEmployee
   @Override 
   public String toString()
   {
      return String.format("%s %s%n%s:%9.2f%n%n", 
      	"base-salaried", super.toString(), 
      	"base salary", getBaseSalary());   
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
      // implicit call to Object constructor occurs here              

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
   } // end constructor           

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

   public double earnings()
   {
      return grossSales * commissionRate;
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
