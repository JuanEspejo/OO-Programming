import java.security.SecureRandom;

public class Pregunta_7_20 {

	private static final int MIN = 2;
	private static final int DELTA = 10;
		
	private static final int MES = 30;
	private static final int PRODUCTOS = 5;
	private static final int VENDEDORES = 4;
	private static Recibo[] recibos = 
	new Recibo[MES*PRODUCTOS*VENDEDORES];
		
	private static int[][] ventas = 
	new int[PRODUCTOS + 1][VENDEDORES + 1]; 
	private static SecureRandom aleatorio = new SecureRandom();
	private static int tamanho;
	
	
	public static void main(String[] args) {
		generarRecibos();
		leerRecibos();
		mostrarMatriz();
	}
	
	
	public static void mostrarMatriz() {
	
		for(int i = 0; i < PRODUCTOS; i++)  
			for(int j = 0; j < VENDEDORES; j++)
				ventas[i][VENDEDORES] += ventas[i][j];
		
		for(int j = 0; j < VENDEDORES; j++) 
			for(int i = 0; i < PRODUCTOS; i++)
				ventas[PRODUCTOS][j] += ventas[i][j];
		
		System.out.printf("%n            ");		
		for(int j = 0; j < VENDEDORES; j++)
			System.out.printf("   Vendedor%2d", j + 1);
		System.out.printf("    Sub total%n%n");
		for(int i = 0; i < PRODUCTOS; i++) {
			System.out.printf("PRODUCTO%2d  ", i + 1); 
			for(int j = 0; j <= VENDEDORES; j++)
				System.out.printf("%12d", ventas[i][j]);
			System.out.printf("%n");
		}
		System.out.printf("%n Sub total  ");
		for(int j = 0; j < VENDEDORES; j++)
				System.out.printf("%12d", ventas[PRODUCTOS][j]);
		System.out.printf("%n%n");	
	}
	
	
	public static void leerRecibos() {
	
		for(int i = 0; i <= PRODUCTOS; i++) 
			for(int j = 0; j <= VENDEDORES; j++)
				ventas[i][j] = 0;
				
		for(int i = 0; i < tamanho; i++)
				ventas[ recibos[i].obtenerProducto() ]
				[ recibos[i].obtenerVendedor() ] += 
				recibos[i].obtenerVenta();
	}
	
	
	public static void generarRecibos() {
		int k = 0;
		int venta;
		for(int m = 0; m < MES; m++) 
			for(int v = 0; v < VENDEDORES; v++)  
				for(int p = 0; p < PRODUCTOS; p++) 
					if(aleatorio.nextInt(2) == 1) {
						venta = MIN + aleatorio.nextInt(DELTA);
						recibos[k++] = new Recibo(v, p, venta);
					} 	
		tamanho = k;		 
		//System.out.printf("%n tamanho: %d%n", tamanho);
	}
	
}


class Recibo {	
	private int vendedor;
	private int producto;
	private int venta;
	
	public Recibo(int vendedor, int producto, int venta) {
		this.vendedor = vendedor;
		this.producto = producto;
		this.venta = venta;
	}
	
	public int obtenerVendedor() {
		return vendedor;
	}
	
	public int obtenerProducto() {
		return producto;
	}
	
	public int obtenerVenta() {
		return venta;
	}	 
}
