package primer02_nasledjivanje;

public class Oblik {
	// Polje oznacavamo kao protected kako bi mogli da mu pristupimo
	// iz podklasa (klase Pravougaonik, Elipsa i Trougao).
	protected Tacka centar;

	// Konstruktor Oblika koji kreira oblik sa istim centrom kao tacka c.
	public Oblik(Tacka c) {
		// Pravimo kopiju prosleđene tačke umesto da koristimo istu referencu.
		// Time osiguravamo da promene originalne tačke ne utiču na centar oblika.
		
		// Pozivamo konstruktor kopije za tacku.
		centar = new Tacka(c);
	}

	/// Konstruktor kopije
	public Oblik(Oblik o) {
		// Mozemo delegirati odgovornost vec implementiranom konstruktoru.
		this(o.centar);
	}

	// Konstruktor Oblika koji postavlja centar na osnovu koordinata x i y.
	public Oblik(double x, double y) {
		centar = new Tacka(x, y);
	}

	// Konstruktor Oblika bez zadatih argumenata koji ce kreirati oblik sa centrom u koordinatnom pocetku
	public Oblik() {
		centar = new Tacka();
	}

	public Tacka getCentar() {
		return centar;
	}

	// Primetimo da je toString() metoda overrideovana i da ce se ova implementacija
	// koristiti umesto one iz nadklase. U ovom slucaju natklasa je klasa Object iz Jave.
	public String toString() {
		return "Oblik centar = " + centar.toString();
	}
}
