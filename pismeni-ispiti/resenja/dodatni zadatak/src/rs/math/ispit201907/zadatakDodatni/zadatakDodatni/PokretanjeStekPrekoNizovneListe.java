/*
a) Napraviti generički interfejs Stek, koji podržava osnovne oparacije sa stekom

b) Napraviti kolekcijsku klasu klasu StekPrekoNizovneListe koja implementira interfejs Stek i implementira interfejs
Collection. Sve komponente steka moraju biti istog, generičkog tipa

Primerci klase StekPrekoNizovneListe informacije o objektima koje sadrze interno cuvaju u nizovnoj listi.

Prilikom kreiranja primerka klase StekPrekoNizovneListe, prosledjuju se jedna ili vise kolekcija objekata istog tipa i
svi objekti iz tih prosleđenih kolekcija treba da se nadju u novokreiranom steku.

Prilikom iteriranja kroz tu kolekciju treba detektovati mogućnost da je u nekoj drugoj niti
dodaje ii ukalnja elemenat steka i u takvom slučaju treba izbaciti izuzetak tipa ConcurrentModificationException.

Prilikom izbacivanja elementa iz preznog steka treba izbaciti izuzetak tipa EmptyStackException.

Iterator kolekcije ne mora da podržava uklanjanje elementa iz steka, već može u tom slučaju izbaciti izuzetak tipa
NotImplementedException.

b) Napraviti metod koji ce biti prvi pokrenut, gde ce biti kreiran primerak klase StekPrekoNizovneListe koji ce
sadrzati elemente iz tri prosleđene kolekcije kojima su svi elementi istog tipa, a potom će se
u taj stek gurnuti jedan elemenat i izbaciti dva elementa.

Posle kreiranja steka i posle svakog ubacivanja i izbacivanja elementa na standardnom izlazu prikazati stek.

 */

package rs.math.ispit201907.zadatakDodatni.zadatakDodatni;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PokretanjeSkupPrekoNizovneListe {
    public static void main(String[] args) {
        List<String> g10 = Arrays.asList("Ana", "Ivana", "Marija", "Ana");
        SkupPrekoNizovneListe<String> s1 = new SkupPrekoNizovneListe<>(g10);
        System.out.println(System.lineSeparator() + "1. -----------------------------");
        System.out.println(s1);

        List<String> g11 = Arrays.asList("Mitar", "Ana", "Zoran", "Petar", "Denis", "Petar");
        for( String s: g11 )
            s1.add(s);
        System.out.println(System.lineSeparator() + "2. -----------------------------");
        System.out.println(s1);

        s1 = new SkupPrekoNizovneListe<String>(g10, g11);
        System.out.println(System.lineSeparator() + "3. -----------------------------");
        System.out.println(s1);

        s1.remove("Mitar");
        s1.remove( "Ana");
        System.out.println(System.lineSeparator() + "4. -----------------------------");
        System.out.println(s1);

        List<Integer> g2 = Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3);
        SkupPrekoNizovneListe<Integer> s2 = new SkupPrekoNizovneListe<>(g2);
        System.out.println(System.lineSeparator() + "5. -----------------------------");
        System.out.println(s2);

        Random generator = new Random();
        System.out.println(System.lineSeparator() + "6. -----------------------------");
        for( int i =0; i<10; i++) {
            int broj = generator.nextInt(20);
            s2.add(broj);
            System.out.println(broj + "\t " + s2);
        }

        System.out.println(System.lineSeparator() + "7. -----------------------------");
        for( int i =0; i<10; i++) {
            int broj = generator.nextInt(20);
            s2.remove(broj);
            System.out.println(broj + "\t " + s2);
        }
    }
}
