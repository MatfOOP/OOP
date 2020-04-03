package rs.math.oop1.z080501.dogadjaji.z01.koriscenje;

import java.util.Scanner;

public class PokretanjeDogadjajiSunce {

   private static void koriscenje() {
      System.out.println("Naredbe: p-<ime> = pretplati studenta <ime> na događaje ");
      System.out.println("         r-<ime> = raskini pretplatu studenta <ime> na događaje ");
      System.out.println("         i       = emituj događaj izlazak sunca ");
      System.out.println("         z       = emituj događaj zalazak sunca ");
      System.out.println("         k       = kraj ");
   }

   public static void main(String... argumenti) {
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
      System.out.println();
      koriscenje();
      Scanner sc = new Scanner(System.in);
      CentralaZaDogadjajSunceKretanje centrala = new CentralaZaDogadjajSunceKretanje();
      boolean gotovo = false;
      while (!gotovo) {
         String ulaz = sc.next().trim();
         char naredba = ulaz.toCharArray()[0];
         switch (naredba) {
            case 'p': {
               String ime = ulaz.substring(2);
               System.out.println("Pretplacuje se '" + ime + "' na dogadjaje kretanja sunca");
               if (ime.equals("petar"))
                  centrala.dodajOsluskivacZaKretanjeSunca(petar);
               if (ime.equals("mitar"))
                  centrala.dodajOsluskivacZaKretanjeSunca(mitar);
               if (ime.equals("miki"))
                  centrala.dodajOsluskivacZaKretanjeSunca(miki);
               if (ime.equals("paja"))
                  centrala.dodajOsluskivacZaKretanjeSunca(paja);
               if (ime.equals("milica"))
                  centrala.dodajOsluskivacZaKretanjeSunca(milica);
               break;
            }
            case 'r': {
               String ime = ulaz.substring(2);
               System.out.println("Raskida se pretplata '" + ime + "' na dogadjaje kretanja sunca");
               if (ime.equals("petar"))
                  centrala.ukloniOsluskivacZaKretanjeSunca(petar);
               if (ime.equals("mitar"))
                  centrala.ukloniOsluskivacZaKretanjeSunca(mitar);
               if (ime.equals("miki"))
                  centrala.ukloniOsluskivacZaKretanjeSunca(miki);
               if (ime.equals("paja"))
                  centrala.ukloniOsluskivacZaKretanjeSunca(paja);
               if (ime.equals("milica"))
                  centrala.ukloniOsluskivacZaKretanjeSunca(milica);
               break;
            }
            case 'i':
               System.out.println("Emituje se dogadjaj za izlazak sunca");
               centrala.ispaliDogadjajZaKretanjeSunca(true);
               break;
            case 'z':
               System.out.println("Emituje se dogadjaj za zalazak sunca");
               centrala.ispaliDogadjajZaKretanjeSunca(false);
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


