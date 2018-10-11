public class TresEnRaya {
   
   public enum celda {X, O, VACIO};   
   private celda[][] tablero = new celda[3][3]; 
   
   public TresEnRaya(){
      for(int i = 0; i < 3; i++){
         for(int j = 0; j < 3; j++){
            tablero[i][j] = celda.VACIO;
         }
      }   
   }
   
   public boolean celdaEstaVacia(int x, int y){
      return tablero[x][y] == celda.VACIO;
   }
   
   public void marcarX(int x, int y){
      tablero[x][y] = celda.X;
   }

   public void marcarO(int x, int y){
      tablero[x][y] = celda.O;
   }
   
   public boolean esXGanador(){
      return (tablero[0][0] == celda.X && tablero[0][1] == celda.X && tablero[0][2] == celda.X) ||
         (tablero[1][0] == celda.X && tablero[1][1] == celda.X && tablero[1][2] == celda.X) ||
         (tablero[2][0] == celda.X && tablero[2][1] == celda.X && tablero[2][2] == celda.X) ||
         (tablero[0][0] == celda.X && tablero[1][1] == celda.X && tablero[2][2] == celda.X) ||
         (tablero[2][0] == celda.X && tablero[1][1] == celda.X && tablero[0][2] == celda.X) ||
         (tablero[0][0] == celda.X && tablero[1][0] == celda.X && tablero[2][0] == celda.X) ||
         (tablero[0][1] == celda.X && tablero[1][1] == celda.X && tablero[2][1] == celda.X) ||
         (tablero[0][2] == celda.X && tablero[1][2] == celda.X && tablero[2][2] == celda.X);
   }
   
   public boolean esOGanador(){
      return (tablero[0][0] == celda.O && tablero[0][1] == celda.O && tablero[0][2] == celda.O) ||
         (tablero[1][0] == celda.O && tablero[1][1] == celda.O && tablero[1][2] == celda.O) ||
         (tablero[2][0] == celda.O && tablero[2][1] == celda.O && tablero[2][2] == celda.O) ||
         (tablero[0][0] == celda.O && tablero[1][1] == celda.O && tablero[2][2] == celda.O) ||
         (tablero[2][0] == celda.O && tablero[1][1] == celda.O && tablero[0][2] == celda.O) ||
         (tablero[0][0] == celda.O && tablero[1][0] == celda.O && tablero[2][0] == celda.O) ||
         (tablero[0][1] == celda.O && tablero[1][1] == celda.O && tablero[2][1] == celda.O) ||
         (tablero[0][2] == celda.O && tablero[1][2] == celda.O && tablero[2][2] == celda.O);
   }
   
   public void imprimirTablero()
   {
      System.out.printf("%n");
      for(int x = 0; x < 3; x++)
      {
         for(int y = 0; y < 3; y++)
         {
            if(tablero[x][y] == celda.X)
               System.out.printf(" X ");
            if(tablero[x][y] == celda.O)
               System.out.printf(" O ");
            if(tablero[x][y] == celda.VACIO)
               System.out.printf(" _ ");
         }
         System.out.printf("%n%n");
      }
   }
   
}
