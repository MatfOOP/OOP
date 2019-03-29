package rs.math.oop1.p070300.apstraktneKlase.z03.geometrija;

public abstract class GeometrijskiObjekat {
   public static int brojKreiranih = 0;

   private String oznaka;

   {
      brojKreiranih++;
   }

   public GeometrijskiObjekat(String oznaka) {
      this.oznaka = oznaka;
   }

   public String getOznaka() {
      return oznaka;
   }

   public void setOznaka(String oznaka) {
      this.oznaka = oznaka;
   }

   public abstract void prikaziSe();

   public abstract boolean jeKonveksan(); 

   public abstract boolean jeOgranicen();

}
