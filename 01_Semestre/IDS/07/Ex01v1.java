import java.util.Scanner;

public class Ex01v1 {
   public static void main (String[] args) {
      Scanner sc = new Scanner(System.in);
      String nombre, mono;

      System.out.print("Digite su nombre: ");
      nombre = sc.next();

      mono = nombre.substring(0, 1) + nombre.substring(nombre.length()-1, nombre.length());
      mono = mono + nombre.indexOf('a');

      System.out.print("El monograma de su nombre es " + mono);
   }
}
