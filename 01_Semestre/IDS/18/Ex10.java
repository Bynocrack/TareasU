import java.util.Scanner;

public class Ex10 {
   static Scanner sc = new Scanner(System.in);
   public static void main (String [] args) {
      int mayor = 0;
      System.out.print("Digite el valor de m: ");
      int m = sc.nextInt();
      System.out.print("Digite el valor de n: ");
      int n = sc.nextInt();
      System.out.print("Digite el valor de p: ");
      int p = sc.nextInt();

      double[][] matriz1 = nuevaMatriz(m, n, 'A'); 
      double[][] matriz2 = nuevaMatriz(n, p, 'B');

      System.out.println("El producto de las matrices es: ");
      imprimir(multiplicar(matriz1, matriz2));
   }
   public static double[][] nuevaMatriz (int m, int n, char A) {
      double[][] matriz = new double[m][n];
      for (int i = 0; i < m; i++) {
	 for (int j = 0; j < n; j++) {
	    System.out.print("Digite el elemento de lugar "+(i+1)+" "+(j+1)+" de la matriz "+A+": ");
	    matriz[i][j] = sc.nextDouble();
	 }
      }
      return matriz;
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

   public static double[][] multiplicar(double[][] A, double[][] B) {
      double[][] C = new double[A.length][B[0].length];
      for (int i = 0; i < A.length; i++) {
	 for (int j = 0; j < B[0].length; j++) {
	    double suma = 0;
	    for (int m = 0; m < A[0].length; m++) {
	       suma += A[i][m] * B[m][j];
	    }
	    C[i][j] = suma;
	 }
      }
      return C;
   }
}
