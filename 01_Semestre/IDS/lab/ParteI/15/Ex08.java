import galapagos.*;

public class Ex08 {
   public static void main (String [] args) {
      Turtle t = new Turtle();
      t.speed(1000);
      t.hide();
      t.turn(160);
      for (int j = 0; j < 5; j++) {
	 for (int i = 0; i < 90; i++) {
	    t.move(4);
	    t.turn(4);
	 }
	 for (int i = 0; i < 90; i++) {
	    t.move(2);
	    t.turn(4);
         }
	 t.turn(72);
      }
   }
}
