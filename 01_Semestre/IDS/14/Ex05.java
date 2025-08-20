import java.util.Scanner;

public class Ex05 {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      int num, max = Integer.MIN_VALUE, cantidad;

      System.out.print("Digite la cantidad de números(0 para infinitos): ");
      cantidad = sc.nextInt();

      if (cantidad == 0) {
	 while (true) {
	    System.out.print("Digite un número: ");
	    num = sc.nextInt();
	    if (max < num) max = num;
	    System.out.println("El número más grande ingresado hasta ahora es: " + max);
	 }
      } else {
	 for (int i = 0; i < cantidad; i++) {
	    System.out.print("Digite un número: ");
	    num = sc.nextInt();
	    if (max < num) max = num;
	 }
	 System.out.print("El número más grande ingresado es: " + max);
      }
   }
}
