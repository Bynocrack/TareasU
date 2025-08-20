import java.util.Scanner;

public class Ex03a {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      double c1, c2;
      
      System.out.print("Digite la longitud del primer cateto: ");
      c1 = sc.nextDouble();
      System.out.print("Digite la longitud del segundo cateto: ");
      c2 = sc.nextDouble();

      muestra(c1, c2);
   }
   public static void muestra(double c1, double c2) {
      System.out.print("La hipotenusa es: " + (Math.sqrt(c1*c1 + c2*c2)));
   }
}
