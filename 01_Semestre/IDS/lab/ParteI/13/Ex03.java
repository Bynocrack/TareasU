import galapagos.*;
import java.util.Scanner;

public class Ex03 {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      int entero1, entero2, entero3;

      System.out.print("Digite un número entero: ");
      entero1 = sc.nextInt();
      System.out.print("Digite otro número entero: ");
      entero2 = sc.nextInt();
      System.out.print("Digite un tercer número entero: ");
      entero3 = sc.nextInt();

      Turtle t = new Turtle();
      t.hide();
      t.speed(10000);
      t.turn(90);      t.move(75);
      t.turn(90);      t.move(25);
      t.turn(-135);    t.move(105);
      t.turn(-90);     t.move(105);
      t.turn(-135);    t.move(25);
      t.turn(90);      t.move(75);
      t.turn(-90);     t.move(100);    t.jumpTo(0, 75);
      t.turn(180);     t.move(100);    t.jumpTo(12, 43);
		       t.move(20);
      t.turn(90);      t.move(20);
      t.turn(90);      t.move(20);
      t.turn(90);      t.move(20);     t.jumpTo(68, 62);
		       t.move(20);
      t.turn(90);      t.move(20);
      t.turn(90);      t.move(20);
      t.turn(90);      t.move(20);     t.jumpTo(62, 40);
		       t.move(25);
      t.turn(90);      t.move(40);
      t.turn(90);      t.move(25);
      t.turn(90);      t.move(40);

   }
}
