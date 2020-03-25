package rs.math.oop1.p070502.prevazilazenje.z02.fakultetKonstruktori;

public class Covek {

   private String ime = "";
   private String prezime = "";

   public Covek(String ime, String prezime) {
      super();
      this.ime = ime;
      this.prezime = prezime;
   }

   public Covek() {
      super();
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

   public void prikazi() {
      System.out.printf("%s %s", ime, prezime);
   }

}