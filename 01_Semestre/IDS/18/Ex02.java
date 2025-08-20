import java.util.Scanner;

public class Ex02 {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      int mayor = 0;
      System.out.print("Digite la cantidad de lanzamientos: ");
      int n = sc.nextInt();

      double[][] datos = new double[11][2];
      for (int i = 0; i < 11; i++) {
	 datos[i][0] = 0.0;
      }
      for (int i = 0; i < n; i++) {
	 int dado1 = lanzar();
	 int dado2 = lanzar();
	 datos[dado1+dado2-2][0] += 1;
      }
      for (int i = 0; i < 11; i++) {
	 datos[i][1] = datos[i][0]/n;
	 if (datos[i][0] > datos[mayor][0]) {
	    mayor = i;
	 }
      }
      System.out.println("El número que aparecio con más frecuencia es: " + (mayor + 2));
      System.out.println("xi \t fi \t hi");
      for (int i = 0; i < 11; i++) {
	 System.out.println((i+2) + "\t" + datos[i][0] + "\t" + datos[i][1]);
      }
   }
   public static int lanzar () {
      return (int) (Math.random() * 6) + 1;
   }
}
