import java.util.Scanner;

public class Ex06 {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      int mayor = 0, ganador = 0;
      System.out.print("Digite la cantidad de dados: ");
      int n = sc.nextInt();
      System.out.print("Digite la cantidad de jugadores: ");
      int m = sc.nextInt();

      int[] datos = new int[6];
      int[] jugadores = new int[m];
      for (int i = 0; i < 6; i++) {
	 datos[i] = 0;
      }
      for (int i = 0; i < m; i++) {
	 jugadores[i] = 0;
	 for (int j = 0; j < n; j++) {
	    int dado = lanzar();
	    jugadores[i] += dado; 
	    datos[dado-1]++;
	 }
      }
      for (int i = 0; i < 6; i++) {
	 if (datos[i] > datos[mayor]) {
	    mayor = i;
	 }
      }
      for (int i = 0; i < m; i++) {
	 if (jugadores[i] > jugadores[ganador]) {
	    ganador = i;
	 }
      }
      System.out.println("El número que aparecio con más frecuencia es: " + (mayor + 1));
      System.out.print("El ganador (por suma de todos los dados) es el " + (ganador+1) + " jugador");
   }
   public static int lanzar () {
      return (int) (Math.random() * 6) + 1;
   }
}
