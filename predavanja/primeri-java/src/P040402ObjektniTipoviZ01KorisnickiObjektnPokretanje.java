//ObjektniTip je korisnicki definisani referentni tip koji je implicitni potomak tipa Object
class ObjektniTip {

    int vrednost; //ovo je celobrojna promeljiva pridružena tipu ObjektniTip

}


class PokretanjeObjektniTip {

    public static void main(String[] args) {
        /*osnovni referentni (objektni) tip,
         * implicitni predak svih drugih referentnih tipova
         */
        Object objekat = new Object();
        /* ključna reč new pronalazi i rezerviše memoriju na kojoj će biti zapisan sadržaj ovog tipa podataka.
         * za promeljivu referentnog tipa se interno vezuje adresa u kojoj se on nalazi u memoriji,
         * nešto poput pokazivačke promenljive u programskom jeziku C
         */

        //ovo je referentni (objektni) tip koji nije ugrađen u Javi, već smo ga mi definisali
        ObjektniTip objektniTip = new ObjektniTip();
        objektniTip.vrednost = 4; //putem tačka notacije, može se pristupiti unutrašnjoj promenljivoj koja se zove vrednost
        System.out.println(objektniTip.vrednost);

        //postoji veliki broj ugrađenih referentnih tipova, pored tipa Object

        //referentni tip String
        String string1 = new String("Ovo je neki tekst.");
        String string2 = "Ovo je neki tekst."; //skraćena zapis, sa implicitnim pozivom ključne reči new

        //tzv. "omotač" referentni tipovi za primitive tipove
        Integer ceoBroj1 = new Integer(3);
        Integer ceoBroj2 = 3; //skraćeni zapis
        Short ceoBroj3 = 10;
        Float realniBroj1 = 4.4f;
        Double realniBroj2 = 3.3;
        /* "omotač" tip za neki primitivni tip je referentni tip
         * u koji je umetnuta promenljiva odgovarajućeg primitivnog tipa
         */
    }
}
