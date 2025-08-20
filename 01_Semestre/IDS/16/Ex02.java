import java.util.Scanner;

public class Ex02 {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      double real, complejo;

      System.out.print("Digite la parte real del número: ");
      real = sc.nextDouble();
      System.out.print("Digite la parte imaginaria del número: ");
      complejo = sc.nextDouble();

      muestra(real, complejo);
   }
   public static void muestra (double a, double b) {
      System.out.print(a);
      if (b > 0) { System.out.print("+"); }
      System.out.print(b + "i");
   }
}
