import java.util.Scanner;

public class Ex02 {
   public static void main (String[] args) {
      Scanner sc = new Scanner(System.in);
      String nombre, ap1, ap2, mono;

      System.out.print("Digite su nombre: ");
      nombre = sc.next();
      System.out.print("Digite su primer apellido: ");
      ap1 = sc.next();
      System.out.print("Digite su segundo apellido: ");
      ap2 = sc.next();

      mono = nombre.substring(0, 1) + ap1.substring(0, 1) + ap2.substring(0, 1);

      System.out.print("El monograma resultante es " + mono);
   }
}
