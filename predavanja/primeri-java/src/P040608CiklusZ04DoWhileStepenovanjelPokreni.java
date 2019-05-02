/*

Написати Јава програм који одређује степен датог
реалног броја (основе) датим природним изложиоцем.

*/

// Задатак представља илустрацију коришћења наредбе циклуса do while

package rs.math.oop1.p040608.naredbeCiklusa.z04.stepenovanjeDoWhile;

public class P040608CiklusZ04DoWhileStepenovanjelPokreni {

   public static void main(String[] args) {
      int n = 10;
      double x = 2;
      double stepen = 1;
      int i = 1;
      do {
         stepen *= x;
         i++;
      } while (i <= n);
      System.out.println(x + "^" + n + "=" + stepen);
   }
}
