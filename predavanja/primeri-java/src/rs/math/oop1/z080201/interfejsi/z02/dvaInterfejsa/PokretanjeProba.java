package rs.math.oop1.z080201.interfejsi.z02.dvaInterfejsa;


public class PokretanjeProba {

    public static void main(String[] arg)
    {
        Proba proba = new Proba();
        proba.prikaziPitanje();
        System.out.println(proba.pitanje());
        proba.prikaziOdgovor();
        System.out.println(proba.odgovor());
        System.out.println(proba.pitanje2());
        System.out.println();

        Prvi p = new Proba();
        p.prikaziPitanje();
        System.out.println(p.pitanje());
        System.out.println();

        Drugi d = new Proba();
        d.prikaziOdgovor();
        System.out.println(d.odgovor());
        System.out.println();
    }
}
