import java.util.Scanner;

public class Ex04 {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      int[] lista = {12, 6, -8, 4, 30, -40, 6, 9, 4, 22};

      int[] ordenado = ordenar(lista);
      System.out.print("La lista ordenada es: ");
      for (int i = 0; i < ordenado.length; i++) {
	 System.out.print(ordenado[i] + " ");
      }
   }

   public static int[] ordenar(int[] lista) {
      int[] salida = lista; 
      int aux = 0;
      boolean hecho = false;
      while (!hecho) {
	 hecho = true;
	 for (int i = 0; i < salida.length-1; i++) {
	    if (salida[i] > salida[i+1]) {
	       aux = salida[i];
	       salida[i] = salida[i+1];
	       salida[i+1] = aux;
	       hecho = false;
	       break;
	    }
	 }
      }
      return salida;
   }
}
