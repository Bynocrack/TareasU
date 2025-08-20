import java.util.Scanner;

public class Ex06 {
   public static void main (String[] args) {
      Scanner sc = new Scanner(System.in);
      int lab, teoria, promedio;
      System.out.print("Digite su nota de teoria: ");
      teoria = sc.nextInt();
      System.out.print("Digite su nota de laboratorio: ");
      lab = sc.nextInt();

      if (lab >= 13){
	 promedio = (int) (lab*0.25+teoria*0.75+0.5);
      } else {
	 if (lab > teoria) {
	    promedio = teoria;
	 } else {
	    promedio = lab;
	 }
      }

      if (promedio >= 13) {
	 System.out.println("Usted esta aprobado!");
      } else {
	 System.out.println("Usted esta desaprobado!");
      }
      System.out.print("Su nota final es " + promedio);

   }
}
