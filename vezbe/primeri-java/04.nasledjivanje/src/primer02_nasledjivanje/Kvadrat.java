package primer02_nasledjivanje;

/// Kvadrat je specijalni slucaj pravougaonika, tako da umesto
/// da implementiramo slicnu funkcionalnost na dva mesta,
/// mozemo naslediti klasu Pravougaonik i iskoristiti vec
/// postojece funkcionalnosti uz sitne izmene.
public class Kvadrat extends Pravougaonik {

	// Konstruktor Kvadrata - kreira Kvadrat sa zadatim centrom c i duzinom stranice a
	public Kvadrat(Tacka c, double a) {
		// Poziva se konstruktor Pravougaonik(Tacka c, double sirina, double visina)
		super(c, a, a);
	}

	// Konstruktor Kvadrata - kreira Kvadrat sa zadatim koordinatama centra x i y i duzinom stranice a
	public Kvadrat(double x, double y, double a) {
		// Poziva se konstruktor Pravougaonik(double x, double y, double sirina, double visina)
		super(x, y, a, a);
	}

	// Konstruktor Kvadrata - kreira Kvadrat sa podrazumevanim centrom i duzinom stranice a
	public Kvadrat(double a) {
		// Poziva se konstruktor Pravougaonik(double sirina, double visina)
		super(a, a);
	}

	/// Konstruktor kopije - kreira kvadrat sa istim vrednostima kao zadati kvadrat t
	public Kvadrat(Kvadrat t) {
		// Poziva se konstruktor Pravougaonik(Tacka c, double sirina, double visina)
		super(t.centar, t.sirina, t.sirina);
	}
	
	public double getDimenzija() {
		return this.sirina;
	}

	// Primetimo da je toString() metoda overrideovana i da ce se ova implementacija
	// koristiti umesto one iz nadklase.
	public String toString() {
		return "Kvadrat centar = " + centar + " a = " + sirina;
	}
}
