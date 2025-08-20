import galapagos.*;

public class Ex09b {
   public static void main (String [] args) {
      Turtle t = new Turtle();
      t.speed(10000);
      t.hide();
      t.turn(-90);

      for (int i = 0; i < 8; i++) {
	 t.jumpTo(0,0);
	 t.move(25);
	 for (int j = 0; j < 3; j++) {
	    t.turn(45);
	    t.move(25);
	    t.turn(180);
	    t.move(25);
	    t.turn(90);
	    t.move(25);
	    t.turn(180);
	    t.move(25);
	    t.turn(-135);
	    t.move(25);
	 }
	 t.turn(-45);
      }
   }
}
