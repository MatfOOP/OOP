package primer02Comparator.comparatorV1;

import java.util.Comparator;

public class PorediPoXPaY implements Comparator<Tacka> {

    @Override
    public int compare(Tacka o1, Tacka o2) {
        // Kako su koordinate tacke celobrojne vrednosti, za 
        // njihovo poredjenje mozemo koristiti metod compare
        // koji se nalazi u klasi Integer.
        return o1.getX() != o2.getX()?
                Integer.compare(o1.getX(), o2.getX()):
                Integer.compare(o1.getY(), o2.getY());
    }
}
