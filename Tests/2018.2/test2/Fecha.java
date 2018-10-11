public class Fecha 
{
   private int mes;
   private int dia;
   private int anho;
   
   private static final int[] diasPorMes = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
   
   public Fecha(Fecha fecha) // constructor que toma un objeto
   {
      this(fecha.getAnho(), fecha.getMes(), fecha.getDia());
   }
   
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
      if (mes == 12)
      {
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
   
   public int getDia()
   {
      return dia;
   }
   public int getMes()
   {
      return mes;
   }
   public int getAnho()
   {
      return anho;
   }
   
   public String toString()
   {
      return String.format("%4d/%02d/%02d", anho, mes, dia);
   }
}
