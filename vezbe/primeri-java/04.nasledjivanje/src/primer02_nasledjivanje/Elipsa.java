package primer02_nasledjivanje;

public class Elipsa extends Oblik {
	// Polja oznacavamo kao protected kako bi im mogli
	// DIREKTNO pristupiti iz podklase (klase Krug).
	protected double /* poluosa 1 */ a, /* poluosa 2 */ b;

	// Konstruktor Elipse koji kreira novu elipsu na osnovu tacke centra c i vrednosti duzina poluosa, a i b
	public Elipsa(Tacka centar, double a, double b) {
		// Potrebno je da pozovemo konstruktor nadklase (UVEK PRI NASLEDJIVANJU)
		// tako sto koristimo sintaksu slicnu this(...) osim sto koristimo super.
		// Super je u stvari referenca na nadklasu (u ovom slucaju Oblik).
		
		// Poziva konstruktor Oblik(Tacka c)
		super(centar);
		
		// Koristimo privatnu funkciju 'init' koja inicijalizuje poluose elipse
		// kako bi smanjili visestruko ponavljanje iste logike.
		init(a, b);
	}

	// Konstruktor Elipse koji kreira elipsu na osnovu koordinata centra x i y, i vrednosti duzina poluosa, a i b
	public Elipsa(double x, double y, double a, double b) {
		// Poziva konstruktor Oblik(double x, double y)
		super(x, y);
		init(a, b);
	}

	// Konstruktor Elipse koji kreira Elipsu samo na osnovu poluosa i postavlja centar na podrazumevanu vrednost - (0,0)
	public Elipsa(double a, double b) {
		// Poziva konstruktor Oblik()
		super();
		init(a, b);
	}

	/// Konstruktor kopije - kreira Elipsu sa istim vrednostima centra i duzina poluosa kao Elipsa u parametru
	public Elipsa(Elipsa p) {
		// Poziva konstruktor Oblik(Tacka c)
		super(p.centar);
		init(p.a, p.b);
	}

	// Pomocna metoda koja postavlja vrednosti duzina poluosa.
	// Ova logika se ponavlja kroz klasu, pa smo je postavili kao metodu zbog citljivosti i manje mogucnosti greske
	private void init(double a, double b) {
		this.a = a;
		this.b = b;
	}

	public double getA() {
		return a;
	}

	public double getB() {
		return b;
	}

	// Primetimo da je toString() metoda overrideovana i da ce se ova implementacija
	// koristiti umesto one iz nadklase.
	// Probajte i da zakomentarisete toString() ispod i da vidite sta ce tada biti ispis.
	public String toString() {
		return "Elipsa a = " + a + " b = " + b;
	}
}