import java.util.Scanner;

public class Ex10b {
   public static void main (String[] args) {
      Scanner sc = new Scanner(System.in);
      String color;
      double cInicial, cFinal;

      System.out.print("Digite el costo inicial de la compra: ");
      cInicial = sc.nextDouble();
      System.out.print("Digite el color de la bolita: ");
      color = sc.next().toUpperCase();

      cFinal = cInicial;

      switch (color) {
	 case "BLANCO":
	    break;
	 case "VERDE":
	    cFinal = cInicial*0.9;
	    break;
	 case "AMARILLA":
	    cFinal = cInicial*0.75;
	    break;
	 case "AZUL":
	    cFinal = cInicial*0.5;
	    break;
	 case "ROJA":
	    cFinal = 0;
	    break;
	 default:
	    System.out.print("El color no es válido.");
	    break;
      }
      System.out.print("El monto final a pagar es " + cFinal);
   }
}
