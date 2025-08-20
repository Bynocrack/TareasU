import java.util.Scanner;

public class Ex14 {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      int n;

      System.out.print("Digite el número a calcular de fibonacci: ");
      n = sc.nextInt();

      System.out.print("El número de fibonacci es: " + fibonacci(n));
   }
   public static int fibonacci (int n) {
      if (n == 1) { return 0; }
      if (n == 2) { return 1; }
      return fibonacci(n-1) + fibonacci(n-2);
   }
}
