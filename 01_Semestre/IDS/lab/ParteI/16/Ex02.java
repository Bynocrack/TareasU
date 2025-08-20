import java.util.Scanner;

public class Ex02 {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      String nombre;
      char seguir = 'S';
      int costo, cantidad;
      double total = 0.0;

      while (seguir == 'S') {
	 System.out.print("Digite el nombre del producto: ");
	 nombre = sc.next();
	 System.out.print("Digite el costo (en céntimos) del producto: ");
	 costo = sc.nextInt();
	 System.out.print("Digite la cantidad que va a comprar: ");
	 cantidad = sc.nextInt();
	 System.out.print("Va a seguir comprando? (s/n): ");
	 seguir = sc.next().toUpperCase().charAt(0);

	 total += costo*cantidad;
      }
      total = total/100;

      System.out.print("El gasto total es de: " + total);

   }
}
