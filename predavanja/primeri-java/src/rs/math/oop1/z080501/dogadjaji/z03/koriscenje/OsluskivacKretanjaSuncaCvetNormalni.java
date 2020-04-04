package rs.math.oop1.z080501.dogadjaji.z03.koriscenje;

public class OsluskivacKretanjaSuncaCvece implements SunceKretanjeOsluskivac {
   private Object trpiUticaj;

   public OsluskivacKretanjaSuncaCvece(Object trpiUticaj) {
      this.trpiUticaj = trpiUticaj;
   }

   @Override
   public void sunceSePomerilo(SunceKretanjeDogadjaj e) {
      if(e.isIzaslo())
         System.out.printf("Cvet %s je rasirio svoj cvet \n", trpiUticaj);
      if(e.isZaslo())
         System.out.printf("Cvet %s je sakupio svoj cvet \n", trpiUticaj);
   }
}
