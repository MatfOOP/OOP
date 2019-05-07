/*
 
 Написати Јава програм који одређује степен датог
 реалног броја (основе) датим природним изложиоцем.
 
 */

// Задатак представља илустрацију коришћења наредбе циклуса while

public class P040608CiklusZ02WhileStepenovanjePokreni {

   public static void main(String[] args) {
      int n = 10;
      double x = 1.75;
      double stepen = 1;
      int j = n;
      while (j >= 1) {
         stepen *= x;
         j--;
      }
      System.out.println(x + "^" + n + "=" + stepen);
   }
}