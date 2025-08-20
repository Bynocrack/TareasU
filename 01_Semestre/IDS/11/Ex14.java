import java.util.Scanner;

public class Ex14 {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      int ano;

      System.out.print("Digite un año: ");
      ano = sc.nextInt();

      if ((ano%4 == 0 && ano%100 != 0) || ano%400 == 0) {
	 System.out.print("El año es bisiesto.");
      } else {
	 System.out.print("El año no es bisiesto.");
      }
   }
}
