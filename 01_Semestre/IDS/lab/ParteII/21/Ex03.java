import java.util.Scanner;

public class Ex03 {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      int mayor = 0;
      System.out.print("Digite la cantidad de lanzamientos: ");
      int n = sc.nextInt();

      double[][] datos = new double[6][2];
      for (int i = 0; i < 6; i++) { datos[i][0] = 0.0; }
      for (int i = 0; i < n; i++) {
	 int dado = lanzar();
	 datos[dado-1][0] += 1;
      }
      for (int i = 0; i < 6; i++) {
	 datos[i][1] = datos[i][0]/n;
	 if (datos[i][0] > datos[mayor][0]) { mayor = i; }
      }

      int cantidad = 0;
      for (int i = 0; i < 6; i++) {
	 if (datos[i][0] == datos[mayor][0]) { cantidad++; }
      }

      int[] mayores = new int[cantidad];
      int indice = 0;
      for (int i = 0; i < 6; i++) {
	 if (datos[i][0] == datos[mayor][0]) { mayores[indice++] = i+1; }
      }

      System.out.println("Los números que aparecieron con más frecuencia son: ");
      for (int numero : mayores) { System.out.println(numero); }
      System.out.println("xi \t fi \t hi");
      for (int i = 0; i < 6; i++) {
	 System.out.println((i+1) + "\t" + datos[i][0] + "\t" + datos[i][1]);
      }
   }

   public static int lanzar () {
      return (int) (Math.random() * 6) + 1;
   }
}
