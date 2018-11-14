// Exercise 10.10: Payroll System Modification
// Employee hierarchy test program.

public class a
{
   public static void main(String[] args) 
   {
      // create four-element Employee array
      Employee[] employees = new Employee[4]; 

      // initialize array with Employees
      employees[0] = new SalariedEmployee(
      	"Fabio", "Pantoja", "94550012", 11, 25, 1998, 800.00);
      employees[1] = new HourlyEmployee(
      	"Mario", "Aguilar", "22221015", 12, 25, 1988, 16.5, 40);
      employees[2] = new CommissionEmployee(
     		"Gerald", "Salazar", "84550013", 11, 25, 1999, 10000, .06); 
      employees[3] = new BasePlusCommissionEmployee(
         "David", "Ruegg", "75440015", 10, 25, 1997, 5000, .04, 300);

      System.out.printf("Employees processed polymorphically:%n%n");
      
      // generically process each element in array employees
      for (Employee currentEmployee : employees) 
      {
         System.out.println(currentEmployee); // invokes toString
         System.out.printf("earned $%,.2f%n%n", 
         	currentEmployee.earnings());
         // determine whether element is a BasePlusCommissionEmployee
         if (currentEmployee.getBirthMonth() == 11) 
         {
            System.out.printf(
               "%s, %s%n%s $%,.2f%n%n",
               "since this month is your birthday",
               "u have a bonus of $100.00",
               "so you earned",
               100 + currentEmployee.earnings());
         } 
      } 
   }
}


class BasePlusCommissionEmployee extends CommissionEmployee
{
   private double baseSalary; // base salary per week

   // six-argument constructor
   public BasePlusCommissionEmployee(String firstName, String lastName, 
      String dni, int month, int day, int year, double grossSales, 
      double commissionRate, double baseSalary)
   {
      // explicit call to superclass CommissionEmployee constructor
      super(firstName, lastName, dni, month, day, year, 
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
      String dni, int month, int day, int year,
      double grossSales, double commissionRate)
   {                                                                  
   	super(firstName, lastName, dni, month, day, year);

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
      String dni, int month, int day, int year, double wage, double hours)
   {
      super(firstName, lastName, dni, month, day, year);

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
      String dni, int month, int day, int year, double weeklySalary)
   {
      super(firstName, lastName, dni, month, day, year); 

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
   private final Date birthDate;

   // constructor
   public Employee(String firstName, String lastName, 
      String dni, int month, int day, int year)
   {
   	birthDate = new Date(month, day, year);
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
   
   public int getBirthMonth()
   {
   	return birthDate.getMonth();	
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


class Date 
{
   private int month; // 1-12
   private int day; // 1-31 based on month
   private int year; // any year

   private static final int[] daysPerMonth = 
      {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
   
   // constructor: confirm proper value for month and day given the year
   public Date(int month, int day, int year)
   {
      // check if month in range
      if (month <= 0 || month > 12)
         throw new IllegalArgumentException(
            "month (" + month + ") must be 1-12");

      // check if day in range for month
      if (day <= 0 || 
         (day > daysPerMonth[month] && !(month == 2 && day == 29)))
         throw new IllegalArgumentException("day (" + day + 
            ") out-of-range for the specified month and year");

      // check for leap year if month is 2 and day is 29
      if (month == 2 && day == 29 && !(year % 400 == 0 || 
           (year % 4 == 0 && year % 100 != 0)))
         throw new IllegalArgumentException("day (" + day +
            ") out-of-range for the specified month and year");

      this.month = month;
      this.day = day;
      this.year = year;

      System.out.printf(
         "Date object constructor for date %s%n", this);
   } 
   
   // return a String of the form month/day/year
   public String toString()
   { 
      return String.format("%d/%d/%d", month, day, year); 
   }
   
   public int getMonth()
   {
   	return month;
   } 
}
