import galapagos.*;

public class Ex04a {
   public static void main (String [] args) {
      Turtle t = new Turtle();

      t.speed(1000);
      t.hide();

      for (int i = 0; i < 4; i++) {
	 t.move(100);
	 t.turn(-60);
	 t.move(100);
	 t.turn(-120);
	 t.move(100);
	 t.turn(-60);
	 t.move(100);
	 t.turn(-30);
      }
   }
}
