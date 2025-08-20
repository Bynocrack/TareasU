import java.util.Scanner;

public class Ex03 {
   public static void main (String[] args) {
      Scanner sc = new Scanner(System.in);
      int ePerro, eHumana;

      System.out.print("Digite la edad del perro: ");
      ePerro = sc.nextInt();

      eHumana = ePerro*7;

      System.out.print("La edad humana del perro es " + eHumana);
   }
}
