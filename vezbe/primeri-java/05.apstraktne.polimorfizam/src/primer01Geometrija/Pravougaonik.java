package primer01Geometrija;

// Nasledjujemo klasu Oblik i kako je ta klasa apstraktna
// moramo implementirati logiku metoda getObim i getPovrsina.
public class Pravougaonik extends Oblik {
	private double sirina, visina;

	public Pravougaonik(Tacka centar, double sirina, double visina) {
		super(centar);
		this.sirina = sirina;
		this.visina = visina;
	}

	// Implementacija logike apstraktne metode getObim
	@Override
	public double getObim() {
		return 2*sirina + 2*visina;
	}

	// Implementacija logike apstraktne metode getPovrsina
	@Override
	public double getPovrsina() {
		return sirina * visina;
	}

	public double getSirina() {
		return sirina;
	}

	public double getVisina() {
		return visina;
	}

	@Override
	public String toString() {
		return "Pravougaonik{centar = " + getCentar() + " sirina = " + sirina + " visina = " + visina + "}";
	}
}
