import java.util.*;

public class Ex02 {
   static Scanner sc = new Scanner(System.in);
   public static void main (String [] args) {
      System.out.print("Digite la cantidad de amigos que tiene en facebook: ");
      int n = sc.nextInt();
      String[] amigos = new String[n];

      for (int i = 0; i < amigos.length; i++) {
	 System.out.print("Digite el nombre de su amigo: ");
	 amigos[i] = sc.next();
      }
      System.out.print("Sus amigos son: ");
      for (String amigo : amigos) {
	 System.out.print(amigo + " ");
      }
   }
}
