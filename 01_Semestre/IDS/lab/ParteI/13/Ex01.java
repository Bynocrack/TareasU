import galapagos.*;

public class Ex01 {
   public static void main (String [] args) {
      Turtle t = new Turtle();

      t.speed(1000);
      t.hide();
      for (int i = 0; i < 3; i++) {
	 t.move(50);
	 t.turn(120);
      }
      t.hide();
   }
}
