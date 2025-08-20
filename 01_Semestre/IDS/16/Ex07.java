import java.util.Scanner;

public class Ex07 {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      int num1, num2, num3, menor;

      System.out.print("Digite el primer número: ");
      num1 = sc.nextInt();
      System.out.print("Digite el segundo número: ");
      num2 = sc.nextInt();
      System.out.print("Digite el tercer número: ");
      num3 = sc.nextInt();

      menor = menor3(num1, num2, num3);

      System.out.print("El menor de los 3 es: " + menor);
   }
   public static int menor3 (int a, int b, int c) {
      if (b < c) {
	 if (a < b) { return a; }
	 return b;
      }
      if (c < a) { return c; }
      return a;
   }
}
