import java.util.*;

public class Ex03 {
   static Scanner sc = new Scanner(System.in);
   public static void main (String [] args) {
      Cuenta cuenta = new Cuenta("Josue");
      cuenta.depositar(1000);
      cuenta.verSaldo();
      cuenta.retirar(199);
      cuenta.verSaldo();
      System.out.print((cuenta.getEsPremium() ? "" : "no ") + "es premium");
   }
}
