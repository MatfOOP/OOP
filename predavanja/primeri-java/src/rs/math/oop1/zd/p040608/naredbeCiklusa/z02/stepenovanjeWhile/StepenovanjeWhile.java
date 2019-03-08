/*
 
 Написати Јава програм који одређује степен датог
 реалног броја (основе) датим природним изложиоцем.
 
 */

// Задатак представља илустрацију коришћења наредбе циклуса while

package rs.math.oop1.zd.p040608.naredbeCiklusa.z02.stepenovanjeWhile;

public class StepenovanjeWhile {

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