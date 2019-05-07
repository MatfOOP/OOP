
class PokretanjeObjectKreiranje {

    public static void main(String[] args) {
        /*osnovni referentni (objektni) tip,
         * implicitni predak svih drugih referentnih tipova
         */
        Object objekat = new Object();
        /* ključna reč new pronalazi i rezerviše memoriju na kojoj će biti zapisan sadržaj ovog tipa podataka.
         * za promeljivu referentnog tipa se interno vezuje adresa u kojoj se on nalazi u memoriji,
         * nešto poput pokazivačke promenljive u programskom jeziku C
         */

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
