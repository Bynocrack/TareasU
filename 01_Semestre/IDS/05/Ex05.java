import java.util.Scanner;

public class Ex05 {
   public static void main (String[] args) {
      Scanner sc = new Scanner(System.in);
      double metros, pies;

      System.out.print("Digite una longitud en metros: ");
      metros = sc.nextDouble();

      pies = metros*3.28;

      System.out.print("Esa longitud en pies es " + pies);
   }
}
