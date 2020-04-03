package rs.math.oop1.z080501.dogadjaji.z02.koriscenje;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Student implements SunceKretanjeOsluskivac {
   private String ime;
   private boolean naRaspustu;
   private int status;

   public Student(String ime, boolean naRaspustu, int status) {
      this.ime = ime;
      this.naRaspustu = naRaspustu;
      this.status = status;
   }

   public Student(String ime, boolean naRaspustu) {
      this(ime, naRaspustu, Status.SPAVANJE);
   }

   public Student(String ime) {
      this(ime, false, Status.SPAVANJE);
   }

   public void setStatus(int status) {
      this.status = status;
   }

   @Override
   public String toString() {
      return String.format("Student '%s' (%s)", ime, naRaspustu ? "na raspustu" : "studira");
   }

   @Override
   public void sunceSePomerilo(SunceKretanjeDogadjaj e) {
      LocalDateTime datumVreme = e.getDatumVreme();
      DateTimeFormatter formatDatum = DateTimeFormatter.ofPattern("dd.MM.YYYY.");
      DateTimeFormatter formatVreme = DateTimeFormatter.ofPattern("HH:mm:ss");
      System.out.printf("%s kaže: Sunce je dana %s %s u vreme %s. ",
            this, datumVreme.format(formatDatum),
            e.isIzaslo() ? "izaslo" : "zaslo",
            datumVreme.format(formatVreme));
      if (naRaspustu) {
         if (e.isIzaslo()) {
            this.status = Status.SPAVANJE;
            System.out.printf("Zavrsen provod, idem na spavanje. Moj novi status: %s\n",
                  Status.opis(status));
         } else {
            this.status = Status.PROVOD;
            System.out.printf("Gde cemo nocas u provod? Moj novi status: %s.\n",
                  Status.opis(status));
         }
      } else {
         if (e.isIzaslo()) {
            this.status = Status.UCENJE;
            System.out.printf("Pocinje novi dan, moram da ucim. Moj novi status: %s.\n",
                  Status.opis(status));
         }
         else {
            this.status = Status.SPAVANJE;
            System.out.printf("Vredno sam ucio, jos malo pa na spavanje. Moj novi status: %s.\n",
                  Status.opis(status));
         }
      }
   }
}