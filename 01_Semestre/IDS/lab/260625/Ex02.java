import java.util.Scanner;

public class Ex02 {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      int[] lista = {12, 6, -8, 4, 30, -40, 6, 9, 4, 22};
      int pos;

      pos = posMayor(lista);
      System.out.print("La posición del mayor elemento de la lista es: " + pos);
   }

   public static int posMayor(int[] lista) {
      int mayor = lista[0], pos = 0;
      for (int i = 1; i < lista.length; i++) {
	 if (lista[i] > mayor) {
	    mayor = lista[i];
	    pos = i;
	 }
      }
      return pos;
   }
}
