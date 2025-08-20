import java.util.Scanner;
public class Ex08 {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      int max = -1, min = 101, total = 0, actual;
      double prom = 0;
      while (true) {
	 System.out.print("Digite el puntaje del carro actual (0-100): ");
	 actual = sc.nextInt();
	 if (actual > max) max = actual;
	 if (actual < min) min = actual;
	 prom = prom*total;
	 prom += actual;
	 total++;
	 prom = prom/total;
	 System.out.println("El máximo actual es: " + max);
	 System.out.println("El minimo actual es: " + min);
	 System.out.println("El promedio actual es: " + prom);
      }
   }
}
