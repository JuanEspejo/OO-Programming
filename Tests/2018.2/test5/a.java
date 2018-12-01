import java.util.Scanner;

public class a 
{
	public static void main(String[] args) 
	{
   	Scanner entrada = new Scanner(System.in);
   	int opcion;
   	do 
   	{
   		System.out.printf("%n%s%n%s%n%s%n%s%n%n%s", 
   			"Menu", "0.-salir", "1.-pregunta 1", 
   			"2.-pregunta 2", "Seleccione una de las opciones: ");
      	opcion = entrada.nextInt();
      	switch (opcion) 
      	{
      		case 0:
         		break;
         	case 1:
         		pregunta1();
         	   break;
         	case 2:
         		pregunta2();
         	break;
			}
		} while (opcion != 0);
	}

	public static void pregunta1() 
	{
   	Estudiante estudiantes[] = new Estudiante[4];
   	estudiantes[0] = new EstudianteRegular(5);
		estudiantes[1] = new EstudianteRegular(2);
		estudiantes[2] = new EstudianteTrasladado(2);
		estudiantes[3] = new EstudianteTrasladado(1);

		for (Estudiante estudiante : estudiantes) 
		{
      	System.out.println(estudiante);
		}
	}

	public static void pregunta2() 
	{
		Redimensionable redimensionables[] = new Redimensionable[2];
		redimensionables[0] = new Circulo(5);
   	redimensionables[1] = new Persona(70, 1.70);

		for (Redimensionable rdm : redimensionables) 
		{
			System.out.println("******************************");
			System.out.printf("%s%n", rdm.getClass().getSimpleName());
         System.out.printf("%s%n%s%n", "Antes del incremento", rdm.toString());
         rdm.redimensionar(10);
         System.out.printf("%s%n%s%n", "Despues del incremento", rdm.toString());
		}
		System.out.println("******************************");
	}   
}



abstract class Estudiante 
{
	private int ndpa;

	public void establecerNdpa(int ndpa) 
	{
   	this.ndpa = ndpa;
	}
	
	public int obtenerNdpa() 
	{
   	return ndpa;
	}

	public abstract boolean aprobado();
}


class EstudianteRegular extends Estudiante 
{
	public EstudianteRegular(int ndpa) 
	{
   	if (ndpa < 0 || 6 < ndpa)
   		throw new IllegalArgumentException
      		("El número de prácticas es incorrecto.");
      establecerNdpa(ndpa);
	}

	@Override
   public boolean aprobado() 
   {
   	return obtenerNdpa() >= 4;
	}
	
	@Override
	public String toString() 
	{
   	String es = String.format
   		("[Estudiante regular]%nPrácticas aprobadas: %d, estado: ",
   		obtenerNdpa());
		return (aprobado()) ? es.concat("aprobó") : es.concat("desaprobó");
   }
}


class EstudianteTrasladado extends Estudiante 
{
	public EstudianteTrasladado(int ndpa) 
   {
   	if (ndpa < 0 || 3 < ndpa)
   		throw new IllegalArgumentException
      		("El número de prácticas es incorrecto.");
      establecerNdpa(ndpa);
	}

	@Override
   public boolean aprobado() 
   {
   	return obtenerNdpa() >= 2;
   }

	@Override
   public String toString() 
   {
   	String es = String.format
   		("[Estudiante trasladado]%nPrácticas aprobadas: %d, estado: ",
   		obtenerNdpa());
   	return (aprobado()) ? es.concat("aprobó") : es.concat("desaprobó");
	}
}


interface Redimensionable 
{
	void redimensionar(int porcentaje);
}

	
class Circulo implements Redimensionable 
{
	private double radio;

	public Circulo(double radio) 
	{
   	this.radio = radio;
   }

	public double obtenerRadio()
	{
		return radio;
	}

	public double obtenerPerimetro() 
	{
		return 2 * Math.PI * obtenerRadio();
	}

	public double obtenerArea() 
	{
		return Math.PI * Math.pow(obtenerRadio(), 2);
	}

	@Override
	public void redimensionar(int porcentaje) 
	{
   	radio = ((100 + (double) porcentaje) / 100) * obtenerRadio();
	}

	@Override
   public String toString() 
   {
		return String.format("%s %.2f%n Area: %.2f%n Perimetro: %.2f",
			"Circulo de radio", obtenerRadio(), 
			obtenerArea(), obtenerPerimetro());
	}
}


class Persona implements Redimensionable 
{
	private double masa;
   private double estatura;

	public Persona(double masa, double estatura) 
	{
   	this.masa = masa;
		this.estatura = estatura;
	}

	public double obtenerMasa()
	{
		return masa;
	}

	public double obtenerEstatura()
	{
		return estatura;
	}
	
	public double obtenerIMC() 
	{
		return obtenerMasa() / Math.pow(obtenerEstatura(), 2);
	}

   @Override
   public void redimensionar(int porcentaje) 
   {
   	masa = ((100 + (double) porcentaje) / 100) * obtenerMasa();
	}

	@Override
	public String toString() 
	{
		return String.format("%s %.2f kg y %.2f m%n ICM: %.2f",
			"Persona de", obtenerMasa(), obtenerEstatura(), 
			obtenerIMC());
	}
}
