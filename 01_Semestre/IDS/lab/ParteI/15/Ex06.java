import galapagos.*;

public class Ex06 {
   public static void main (String [] args) {
      Turtle t = new Turtle();
      int x = -13, y = 6;
      t.speed(1000);
      t.hide();
      t.turn(90);
      t.jumpTo(x, y);

      for (int i = 0; i < 9; i++) {
	 for (int j = 0; j < 90; j++) {
	    t.move(2);
	    t.turn(4);
	 }
	 t.turn(-40);
	 t.move(10);
      }
   }
}
