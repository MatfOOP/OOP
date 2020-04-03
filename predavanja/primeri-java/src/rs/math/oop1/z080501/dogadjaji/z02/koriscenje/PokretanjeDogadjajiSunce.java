package rs.math.oop1.z080501.dogadjaji.z02.koriscenje;

import java.util.Scanner;

public class PokretanjeDogadjajiSunce {

   private static void koriscenje() {
      System.out.println("Naredbe: p-<ime> = pretplati <ime> na događaje ");
      System.out.println("         r-<ime> = raskini pretplatu <ime> na događaje ");
      System.out.println("         i       = emituj događaj izlazak sunca ");
      System.out.println("         z       = emituj događaj zalazak sunca ");
      System.out.println("         k       = kraj ");
   }

   public static void main(String... argumenti) {
      Suncokret suncokret = new Suncokret();
      System.out.println("suncokret");
      Student petar = new Student("petar");
      System.out.println(petar);
      Student mitar = new Student("mitar");
      System.out.println(mitar);
      Student miki = new Student("miki", true);
      System.out.println(miki);
      Student paja = new Student("paja", true);
      System.out.println(paja);
      Student milica = new Student("milica");
      System.out.println(milica);
      Radnik supermen = new Radnik("supermen");
      System.out.println(supermen);
      Radnik spajdermen = new Radnik("spajdermen");
      System.out.println(spajdermen);
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
               String ime = ulaz.substring(2);
               System.out.println("Pretplacuje se '" + ime + "' na dogadjaje kretanja sunca");
               if (ime.equals("petar"))
                  sunceKretanje.dodajOsluskivac(petar);
               if (ime.equals("mitar"))
                  sunceKretanje.dodajOsluskivac(mitar);
               if (ime.equals("miki"))
                  sunceKretanje.dodajOsluskivac(miki);
               if (ime.equals("paja"))
                  sunceKretanje.dodajOsluskivac(paja);
               if (ime.equals("milica"))
                  sunceKretanje.dodajOsluskivac(milica);
               if (ime.equals("supermen"))
                  sunceKretanje.dodajOsluskivac(supermen);
               if (ime.equals("spajdermen"))
                  sunceKretanje.dodajOsluskivac(spajdermen);
               if (ime.equals("suncokret"))
                  sunceKretanje.dodajOsluskivac(suncokret);
               break;
            }
            case 'r': {
               String ime = ulaz.substring(2);
               System.out.println("Raskida se pretplata '" + ime + "' na dogadjaje kretanja sunca");
               if (ime.equals("petar"))
                  sunceKretanje.ukloniOsluskivac(petar);
               if (ime.equals("mitar"))
                  sunceKretanje.ukloniOsluskivac(mitar);
               if (ime.equals("miki"))
                  sunceKretanje.ukloniOsluskivac(miki);
               if (ime.equals("paja"))
                  sunceKretanje.ukloniOsluskivac(paja);
               if (ime.equals("milica"))
                  sunceKretanje.ukloniOsluskivac(milica);
               if (ime.equals("supermen"))
                  sunceKretanje.ukloniOsluskivac(supermen);
               if (ime.equals("spajdermen"))
                  sunceKretanje.ukloniOsluskivac(spajdermen);
               if (ime.equals("suncokret"))
                  sunceKretanje.ukloniOsluskivac(suncokret);
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

}


