package rs.math.oop1.p040307.komentari.z03.javaDokumentacija;

/**
 * @author vlado
 * <p>
 * Interfejs ProbaInterfejs sluzi za testiranje ponasanja konstanti
 * @see ProbaImplemenetacija
 */
public interface ProbaInterfejs {
    /**
     * Metod <code> saberi </code> sabira dva argumenta
     * <p>
     *
     * @param a prvi sabirak
     * @param b drugi sabirak
     * @return zbir sabiraka
     */
    int saberi(int a, int b);

    /**
     * Konstanta <code> NULA </code> ima vrednost <code> 0 </code>
     * <p>
     * Ona nije deklarisana kao staticka
     */
    final int NULA = 0;

    /**
     * Konstanta <code> NULA2 </code> ima vrednost <code> 0 </code>
     * <p>
     * Ona jeste deklarisana kao staticka
     */
    static final int NULA2 = 0;
}
