package primer02_nasledjivanje;

public class Oblik {
	// Polje oznacavamo kao protected kako bi mogli da mu pristupimo
	// iz podklasa (klase Pravougaonik, Elipsa i Trougao).
	protected Tacka centar;

	public Oblik(Tacka c) {
		// Pravimo kopiju prosleđene tačke umesto da koristimo istu referencu.
		// Time osiguravamo da promene originalne tačke ne utiču na centar oblika.
		
		// Pozivamo konstruktor kopije za tacku.
		centar = new Tacka(c);
	}

	/// Konstruktor kopije.
	public Oblik(Oblik o) {
		// Mozemo delegirati odgovornost vec implementiranom konstruktoru.
		this(o.centar);
	}

	public Oblik(double x, double y) {
		centar = new Tacka(x, y);
	}

	public Oblik() {
		centar = new Tacka();
	}

	public Tacka getCentar() {
		return centar;
	}

	public String toString() {
		return "Oblik centar = " + centar.toString();
	}
}
