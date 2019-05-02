/*

 Написати Јава програм који одређује факторијел датог природног броја.

*/

// Задатак представља илустрацију коришћења наредбе циклуса do while

public class P040608CiklusZ03DoWhileFaktorijelPokreni {

   public static void main(String[] args) {
      int n = 4;
      long fakt = 1;
      int i = 1;
      do {
         fakt *= i;
         i++;
      } while (i <= n);
      System.out.println(n + "!=" + fakt);
   }
}
