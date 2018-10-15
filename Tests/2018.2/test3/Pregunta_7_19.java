import java.util.Scanner;
import java.security.SecureRandom;

public class Pregunta_7_19 {

	private static final int TAMANHO = 10;
	
	private static boolean[] asientos = new boolean[TAMANHO];
	private static int[] indices1 = new int[TAMANHO/2];
	private static int[] indices2 = new int[TAMANHO/2];
	private static int tamanho1, tamanho2; 
	
	private static	Scanner entrada = new Scanner(System.in);
 	private static SecureRandom aleatorio = new SecureRandom(); 
	private static int indice;
    
	public static void main(String[] args) {

		inicializarAsientos();
		mostrarAsientos();

		while(true) {
					
			if(tamanho1 > 0 && tamanho2 > 0) 
				if(primeraClase())
					reservarPrimera();
				else
					reservarEconomica();
			
			else if(tamanho1 == 0 && tamanho2 > 0) 
				
				if(pasarEconomica()) 
					reservarEconomica();
				else {
					mostrarMensaje();
					break;
				}
				
			else if(tamanho1 > 0 && tamanho2 == 0)
				
				if(pasarPrimera()) 
					reservarPrimera();
				else { 
					mostrarMensaje();
					break;
				}	
					
			else {
				System.out.printf("Avión lleno. ");
				mostrarMensaje();
				break;			
			}

			mostrarAsientos();
			
		}

   }


	public static void reservarPrimera() {
	// funciona mientras tamanho1 >= 1 
		int indice;
		if(tamanho1 == 1) 
			indice = indices1[0];
		else {
			int i = aleatorio.nextInt(tamanho1);
			indice = indices1[i];
			indices1[i] = indices1[tamanho1 - 1];
			indices1[tamanho1 - 1] = indice;
		}
		tamanho1--;
		asientos[indice] = true;
		System.out.printf("%n%s%n%s%d%n%s%n%n",
		"Tarjeta de Embarque:", "Asiento Nro. ", 
		indice + 1, "Primera Clase");
	}


	public static void reservarEconomica() {
	// funciona mientras tamanho2 >= 1 
		int indice;
		if(tamanho2 == 1) 
			indice = 5 + indices2[0];
		else {
			int i = aleatorio.nextInt(tamanho2);
			indice = indices2[i];
			indices2[i] = indices2[tamanho2 - 1];
			indices2[tamanho2 - 1] = indice;
			indice += 5;
		}
		tamanho2--;
		asientos[indice] = true;
		System.out.printf("%n%s%n%s%d%n%s%n%n",
		"Tarjeta de Embarque:", "Asiento Nro. ", 
		indice + 1, "Clase Económica");
	}


   public static void inicializarAsientos() {
   	for(int i = 0; i < TAMANHO; i++) {
   		asientos[i] = false;
   		if(i < TAMANHO/2){
	   		indices1[i] = i;
	   		indices2[i] = i;
	   	}
   	}
   	tamanho1 = tamanho2 = TAMANHO/2;
   	//tamanho2 = tamanho1;
   }


	public static boolean pasarEconomica() {
		while(true) {	
			System.out.printf("%s%s%n%s%s",
			"La primera clase está llena, ",
			"¿quieres pasar a clase económica?",
			"Si tu rpta es afirmativa presiona 1; ",
			"caso contrario, presiona 0: ");
			int opcion = entrada.nextInt();
			if(opcion == 1) return true;
			if(opcion == 0) return false;
		}
	}			


	public static boolean pasarPrimera() {
		while(true) {	
			System.out.printf("%s%s%n%s%s",
			"La clase económica está llena, ",
			"¿quieres pasar a primera clase?",
			"Si tu rpta es afirmativa presiona 1; ",
			"caso contrario, presiona 0: ");
			int opcion = entrada.nextInt();
			if(opcion == 1) return true;
			if(opcion == 0) return false;
		}
	}			


   public static boolean primeraClase() {
		while(true) {
   		System.out.printf("%s%s", 
   		"Por favor, presione 1 para primera clase", 
   		" y presione 2 para clase económica: ");
   		int opcion = entrada.nextInt(); 
   		if(opcion == 1) return true;
	  		if(opcion == 2) return false;
   	}
   }
        	

	public static void mostrarAsientos() {
		int i;
		String estado; 
		System.out.printf("Estado actual:%n%n");
		for(i = 0; i < TAMANHO; i++){
			if(i == 0) System.out.printf("Primera Clase%n");
			if(i == 5) System.out.printf("%nClase Económica%n");
			if(asientos[i]) estado = "ocupado";
			else estado = "disponible";		
			System.out.printf("Asiento%3d: %s%n", i + 1, estado);	
		}
		System.out.printf("%n"); 
	}
	

	public static void mostrarMensaje() {
		System.out.printf("Siguiente vuelo sale en 3 horas.%n%n");
	}		
}
