import java.util.Scanner;
import java.security.SecureRandom;

public class Pregunta_6_33 {

	private enum Estado {CONTINUA, GANO, PERDIO};
	
	private static final int DOS = 2;
	private static final int TRES = 3;
	private static final int SIETE = 7;
	private static final int ONCE = 11;
	private static final int DOCE = 12;
	
	private static	Scanner entrada = new Scanner(System.in);
 	private static SecureRandom aleatorio = new SecureRandom(); 
	private static int saldo = 1000;
    
	public static void main(String[] args) {

		while(true) {
		
			int apuesta = obtenerApuesta();
	
			if(ganoCraps()) {
				System.out.printf("Jugador ganó%n");
				saldo += apuesta;
				charla();
			} 		
			else {
				System.out.printf("Jugador perdió%n");	
				saldo -= apuesta;
				if(saldo > 0) {
					System.out.printf("%s%n",
					"¡Oh!, se esta yendo a la quiebra, ¿verdad?");
				}
				else { 
					System.out.printf("%s%n",
					"Lo siento. ¡Se quedó sin fondos!");
					break;
				}
			}
			
			if(noSeguir()) break;

		}

   }


   public static boolean noSeguir() {
		while(true) {
   		System.out.printf("%s%s", "Si quiere seguir apostando presione 1", 
   		"; caso contrario, presione 0: ");
   		int opcion = entrada.nextInt(); 
   		if(opcion == 1) return false;
	  		if(opcion == 0) return true;
   	}
   }


   public static int obtenerApuesta() {
   	while(true) {
   		System.out.printf("Introduce una apuesta (saldo:%6d): ", saldo);
   		int apuesta = entrada.nextInt();
	  		if(apuesta <= saldo) return apuesta;
   	}
   }
         	
         	
   public static void charla() {  
  		switch(aleatorio.nextInt(2)) {
         case 0:
         	System.out.printf("%s%n","¡Oh, vamos, arriésguese!");
            break;
         case 1:
            System.out.printf("%s%s%n",
            "La hizo en  grande.",
            " ¡Ahora es tiempo de cambiar sus  fichas por efectivo!");
            break;
		}
	}


	public static boolean ganoCraps() {
	
		int miPunto;
		int lance = lanzarDados();

		switch(lance) {
		
			case SIETE:
   	   case ONCE: 
   	   	return true;
      	
      	case DOS:
   	   case TRES:
   	   case DOCE:
   	   	return false;
       	
       	default:
      	   miPunto = lance;
				System.out.printf("El punto es %d%n", miPunto);
				while(true) {
					lance = lanzarDados();
					if(lance == miPunto) 
						return true;
					else if(lance == SIETE) 
						return false;
				}		
			
		}
		
	}
	
	
	public static int lanzarDados() {
		int dado1 = 1 + aleatorio.nextInt(6);
		int dado2 = 1 + aleatorio.nextInt(6);
		int suma = dado1 + dado2;
		System.out.printf("Jugador tiró %d + %d = %d%n", 
			dado1, dado2, suma);
	   return suma; 		
	}
	
}
