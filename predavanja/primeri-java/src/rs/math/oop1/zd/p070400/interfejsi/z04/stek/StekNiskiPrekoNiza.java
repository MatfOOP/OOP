
/*

Класа за реализацију стека који садржи ниске.

Стек се реализује преко низа. 

Стек може да расте по потреби.
 
 */

package rs.math.oop1.zd.p070400.interfejsi.z04.stek;

public class StekNiskiPrekoNiza extends Stek {

   private String[] elementi;
   private int vrhSteka;

   // inicijalizacioni blok primerka
   {
      elementi = new String[8];
      vrhSteka = -1;
   }

   public void push(String elem) {
      if (vrhSteka == elementi.length - 1) {
         String[] temp = elementi;
         elementi = new String[2 * temp.length];
         for (int i = 0; i < temp.length; i++)
            elementi[i] = temp[i];
      }
      elementi[++vrhSteka] = elem;
   }

   public String pop() {
      if (vrhSteka == -1) {
         System.out.println("Greska POP: Stek je prazan!");
         return "<nema>";
      }
      return elementi[vrhSteka--];
   }

   public int brojElemenata() {
      return (vrhSteka + 1);
   }
}
