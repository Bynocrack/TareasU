import java.util.Scanner;

public class Ex11a {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      int n;
      double x, resultado = 1;
      boolean invertir = false;

      System.out.print("Digite el valor de la base: ");
      x = sc.nextDouble();
      System.out.print("Digite el valor del exponente: ");
      n = sc.nextInt();

      if (n < 0) {
	 invertir = true;
	 n *= -1;
      }
      for (int i = 0; i < n; i++) {
         resultado *= x;
      }
      if (invertir) { resultado = 1/resultado; }
      System.out.print("El resultado de elevar es: " + resultado);
   }
}
