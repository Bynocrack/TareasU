import galapagos.*;
import java.awt.*;

public class Ex02 {
   public static void main (String [] args) {
      Turtle t = new Turtle();

      t.speed(10000);
      t.hide();
      t.penColor(Color.BLACK);

      t.jumpTo(0,50);
      t.move(50);
      t.jumpTo(25, 50);
      t.turn(-90);
      t.move(37);
      for (int i = 0; i < 17; i++) {
	 t.turn(-10);
	 t.move(2);
      }

      t.jumpTo(50, 0);
      t.turn(-38);
      t.move(55);
      t.turn(-124);
      t.move(55);
      t.jumpTo(63, 25);
      t.turn(62);
      t.move(24);

      t.turn(90);
      t.jumpTo(100, 0);
      for (int i = 0; i < 2; i++) {
	 t.move(50);
	 t.turn(-135);
	 t.move(36);
	 t.turn(90);
	 t.move(36);
	 t.turn(-135);
	 t.move(50);
	 t.turn(180);
	 t.jumpTo(150,0);
      }
   }
}
