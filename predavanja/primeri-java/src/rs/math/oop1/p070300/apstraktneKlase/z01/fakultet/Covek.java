package rs.math.oop1.p070300.apstraktneKlase.z01.fakultet;

public  abstract class Covek {

   private String ime = "";
   private String prezime = "";

   public Covek(String ime, String prezime) {
      super();
      this.ime = ime;
      this.prezime = prezime;
   }

   public String getIme() {
      return ime;
   }

   public void setIme(String ime) {
      this.ime = ime;
   }

   public String getPrezime() {
      return prezime;
   }

   public void setPrezime(String prezime) {
      this.prezime = prezime;
   }
   
   public abstract void prikazi();

}