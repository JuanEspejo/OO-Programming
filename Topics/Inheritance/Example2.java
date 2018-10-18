// BasePlusCommissionEmployee test program.

public class Example2.java 
{
   public static void main(String[] args) 
   {
      // instantiate BasePlusCommissionEmployee object
      BasePlusCommissionEmployee employee = 
         new BasePlusCommissionEmployee(
         "Fabio", "Pantoja", "89120054", 10000, .02, 300);
      
      // get base-salaried commission employee data
      System.out.printf(
         "%nEmployee information obtained by get methods:%n");
      System.out.printf("%n%s %s%n", "First name is",
         employee.getFirstName());
      System.out.printf("%s %s%n", "Last name is", 
         employee.getLastName());
      System.out.printf("%s %s%n", "Dni number is", 
         employee.getDni());
      System.out.printf("%s %.2f%n", "Gross sales is", 
         employee.getGrossSales());
      System.out.printf("%s %.2f%n", "Commission rate is",
         employee.getCommissionRate());
      System.out.printf("%s %.2f%n", "Base salary is",
         employee.getBaseSalary());

      employee.setBaseSalary(1000);
      
      System.out.printf("%n%s:%n%n%s%n%n", 
         "Updated employee information obtained by toString", 
         employee.toString());
   } 
} 
 
class BasePlusCommissionEmployee
{
   private final String firstName;
   private final String lastName;
   private final String dni;
   private double grossSales; // gross weekly sales
   private double commissionRate; // commission percentage
   private double baseSalary; // base salary per week

   // six-argument constructor
   public BasePlusCommissionEmployee(String firstName, String lastName, 
      String dni, double grossSales, 
      double commissionRate, double baseSalary)
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

      // if baseSalary is invalid throw exception
      if (baseSalary < 0.0)                      
         throw new IllegalArgumentException(    
            "Base salary must be >= 0.0");       

      this.firstName = firstName;
      this.lastName = lastName;
      this.dni = dni;
      this.grossSales = grossSales;
      this.commissionRate = commissionRate;
      this.baseSalary = baseSalary;
   } // end constructor 

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

   public double getBaseSalary()
   {
      return baseSalary;
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

   public void setBaseSalary(double baseSalary)
   {
      if (baseSalary < 0.0)
         throw new IllegalArgumentException(
            "Base salary must be >= 0.0");

      this.baseSalary = baseSalary;
   } 


   // return String representation of BasePlusCommissionEmployee
   @Override 
   public String toString()
   {
      return String.format(
         "%s: %s %s%n%s: %s%n%s: %.2f%n%s: %.2f%n%s: %.2f", 
         "base-salaried commission employee", firstName, lastName, 
         "dni number", dni, 
         "gross sales", grossSales, "commission rate", commissionRate, 
         "base salary", baseSalary);
   }
}
