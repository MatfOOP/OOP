/*
 
 Написати Јава програм који одређује факторијел датог природног броја.
 
 */

// Задатак представља илустрацију коришћења наредбе циклуса while

public class P040608CiklusZ01WhileFaktorijelPokreni {

   public static void main(String[] args) {
      int n = 6;
      long fakt = 1;
      int i = 1;
      while (i <= n) {
         fakt *= i;
         i++;
      }
      System.out.println(n + "!=" + fakt);
   }
}
