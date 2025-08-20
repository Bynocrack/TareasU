import java.util.Scanner;

public class Ex13 {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      int n, fibonacci = 0, a = 0, b = 1;

      System.out.print("Digite el número a calcular de fibonacci: ");
      n = sc.nextInt();

      for (int i = 0; i < n-2; i++) {
	 fibonacci = a+b;
	 a = b;
	 b = fibonacci;
      }
      System.out.print("El número de fibonacci es: " + fibonacci);
   }
}
