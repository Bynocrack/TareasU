import java.util.Scanner;

public class Ex03a {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      double c1, c2, h;
      
      System.out.print("Digite la longitud del primer cateto: ");
      c1 = sc.nextDouble();
      System.out.print("Digite la longitud del segundo cateto: ");
      c2 = sc.nextDouble();

      h = retorna(c1, c2);

      System.out.print("La hipotenusa es: " +  + h);
   }
   public static double retorna(double c1, double c2) {
      return Math.sqrt(c1*c1 + c2*c2);
   }
}
