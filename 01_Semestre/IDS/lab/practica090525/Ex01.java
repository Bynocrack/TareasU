import java.util.Scanner;

public class Ex01{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		float horas, pHora, sNeto;

		System.out.print("Digite la cantidad de horas que trabajó esta semana: ");
		horas = sc.nextFloat();
		System.out.print("Digite la paga que recibe por hora: ");
		pHora = sc.nextFloat();

		sNeto = horas*pHora;

		if (horas > 40) {
			sNeto = sNeto + (horas-40)*pHora/2;
		}
		if (sNeto > 500) {
			sNeto = sNeto - 20;
		}

		System.out.print("Su sueldo neto semanal es de: " + sNeto);
	}
}
