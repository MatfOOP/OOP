package primer02Comparator.comparatorV1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        List<Tacka> tacke = new ArrayList<>(Arrays.asList(
                new Tacka(2, 3),
                new Tacka(2, 5),
                new Tacka(3, 1),
                new Tacka(-1, 1),
                new Tacka(7, 6),
                new Tacka(5, -7),
                new Tacka(-3, 2),
                new Tacka(5, -6)
        ));

        /*
            Postoji jos jedan nacin da se definise funkcija 'sort', a
            on podrazumeva da mu se pored kolekcije koju je potrebno
            sortirati prosledi i komparator koji govori kako se porede
            dve instance date klase. Na ovaj nacin, logika poredjenja
            preneta je u zasebnu klasu i funkcija za
            sortiranje zna da poredi elemente dok se bude 
            primenjivao algoritam za sortiranje.
            Poredjenje se vrsi tako sto algoritam sortiranja
            poziva metod 'compare' (koji smo definisali) nad komparatorom kojem
            i prosledjuje elemente iz kolekcije koja se sortira.
        */
        PorediPoXPaY poXpaY = new PorediPoXPaY();
        Collections.sort(tacke, poXpaY);

        System.out.println(tacke);
    }
}
