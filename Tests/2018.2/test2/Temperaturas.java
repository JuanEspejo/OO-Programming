public class Temperaturas {

   private Fecha[] fecha = new Fecha[10000]; // definimos un arreglo de clases Fecha
   private int longitud; 

   public Temperaturas()
   {
      Fecha temp = new Fecha(1994, 1, 1); // temp es un objeto temporal
      int i = 0; // declaramos i fuera del bucle para acceder a el fuera del bucle
      for (; temp.getAnho() != 2018; temp.siguienteDia())
      { // en cada ciclo vamos inicializando el elemento i-esimo del arreglo
         fecha[i++] = new Fecha(temp);
      }
      longitud = i; 
   }
   
   public void printFechas()
   {
      for (int i = 0; i < longitud;)
      {
         System.out.println(fecha[i++]);
      }
   }
}
