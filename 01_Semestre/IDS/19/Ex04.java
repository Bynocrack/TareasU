import java.util.*;

public class Ex04 {
   static Scanner sc = new Scanner(System.in);
   public static void main (String [] args) {
      ArrayList<Integer> numeros = new ArrayList<Integer>();
      for (int i = 1; i < 7; i++) {
	 numeros.add(i);
      }
      System.out.println("El orden es: ");
      while (!numeros.isEmpty()) {
	 System.out.println(sacar(numeros));
      }
   }
   public static int sacar (ArrayList<Integer> lista) {
      int indice = (int) (Math.random()*lista.size());
      return lista.remove(indice);
   }
}
