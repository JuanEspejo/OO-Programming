// Example9: Payroll System
// Employee hierarchy test program.

public class Example9  
{
   public static void main(String[] args) 
   {
      // create subclass objects
      SalariedEmployee salariedEmployee = 
         new SalariedEmployee("Fabio", "Pantoja", "94550012", 800.00);
      HourlyEmployee hourlyEmployee = 
         new HourlyEmployee("Mario", "Aguilar", "22221015", 16.5, 40);
      CommissionEmployee commissionEmployee = 
         new CommissionEmployee(
         "Gerald", "Salazar", "84550013", 10000, .06);
      BasePlusCommissionEmployee basePlusCommissionEmployee = 
         new BasePlusCommissionEmployee(
         "David", "Ruegg", "75440015", 5000, .04, 300);

      System.out.println("Employees processed individually:");
      
      System.out.printf("%n%s%n%s: $%,.2f%n%n", 
         salariedEmployee, "earned", salariedEmployee.earnings());
      System.out.printf("%s%n%s: $%,.2f%n%n",
         hourlyEmployee, "earned", hourlyEmployee.earnings());
      System.out.printf("%s%n%s: $%,.2f%n%n",
         commissionEmployee, "earned", commissionEmployee.earnings());
      System.out.printf("%s%n%s: $%,.2f%n%n", 
         basePlusCommissionEmployee, 
         "earned", basePlusCommissionEmployee.earnings());

      // create four-element Employee array
      Employee[] employees = new Employee[4]; 

      // initialize array with Employees
      employees[0] = salariedEmployee;
      employees[1] = hourlyEmployee;
      employees[2] = commissionEmployee; 
      employees[3] = basePlusCommissionEmployee;

      System.out.printf("Employees processed polymorphically:%n%n");
      
      // generically process each element in array employees
      for (Employee currentEmployee : employees) 
      {
         System.out.println(currentEmployee); // invokes toString

         // determine whether element is a BasePlusCommissionEmployee
         if (currentEmployee instanceof BasePlusCommissionEmployee) 
         {
            // downcast Employee reference to 
            // BasePlusCommissionEmployee reference
            BasePlusCommissionEmployee employee = 
            	(BasePlusCommissionEmployee) currentEmployee;

            employee.setBaseSalary(1.10 * employee.getBaseSalary());

            System.out.printf(
               "new base salary with 10%% increase is: $%,.2f%n",
               employee.getBaseSalary());
         } 

         System.out.printf(
            "earned $%,.2f%n%n", currentEmployee.earnings());
      } 

      // get type name of each object in employees array
      for (int j = 0; j < employees.length; j++)
         System.out.printf("Employee %d is a %s%n", j, 
            employees[j].getClass().getName());
     	System.out.println();
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
      return getBaseSalary() + super.earnings();
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
      return String.format("%s %s%n%s:%9.2f", 
      	"base-salaried", super.toString(), 
      	"base salary", getBaseSalary());   
   } 
}


class CommissionEmployee extends Employee
{
   private double grossSales; // gross weekly sales       
   private double commissionRate; // commission percentage

   // five-argument constructor                                       
   public CommissionEmployee(String firstName, String lastName, 
      String dni, double grossSales, double commissionRate)
   {                                                                  
   	super(firstName, lastName, dni);

      // if grossSales is invalid throw exception
      if (grossSales < 0.0) 
         throw new IllegalArgumentException(
            "Gross sales must be >= 0.0");

      // if commissionRate is invalid throw exception
      if (commissionRate <= 0.0 || commissionRate >= 1.0)
         throw new IllegalArgumentException(
            "Commission rate must be > 0.0 and < 1.0");

      this.grossSales = grossSales;
      this.commissionRate = commissionRate;
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
      return getCommissionRate() * getGrossSales();
   } 

   @Override // indicates that this method overrides a superclass method
   public String toString()                                             
   {                                                                    
      return String.format("%s: %s%n%s: %.2f%n%s: %.2f",    
         "commission employee", super.toString(),                
         "gross sales", getGrossSales(),                                     
         "commission rate", getCommissionRate());                           
   } 
}


class HourlyEmployee extends Employee 
{
   private double wage; // wage per hour
   private double hours; // hours worked for week

   // constructor
   public HourlyEmployee(String firstName, String lastName,
      String dni, double wage, double hours)
   {
      super(firstName, lastName, dni);

      if (wage < 0.0) // validate wage
         throw new IllegalArgumentException(
            "Hourly wage must be >= 0.0");

      if ((hours < 0.0) || (hours > 168.0)) // validate hours
         throw new IllegalArgumentException(
            "Hours worked must be >= 0.0 and <= 168.0");

      this.wage = wage;
      this.hours = hours;
   } 

   public void setWage(double wage)
   {
      if (wage < 0.0) // validate wage
         throw new IllegalArgumentException(
            "Hourly wage must be >= 0.0");

      this.wage = wage;
   } 

   public double getWage()
   {
      return wage;
   } 

   public void setHours(double hours)
   {
      if ((hours < 0.0) || (hours > 168.0)) // validate hours
         throw new IllegalArgumentException(
            "Hours worked must be >= 0.0 and <= 168.0");

      this.hours = hours;
   } 

   public double getHours()
   {
      return hours;
   } 

   // calculate earnings; override abstract method earnings in Employee
   @Override                                                           
   public double earnings()                                            
   {                                                                   
      if (getHours() <= 40) // no overtime                           
         return getWage() * getHours();                                
      else                                                             
         return 40 * getWage() + (getHours() - 40) * getWage() * 1.5;
   }                                          

   @Override                                                             
   public String toString()                                              
   {                                                                     
      return String.format("hourly employee: %s%n%s: $%,.2f; %s: %,.2f",
         super.toString(), "hourly wage", getWage(),                     
         "hours worked", getHours());                                   
   }                                    
}


class SalariedEmployee extends Employee 
{
   private double weeklySalary;

   // constructor
   public SalariedEmployee(String firstName, String lastName, 
      String dni, double weeklySalary)
   {
      super(firstName, lastName, dni); 

      if (weeklySalary < 0.0)
         throw new IllegalArgumentException(
            "Weekly salary must be >= 0.0");

      this.weeklySalary = weeklySalary;
   } 

   public void setWeeklySalary(double weeklySalary)
   {
      if (weeklySalary < 0.0)
         throw new IllegalArgumentException(
            "Weekly salary must be >= 0.0");

      this.weeklySalary = weeklySalary;
   } 

   public double getWeeklySalary()
   {
      return weeklySalary;
   } 

   // calculate earnings; override abstract method earnings in Employee
   @Override                                                           
   public double earnings()                                            
   {                                                                   
      return getWeeklySalary();                                        
   }                                             

   // return String representation of SalariedEmployee object   
   @Override                                                    
   public String toString()                                     
   {                                                            
      return String.format("salaried employee: %s%n%s: $%,.2f",
         super.toString(), "weekly salary", getWeeklySalary());
   } 
}


abstract class Employee 
{
   private final String firstName;
   private final String lastName;
   private final String dni;

   // constructor
   public Employee(String firstName, String lastName, 
      String dni)
   {
      this.firstName = firstName;                                    
      this.lastName = lastName;                                    
      this.dni = dni;         
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

   // return String representation of Employee object
   @Override
   public String toString()
   {
      return String.format("%s %s%ndni number: %s", 
         getFirstName(), getLastName(), getDni());
   } 

   // abstract method must be overridden by concrete subclasses
   public abstract double earnings(); // no implementation here
}
