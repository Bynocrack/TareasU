import java.util.Scanner;

public class Ex01 {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      double num1, num2, num3, num4, num5, num6, num7, num8, mayor;
      System.out.print("Digite el número 1: ");
      num1 = sc.nextDouble();
      System.out.print("Digite el número 2: ");
      num2 = sc.nextDouble();
      System.out.print("Digite el número 3: ");
      num3 = sc.nextDouble();
      System.out.print("Digite el número 4: ");
      num4 = sc.nextDouble();
      System.out.print("Digite el número 5: ");
      num5 = sc.nextDouble();
      System.out.print("Digite el número 6: ");
      num6 = sc.nextDouble();
      System.out.print("Digite el número 7: ");
      num7 = sc.nextDouble();
      System.out.print("Digite el número 8: ");
      num8 = sc.nextDouble();

      mayor = mayor8(num1, num2, num3, num4, num5, num6, num7, num8);

      System.out.print("El mayor de los 8 números es: " + mayor);
   }
   public static double mayor8 (double a, double b, double c, double d, double e, double f, double g, double h) {
      return mayor2(mayor2(mayor2(a, b), mayor2(c, d)), mayor2(mayor2(e, f), mayor2(g, h)));
   }
   public static double mayor2 (double a, double b) {
      if (a >= b) { return a; }
      return b;
   }
}
