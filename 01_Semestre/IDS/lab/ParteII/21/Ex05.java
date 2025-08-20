import java.util.Scanner;

public class Ex05 {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      int mayor = 0, menor = 0;
      System.out.print("Digite la cantidad de alumnos: ");
      int n = sc.nextInt();

      int[] datos = inicializar(21);
      
      for (int i = 0; i < n; i++) {
	 System.out.print("Digite la nota del " + (i+1) + " alumno: ");
	 int nota = sc.nextInt();
	 datos[nota] += 1;
      }
      for (int i = 0; i < datos.length; i++) {
	 if (datos[i] > datos[mayor]) { mayor = i; }
	 if (datos[i] < datos[menor]) { menor = i; }
      }
      System.out.println("La nota que aparecio con más frecuencia es: " + mayor);
      System.out.println("La nota que aparecio con menor frecuencia es: " + menor);
      for (int i = datos[mayor]; i > datos[menor]; i--) {
	 System.out.print("\n" + i + " |");
	 for (int j = 0; j < 21; j++) {
	    if (i <= datos[j]) { System.out.print(" ██"); }
	    else { System.out.print("   "); }
       	 }
      }
      System.out.print("\n   ");
      for (int i = 0; i < 10; i++) { System.out.print("  " + i); }
      for (int i = 10; i < 21; i++) { System.out.print(" " + i); }
   }
   public static int[] inicializar (int n) {
      int[] datos = new int[n];
      for (int i = 0; i < datos.length; i++) { datos[i] = 0; }
      return datos;
   }
}
