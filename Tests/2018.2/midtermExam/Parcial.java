// clases importadas:
import java.util.Scanner;
import java.security.SecureRandom;
import java.math.BigDecimal;
import java.text.NumberFormat;

public class Parcial{
   
   public static void main(String[] args){
      Scanner entrada = new Scanner(System.in);
      int opcion;
      do{
         System.out.printf("%n%s%n%s%n%s%n%s%n%n%s", "Menu", "1.- salir", "2.- pregunta 2", "3.- pregunta 3", "Seleccione una de las opciones: ");
         opcion = entrada.nextInt();
         switch (opcion){
            case 2:
               pregunta2();
               break;
            case 3:
               pregunta3();
               break;
         }
      } while(opcion != 1);
   }
   
   public static void pregunta2() {
      Temperaturas noaa = new Temperaturas(1990);
      noaa.mostrar();
   }
   
   public static void pregunta3() {
      Cuenta bcp = new Cuenta("Gerald Villaroel", 68520014, 100);
      bcp.mostrarCuenta();
      bcp.depositar(-50); 
      bcp.depositar(200); 
      bcp.retirar(500);
      bcp.retirar(250);
   }
   
}

class Cuenta {   
   private String nombre; 
   private int dni;
   private BigDecimal saldo;

   public Cuenta(String nombre, int dni) {
      this(nombre, dni, 0);
   }
   
   public Cuenta(String nombre, int dni, float saldo) {
      this.nombre = nombre; 
      this.dni = dni;
      this.saldo = BigDecimal.valueOf(saldo);
   }

   public void retirar(double cantidad) {     
      if(cantidad > 0){ // si la cantidad a retirar es válida
         BigDecimal temp = saldo.subtract(BigDecimal.valueOf(cantidad));
         if(temp.compareTo(BigDecimal.ZERO) >= 0) { // si hay saldo suficiente
            System.out.printf("...retirando%10s%n", 
               NumberFormat.getCurrencyInstance().format(BigDecimal.valueOf(cantidad)));
            saldo = temp;
            mostrarCuenta();
         }   
         else System.out.printf("Saldo insuficiente.%n");
      }
      else System.out.printf("Cantidad ingresada NO es válida.%n");
   }

   public void depositar(double cantidad) {      
      if (cantidad > 0){ // si la cantidad a depositar es válida
         System.out.printf("...depositando%10s%n", 
            NumberFormat.getCurrencyInstance().format(BigDecimal.valueOf(cantidad)));
         saldo = saldo.add(BigDecimal.valueOf(cantidad));
         mostrarCuenta();
      }
      else System.out.printf("Cantidad ingresada NO es válida.%n");
   }

   public BigDecimal obtenerSaldo() {
      return saldo; 
   } 

   public String obtenerNombre() {
      return nombre; 
   } 
   
   public int obtenerDni() {
      return dni; 
   } 
   
   public void mostrarCuenta() {
      System.out.printf("Nombre:%20s Dni:%9d Saldo:%10s%n",
         obtenerNombre(), obtenerDni(), 
         NumberFormat.getCurrencyInstance().format(obtenerSaldo()));
   }
}

class Fecha{
   private int anho;
   private int mes;
   private int dia;
   private static final int[] diasPorMes = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
   
   public Fecha(int anho, int mes, int dia){
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
   
   public boolean esBisiesto(){
      return (anho % 400 == 0 || (anho % 4 == 0 && anho % 100 != 0));
   }
   
   public void siguienteAnho(){
      ++anho;
   }
   
   public void siguienteMes(){
      if (mes == 12){
         siguienteAnho();
         mes = 1;
      }
      else
         ++mes;
   }
   
   public void siguienteDia(){
      if(dia == 28 && mes == 2 && !esBisiesto()){
         siguienteMes();
         dia = 1;
      }
      else if(dia == 29 && mes == 2){
         siguienteMes();
         dia = 1;
      }
      else if(dia == 28 && mes == 2 && esBisiesto())
         ++dia;
      else if(dia == diasPorMes[mes]){
         siguienteMes();
         dia = 1;
      }
      else
         ++dia;
   }
   
   public int obtenerDia(){
      return dia;
   }
   
   public int obtenerMes(){
      return mes;
   }
   
   public int obtenerAnho(){
      return anho;
   }
}

class Temperaturas{

   private int[][] serie = new int[10500][4]; // serie de temperaturas
   private int tamanhoSerie; 

   public Temperaturas(int anho) { // constructor
      if(anho < 1990 || anho > 2017)
         throw new IllegalArgumentException("anho (" + anho + ") debe estar en el intervalo 1990-2017");
      Fecha temp = new Fecha(anho, 1, 1); // temp es la fecha temporal
      int i = 0; // declaramos i fuera del bucle para acceder a él fuera del bucle
      for (; temp.obtenerAnho() != 2018; temp.siguienteDia()){ 
      // en cada ciclo vamos inicializando el elemento i-esimo de la serie
         serie[i][0] = temp.obtenerAnho();
         serie[i][1] = temp.obtenerMes();
         serie[i][2] = temp.obtenerDia();
         serie[i++][3] = generar(temp.obtenerMes());
      }
      tamanhoSerie = i; 
   }
   
   public int generar(int mes) {
      int temperatura = 0;
      SecureRandom aleatorio = new SecureRandom(); 
      switch(mes){
         case 1: temperatura = 30 + aleatorio.nextInt(3); break;
         case 2: temperatura = 31 + aleatorio.nextInt(3); break;
         case 3: temperatura = 30 + aleatorio.nextInt(3); break;
         case 4: temperatura = 28 + aleatorio.nextInt(3); break;
         case 5: temperatura = 26 + aleatorio.nextInt(3); break;
         case 6: temperatura = 23 + aleatorio.nextInt(3); break;
         case 7: temperatura = 19 + aleatorio.nextInt(3); break;
         case 8: temperatura = 17 + aleatorio.nextInt(3); break;
         case 9: temperatura = 20 + aleatorio.nextInt(3); break;
         case 10: temperatura = 23 + aleatorio.nextInt(3); break;
         case 11: temperatura = 26 + aleatorio.nextInt(3); break;
         case 12: temperatura = 28 + aleatorio.nextInt(3); break;
      }
      return temperatura;
   }
   
   public void mostrar() {
      int[] mes = {0,0,0,0,0,0,0,0,0,0,0,0,0};
      int[] cantidad = {0,0,0,0,0,0,0,0,0,0,0,0,0};
      System.out.printf(" Tamaño de la serie:%6d%n", tamanhoSerie);
      for (int i = 0; i < tamanhoSerie; i++){
         mes[serie[i][1]] += serie[i][3];
         cantidad[serie[i][1]] += 1;
         if(serie[i][1] == 2 && serie[i][2] == 29) 
         // necesariamente se trata de un año bisiesto
            System.out.printf("%4d%3d%3d:%3d%n", 
            serie[i][0], serie[i][1], serie[i][2], serie[i][3]);
      }
      for (int i = 1; i < 13; i++) {
         System.out.printf("%3d:%6.2f%n", i, (float)mes[i]/cantidad[i]);
      }
   }
}
