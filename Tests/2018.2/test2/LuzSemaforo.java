public enum LuzSemaforo 
{
   // construimos tres constantes
   ROJO(10),
   VERDE(55),
   AMARILLO(5);
   
   private final int duracion;
   
   // constructor
   LuzSemaforo(int duracion)
   {
      this.duracion = duracion;
   }
   
   // metodo de acceso
   public int getDuracion()
   {
      return duracion;
   }
}
