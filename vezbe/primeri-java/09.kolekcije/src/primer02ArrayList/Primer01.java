package primer02ArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Primer01 {

	// ------------------------------------------------------------------------------------------------------
	// Klasa ArrayList predstavlja implementaciju dinamickog niza (mozemo dodavati i uklanjati elemente).
	// Cesto cemo umesto da promenljivu deklarisemo kao referencu na 'ArrayList' birati da je deklarisemo
	// kao referencu na "nesto sto implementira interfejs 'List'". Na ovaj nacin mozemo da promenimo
	// klasu objekta na koji referenca pokazuje, a kod koji smo napisali ce sustinski ostati isti.
	// ------------------------------------------------------------------------------------------------------
	// Klase LinkedList i ArrayList implementiraju interfejs List.
	// ------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		List<Tacka> tacke = new ArrayList<>();
		tacke.add(new Tacka(2, 3));
		tacke.add(new Tacka(10, 9));
		tacke.add(new Tacka(5, 1));
		tacke.add(new Tacka(-4, 11));
		tacke.add(new Tacka(100, 1));
		
		// Sortiranje mozemo izvrsiti i nad nasim Klasama, no bitne je da
		// definisemo "kako" se porede dve instance nase klase.
		// Jedan od nacina je da klasa 'Tacka' implementira interfejs 'Comparable<Tacka>' cime
		// je duzna da definise metod 'compareTo'. Vise o ovome u klasi 'Tacka'.
		Collections.sort(tacke);
		
		// Iteriramo kroz listu kako bi prikazali sortirane elemente.
		Iterator<Tacka> i = tacke.iterator();
		while (i.hasNext())
			System.out.print(i.next() + " ");
		System.out.println();
		
		// Binarna pretraga, zahteva da znamo da poredimo elemente u kolekciji (metod 'compareTo').
		Tacka t = new Tacka(5, 1);
		int k = Collections.binarySearch(tacke, t);
		if (k >= 0) System.out.println("Pronadjena je tacka " + tacke.get(k) + " na indeksu " + k);
		else System.out.println("Ne postoji tacka " + t);
		
		// Mozemo obrnuti kolekciju.
		Collections.reverse(tacke);
		i = tacke.iterator();
		while (i.hasNext())
			System.out.print(i.next() + " ");
		System.out.println();
		
		// Cool nacin da ispisemo svaki element
		// (vise o ovome u dodatnim materijalima)
		// tacke.stream().forEach(e -> System.out.print(e + " "));
	}
}
