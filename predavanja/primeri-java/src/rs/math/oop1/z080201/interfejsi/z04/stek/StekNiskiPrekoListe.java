
/*

Класа за реализацију стека који садржи ниске.

Стек се реализује преко једноструко повезане листе. 

Стек може да расте по потреби.
 
 */

package rs.math.oop1.z080201.interfejsi.z04.stek;

public class StekNiskiPrekoListe extends Stek {

   private PovezanaLista elementi = new PovezanaLista();

   public void push(String elem) {
      elementi.dodajElemenatNaPocetak(elem);
   }

   public String pop() {
      String elem = elementi.ukloniElemenatSaPocetka();
      if (elem == null) {
         System.out.println("Greska POP: Stek je prazan!");
         return "<nema>";
      }
      return elem;
   }

   public int brojElemenata() {
      String elem = elementi.getPrvi();
      if (elem == null)
         return 0;
      int n = 0;
      while (elem != null) {
         n++;
         elem = elementi.getSledeci();
      }
      return n;
   }
}