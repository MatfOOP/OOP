/*
a) Napraviti klasu AlternirajuciIterabilni koja implementira interfejs Iterable (tj. kroz primerke te klase se moze iterirati).

Primerci klase AlternirajuciIterabilni informacije o objektima u sebi cuvaju u listi iterabilnih objekata.

Prilikom kreiranja primerka klase AlternirajuciIterabilni, prosledjuju se jedan, dva ili tri iterabilnih objekata.

Iteriranje kroz primerak klase AlternirajuciIterabilni se vrsi naizmenicno - npr. ako su informacije o objektima u sebi smestene
u dva iterabilna objekta, prvo je prikaze tekuci elemenat prvog iterabilnog objekta, onda tekuci elemenat drugog,
pa sledeci elemenat prvog, pa sledeci drugog itd.

b) Napraviti metod koji ce biti prvi pokrenut, gde ce biti kreiran primerak klase AlternirajuciIterabilni koji ce sadrzati tri
list-iterabilna objekta razlicite duzine, a potom ce koriscenjem iteratora nad biti prikazani svi elementi kreiranog objekta.

 */

package rs.math.ispit201905.zadatakDodatni;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PokretanjeAterirajuciIterabilni {

    public static void main(String[] args) {
        List<String> g1 = Arrays.asList("Ana", "Ivana", "Marija");
        List<String> g2 = Arrays.asList("Mitar", "Petar", "Zoran", "Filip", "Denis", "Mihailo");
        List<String> g3 = Arrays.asList("Mercedes", "Folksvagen", "Lada", "Fiat");
        AlterirajuciIterabilni<String> alternator = new AlterirajuciIterabilni<>(g1, g2, g3);
        Iterator<String> prolazak = alternator.iterator();
        while( prolazak.hasNext())
            System.out.print(prolazak.next() + " ");
        System.out.println(System.lineSeparator() + "-----------------------------");
        List<String> g4 = Arrays.asList("Crna", "Bela", "Plava", "Zelena");
        alternator = new AlterirajuciIterabilni<>(g1, g2, g3, g4);
        for (String s : alternator) {
            System.out.print(s + " ");
        }
    }

}
