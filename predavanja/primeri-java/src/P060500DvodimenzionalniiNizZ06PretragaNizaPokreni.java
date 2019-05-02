// Пример илуструје употребу обележене наредбе.

/*
 Задатак је изаћи из свих петљи чим се нађе тражени број у најунутрашњијој петљи.
 Ова конструкција је посебно погодна ако има и више од једне угњеждене петље.
 */

package rs.math.oop1.p050401.prevremeniIzlazak.z01.obelezenaNaredba;

public class P060500DvodimenzionalniiNizZ06PretragaNizaPokreni {

    public static void main(String[] args) {
        int[][] niz = {{32, 87, 3, 589}, {12, 1076, 2000, 8}, {622, 127, 77, 955}};
        int traziSe = 12;
        boolean pronadjen = false;

        obelezje1:
        // obelezje
        for (int i = 0; i < niz.length; i++) {
            for (int j = 0; j < niz[i].length; j++) {
                if (niz[i][j] == traziSe) {
                    pronadjen = true;
                    break obelezje1;
                    // da je samo break, bez obelezja,
                    // onda bi se iskocilo samo iz
                    // unutrasnje petlje
                }
            }
        }
        System.out.println("Pronadjen " + pronadjen);
    }
}
