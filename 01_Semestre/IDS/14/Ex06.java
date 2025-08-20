public class Ex06 {
   public static void main (String [] args) {
      for (int i = 0; i < (24*60*60); i++) {
	 System.out.println((i/3600) + ":" + ((i/60)%60) + ":" + (i%60));
      }
   }
}
