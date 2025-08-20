import java.util.Scanner;

public class Ex01 {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      int num, suma = 0;

      System.out.print("Digite un número: ");
      num = sc.nextInt();

      for (int i = 1; i < num; i++) {
	 if (num % i == 0) suma += i;
      }

      if (suma == num) System.out.print("Es un número perfecto.");
      else System.out.print("No es un número perfecto, la suma de sus divisores es: "+suma);
   }
}
