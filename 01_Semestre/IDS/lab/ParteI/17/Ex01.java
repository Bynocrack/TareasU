import java.util.Scanner;

public class Ex01 {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      int dardos, dardosc = 0;
      double pi, x, y, distancia;

      System.out.print("Digite la cantidad de dardos que desea tirar: ");
      dardos = sc.nextInt();

      for (int i = 0; i < dardos; i++) {
	 x = Math.random();
	 y = Math.random();
	 distancia = Math.sqrt(x*x+y*y);

	 if (distancia <= 1) dardosc++;
      }
      pi = (double) 40000*dardosc/dardos;
      pi = (int) pi;
      pi = pi/10000;
      System.out.println("La cantidad de dardos totales es: " + dardos);
      System.out.println("La cantidad de dardos dentro del cícrulo: " + dardosc);
      System.out.print("La aproximación de pi es: " + pi);
   }
}
