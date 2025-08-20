import java.util.Scanner;

public class Ex02 {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      int[] notas1 = new int[10], notas2 = new int[10], suma = new int[10];
      
      notas1 = generar();
      notas2 = generar();

      suma = sumar(notas1, notas2);

      imprimir(notas1, notas2, suma);
   }
   public static int[] generar() {
      int[] a = new int[10];
      for (int i = 0; i < 10; i++) {
	 a[i] = (int) (Math.random()*21);
      }
      return a;
   }
   public static int[] sumar(int[] a, int[] b) {
      int[] output = new int[10];
      for (int i = 0; i < 10; i++) {
	 output[i] = a[i] + b[i];
      }
      return output;
   }
   public static void imprimir(int[] a, int[] b, int[] c) {
      for (int i = 0; i < a.length; i++) {
	 System.out.println("La suma de las notas " + a[i] + " y " + b[i] + " es " + c[i]);
      }
   }
}
