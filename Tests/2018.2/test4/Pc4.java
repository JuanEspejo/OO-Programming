import java.util.Scanner;

public class Pc2 {
   
   public static void main(String[] args){
      Scanner entrada = new Scanner(System.in);
      int opcion;
      do{
         System.out.printf("%n%s%n%s%n%s%n%s%n%n%s", "Menu", "0.- salir", "1.- pregunta 1", "2.- pregunta 2", "Seleccione una de las opciones: ");
         opcion = entrada.nextInt();
         switch(opcion){
            case 1:
               pregunta1();
               break;
            case 2:
               pregunta2();
         }
      } while(opcion != 0);
   }

   public static void pregunta1(){
      EmpleadoPorComision empleado = new EmpleadoPorComision("David", "Ruegg", 77797352, 2800, 0.1);
      System.out.printf("%s%n", empleado.toString());
   }

   public static void pregunta2(){
      EmpleadoPorHoras empleado = new EmpleadoPorHoras("David", "Ruegg", 77797352, 1000, 41);
      System.out.printf("%s%n", empleado.toString());
   }   
   
}


class Empleado{
   
   private String primerNombre;
   private String apellidoPaterno;
   private int dni;
   
   public Empleado(String primerNombre, String apellidoPaterno, int dni){
      this.primerNombre = primerNombre;
      this.apellidoPaterno = apellidoPaterno;
      this.dni = dni;
   }
   
   public String obtenerPrimerNombre(){return primerNombre;}
   public String obtenerApellidoPaterno(){return apellidoPaterno;}
   public int obtenerDni(){return dni;}
   
   @Override
   public String toString(){return String.format("%s: %s %s%n%s: %d", 
   	"Nombre y apellido", obtenerPrimerNombre(), 
   	obtenerApellidoPaterno(), "DNI", obtenerDni());
   }
   
}


class EmpleadoPorComision extends Empleado{
 
   private double ventasBrutas;
   private double tarifaComision;

   public double obtenerVentasBrutas(){return ventasBrutas;}
   public double obtenerTarifaComision(){return tarifaComision;}
 
   public void establecerVentasBrutas(double ventasBrutas){
      if(ventasBrutas >= 0)
         this.ventasBrutas = ventasBrutas;
      else
         throw new IllegalArgumentException
         	("Ventas brutas deben ser mayores a 0");
   }

   public void establecerTarifaComision(double tarifa){
      if(tarifa >= 0 && tarifa <= 1)
         this.tarifaComision = tarifa;
      else
         throw new IllegalArgumentException
         	("Tarifa debe estar entre 0 y 1");
   }
   
   public EmpleadoPorComision(String primerNombre, String apellidoPaterno, 
   	int dni, double ventasBrutas, double tarifaComision){
      super(primerNombre, apellidoPaterno, dni);     
      if(ventasBrutas >= 0)
         this.ventasBrutas = ventasBrutas;
      else
         throw new IllegalArgumentException
         	("Ventas brutas deben ser mayores a 0");
      if(tarifaComision >= 0 && tarifaComision <= 1)
         this.tarifaComision = tarifaComision;
      else
         throw new IllegalArgumentException
         	("Tarifa debe estar entre 0 y 1");
   }
   
   @Override
   public String toString(){
      return String.format("%s%n%s: %.2f%n%s: %.2f", super.toString(), 
      	"Ventas brutas", obtenerVentasBrutas(), 
      	"Tarifa comision", obtenerTarifaComision());
   }
   
}


class EmpleadoPorHoras extends Empleado{

   private double horas;
   private double sueldo;

   public double obtenerHoras(){return horas;}
   public double obtenerSueldo(){return sueldo;}

   public void establecerSueldo(double sueldo){
      if(sueldo >= 0)
         this.sueldo = sueldo;
      else
         throw new IllegalArgumentException
         	("Sueldo debe ser mayor a 0");
   }

   public void establecerHoras(double horas){
      if(horas >= 0 && horas <= 168)
         this.horas = horas;
      else
         throw new IllegalArgumentException
         	("Horas deben estar entre 0 y 168");
   }

   public double ingresos(){
      double exceso = 0;
      if(obtenerHoras() > 40)
         exceso = obtenerHoras() - 40;
      return obtenerHoras()*obtenerSueldo() + 
      	exceso*obtenerSueldo()*0.5;
   }
   
   public EmpleadoPorHoras(String primerNombre, String apellidoPaterno, 
   	int dni, double sueldo, double horas){
      super(primerNombre, apellidoPaterno, dni);
      if(sueldo >= 0)
         this.sueldo = sueldo;
      else
         throw new IllegalArgumentException
         	("Sueldo debe ser mayores a 0");      
      if(horas >= 0 && horas <= 168)
         this.horas = horas;
      else
         throw new IllegalArgumentException
         	("Horas deben estar entre 0 y 168");
   }
   
   @Override
   public String toString(){
      return String.format("%s%n%s: %.2f%n%s: %.2f%n%s: %.2f", 
      	super.toString(), "Sueldo", obtenerSueldo(), 
      	"Horas", obtenerHoras(),
      	"Ingresos", ingresos());
   }

}
