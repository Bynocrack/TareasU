import java.util.Scanner;

public class Ex10a {
   public static void main (String[] args) {
      Scanner sc = new Scanner(System.in);
      String color;
      double cInicial, cFinal;

      System.out.print("Digite el costo inicial de la compra: ");
      cInicial = sc.nextDouble();
      System.out.print("Digite el color de la bolita: ");
      color = sc.next().toUpperCase();

      cFinal = cInicial;

      if (color.equals("BLANCO")) {
	 cFinal = cInicial;
      } else if (color.equals("VERDE")) {
	 cFinal = cInicial*0.9;
      } else if (color.equals("AMARILLA")) {
	 cFinal = cInicial*0.75;
      } else if (color.equals("AZUL")) {
	 cFinal = cInicial*0.5;
      } else if (color.equals("ROJA")) {
	 cFinal = 0;
      } else {
	 System.out.print("Usted ha digitado un color no válido.");
      }

      System.out.print("El monto final a pagar es " + cFinal);
   }
}
