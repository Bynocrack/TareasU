import galapagos.*;

public class Ex02 {
   public static void main (String [] args) {
      Turtle t = new Turtle();

      t.speed(1000);
      t.hide();
      t.turn(18);
      for (int i = 0; i < 10; i++) {
	 t.move(50);
	 t.turn(36);
	 t.jumpTo(0, 0);
      }
      t.hide();
   }
}
