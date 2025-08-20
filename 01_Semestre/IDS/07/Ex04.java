import java.util.Scanner;

public class Ex04 {
   public static void main (String[] args) {
      Scanner sc = new Scanner(System.in);
      String nCompleto, mono;
      int indice;

      System.out.print("Digite su nombre completo (nombre ap1 ap2): ");
      nCompleto = sc.nextLine();

      indice = nCompleto.indexOf(' ');
      mono = nCompleto.substring(0, 1) + nCompleto.substring(indice+1, indice+2);
      indice = indice + 1 + nCompleto.substring(indice+1, nCompleto.length()).indexOf(' ');
      mono = mono + nCompleto.substring(indice+1, indice+2);

      System.out.print("El monograma resultante es " + mono);
   }
}
