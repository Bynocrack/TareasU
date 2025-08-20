import java.util.Scanner;

public class Ex09 {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      int mayor = 0;
      System.out.print("Digite el valor de m: ");
      int m = sc.nextInt();
      System.out.print("Digite el valor de n: ");
      int n = sc.nextInt();

      double[][] matriz1 = new double[m][n];
      for (int i = 0; i < m; i++) {
	 for (int j = 0; j < n; j++) {
	    System.out.print("Digite el elemento en la posición "+(i+1)+" "+(j+1)+" de la matriz:");
	    matriz1[i][j] = sc.nextDouble();
	 }
      }
      
      imprimir(transpuesta(matriz1));
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

   public static double[][] transpuesta (double[][] A) {
      double[][] C = new double[A[0].length][A.length];
      for (int i = 0; i < A.length; i++) {
	 for (int j = 0; j < A[i].length; j++) {
	    C[j][i] = A[i][j];
	 }
      }
      return C;
   }
}
