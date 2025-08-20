import java.util.*;

public class Ex01 {
   static Scanner sc = new Scanner(System.in);
   public static void main (String [] args) {
      int[][] matriz = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
      String rpta;
      rpta = esCuadrada(matriz) ? "Es " : "No es ";
      System.out.println(rpta + "cuadrada");
      System.out.print("Su diagonal es: ");
      int[] diagonal = diagonal(matriz);
      for (int numero : diagonal) {
	 System.out.print(numero + " ");
      }
      rpta = esIdentidad(matriz) ? "\nEs " : "\nNo es ";
      System.out.println(rpta + "identidad");
      rpta = esDiagonal(matriz) ? "Es " : "No es ";
      System.out.println(rpta + "diagonal");
      rpta = triSuperior(matriz) ? "Es " : "No es ";
      System.out.println(rpta + "triangular superior");
      rpta = triInferior(matriz) ? "Es " : "No es ";
      System.out.println(rpta + "triangular inferior");
   }
   public static boolean esCuadrada (int[][] matriz) {
      for (int[] fila : matriz) {
	 if (matriz.length != fila.length) {
	    return false;
	 }
      }
      return true;
   }
   public static int[] diagonal (int[][] matriz) {
      int[] output = new int[matriz.length];
      for (int i = 0; i < matriz.length; i++) {
	 output[i] = matriz[i][i];
      }
      return output;
   }
   public static boolean esIdentidad (int[][] matriz) {
      for (int i = 0; i < matriz.length; i++) {
	 for (int j = 0; j < matriz[i].length; j++) {
	    if (i == j && matriz[i][j] != 1) {
	       return false;
	    }
	    if (i != j && matriz[i][j] != 0) {
	       return false;
	    }
	 }
      }
      return true;
   }
   public static boolean esDiagonal(int[][] matriz) {
      for (int i = 0; i < matriz.length; i++) {
	 for (int j = 0; j < matriz[i].length; j++) {
	    if (i != j && matriz[i][j] != 0) {
	       return false;
	    }
	 }
      }
      for (int i = 0; i < matriz.length; i++) {
	 for (int j = 0; j < matriz[i].length; j++) {
	    if (i == j && matriz[i][j] != 0) {
	       return true;
	    }
	 }
      }
      return false;
   }
   public static boolean triSuperior (int[][] matriz) {
      for (int i = 0; i < matriz.length; i++) {
	 for (int j = 0; j < matriz[i].length; j++) {
	    if (i < j && matriz[i][j] != 0) {
	       return false;
	    }
	 }
      }
      for (int i = 0; i < matriz.length; i++) {
	 for (int j = 0; j < matriz[i].length; j++) {
	    if (i >= j && matriz[i][j] != 0) {
	       return true;
	    }
	 }
      }
      return false;
   }
   public static boolean triInferior (int[][] matriz) {
      for (int i = 0; i < matriz.length; i++) {
	 for (int j = 0; j < matriz[i].length; j++) {
	    if (i > j && matriz[i][j] != 0) {
	       return false;
	    }
	 }
      }
      for (int i = 0; i < matriz.length; i++) {
	 for (int j = 0; j < matriz[i].length; j++) {
	    if (i <= j && matriz[i][j] != 0) {
	       return true;
	    }
	 }
      }
      return false;
   }
}
