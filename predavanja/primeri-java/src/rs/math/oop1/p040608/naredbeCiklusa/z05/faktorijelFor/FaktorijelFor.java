/*

 Написати Јава програм који одређује факторијел датог природног броја.

*/

// Задатак представља илустрацију коришћења наредбе циклуса for

package rs.math.oop1.p040608.naredbeCiklusa.z05.faktorijelFor;

public class FaktorijelFor {

   public static void main(String[] args) {
      int n = 6;
      long fakt = 1;
      for (int i = 1; i <= n; i++)
         fakt *= i;
      System.out.println(n + "!=" + fakt);
   }
}
