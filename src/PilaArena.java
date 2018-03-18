import java.util.Scanner;
public class PilaArena {
	
	public static int[][] matriz;
	public static int[][] matrix;
	public static int k = 0;
	public static int m = 0;
	
	public static int iterar(int[][] matriz) {
		int k = 0;
		while(checkReady(matriz) == false) {
			derrumbe(matriz);
			k += 1;
		}
		return k;
		
	}
	
	public static int iterar_i(int[][] matriz) {
		int k = 0;
		while(checkReady(matriz) == false) {
			derrumbe_i(matriz);
			k += 1;
		}
		return k;
	}
	
	
	public static void verMatriz(int[][] matriz) {
		for(int i = 0; i < matriz.length; i++) {
			for(int j = 0; j < matriz[0].length; j ++ ) {
				System.out.print(matriz[i][j] + "  ");
			}
			System.out.println("");
		}
	}
	
	public static boolean checkReady(int[][] matriz) {
		for(int i = 0; i < matriz.length; i++) {
			for(int j = 0; j < matriz[0].length; j ++ ) {
				if (matriz[i][j] >= 4) return false;
			}
		}
		return true;
	}
		
	public static void derrumbe(int[][] matriz) {
		for(int i = 0; i < matriz.length; i++) {
			for(int j = 0; j < matriz[0].length; j ++ ) {
				if (matriz[i][j] >= 4) {
					
					// Saltar bordes
					if (i==0) continue;
					if (j==0) continue;
					if (i==matriz.length-1) continue;
					if (j==matriz.length-1) continue;
					
					// Distribuir
					matriz[i-1][j] += 1;
					matriz[i+1][j] += 1;
					matriz[i][j+1] += 1;
					matriz[i][j-1] += 1;
					matriz[i][j] -= 4;
				}
				
		}
	}	
}

	public static void derrumbe_i(int[][] matriz) {
		for(int i = 0; i < matriz.length; i++) {
			for(int j = 0; j < matriz[0].length; j ++ ) {
				if (matriz[i][j] >= 4) {
					
					// Saltar bordes
					if (i==0) continue;
					if (j==0) continue;
					if (i==matriz.length-1) continue;
					if (j==matriz.length-1) continue;
					
					// Distribuir
					
					int var = matriz[i][j] - matriz[i][j]%4;
					matriz[i-1][j] += var/4;
					matriz[i+1][j] += var/4;
					matriz[i][j+1] += var/4;
					matriz[i][j-1] += var/4;
					matriz[i][j] %= 4;
					
				}
				
		}
	}	
}

	public static void main(String[] args) {
		// Ingreso de arena y calculo de parametros
		Scanner sc = new Scanner(System.in);
		System.out.print("N? ");
		int n = sc.nextInt();
		double lado = Math.sqrt(n);
		int int_lado = (int)lado;
		
		// Si no alcanza aumenta en 1
		if (lado > int_lado) lado = (int)lado + 1;
		
		// Si es par aumenta en 1
		if (lado % 2 == 0) lado += 1;
		
		// Calculamos el centro de la matriz
		int pos_centro = (int)(lado/2);
		
		
		System.out.println("Centro: "+ (pos_centro+1) + ", lado: " + lado);
		
		
		
		// PARTE 1
		// Derrumbe Simple
		
		/*
		// Crear matriz y colocar arena
		matriz = new int[(int) lado][(int) lado];
		matriz[pos_centro][pos_centro] = n;

		while(checkReady(matriz) == false) {
			derrumbe(matriz);
			k += 1;
		}
		
		System.out.println("Ready at "+ k + " iteration");
		Ventana ventana = new Ventana((int)lado, "Pila 1");
		ventana.mostrarMatriz(matriz);
		*/
		
		// PARTE 2
		// Derrumbe inteligente
		
		// Crear matriz y colocar arena
		matriz = new int[(int) lado][(int) lado];
		matriz[pos_centro][pos_centro] = n;
		
		while(checkReady(matriz) == false) {
			derrumbe_i(matriz);
			m += 1;
		}
		
		System.out.println("Ready at "+ m + " iteration");
		Ventana ventana_i = new Ventana((int)lado, "Pila 2");
		ventana_i.mostrarMatriz(matriz);
		
		// PARTE 3
		// Multiples derrumbes
		for(int x = 10000; x < 100000; x += 1000) {
			
			
			lado = Math.sqrt(x);
			int_lado = (int)lado;
			if (lado > int_lado) lado = (int)lado + 1;
			if (lado % 2 == 0) lado += 1;
			pos_centro = (int)(lado/2);
			
			matriz = new int[(int) lado][(int) lado];
			matriz[pos_centro][pos_centro] = x;
			
			k = 0;
			m = 0;
			
			while(checkReady(matriz) == false) {
				derrumbe(matriz);
				k += 1;
			}
		
			matrix = new int[(int) lado][(int) lado];
			matrix[pos_centro][pos_centro] = x;
			
			while(checkReady(matrix) == false) {
				derrumbe_i(matrix);
				m += 1;
			}
			
			String iteracion= x + "," + k + "," + m;
			System.out.println(iteracion);
		}
		
		
	}

}


