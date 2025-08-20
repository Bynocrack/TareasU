import galapagos.*;

public class Ex05 {
   public static void main (String [] args) {
      Turtle t = new Turtle();
      int x = -87, y = 0;
      t.speed(1000);
      t.hide();
      t.turn(90);

      for (int i = 0; i < 9; i++) {
	 t.jumpTo(x, y);
	 for (int j = 0; j < 90; j++) {
	    t.move(2);
	    t.turn(4);
	 }
	 x = x+29;
      }
   }
}
