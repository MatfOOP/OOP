
/*

Класа за реализацију стека који садржи ниске.

Стек се реализује преко низа. 

Стек може да расте по потреби.
 
 */

package rs.math.oop1.z080100.apstraktneKlase.z04.stek;

public class StekNiskiPrekoSamorastucegNiza extends StekNiski {

   private SamorastuciNizNiski elementi;
   private int vrhSteka;

   // inicijalizacioni blok primerka
   {
      elementi = new SamorastuciNizNiski();
      vrhSteka = -1;
   }

   public void push(String elem) {
      elementi.postavi(elem, ++vrhSteka);
   }

   public String pop() {
      if (vrhSteka == -1) {
         System.err.println("Greska POP: Stek je prazan!");
         return null;
      }
      return elementi.vrati(vrhSteka--);
   }

   public int brojElemenata() {
      return (vrhSteka + 1);
   }
}
