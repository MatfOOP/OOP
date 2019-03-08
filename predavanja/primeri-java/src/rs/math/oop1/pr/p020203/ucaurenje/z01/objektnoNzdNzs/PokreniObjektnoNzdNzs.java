/**
 * Програм (у виду конзолне апликације) за одређивање најмањег зајдничког делиоца за три броја.
 * Програм је реализован коришћењем објектно-орјентисане парадигме.
 * Програмски код је модуларно организован - реализовано je чување Јава кода у различитим датотекама.
 * Покретање програма је могуће само из датотеке која у себи садржи методу main.
 */
package rs.math.oop1.pr.p020203.ucaurenje.z01.objektnoNzdNzs;

class PokreniObjektnoNzdNzs {

    // улазна тачка програма
    public static void main(String[] args) {
        // бројеви чији се НЗД тражи
        CeoBroj prvi = new CeoBroj(48);
        CeoBroj drugi = new CeoBroj(120);
        CeoBroj treci = new CeoBroj(56);

        // приказ бројева чији се НЗД и НЗС тражи
        System.out.print("Први број је ");
        prvi.prikaz();
        System.out.print("Други број је ");
        drugi.prikaz();
        System.out.print("Трећи број је ");
        treci.prikaz();

        // одређивање НЗД за ова три броја
        CeoBroj nzd = prvi.NZD(drugi, treci);
        // одређивање НЗС за ова три броја
        CeoBroj nzs = prvi.NZS(drugi, treci);

        // приказ резултата
        System.out.print("НЗД ова три броја је ");
        nzd.prikaz();
        System.out.print("НЗС ова три броја је ");
        nzs.prikaz();
    }

}
