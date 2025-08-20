public class Ex10a {
    public static void main(String[] args) {
       String bin = "";
       int num = 0;
       for (int i = 0; i < 8; i++) {
	  num = i;
	  for (int j = 0; j < 3; j++) {
	      bin = (num%2) + bin;
	      num = num/2;
	  }
	  System.out.println("El número " + i + " a binario es: " + bin);
	  bin = "";
       }
    }
}
