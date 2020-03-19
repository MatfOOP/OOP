/*
 
 Написати Јава програм који мери време протекло између два 
 узастопна притиска на тастер <Enter>.
 
 */

// Задатак представља илустрацију мерења трајања неког временског
// интервала

package rs.math.oop1.p050602.merenjeVremena.z01.protekloVreme;

public class VremeIzvrsenjaMetoda {

   public static void main(String[] args) {
      java.util.Scanner skener = new java.util.Scanner(System.in);
      System.out.println(
            "Pritisni dva puta taster <Enter>!");
      skener.nextLine();
      long vremePocetka = System.nanoTime();
      skener.nextLine();
      double trajanje = (System.nanoTime() - vremePocetka) / 1e9;
      System.out.printf(
            "Izmedju dva pritiska je proteklo %f sekundi!",
            trajanje);
      skener.close();
   }

}
