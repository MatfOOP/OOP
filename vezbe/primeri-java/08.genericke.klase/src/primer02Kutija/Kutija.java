package primer02Kutija;

// U klasi Kutija imamo funkcionalnosti provere da li je nesto sasdrzano u kutiji,
// ubacivanja u kutiju, uzimanja iz kutije i ispisa sta je u kutiji.
// Posto nijedna od ovih funkcionalnosti nije specificna za neki odredjeni tip,
// mozemo tip predmeta da predstavimo kao genericki parametar klase Kutija.
// Na taj nacin povecavamo njenu upotrebljivost i omogucavamo rad sa razlicitim tipovima podataka.
public class Kutija<T>
{
    private T predmet;
    private boolean sadrziPredmet;

    public Kutija() {}
    public Kutija(T predmet)
    {
        this.predmet = predmet;
        this.sadrziPredmet = true;
    }

    public T uzmiPredmet()
    {
        if (sadrziPredmet) {
            sadrziPredmet = false;
            return predmet;
        } else {
            return null;
        }
    }

    public void ubaciPredmet(T predmet)
    {
        if (sadrziPredmet) {
            System.out.println("Kutija je puna!");
        } else {
            this.predmet = predmet;
            sadrziPredmet = true;
        }
    }

    @Override
    public String toString()
    {
        if (sadrziPredmet) {
            return "[" + predmet.toString() + "]";
        } else {
            return "[ ]";
        }
    }
}
