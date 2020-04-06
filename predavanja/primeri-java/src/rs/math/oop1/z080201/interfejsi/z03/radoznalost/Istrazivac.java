package rs.math.oop1.z080201.interfejsi.z03.radoznalost;

public class Istrazivac extends Naucnik {
   String probojUOblasti;

   public Istrazivac(String ime, String probojUOblasti) {
      super(ime);
      this.probojUOblasti = probojUOblasti;
   }

   @Override
   public void interesujeSe() {
      System.out.println("'" + getIme() +"' je ostvario proboj u naucnoj oblasti " + probojUOblasti +".");
   }
}
