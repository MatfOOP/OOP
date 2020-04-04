package rs.math.oop1.z080501.dogadjaji.z03.koriscenje;

public class OsluskivacKretanjaSuncaCvetInverzni implements SunceKretanjeOsluskivac {
   private Object trpiUticaj;

   public OsluskivacKretanjaSuncaCvetInverzni(Object trpiUticaj) {
      this.trpiUticaj = trpiUticaj;
   }

   @Override
   public void sunceSePomerilo(SunceKretanjeDogadjaj e) {
      if(e.isIzaslo())
         System.out.printf("Cvet %s je sakupio svoj cvet \n", trpiUticaj);
      if(e.isZaslo())
         System.out.printf("Cvet %s je rasirio svoj cvet \n", trpiUticaj);
   }
}
