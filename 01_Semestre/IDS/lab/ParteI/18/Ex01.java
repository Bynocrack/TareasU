import java.util.Scanner;

public class Ex01 {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      int c3, c2, c1, c0;
      double a, b, m= 0, pa, pb, pm = 1, aux, alfa = 0.0001;

      System.out.print("Digite el coeficiciente del termino cúbico: ");
      c3 = sc.nextInt();
      System.out.print("Digite el coeficiciente del termino cuadrático: ");
      c2 = sc.nextInt();
      System.out.print("Digite el coeficiciente del termino lineal: ");
      c1 = sc.nextInt();
      System.out.print("Digite el coeficiciente del termino independiente: ");
      c0 = sc.nextInt();
      System.out.print("Digite el valor de a: ");
      a = sc.nextDouble();
      System.out.print("Digite el valor de b: ");
      b = sc.nextDouble();

      if (b<a) {
	 aux = a;
	 a = b;
	 b = aux;
      }
      int i = 1;
      while (true) {
	 m = (a+b)/2;
	 pa = c3*a*a*a + c2*a*a + c1*a + c0;
	 pb = c3*b*b*b + c2*b*b + c1*b + c0;
	 pm = c3*m*m*m + c2*m*m + c1*m + c0;

	 System.out.print("#" + i + ": a = " + String.format("%.6f", a) + "; b = " + String.format("%.6f", b)+ "; m = " + String.format("%.6f", m));
	 System.out.println("; p(a) = " + String.format("%.6f", pa) + "; p(b) = " + String.format("%.6f", pb) + "; p(m) = " + String.format("%.6f", pm));
	 i++;

	 if (!((b-a) > alfa && pm != 0)) break;

	 if (pm > 0) b = m;
	 else if (pm < 0) a = m;
      }
      System.out.print("root = " + String.format("%.6f", m) + "\np(root) = " + String.format("%.6f", pm));
   }
}
