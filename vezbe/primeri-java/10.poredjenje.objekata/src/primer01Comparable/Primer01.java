package primer01Comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Primer01 {

	public static void main(String[] args) {
		List<Tacka> tacke = new ArrayList<>();
		tacke.add(new Tacka(2, 3));
		tacke.add(new Tacka(10, 9));
		tacke.add(new Tacka(5, 1));
		tacke.add(new Tacka(-4, 11));
		tacke.add(new Tacka(100, 1));
		
		/*
		 	Sortiranje mozemo izvrsiti i nad nasim klasama, no
		 	bitno je da definisemo "kako" se porede dve instance
		 	nase klase. Jedan od nacina je da nasa klasa implementira
			interfejs Comparable<T> i u metodu 'compareTo' definise kako
			se vrsi poredjenje instanci date klase. U ovom konkretnom 
			primeru, klasa 'Tacka' implementira interfejs 
			'Comparable<Tacka>' (jer zelimo da poredimo instance klase 
			Tacka). Metoda 'compareTo' sadrzi logiku za poredjenje tacaka.
			Nakon sto je definisan nacin za poredjenje tacaka, moguce ih je 
			sortirati primenom kolekcijske funkcije 'sort'. Kada se ta
			funkcija pozove, ona za poredjenje tacaka koristi predefinisan
			metod 'compareTo'. Rezultat je sortirana kolekcija elemenata. 
			Funkcija sort() sortira elemente "u mestu", tj. sortiranje
			elemenata se vrsi bez koriscenja dodatnog niza. 
			Zato je povratna vrednost ove funkcije tipa void.
		*/
		Collections.sort(tacke);
		System.out.println(tacke);
		
		/*
		 	Binarna pretraga, zahteva da znamo da poredimo
		 	elemente u kolekciji (metod 'compareTo').
			Funkcija binarySearch kao rezultat vraca indeks pronadjenog
			elementa, ili vrednost manju od 0 ukoliko element nije nadjen.
		*/
		Tacka t = new Tacka(5, 1);
		int k = Collections.binarySearch(tacke, t);
		if (k >= 0)
			System.out.println("Pronadjena je tacka " + tacke.get(k) + " na indeksu " + k);
		else
			System.out.println("Ne postoji tacka " + t);
	}
}
