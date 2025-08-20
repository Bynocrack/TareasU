import java.util.Scanner;

public class Ex09 {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      double m, n;

      System.out.print("Digite el valor de m: ");
      m = sc.nextDouble();
      System.out.print("Digite el valor de n: ");
      n = sc.nextDouble();

      if (m > n) {
	 double aux = m;
	 m = n;
	 n = aux;
      }

      System.out.print("El número generado es: " + (Math.random()*(n-m)+m));
   }
}
