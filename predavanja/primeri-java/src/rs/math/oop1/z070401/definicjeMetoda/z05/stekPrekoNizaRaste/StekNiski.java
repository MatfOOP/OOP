/*

Класа за реализацију стека који садржи ниске.

Стек се реализује преко низа. 

Стек може да расте по потреби.
 
 */

package rs.math.oop1.z70401.definicjeMetoda.z05.stekPrekoNizaRaste;

class StekNiski {

   String[] elementi;
   int vrhSteka;

   void init() {
      elementi = new String[3];
      vrhSteka = -1;
   }

   void push(String elem) {
      if (vrhSteka == elementi.length - 1) {
         String[] temp = elementi;
         elementi = new String[2 * temp.length];
         for (int i = 0; i < temp.length; i++)
            elementi[i] = temp[i];
      }
      elementi[++vrhSteka] = elem;
   }

   String pop() {
      if (vrhSteka == -1) {
         System.out.println("Greska POP: StekNiski je prazan!");
         return "<nema>";
      }
      return elementi[vrhSteka--];
   }

   int brojElemenata() {
      return (vrhSteka + 1);
   }
}
