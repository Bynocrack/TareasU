import java.util.*;

public class Ex03 {
   static Scanner sc = new Scanner(System.in);
   public static void main (String [] args) {
      System.out.print("Digite la cantidad de alumnos: ");
      int n = sc.nextInt();
      ArrayList<Integer> notas = new ArrayList<Integer>();
      for (int i = 0; i <= 20; i++) {
	 notas.add(0);
      }
      for (int i = 1; i <= n; i++) {
	 System.out.print("Digite la nota del " + i + " alumno: ");
	 int nota = sc.nextInt();
	 notas.set(nota, notas.get(nota)+1);
      }
      int menor = n, mayor = 0;
      for (int frecuencia : notas) {
	 if (frecuencia > mayor) {
	    mayor = frecuencia;
	 }
	 if (frecuencia < menor) {
	    menor = frecuencia;
	 }
      }
      imprimirHistograma(menor, mayor, notas);

   }
   public static void imprimirHistograma (int menor, int mayor, ArrayList<Integer> lista) {
      for (int i = mayor; i >= menor; i--) {
	 System.out.print(i + "\t|");
	 for (int j = 0; j < lista.size(); j++) {
	    if (lista.get(j) >= i) {
	       System.out.print(" ██");
	    } else {
	       System.out.print("   ");
	    }
	 }
	 System.out.println();
      }
      System.out.print("\t "); 
      for (int i = 0; i < 10; i++) { System.out.print("  " + i); }
      for (int i = 10; i < 21; i++) { System.out.print(" " + i); }
   }
}
