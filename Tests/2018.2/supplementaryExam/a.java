import java.io.Serializable;
import java.io.IOException;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.lang.IllegalStateException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Formatter;
import java.util.FormatterClosedException;

public class a
{
   private static Scanner input;
	private static ObjectOutputStream output; 
	private static ObjectInputStream input2;
	private static Formatter output2;
	
   public static void main(String[] args)
   {
   	Scanner entrada = new Scanner(System.in);
      int opcion;
   	do 
		{
			System.out.printf("%n%s%n%s%n%s%n%s%n%n%s", 
            "Menu", "0.- salir", "1.- pregunta 1",
            "2.- pregunta 2", 
            "Seleccione una de las opciones: ");
      	opcion = entrada.nextInt();
            
      	switch(opcion)
      	{
         	case 0: break;
            case 1: pregunta1(); break;
            case 2: pregunta2(); break;
         }
      } while(opcion != 0);
   } 

	public static void pregunta1()
   {
      openFiles();
      readAndWriteRecords();
      closeFiles();
   	openReadAndCloseBinaryFile();
  	}	

	public static void pregunta2()
   {
   	writeText();
      readText();
  	}	
      
   // open files
   public static void openFiles(){
      try
      {
         input = new Scanner(Paths.get("sst8s110w.ascii"));
         output = new ObjectOutputStream(
            Files.newOutputStream(Paths.get("sst8s110w.ser"))); 
      } 
      catch (IOException ioException)
      {
         System.err.println("Error opening file. Terminating.");
         System.exit(1);
      } 
   }

   // read and write files
   public static void readAndWriteRecords()
   {
      try 
      {
      	for(int i=0; i<18; i++) input.next(); 

			Fecha fecha = new Fecha(2016,1,1);
			 		  		  		 	     
         while (input.hasNext())
         {
         	input.next(); input.next();
         	double temperatura = input.nextDouble();
         	input.next(); input.next();
         	
         	Registro registro = new Registro
         		(fecha.obtenerAnho(), fecha.obtenerMes(), 
         		fecha.obtenerDia(), temperatura);
         	output.writeObject(registro); 
         	fecha.siguienteDia();
         }
      }
       
      catch (NoSuchElementException elementException)
      {
         System.err.println("File improperly formed. Terminating.");
      } 
      catch (IOException ioException)
      {
         System.err.println("Error writing to file. Terminating.");
      } 
      catch (IllegalStateException stateException)
      {
         System.err.println("Error reading from file. Terminating.");
      } 
   }

   // close files and terminate application
   public static void closeFiles()
   {
   	try
   	{
      	if (input != null) input.close();
      	if (output != null) output.close();
      }
      catch (IOException ioException)
      {
         System.err.println("Error closing file. Terminating.");
      } 
   } 
   
   public static void openReadAndCloseBinaryFile()
   {
   	try // open file
      {
         input2 = new ObjectInputStream(          
            Files.newInputStream(Paths.get("sst8s110w.ser")));
      } 
      catch (IOException ioException)
      {
         System.err.println("Error opening file.");
         System.exit(1);
      }
      
      try // read record from binaty file 
      {
         while (true) // loop until there is an EOFException
         {
            Registro registro = (Registro) input2.readObject();
            System.out.printf("%s%n", registro);
         } 
      }
      catch (EOFException endOfFileException)
      {
         System.out.printf("%nNo more records%n");
      } 
      catch (ClassNotFoundException classNotFoundException)
      {
         System.err.println("Invalid object type. Terminating.");
      } 
      catch (IOException ioException)
      {
         System.err.println("Error reading from file. Terminating.");
      }
      
      try // close binary file
      {
         if (input2 != null)
            input2.close();
      } 
      catch (IOException ioException)
      {
         System.err.println("Error closing file. Terminating.");
         System.exit(1);
      }
   }   
   
   public static void writeText()
   {
   	try
      {
         output2 = new Formatter("profesores.txt"); // open the file
      }
      catch (SecurityException securityException)
      {
         System.err.println("Write permission denied. Terminating.");
         System.exit(1); // terminate the program
      } 
      catch (FileNotFoundException fileNotFoundException)
      {
         System.err.println("Error opening file. Terminating.");
         System.exit(1); // terminate the program
      }
      
      try
      {
      	Profesor[] profe = new Profesor[4];
        	profe[0] = new Ingeniero("Blas Silva", "20001659F",
        		true, true, false);
        	profe[1] = new Cientifico("Juan Perez", "19981789G",
        		true, false);
        	profe[2] = new Arquitecto("Mario Plano", "20017962H",
        		false, true);		
        	profe[3] = new Ingeniero("Felix Escuadra", "20021178F",
        		true, false, true);
        		
        	for(Profesor profesor: profe)
        		output2.format("%s%n", profesor);
                             
      } 
      catch (FormatterClosedException formatterClosedException)
      {
      	System.err.println("Error writing to file. Terminating.");
      } 
      catch (NoSuchElementException elementException)
      {
      	System.err.println("Invalid input. Please try again.");
         input.nextLine(); // discard input so user can try again
      }
      
      if (output2 != null) output2.close();
   }
   
   public static void readText()
   {
   	try
      {
         input = new Scanner(Paths.get("profesores.txt")); 
      } 
      catch (IOException ioException)
      {
         System.err.println("Error opening file. Terminating.");
         System.exit(1);
      }
      
      try 
      {
			while(input.hasNext())
         	System.out.println(input.nextLine());
      } 
      catch (NoSuchElementException elementException)
      {
         System.err.println("File improperly formed. Terminating.");
      } 
      catch (IllegalStateException stateException)
      {
         System.err.println("Error reading from file. Terminating.");
      }
   }
}


class Fecha implements Serializable
{

   private int anho;
   private int mes;
   private int dia;
   private final int[] diasPorMes = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
   
   public Fecha(int anho, int mes, int dia)
   {
      if(mes < 1 || mes > 12)
         throw new IllegalArgumentException("mes (" + mes + ") debe estar en el intervalo 1-12");
      if(dia < 1 || (dia > diasPorMes[mes] && !(mes == 2 && dia == 29)))
         throw new IllegalArgumentException("dia (" + dia + ") fuera del rango para el mes y año especificados");
      if(mes == 2 && dia == 29 && !(anho % 400 == 0 || (anho % 4 == 0 && anho % 100 != 0)))
         throw new IllegalArgumentException("dia (" + dia + ") fuera del rango para el mes y año especificados");
      
      this.mes = mes;
      this.dia = dia;
      this.anho = anho;
   }
   
   public boolean esBisiesto()
   {
      return (anho % 400 == 0 || (anho % 4 == 0 && anho % 100 != 0));
   }
   
   public void siguienteAnho()
   {
      ++anho;
   }
   
   public void siguienteMes()
   {
      if (mes == 12){
         siguienteAnho();
         mes = 1;
      }
      else
         ++mes;
   }
   
   public void siguienteDia()
   {
      if(dia == 28 && mes == 2 && !esBisiesto())
      {
         siguienteMes();
         dia = 1;
      }
      else if(dia == 29 && mes == 2)
      {
         siguienteMes();
         dia = 1;
      }
      else if(dia == 28 && mes == 2 && esBisiesto())
         ++dia;
      else if(dia == diasPorMes[mes])
      {
         siguienteMes();
         dia = 1;
      }
      else
         ++dia;
   }

   public int obtenerDia()
   {
      return dia;
   }
   
   public int obtenerMes()
   {
      return mes;
   }
   
   public int obtenerAnho()
   {
      return anho;
   }
   
   public String toString()
   {
		return String.format("%5d%3d%3d", 
			obtenerAnho(), obtenerMes(), obtenerDia());   
   }   
}


class Registro implements Serializable
{
	private Fecha fecha;
	private double temperatura;
	
		public Registro(int anho, int mes, int dia, double temperatura)
	{
		fecha = new Fecha(anho, mes, dia);
		if(temperatura < 0)
			throw new IllegalArgumentException
			("temperatura (" + temperatura + ") fuera del rango");
		this.temperatura = temperatura;
	}
		
	public double obtenerTemperatura()
	{
		return temperatura;
	}
	
	public String toString()
	{
		return String.format("%s%7.2f", fecha, obtenerTemperatura());		
	}	
}
class Cientifico extends Profesor
{
	private boolean patentes;
	
	public Cientifico(String nombre, String codigo, boolean regina, 
		boolean patentes)
	{
		super(nombre, codigo, regina);
		this.patentes = patentes;
	}	
	
	public boolean obtenerPatentes()
	{
		return patentes;
	}
	@Override
	public double obtenerSaldoTotal()
	{
		return obtenerSaldo() + (obtenerRegina()?0.25*obtenerSaldo():0) 
			+ (obtenerPatentes()?1500:0);
	}
	@Override
	public String toString()
	{
		return String.format("Cientifico %s%s", super.toString(), 
			obtenerPatentes()?" Tiene patentes.": "");
	}				
}
class Ingeniero extends Profesor
{
	private boolean patentes;
	private boolean consultorias;
	
	public Ingeniero(String nombre, String codigo, boolean regina, 
		boolean patentes, boolean consultorias)
	{
		super(nombre, codigo, regina);
		this.patentes = patentes;
		this.consultorias = consultorias;
	}	
	
	public boolean obtenerPatentes()
	{
		return patentes;
	}
	public boolean obtenerConsultorias()
	{
		return consultorias;
	}
	@Override
	public double obtenerSaldoTotal()
	{
		return obtenerSaldo() + (obtenerRegina()?0.25*obtenerSaldo():0) 
			+ (obtenerPatentes()?1500:0) + (obtenerConsultorias()?1000:0);
	}
	@Override
	public String toString()
	{
		return String.format("Ingeniero %s%s%s", super.toString(), 
			obtenerPatentes()?" Tiene patentes.": "", 
			obtenerConsultorias()?" Hace consultorías.": "");
	}				
}
class Arquitecto extends Profesor
{
	private boolean consultorias;
	
	public Arquitecto(String nombre, String codigo, boolean regina, 
		boolean consultorias)
	{
		super(nombre, codigo, regina);
		this.consultorias = consultorias;
	}	
	
	public boolean obtenerConsultorias()
	{
		return consultorias;
	}
	public double obtenerSaldoTotal()
	{
		return obtenerSaldo() + (obtenerRegina()?0.25*obtenerSaldo():0) 
			+ (obtenerConsultorias()?1000:0);
	}
	@Override
	public String toString()
	{
		return String.format("Arquitecto %s%s", super.toString(), 
			obtenerConsultorias()?" Hace consultorías.": "");
	}				
}
abstract class Profesor
{
	private String nombre;
	private String codigo;
	private boolean regina;
	private final double saldo = 3000;
	public Profesor(String nombre, String codigo, boolean regina)
	{
		this.nombre = nombre;
		this.codigo = codigo;
		this.regina = regina;		
	}	
	
	public String obtenerNombre()
	{
		return nombre;
	}
	public String obtenerCodigo()
	{
		return codigo;
	}
	public boolean obtenerRegina()
	{
		return regina;
	}
	public double obtenerSaldo()
	{
		return saldo;
	}
	public double obtenerSaldoTotal()
	{
		return saldo;
	}
	@Override
	public String toString()
	{
		return String.format("%s. Código: %s.%s%6.0f%s%n%s", obtenerNombre(), 
			obtenerCodigo(), " Saldo Total: ", obtenerSaldoTotal(), 
			" Soles.",  obtenerRegina()?"Investigador REGINA.": "");
	}			
}
