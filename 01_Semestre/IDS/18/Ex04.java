import java.util.Scanner;

public class Ex04 {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      int mayor = 0, menor = 0;
      int[] calificaciones = new int[10];
      int[] datos = inicializar(5);

      for (int i = 0; i < 10; i++) {
	 System.out.print("Digite la nota del " + (i+1) + " alumno: ");
	 calificaciones[i] = sc.nextInt();
	 datos[calificaciones[i]-1] += 1;
      }
      System.out.print("[");
      for (int i = 0; i < 8; i +=2) {
	 System.out.println("[" + calificaciones[i] + ", " + calificaciones[i+1] + "],");
      }
      System.out.println("[" + calificaciones[8] + ", " + calificaciones[9] + "]]");
      for (int i = 0; i < datos.length; i++) {
	 if (datos[i] > datos[mayor]) { mayor = i; }
	 if (datos[i] < datos[menor]) { menor = i; }
      }
      for (int i = datos[mayor]; i >= datos[menor]; i--) {
	 if (i > 0) {
	    System.out.print("\n" + i + " |");
	    for (int j = 0; j < 5; j++) {
	       if (i <= datos[j]) { System.out.print(" ██"); }
	       else { System.out.print("   "); }
	    }
	 }
      }
      System.out.print("\n   ");
      for (int i = 1; i < 6; i++) {
	 System.out.print("  " + i);
      }
   }
   public static int[] inicializar (int n) {
      int[] datos = new int[n];
      for (int i = 0; i < datos.length; i++) {
	 datos[i] = 0;
      }
      return datos;
   }
}
