import java.util.Scanner;

public class Ex08 {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      System.out.print("Digite el valor de n: ");
      int n = sc.nextInt();

      double[][] identidad = generar(n);
      imprimir(identidad);
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

   public static double[][] generar (int n) {
      double[][] C = new double[n][n];
      for (int i = 0; i < n; i++) {
	 for (int j = 0; j < n; j++) {
	    if (i == j) { C[i][j] = 1; }
	    else { C[i][j] = 0; }
	 }
      }
      return C;
   }
}
