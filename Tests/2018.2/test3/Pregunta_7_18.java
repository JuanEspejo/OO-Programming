import java.util.Scanner;
import java.security.SecureRandom;

public class Pregunta_7_18 {

	private enum Estado {CONTINUA, GANO, PERDIO};
	
	private static final int DOS = 2;
	private static final int TRES = 3;
	private static final int SIETE = 7;
	private static final int ONCE = 11;
	private static final int DOCE = 12;
	
	private static final int LANCES = 1000000;	
	private static final int TAMANHO = 13;
	
	private static	Scanner entrada = new Scanner(System.in);
 	private static SecureRandom aleatorio = new SecureRandom(); 

	private static int[] victorias = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	private static int[] perdidas = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	private static int[] juegos = new int[22];
 
	public static void main(String[] args) {

		llenarVectores();					
		mostrarVictorias();
		mostrarPerdidas();		
		chancesGanar();
		duracionMedia();
		tendenciaGanar();
   	}


	public static void tendenciaGanar() {
		for(int i = 0; i < TAMANHO - 1; i++)
			System.out.printf("Chances de ganar con %2d juego(s):%6.2f%%%n",
			i + 1, (float)victorias[i]*100/juegos[i]); 
		System.out.printf("%s%n",
		"Cuanto más dura el juego, las chances de ganar NO mejoran."); 
	}


	public static void duracionMedia() {
		float duracion = 0;
		for(int i = 0; i < TAMANHO - 1; i++)
			duracion += (i + 1)*juegos[i]; 
		duracion /= (LANCES - juegos[TAMANHO - 1]);
		System.out.printf("Duracion media :%6.2f juegos.%n", duracion); 
	}


	public static void mostrarVictorias() {
		for(int i = 0; i < TAMANHO - 1; i++)
			System.out.printf("Juegos ganados con %5d lance(s):%6d%n", 
			i + 1, victorias[i]); 
		System.out.printf("Juegos ganados con  >=%2d lance(s):%6d%n", 
			TAMANHO - 1, victorias[TAMANHO - 1]); 
	}
	
	
	public static void mostrarPerdidas() {
		for(int i = 0; i < TAMANHO - 1; i++)
			System.out.printf("Juegos perdidos con %4d lance(s):%6d%n", 
			i + 1, perdidas[i]); 
		System.out.printf("Juegos perdidos con >=%2d lance(s):%6d%n", 
			TAMANHO - 1, perdidas[TAMANHO - 1]); 
	}

	public static void chancesGanar() {
		float esperanza = 0;
		for(int i = 0; i < TAMANHO; i++) 
			esperanza += victorias[i];
		esperanza = esperanza*100/LANCES;
		System.out.printf("Las chances de ganar son %6.2f%%%n", esperanza);
	}
	

	public static void llenarVectores() {

		int miPunto, tamanho;
		
		for(int i = 0; i < LANCES; i++) {
	
			int lance = lanzarDados();
			tamanho = 0;

			switch(lance) {
		
				case SIETE:
   	   			case ONCE: 
   	   				victorias[tamanho] += 1;
      					break;

      				case DOS:
   	   			case TRES:
   	   			case DOCE:
   	   				perdidas[tamanho] += 1;
      					break;

		       		default:
		      	   		miPunto = lance;
	      		   		//System.out.printf("El punto es %d%n", miPunto);
					while(true) {
						lance = lanzarDados();
						tamanho++;
						if(lance == miPunto) { 
							if(tamanho < TAMANHO - 1) 
								victorias[tamanho] += 1;
							else
								victorias[TAMANHO - 1] += 1;
							break;
						}
						else if(lance == SIETE) { 
							if(tamanho < TAMANHO - 1) 
								perdidas[tamanho] += 1;
							else
								perdidas[TAMANHO - 1] += 1;
							break;
						}	
					}		
				
			}
			
		}
		
		for(int i = 0; i < TAMANHO; i++) 
			juegos[i] = victorias[i] + perdidas[i];

	}
	
	
	public static int lanzarDados() {
		int dado1 = 1 + aleatorio.nextInt(6);
		int dado2 = 1 + aleatorio.nextInt(6);
		int suma = dado1 + dado2;
		//System.out.printf("Jugador tiró %d + %d = %d%n", dado1, dado2, suma);
	   return suma; 		
	}
	
}
