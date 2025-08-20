import galapagos.*;

public class Ex04b {
   public static void main (String [] args) {
      Turtle t = new Turtle();
      t.speed(1000);
      t.hide();

      t.turn(2);
      for (int i = 0; i < 10; i++) {
	 t.move(100);
	 t.turn(-60);
	 t.move(100);
	 t.turn(-120);
	 t.move(100);
	 t.turn(-60);
	 t.move(100);
	 t.turn(-40);
      }
   }
}
