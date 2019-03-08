package rs.math.oop1.pr.p050301.kolekcijskiFor.z01.nzdNiza;

public class PokreniNzdNiza {
    // одређивање НЗД за два броја
    static int NZD(int prvi, int drugi) {
        while (true)
            if (prvi > drugi)
                // први је већи
                if (prvi % drugi == 0)
                    return drugi;
                else
                    prvi %= drugi;
            else
                // први је мањи или једнак
                if (drugi % prvi == 0)
                    return prvi;
                else
                    drugi %= prvi;
    }
    // улазна тачка програма
    public static void main(String[] argumenti)
    {
        // низ чији се НЗД тражи
        int[] niz = {24, 48, 96, 192, 36, 72, 144};
        // приказ низа
        System.out.print("Низ: ");
        for( int elemenat:niz)
            System.out.print( elemenat + " ");
        System.out.println();
        // одређивање НЗД-а
        int nzd = niz[0];
        for( int elemenat:niz)
            nzd = NZD( nzd, elemenat);
        // приказ резултата
        System.out.print("НЗД низа: " + nzd);
    }
}
