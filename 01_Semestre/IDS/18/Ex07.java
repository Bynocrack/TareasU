import java.util.Scanner;

public class Ex07 {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      int mayor = 0;
      System.out.print("Digite el valor de m: ");
      int m = sc.nextInt();
      System.out.print("Digite el valor de n: ");
      int n = sc.nextInt();

      double[][] matriz1 = new double[m][n];
      double[][] matriz2 = new double[m][n];
      for (int i = 0; i < m; i++) {
	 for (int j = 0; j < n; j++) {
	    System.out.print("Digite el elemento en la posición "+(i+1)+" "+(j+1)+" de la matriz A:");
	    matriz1[i][j] = sc.nextDouble();
	    System.out.print("Digite el elemento en la posición "+(i+1)+" "+(j+1)+" de la matriz B:");
	    matriz2[i][j] = sc.nextDouble();
	 }
      }

      System.out.println("La suma de las matrices es: ");
      imprimir(operar(0, matriz1, matriz2));
      System.out.println("La resta de las matrices es: ");
      imprimir(operar(1, matriz1, matriz2));
      System.out.println("El producto punto de las matrices es: " + productoP(matriz1, matriz2));
   }
   public static void imprimir (double[][] A) {
      System.out.print("[");
      for (int i = 0; i < A.length; i++) {
	 System.out.print("[");
	 for (int j = 0; j < A[i].length; j++) {
	    System.out.print(A[i][j]);
	    if (j != A[i].length-1) { System.out.print(", "); }
	 }
	 if (i != A.length-1) { System.out.println("],"); }
      }
      System.out.println("]]");
   }

   public static double[][] operar (int op, double[][] A, double[][] B) {
      double[][] C = new double[A.length][A[0].length];
      for (int i = 0; i < A.length; i++) {
	 for (int j = 0; j < A[i].length; j++) {
	    if (op == 0) { C[i][j] = A[i][j] + B[i][j]; }
	    else { C[i][j] = A[i][j] - B[i][j]; }
	 }
      }
      return C;
   }
   public static double productoP (double[][] A, double[][] B) {
      double output = 0;
      for (int i = 0; i < A.length; i++) {
	 for (int j = 0; j < A[i].length; j++) {
	    output += A[i][j] * B[i][j];
	 }
      }
      return Math.sqrt(output);
   }
}
