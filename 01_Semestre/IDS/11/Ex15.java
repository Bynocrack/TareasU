import java.util.Scanner;

public class Ex15 {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      int a, b, c, d, denominador, nominador;

      System.out.print("Digite el valor de a: ");
      a = sc.nextInt();
      System.out.print("Digite el valor de b: ");
      b = sc.nextInt();
      System.out.print("Digite el valor de c: ");
      c = sc.nextInt();
      System.out.print("Digite el valor de d: ");
      d = sc.nextInt();

      denominador = b*d;
      nominador = a*d + b*c;

      if (denominador == 0) {
	 System.out.print("No se puede dividir, uno de los denominadores es 0!");
      } else {
	 System.out.print("La fracción es " + nominador + "/" + denominador);
      }
   }
}
