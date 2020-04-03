package rs.math.oop1.z090401.anonimneUnutrasnje.z04.dogadjaji;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class PokretanjeDogadjajiSunce {

   private static int BROJ_CVETOVA = 4;

   private void koriscenje() {
      System.out.println("Naredbe: p-s = pretplati sve studente na događaje ");
      System.out.println("         r-s = raskini pretplatu za sve studente na događaje ");
      System.out.println("         p-r = pretplati sve radnike na događaje ");
      System.out.println("         r-r = raskini pretplatu za sve radnike na događaje ");
      System.out.println("         p-c = pretplati sve cvetove na događaje ");
      System.out.println("         r-c = raskini pretplatu za sve cvetove na događaje ");
      System.out.println("         i    = emituj događaj izlazak sunca ");
      System.out.println("         z    = emituj događaj zalazak sunca ");
      System.out.println("         k    = kraj ");
   }

   private void izvrsi() {
      Suncokret[] suncokreti = new Suncokret[BROJ_CVETOVA];
      SunceKretanjeOsluskivac[] slusaociCvetovi = new SunceKretanjeOsluskivac[BROJ_CVETOVA];
      for (int i = 0; i < suncokreti.length; i++) {
         suncokreti[i] = new Suncokret();
         Object trpiUticaj = suncokreti[i];
         slusaociCvetovi[i] = new SunceKretanjeOsluskivac() {
            @Override
            public void sunceSePomerilo(SunceKretanjeDogadjaj e) {
               if (e.isIzaslo())
                  System.out.printf("Cvet %s je rasirio svoj cvet \n", trpiUticaj);
               if (e.isZaslo())
                  System.out.printf("Cvet %s je sakupio svoj cvet \n", trpiUticaj);
            }
         };
         System.out.println(suncokreti[i]);
      }
      Student petar = new Student("petar");
      Student mitar = new Student("mitar");
      Student miki = new Student("miki", true);
      Student paja = new Student("paja", true);
      Student milica = new Student("milica");
      Student[] studenti = {petar, mitar, miki, paja, milica};
      SunceKretanjeOsluskivac[] slusaociRaspust = new SunceKretanjeOsluskivac[studenti.length - 1];
      for (int i = 0; i < studenti.length - 1; i++) {
         Student meta = studenti[i];
         slusaociRaspust[i] = new SunceKretanjeOsluskivac() {
            @Override
            public void sunceSePomerilo(SunceKretanjeDogadjaj e) {
               LocalDateTime datumVreme = e.getDatumVreme();
               DateTimeFormatter formatDatum = DateTimeFormatter.ofPattern("dd.MM.YYYY.");
               DateTimeFormatter formatVreme = DateTimeFormatter.ofPattern("HH:mm:ss");
               System.out.printf("%s kaže: Sunce je dana %s %s u vreme %s. ",
                     meta, datumVreme.format(formatDatum),
                     e.isIzaslo() ? "izaslo" : "zaslo",
                     datumVreme.format(formatVreme));
               if (meta.isNaRaspustu()) {
                  if (e.isIzaslo()) {
                     meta.setStatus(Status.SPAVANJE);
                     System.out.printf("Zavrsen provod, idem na spavanje. Moj novi status: %s\n",
                           Status.opis(meta.getStatus()));
                  } else {
                     meta.setStatus(Status.PROVOD);
                     System.out.printf("Gde cemo nocas u provod? Moj novi status: %s.\n",
                           Status.opis(meta.getStatus()));
                  }
               } else {
                  if (e.isIzaslo()) {
                     meta.setStatus(Status.UCENJE);
                     System.out.printf("Pocinje novi dan, moram da ucim. Moj novi status: %s.\n",
                           Status.opis(meta.getStatus()));
                  } else {
                     meta.setStatus(Status.SPAVANJE);
                     System.out.printf("Vredno sam ucio, jos malo pa na spavanje. Moj novi status: %s.\n",
                           Status.opis(meta.getStatus()));
                  }
               }

            }
         };
         System.out.println(studenti[i]);
      }
      Radnik supermen = new Radnik("supermen");
      Radnik spajdermen = new Radnik("spajdermen");
      Radnik[] radnici = {supermen, spajdermen};
      SunceKretanjeOsluskivac[] slusaociDanUNedelji =
            new SunceKretanjeOsluskivac[radnici.length + 1];
      for (int i = 0; i < radnici.length; i++) {
         Covek meta = radnici[i];
         slusaociDanUNedelji[i] = new SunceKretanjeOsluskivac() {
            final class DanUNedelji {
               public static final int PONEDELJAK = 1;
               public static final int UTORAK = 2;
               public static final int SREDA = 3;
               public static final int CETVRTAK = 4;
               public static final int PETAK = 5;
               public static final int SUBOTA = 6;
               public static final int NEDELJA = 7;

               public final String opis(int dan) {
                  switch (dan) {
                     case PONEDELJAK:
                        return "ponedeljak";
                     case UTORAK:
                        return "utorak";
                     case SREDA:
                        return "sreda";
                     case CETVRTAK:
                        return "cetvrtak";
                     case PETAK:
                        return "petak";
                     case SUBOTA:
                        return "subota";
                     case NEDELJA:
                        return "nedelja";
                     default:
                        return "ovo ne bi smelo da se pojavi!";
                  }
               }
            }

            @Override
            public void sunceSePomerilo(SunceKretanjeDogadjaj e) {
               LocalDateTime datumVreme = e.getDatumVreme();
               DateTimeFormatter formatDatum = DateTimeFormatter.ofPattern("dd.MM.YYYY.");
               DateTimeFormatter formatVreme = DateTimeFormatter.ofPattern("HH:mm:ss");
               System.out.printf("%s kaže: Sunce je dana %s %s u vreme %s. ",
                     meta, datumVreme.format(formatDatum),
                     e.isIzaslo() ? "izaslo" : "zaslo", datumVreme.format(formatVreme));
               int danUNedelji = datumVreme.getDayOfWeek().getValue();
               System.out.printf(" %s - ", (new DanUNedelji()).opis(danUNedelji));
               switch (danUNedelji) {
                  case DanUNedelji.PONEDELJAK:
                     if (e.isIzaslo()) {
                        meta.setStatus(Status.RAD);
                        System.out.printf("Pcinje rad u novoj radnoj nedelji :( Moj novi status: %s. \n",
                              Status.opis(meta.getStatus()));
                     }
                     if (e.isZaslo()) {
                        meta.setStatus(Status.SPAVANJE);
                        System.out.printf("Nekako sam pregurao prvi radni dan... Moj novi status: %s. \n",
                              Status.opis(meta.getStatus()));
                     }
                     break;
                  case DanUNedelji.UTORAK:
                  case DanUNedelji.SREDA:
                  case DanUNedelji.CETVRTAK:
                     if (e.isIzaslo()) {
                        meta.setStatus(Status.RAD);
                        System.out.printf("I danas treba uskoro da se pocne sa radom. Moj novi status: %s. \n",
                              Status.opis(meta.getStatus()));
                     }
                     if (e.isZaslo()) {
                        meta.setStatus(Status.SPAVANJE);
                        System.out.printf("Za danas sam zavrsio sa poslom... Moj novi status: %s. \n",
                              Status.opis(meta.getStatus()));
                     }
                     break;
                  case DanUNedelji.PETAK:
                     if (e.isIzaslo()) {
                        meta.setStatus(Status.RAD);
                        System.out.printf("Sto bi petak bio lepsi da sutra nije subota radna. Moj novi status: %s. \n",
                              Status.opis(meta.getStatus()));
                     }
                     if (e.isZaslo()) {
                        meta.setStatus(Status.SPAVANJE);
                        System.out.printf("Kraj dansenjeg posla. Jos sutra pa gotovo. Moj novi status: %s. \n",
                              Status.opis(meta.getStatus()));
                     }
                     break;
                  case DanUNedelji.SUBOTA:
                     if (e.isIzaslo()) {
                        meta.setStatus(Status.RAD);
                        System.out.printf("Mrzim radne subote! Moj novi status: %s. \n",
                              Status.opis(meta.getStatus()));
                     }
                     if (e.isZaslo()) {
                        meta.setStatus(Status.SPAVANJE);
                        System.out.printf("Kraj subotnjeg posla. Slobodan sam!  Moj novi status: %s. \n",
                              Status.opis(meta.getStatus()));
                     }
                     break;
                  case DanUNedelji.NEDELJA:
                     if (e.isIzaslo()) {
                        meta.setStatus(Status.ODMOR);
                        System.out.printf("Sloboda!!! Moj novi status: %s. \n",
                              Status.opis(meta.getStatus()));
                     }
                     if (e.isZaslo()) {
                        meta.setStatus(Status.SPAVANJE);
                        System.out.printf("Jos malo, pa ponovo na posao :(  Moj novi status: %s. \n",
                              Status.opis(meta.getStatus()));
                     }
                     break;
                  default:
                     System.out.printf("Ovo nikad ne bi smelo da se pojavi");
               }
            }

         };
         System.out.println(studenti[i]);
      }
      Covek meta = studenti[studenti.length - 1];
      slusaociDanUNedelji[radnici.length] = new SunceKretanjeOsluskivac() {
         @Override
         public void sunceSePomerilo(SunceKretanjeDogadjaj e) {
            System.out.printf("%s ce se ponasati drugacije od svih ostalih studenata.\n", meta);
         }
      };
      System.out.println();
      koriscenje();
      Scanner sc = new Scanner(System.in);
      SunceKretanje sunceKretanje = new SunceKretanje();
      boolean gotovo = false;
      while (!gotovo) {
         String ulaz = sc.next().trim();
         char naredba = ulaz.toCharArray()[0];
         switch (naredba) {
            case 'p': {
               char tip = ulaz.charAt(2);
               System.out.println("Kreira se pretplata '" + tip + "' na dogadjaje kretanja sunca");
               switch (tip) {
                  case 's':
                     for (SunceKretanjeOsluskivac slusa : slusaociRaspust)
                        sunceKretanje.dodajOsluskivac(slusa);
                     break;
                  case 'r':
                     for (SunceKretanjeOsluskivac slusa : slusaociDanUNedelji)
                        sunceKretanje.dodajOsluskivac(slusa);
                     break;
                  case 'c':
                     for (SunceKretanjeOsluskivac slusa : slusaociCvetovi)
                        sunceKretanje.dodajOsluskivac(slusa);
                     break;
                  default:
               }
               break;
            }
            case 'r': {
               char tip = ulaz.charAt(2);
               System.out.println("Raskida se pretplata '" + tip + "' na dogadjaje kretanja sunca");
               switch (tip) {
                  case 's':
                     for (SunceKretanjeOsluskivac slusa : slusaociRaspust)
                        sunceKretanje.ukloniOsluskivac(slusa);
                     break;
                  case 'r':
                     for (SunceKretanjeOsluskivac slusa : slusaociDanUNedelji)
                        sunceKretanje.ukloniOsluskivac(slusa);
                     break;
                  case 'c':
                     for (SunceKretanjeOsluskivac slusa : slusaociCvetovi)
                        sunceKretanje.ukloniOsluskivac(slusa);
                     break;
                  default:
               }
               break;
            }
            case 'i':
               System.out.println("Emituje se dogadjaj za izlazak sunca");
               sunceKretanje.ispaliDogadjaj(true);
               break;
            case 'z':
               System.out.println("Emituje se dogadjaj za zalazak sunca");
               sunceKretanje.ispaliDogadjaj(false);
               break;
            case 'k':
               System.out.println("Zavrsetak rada");
               gotovo = true;
               break;
            default:
               System.out.println("Nekorektna naredba");
               koriscenje();
         }
      }
      sc.close();
   }

   public static void main(String... argumenti) {
      (new PokretanjeDogadjajiSunce()).izvrsi();
   }


}


