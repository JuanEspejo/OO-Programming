import java.io.EOFException;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.SecurityException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;



public class a 
{
    private static ObjectOutputStream output;
    private static ObjectInputStream input;
    private static Formatter outputF;
    private static Scanner input2;
    
    public static void main(String[] args) 
    {
        Scanner entrada = new Scanner(System.in);
        int opcion;
        do 
		{
            System.out.printf(
            "%n%s%n%s%n%s%n%s%n%n%s", 
            "Menu", "0.- salir", "1.- pregunta 1",
            "2.- pregunta 2", 
            "Seleccione una de las opciones: ");
            opcion = entrada.nextInt();
            
            switch(opcion){
                case 0: break;
                case 1:
                    pregunta1();
                    break;
                case 2:
                    pregunta2();
                    break;
                
            }
            
        } while(opcion != 0);
    } 
    
    public static void pregunta1()
    {
        Abeja maya = new Abeja("Maya");
        Hormiga fuerte = new Hormiga("Fuerte");
        
        // escritura del archivo binario

        try
        {
            output = new ObjectOutputStream(Files.newOutputStream(Paths.get("movibles.ser")));
        }
        catch(IOException ioException)
        {
            System.err.println("Error opening file. Terminating.");
            System.exit(1);
        }
        
        try
        {
            output.writeObject(maya);
            output.writeObject(fuerte);
        }
        catch(IOException ioException)
        {
            System.err.println("Error writing objects");
        }

        try
        {
            if(output != null)
                output.close();
        }
        catch(IOException ioException)
        {
            System.err.println("Error closing file.");
        }

        
        // lectura del archivo binario

        try
        {
            input = new ObjectInputStream(Files.newInputStream(Paths.get("movibles.ser")));
        }
        catch(IOException ioException)
        {
            System.err.println("Error opening file. Terminating");
            System.exit(1);
        }
        
        try
        {
            while(true)
            {
                Movible movible = (Movible) input.readObject();
                System.out.printf("%s%s%n%s%n", "Tipo: ", 
                	movible.getClass().getName(), movible);
            }
        }
        catch(EOFException endOfFileException)
        {
            System.out.println("Fin del archivo.");
        }
        catch(ClassNotFoundException classNotFoundException)
        {
            System.err.println("Invalid Object type.");
        }
        catch(IOException ioException)
        {
            System.err.println("Error reading from file.");
        }
        
        try
        {
            if(input != null)
                input.close();
        }
        catch(IOException ioException)
        {
            System.err.println("Error closing file. Terminating.");
            System.exit(1);
        }
    }
    
    
    public static void pregunta2()
    {
        Citable[] citaciones = new Citable[4];
        citaciones[0] = new Libro("The C++ programming language.", "Bjarne Stroutsrup.", "Pearson Education India.", 10304);
        citaciones[1] = new Articulo("What is object-oriented programming?", "Bjarne Stroutstrup.", "IEEE software 5 (3), 10-20.", 321);
        citaciones[2] = new Libro("Object-oriented database systems: concepts and architectures.", "Elisa Bertino.", "Addison-Wesley Longman Publishing Co.. Inc.", 341);
        citaciones[3] = new Articulo("State-of-the-art in privacy preserving data mining.", "Elisa Bertino.", "ACM SIgmod Record 33 (1), 50-57.", 956);

        // escritura del archivo de texto

        try
        {
            outputF = new Formatter("citables.txt");
        }
        catch(SecurityException securityException)
        {
            System.err.println("Write permission denied. Terminating.");
            System.exit(1);
        }
        catch(FileNotFoundException fileNotFoundException)
        {
            System.err.println("Error opening file. Terminating.");
            System.exit(1);
        }

        for(Citable citable: citaciones)
        {
            try
            {
                outputF.format(citable.toString());
            }
            catch(FormatterClosedException formatterClosedException)
            {
                System.err.println("Error writing to file. Terminating.");
                break;
            }
        }

		if(outputF != null)
        	outputF.close();
                
        // lectura del archivo de texto
        
        try
        {
            input2 = new Scanner(Paths.get("citables.txt"));
        }
        catch(IOException ioException)
        {
            System.err.println("Error opening file. Terminating.");
            System.exit(1);
        }
        
        try
        {
            while(input2.hasNext())
                System.out.println(input2.nextLine());
        }
        catch(IllegalStateException stateException)
        {
            System.err.println("Error reading from file. Terminating.");
        }
        
        if(input2 != null)
        	input2.close();
    }
    
}



//clases de pregunta 1

class Abeja extends Insecto implements Movible
{
    public Abeja(String name)
    {
        super.setName(name);
        super.setRecorrido(obtenerRecorrido());
    }
    
    @Override
    public double moverse(double iniX, double iniY, double finX, double finY)
    {
        double diametro;
        diametro = 
        	Math.sqrt(Math.pow(iniX - iniY, 2) + Math.pow(finX - finY, 2));
        return diametro*Math.PI/2;
    }
    
    @Override
    public double obtenerRecorrido()
    {
        return moverse(0, 0, 1, 2) + moverse(1, 2, 2, 5) + 
        	moverse(2, 5, 4, 8);
	}
}


class Hormiga extends Insecto implements Movible
{
    public Hormiga(String name)
    {
        super.setName(name);
        super.setRecorrido(obtenerRecorrido());
    }
        
    @Override
    public double moverse(double iniX, double iniY, double finX, double finY)
    {
        return Math.sqrt(Math.pow(iniX - iniY, 2) + Math.pow(finX - finY, 2));
    }
    
    @Override
    public double obtenerRecorrido()
    {
        return moverse(0, 0, 1, 2) + moverse(1, 2, 2, 5) + 
        	moverse(2, 5, 4, 8);       
    }   
}


interface Movible
{
    abstract double moverse(double iniX, double iniY, double finX, double finY);
    abstract double obtenerRecorrido();
}


abstract class Insecto implements Serializable
{
    private double recorrido;
    private String name;
    
    public double getRecorrido()
    {
        return recorrido;
    }
    
    public void setRecorrido(double recorrido)
    {
        this.recorrido = recorrido;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    @Override
    public String toString()
    {
        return String.format("%s%s%n%s%.2f%n", "Nombre: ", getName(), 				"Recorrido: ", getRecorrido());
    }
}



//clases de pregunta 2

abstract class Citable
{
    private String titulo;
    private String autor;
    private int citaciones;
    
    public Citable(String titulo, String autor, int citaciones)
    {
        this.titulo = titulo;
        this.autor = autor;
        this.citaciones = citaciones;
    }
    
    public void setTitulo(String titulo)
    {
        this.titulo = titulo;
    }
    
    public void setAutor(String autor)
    {
        this.autor = autor;
    }
    
    public void setCitaciones(int citaciones)
    {
        this.citaciones = citaciones;
    }
    
    public String getTitulo()
    {
        return this.titulo;
    }
    
    public String getAutor()
    {
        return this.autor;
    }
    
    public int getCitaciones()
    {
        return this.citaciones;
    }
}


class Libro extends Citable
{
    private String editorial;

    public Libro(String titulo, String autor, String editorial, int citaciones)
    {
        super(titulo, autor, citaciones);
        this.editorial = editorial;
    }
    
    public void setEditorial(String editorial)
    {
        this.editorial = editorial;
    }
    public String getEditorial()
    {
        return editorial;
    }
    
    @Override
    public String toString()
    {
        return String.format("%s %s %s %s %d%s%n", super.getTitulo(), super.getAutor(), getEditorial(), "[citado por", super.getCitaciones(), "]");
    }
}


class Articulo extends Citable
{
    private String revista;

    public Articulo(String titulo, String autor, String revista, int citaciones)
    {
        super(titulo, autor, citaciones);
        this.revista = revista;
    }
    
    public void setRevista(String revista)
    {
        this.revista = revista;
    }
    public String getRevista()
    {
        return revista;
    }
    
    @Override
    public String toString()
    {
        return String.format("%s %s %s %s %d%s%n", super.getTitulo(), super.getAutor(), getRevista(), "[citado por", super.getCitaciones(), "]");
    }
}
