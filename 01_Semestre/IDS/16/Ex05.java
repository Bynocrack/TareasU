import java.util.Scanner;

public class Ex05 {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      double num;

      do {
	 System.out.print("Digite un número: ");
	 num = sc.nextDouble();
	 System.out.println("El entero más cercano a " + num + " es: " + Math.round(num));
      } while (num != 0.0);
   }
}
