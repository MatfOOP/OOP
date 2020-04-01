package rs.math.oop1.z080100.apstraktneKlase.z02.ljudi;

public class Apsolvent extends Student {
   private int brojRokovaDoIstekaStaza;

   public Apsolvent(String ime, String prezime, String smer, String brojIndeksa, int godinaStudija,
                    int brojRokovaDoIstekaStaza) {
      super(ime, prezime, smer, brojIndeksa, godinaStudija);
      this.brojRokovaDoIstekaStaza = brojRokovaDoIstekaStaza;
   }

   public int getBrojRokovaDoIstekaStaza() {
      return brojRokovaDoIstekaStaza;
   }

   public void setBrojRokovaDoIstekaStaza(int brojRokovaDoIstekaStaza) {
      this.brojRokovaDoIstekaStaza = brojRokovaDoIstekaStaza;
   }

   @Override
   public void predstaviSe() {
      System.out.println("Apsolvent: "
            + getIme() + " " + getPrezime() + " "
            + getSmer() + " " + getBrojIndeksa() + " "
            + getGodinaStudija() + " "
            + brojRokovaDoIstekaStaza + ".");
   }
}
