/**
 * Програм (у виду конзолне апликације) за одређивање најмањег зајдничког делиоца за три броја.
 * Програмски код је модуларно организован - реализовано je чување Јава кода у различитим датотекама.
 * Покретање програма је могуће само из датотеке која у себи садржи методу main.
 */
package rs.math.oop1.pr.p010201.paradigme.z03.modularnoNzdNzs;

class PokreniModularnoNzdNzs {

    // улазна тачка програма
    public static void main(String[] args) {
        // бројеви чији се НЗД и НЗС тражи
        int prviBroj = 48;
        int drugiBroj = 120;
        int treciBroj = 56;

        // приказ бројева чији се НЗД и НЗС тражи
        System.out.println("Први број је " + prviBroj);
        System.out.println("Други број је " + drugiBroj);
        System.out.println("Трећи број је " + treciBroj);

        // одређивање НЗД за ова три броја
        int nzd = Funkcije.NZD(prviBroj, drugiBroj, treciBroj);

        // одређивање НЗС за ова три броја
        int nzs = Funkcije.NZS(prviBroj, drugiBroj, treciBroj);

        // приказ резултата
        System.out.println("НЗД ова три броја је " + nzd);
        System.out.println("НЗС ова три броја је " + nzs);
    }

}
