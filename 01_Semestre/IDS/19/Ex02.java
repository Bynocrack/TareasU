import java.util.*;

public class Ex02 {
   static Scanner sc = new Scanner(System.in);
   public static void main (String [] args) {
      System.out.print("Digite la cantidad de lanzamientos: ");
      int n = sc.nextInt();
      ArrayList<Integer> resultados = new ArrayList<Integer>();
      for (int i = 2; i <= 12; i++) {
	 resultados.add(0);
      }
      for (int i = 0; i < n; i++) {
	 int resultado = lanzar();
	 resultados.set(resultado-2, resultados.get(resultado-2)+1);
      }
      int menor = n, mayor = 0;
      for (int frecuencia : resultados) {
	 if (frecuencia > mayor) {
	    mayor = frecuencia;
	 }
	 if (frecuencia < menor) {
	    menor = frecuencia;
	 }
      }
      ArrayList<Integer> mayores = new ArrayList<Integer>();
      ArrayList<Integer> menores = new ArrayList<Integer>();
      for (int i = 0; i < resultados.size(); i++) {
	 if (resultados.get(i) == mayor) {
	    mayores.add(i+2);
	 }
	 if (resultados.get(i) == menor) {
	    menores.add(i+2);
	 }
      }
      System.out.println("Los resultados con mayor frecuencia son: " + mayores);
      System.out.print("Los resultados con menor frecuencia son: " + menores);

   }
   public static int lanzar () {
      return (int) (Math.random()*6) + (int) (Math.random()*6) + 2;
   }
}
