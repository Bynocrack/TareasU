import java.util.*;

public class Ex01 {
   static Scanner sc = new Scanner(System.in);
   public static void main (String [] args) {
      System.out.print("Digite el número a realizar la tabla de multiplicar: ");
      int x = sc.nextInt();
      System.out.print("Digite el valor de m: ");
      int m = sc.nextInt();
      System.out.print("Digite el valor de n: ");
      int n = sc.nextInt();

      int[] tabla = new int[n-m+1];
      for (int i = 0; i < tabla.length; i++) {
	 tabla[i] = (m+i)*x;
      }
      for (int i = 0; i < tabla.length; i++) {
	 System.out.println(i+m + "\tx " + x + " =\t" + tabla[i]);
      }
   }
}
