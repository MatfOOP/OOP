package rs.math.oop1.z080204.interfejsi.z04.stek;

public class ElemenatListe {
   private String sadrzaj;
   private ElemenatListe sledeci;

   public ElemenatListe(String elem) {
      sadrzaj = elem;
      sledeci = null;
   }

   public String getSadrzaj() {
      return sadrzaj;
   }

   public void setSadrzaj(String sadrzaj) {
      this.sadrzaj = sadrzaj;
   }

   public ElemenatListe getSledeci() {
      return sledeci;
   }

   public void setSledeci(ElemenatListe sledeci) {
      this.sledeci = sledeci;
   }

   public void prikazi() {
      System.out.print("Elemenat liste: " + sadrzaj);
   }

}
