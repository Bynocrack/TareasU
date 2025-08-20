import java.util.*;

public class Ex01 {
   static Scanner sc = new Scanner(System.in);
   public static void main (String [] args) {
      reglas();
      boolean jugar = jugar(true);
      while (jugar) {
	 int n = numero();
	 juego(n);
	 jugar = jugar(false);
      }
   }
   public static void reglas() {
      System.out.print("Se generara un número aleatorio entre 0 y 99, usted va a tener 6 ");
      System.out.print("oportunidades para adivinarlo. La computadora le ayudara diciendo ");
      System.out.print("si el número generado es mayor o menor al ingresado. \n");
   }
   public static boolean jugar(boolean primeraVez) {
      if (primeraVez) {
	 System.out.print("Desea jugar? (s/N) ");
      } else {
	 System.out.print("Desea seguir jugando? (s/N) ");
      }
      return (sc.next().toUpperCase().charAt(0) == 'S');
   }
   public static int numero() {
      return (int) (Math.random()*100);
   }
   public static void juego(int n) {
      for (int i = 6; i > 0; i--) {
	 System.out.print("Tiene " + i + " oportunidades, digite su suposición: ");
	 int intento = sc.nextInt();
	 if (intento == n) {
	    System.out.print("Usted lo adivinó en " + (7-i) + " intentos\n");
	    break;
	 } else if (intento > n) {
	    System.out.print("El número generado es menor que ese\n");
	 } else {
	    System.out.print("El número generado es mayor que ese\n");
	 }
      }
      System.out.print("Usted perdió\n");
   }
}
