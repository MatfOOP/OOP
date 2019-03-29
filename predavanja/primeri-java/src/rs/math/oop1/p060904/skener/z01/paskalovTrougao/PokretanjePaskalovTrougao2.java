/*
 
Написати Јава програм који омогућује да се, коришћењем дводимензионалног низа, реализује
приказ Паскаловог троугла.

Број врста Паскаловог троугла се учитава са улаза.

 */

// Програм илуструје учаурење функционалности за одређивање и приказ Паскаловог троугла,
// као и учитавање бројева са улаза.
// У овом примеру не користи се наредба import, већ се свуда користе пуна имена класа.

package rs.math.oop1.p060904.skener.z01.paskalovTrougao;

public class PokretanjePaskalovTrougao2 {

   public static void main(String[] args) {
      System.out.println(
               "Unesi broj vrsta Paskalovog trougla: ");
      java.util.Scanner skener = new java.util.Scanner(
               System.in);
      int brojVrsta = skener.nextInt();
      skener.close();
      PaskalovTrougао pt = new PaskalovTrougао();
      pt.odredi(brojVrsta);
      pt.prikazi();
   }
}
