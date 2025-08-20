import galapagos.*;

public class Ex03 {
   public static void main (String [] args) {
      Turtle t = new Turtle();

      t.speed(1000);
      t.hide();

      t.move(100);
      t.turn(-60);
      t.move(100);
      t.turn(-120);
      t.move(100);
      t.turn(-60);
      t.move(100);
   }
}
