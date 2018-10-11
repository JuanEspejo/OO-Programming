import java.util.Scanner;

public class Pc2{
   public static void main(String[] args){
      Scanner entrada = new Scanner(System.in);
      int opcion;
      do{
         System.out.printf("%n%s%n%s%n%s%n%s%n%s%n%n%s", "Menu", "1.- salir", "2.- pregunta 2", "3.- pregunta 3", "4.- pregunta 4", "Seleccione una de las opciones: ");
         opcion = entrada.nextInt();
         switch (opcion){
            case 2:
               pregunta2();
               break;
            case 3:
               pregunta3();
               break;
            case 4:
               pregunta4();
               break;
         }
      } while(opcion != 1);
   }
   
   public static void pregunta2(){
      for (LuzSemaforo semaforo : LuzSemaforo.values()){
         System.out.printf("%n Constante: %s%n Duración: %d%n", semaforo, semaforo.getDuracion());
      }
   }
   
   public static void pregunta3(){
      Temperaturas temp = new Temperaturas(); 
      temp.printFechas(); // imprimimos las fechas construidas
   }
   
   public static void pregunta4(){
      TresEnRaya juego = new TresEnRaya();
      int turno = 1; // el primer turno es para el jugador X
      int x, y, aux; // aux sera nuestra variable auxiliar
      Scanner entrada = new Scanner(System.in);
      
      while(turno < 10){ // mientras NO llegemos a la jugada nro 10
         aux = turno;
         juego.imprimirTablero(); // mostramos el tablero
         do{
            System.out.printf("Jugador X, ingrese la fila a marcar: ");
            x = entrada.nextInt() - 1;
            System.out.printf("Jugador X, ingrese la columna a marcar: ");
            y = entrada.nextInt() - 1;
            if(juego.celdaEstaVacia(x, y)) 
            {
               juego.marcarX(x, y);
               ++turno;
            }
            else
               System.out.println("Por favor marque en un recuadro vacio");
         } while(turno == aux); // mientras que turno NO se incremente seguimos en el bucle
         if(juego.esXGanador()){ // si X resultó ser el ganador y salimos del bucle
            System.out.printf("%nEl jugador X ganó%n");
            break;
         }
         if(turno == 10){ // si corresponde el turno 10 salimos tb y es un empate
            System.out.printf("%nEmpate%n");
            break;
         }
                  
         aux = turno;
         juego.imprimirTablero();
         do{
            System.out.printf("Jugador O ingrese la fila a marcar: ");
            x = entrada.nextInt() - 1;
            System.out.printf("Jugador O ingrese la columna a marcar: ");
            y = entrada.nextInt() - 1;
            if(juego.celdaEstaVacia(x, y)){
               juego.marcarO(x, y);
               ++turno;
            }
            else
               System.out.println("Por favor marque en un recuadro vacio");
         } while(turno == aux);
         if(juego.esOGanador()){
            System.out.printf("%nEl jugador O ganó%n");
            break;
         }
      }
   }
}

