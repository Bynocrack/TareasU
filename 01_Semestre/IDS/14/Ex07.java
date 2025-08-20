import java.util.Scanner;

public class Ex07 {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      int num, pos = 0, neg = 0, cero = 0;

      while (true) {
	 System.out.print("Digite un número: ");
	 num = sc.nextInt();
	 if (num > 0) pos++;
	 else if (num < 0) neg++;
	 else cero++;
	 System.out.println("Hasta ahora van: " + pos + " positivos, " + cero + " ceros y " + neg + " negativos.");
      }
   }
}
