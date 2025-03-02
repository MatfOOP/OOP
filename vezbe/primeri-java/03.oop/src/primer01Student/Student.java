package primer01Student;

public class Student {
	// Polja koja opisuju stanje nase klase.
	private String ime, prezime, indeks;
	private double prosek;
	// Modifikator pristupa private govori da su navedeni atributi/metodi 
	// vidljivi samo ostalim clanovima ove klase i da im se ne moze pristupiti
	// iz "spoljnog sveta" (npr. iz Main klase ili nekog drugog paketa).
	// Sa druge strane, modifikator public (sa kojim smo se sretali do sad)
	// oznacava da je atribut/metod vidljiv iz bilo kog drugog paketa ili klase.
	
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
	// Konstruktor - funkcija koja se poziva pri
	// pravljenju objekta. Ona nema povratnu vrednost i mora 
	// nositi isto ime kao i klasa.

	// Svaka klasa MORA imati BAR 1 konstruktor. Ukoliko programeri ne napisu
	// eksplicitno konstruktor, implicitno se poziva PODRAZUMEVANI konstruktor (on nema
	// argumenata i on postavlja polja klase na podrazumevane vrednosti). 
	// Ukoliko programer definise svoj konstruktor 
	// onda podrazumevani konstruktor prestaje da postoji.
	//
	//
	// this - referenca na objekat u kojem se trenutno nalazimo
	// U konstruktoru cesto koristimo kako bi razresili koliziju imena
	// 	kada konstruktor prima argument koji se zove isto kao neko od polja.
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
	public Student(String ime, String prezime, String indeks, double prosek) {
		this.ime = ime;
		this.prezime = prezime;
		this.indeks = indeks;
		this.prosek = prosek;
	}

	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
	// "GETERI" - Funkcije koje vracaju korisniku nase klase deo trenutnog
	// 				stanja objekta.
	// Ne mora da znaci da svako polje TREBA da ima svoj geter. Konkretan geter
	// pravimo onda kada procenimo da ce nam neka vrednost biti potrebna.
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
	public String getIme() {
		return ime;
	}
	
	public String getPrezime() {
		return prezime;
	}
	
	public String getIndeks() {
		return indeks;
	}
	
	public int getGodinaUpisa() {
		String tmp = "20" + indeks.charAt(2) + indeks.charAt(3);
		// Klasa 'Integer' sadrzi staticki metod 'parseInt' koji moze da
		// konvertuje objekat klase String u primitivni tip 'int'
		return Integer.parseInt(tmp);
	}
	
	public int getBrojIndeksa() {
		String tmp = "" + indeks.charAt(4) + indeks.charAt(5) + indeks.charAt(6);
		return Integer.parseInt(tmp);
	}

	public String getSmer() {
		char studije = indeks.charAt(0);
		char smer = indeks.charAt(1);
		if (studije == 'm')
			switch (smer) {
				case 'm': return "Teorijska matematika";
				case 'n': return "Primenjena matematika";
				case 'v': return "Statistika i aktuarska i finansijska matematika";
				case 'l': return "Profesor matematike i racunarstva";
				case 'r': return "Racunarstvo i informatika";
				case 'i': return "Informatika";
				default:  return "Nepoznat smer...";
			}
		else if (studije == 'a' && smer == 'f')
			return "Astrofizika";
		else if (studije == 'a' && smer == 'i')
			return "Astroinformatika";
		else
			return "Nepoznat smer...";
	}

	public double getProsek() {
		return prosek;
	}

	
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
	// "SETERI" - Funkcije koje sluze da promene trenutno stanje objekta.
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
	
	
	public void setIndeks(String indeks) {
		this.indeks = indeks;
	}

	
	public String toString() {
		return ime + " " + prezime + ", " + indeks + ", " + prosek;
	}
}

