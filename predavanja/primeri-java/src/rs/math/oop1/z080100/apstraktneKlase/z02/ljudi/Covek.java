package rs.math.oop1.z080100.apstraktneKlase.z02.ljudi;

abstract class Covek {
   private String ime;
   private String prezime;

   public Covek(String ime, String prezime) {
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

   public abstract void predstaviSe();
}