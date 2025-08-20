import java.util.*;

public class Ex05 {
   static Scanner sc = new Scanner(System.in);
   public static void main (String [] args) {
      System.out.print("Digite la cantidad de alumnos: ");
      int n = sc.nextInt();
      ArrayList<Integer> notas = new ArrayList<Integer>();
      for (int i = 1; i <= n; i++) {
	 System.out.print("Digite la nota del " + i + " alumno: ");
	 notas.add(sc.nextInt());
      }
      System.out.println("Las notas ordenadas segun creación: " + notas);
      notas = ordenar(notas);
      System.out.print("Las notas ordenadas descentemente: " + notas);
   }
   public static ArrayList<Integer> ordenar(ArrayList<Integer> lista) {
      for (int i = 1; i < lista.size(); i++) {
	 for (int j = 0; j < lista.size() - i; j++) {
	    if (lista.get(j) < lista.get(j+1)) {
	       int aux = lista.get(j);
	       lista.set(j, lista.get(j+1));
	       lista.set(j+1, aux);
	    }
	 }
      }
      return lista;
   }
}
