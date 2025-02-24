package a_nizovi;

import java.util.Scanner;

public class Primer01 {

	/**
	 * Primer prikazuje pravljenje niza duzine n, unos elemenata
	 * i njihov ispis.
	 */
	public static void main(String[] args) {
		// Kada Scanner vezujemo na standardni ulaz,
		// necemo ga zatvarati (jer ce to zatvarati standardni ulaz,
		// tako da nas program ne moze da ga koristi na dalje).
		// Eventualno, mozemo ga zatvoriti na samom kraju programa
		// kada smo sigurni da nam vise nece trebati standardni ulaz.
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Unesite duzinu niza:");
		int n = sc.nextInt();
		
		// Pravimo niz duzine n
		int[] a = new int[n];
		
		System.out.println("Unesite " + n + " brojeva:");
		for (int i = 0; i < n;  i++)
			a[i] = sc.nextInt();

		System.out.println("Uneti brojevi (for petlja):");
		for (int i = 0; i < n;  i++)
			System.out.print(a[i] + " ");

        	System.out.println();

		// For-each petlja služi za jednostavno iteriranje kroz nizove i kolekcije.
		// Umesto klasične for petlje sa indeksima, prolazi kroz svaki element direktno.
		// Sintaksa: for (tip_promenljive ime_promenljive : kolekcija) { ... }  
		// Promenljiva unutar petlje predstavlja trenutni element iz kolekcije.
		// npr. imamo niz {1, 5, 6} ; u prvoj iteraciji foreach petlje, u promenljivoj e se nalazi 1,
		// u drugoj iteraciji se u promenljivoj e nalazi 5, a u trecoj 6; I ako bismo menjali e, 
		// originalni element se ne menja, npr. ako uradimo e++, niz na kraju isto ostaje 1, 5, 6
		System.out.println("Uneti brojevi (foreach petlja):");
		for (int e: a)
			System.out.print(e + " ");
		
		// NE ZATVARAMO SCANNER
		// sc.close();
	}

}
