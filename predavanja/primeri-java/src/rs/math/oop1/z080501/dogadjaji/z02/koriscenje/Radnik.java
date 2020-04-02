package rs.math.oop1.z080501.dogadjaji.z02.koriscenje;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Radnik implements SunceKretanjeOsluskivac {
   private String ime;

   public Radnik(String ime) {
      this.ime = ime;
   }

   @Override
   public String toString() {
      return "Radnik '" + ime + "'" + "";
   }

   @Override
   public void sunceSePomerilo(SunceKretanjeDogadjaj e) {
      LocalDateTime datumVreme = e.getDatumVreme();
      DateTimeFormatter formatDatum = DateTimeFormatter.ofPattern("dd.MM.YYYY.");
      DateTimeFormatter formatVreme = DateTimeFormatter.ofPattern("HH:mm:ss");
      System.out.printf("%s kaže: Sunce je dana %s %s u vreme %s. ",
            this, datumVreme.format(formatDatum),
            e.isIzaslo() ? "izaslo" : "zaslo", datumVreme.format(formatVreme));
      DayOfWeek danUNedelji = datumVreme.getDayOfWeek();
      System.out.printf(" %s - ", danUNedelji);
      switch (danUNedelji) {
         case MONDAY:
            if (e.isIzaslo())
               System.out.printf("Pcinje rad u novoj radnoj nedelji :( \n");
            if (e.isZaslo())
               System.out.printf("Nekako sam pregurao prvi radni dan... \n");
            break;
         case TUESDAY:
         case WEDNESDAY:
         case THURSDAY:
            if (e.isIzaslo())
               System.out.printf("I danas treba uskoro da se pocne sa radom. \n");
            if (e.isZaslo())
               System.out.printf("Za danas sam zavrsio sa poslom... \n");
            break;
         case FRIDAY:
            if (e.isIzaslo())
               System.out.printf("Sto bi petak bio lepsi da sutra nije subota radna. \n");
            if (e.isZaslo())
               System.out.printf("Kraj dansenjeg posla. Jos sutra pa gotovo. \n");
            break;
         case SATURDAY:
            if (e.isIzaslo())
               System.out.printf("Mrzim radne subote! \n");
            if (e.isZaslo())
               System.out.printf("Kraj subotnjeg posla. Slobodan sam! \n");
            break;
         case SUNDAY:
            if (e.isIzaslo())
               System.out.printf("Sloboda!!! \n");
            if (e.isZaslo())
               System.out.printf("Jos malo, pa ponovo na posao :( \n");
            break;
         default:
            System.out.printf("Ovo nikad ne bi smelo da se pojavi");
      }
   }
}