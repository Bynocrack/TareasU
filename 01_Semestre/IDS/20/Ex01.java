import java.util.*;

public class Ex01 {
   static Scanner sc = new Scanner(System.in);
   public static void main (String [] args) {
      Rectangulo rect1 = new Rectangulo(10, 20);
      rect1.calcularArea();
      rect1.calcularPerimetro();
      rect1.verificar();
      System.out.print(rect1.getArea() + " " + rect1.getPerimetro());
      System.out.print((rect1.getEsCuadrado() ? "" : " no") + " es cuadrado");
   }
}
