import java.util.Scanner;

public class Ex01 {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      int[] lista = {12, 6, -8, 4, 30, -40, 6, 9, 4, 22};
      int menor;

      menor = menor(lista);

      System.out.print("El menor número de la lista es: " + menor);
   }

   public static int menor(int[] lista) {
      int menor = lista[0];
      for (int i = 1; i < lista.length; i++) {
	 if (lista[i] < menor) {
	    menor = lista[i];
	 }
      }
      return menor;
   }
}
