/*
 
Написати Јава програм који омогућује да се, коришћењем дводимензионалног низа, реализује
приказ Паскаловог троугла.

Број врста Паскаловог троугла се учитава са улаза.

 */

// Програм илуструје учаурење функционалности за одређивање и приказ Паскаловог троугла,
// као и учитавање бројева са улаза.
// У овом примеру не користи се наредба import, већ се свуда користе пуна имена класа.

package rs.math.oop1.p080301.skenerNiska.z01.paskalovTrougao;

public class PokretanjePaskalovTrougao {

   public static void main(String[] args) {
      java.util.Scanner skener = new java.util.Scanner( "12");
      int brojVrsta = skener.nextInt();
      skener.close();
      PaskalovTrougао pt = new PaskalovTrougао();
      pt.odredi(brojVrsta);
      pt.prikazi();
   }
}
