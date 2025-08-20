import java.util.*;

public class Ex01 {
   static Scanner sc = new Scanner(System.in);
   public static void main (String [] args) {
      System.out.print("Digite el tamaño del array: ");
      int n = sc.nextInt();
      double prom = 0;
      ArrayList<Integer> elementos = inicializar(n);

      int mayor = elementos.get(0), menor = elementos.get(0);
      for (int i = 0; i < n; i++) {
	 prom += elementos.get(i);
	 if (elementos.get(i) < menor) {
	    menor = elementos.get(i);
	 }
	 if (elementos.get(i) > mayor) {
	    mayor = elementos.get(i);
	 }
	 if (elementos.get(i)%2 == 0) {
	    System.out.println(elementos.get(i));
	 }
      }
      prom /= n;
      System.out.println("El promedio es " + prom);
      System.out.print("El mayor es " + mayor + ", y el menor es " + menor);
   }
   public static ArrayList<Integer> inicializar(int n) {
      ArrayList<Integer> output = new ArrayList<Integer>();
      for (int i = 0; i < n; i++) {
	 output.add((int) (Math.random()*1000)-500);
      }
      return output;
   }
}

