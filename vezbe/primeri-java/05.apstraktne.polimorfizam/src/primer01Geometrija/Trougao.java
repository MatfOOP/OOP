package primer01Geometrija;

// Nasledjujemo klasu Oblik i kako je ta klasa apstraktna
// moramo implementirati logiku metoda getObim i getPovrsina.
public class Trougao extends Oblik {
	private Tacka a, b, c;

	public Trougao(Tacka centar, Tacka a, Tacka b, Tacka c) {
		super(centar);
		init(a, b, c);
	}

	public Trougao(Tacka a, Tacka b, Tacka c) {
		super();
		init(a, b, c);
	}

	// Pomocna funkcija koja inicijalizuje tacke trougla
	private void init(Tacka a, Tacka b, Tacka c) {
		this.a = new Tacka(a);
		this.b = new Tacka(b);
		this.c = new Tacka(c);
	}

	public Tacka getA() {
		return a;
	}

	public Tacka getB() {
		return b;
	}

	public Tacka getC() {
		return c;
	}

	/// Vraca duzinu stranice AB
	public double getAB() {
		return a.distance(b);
	}

	/// Vraca duzinu stranice BC
	public double getBC() {
		return b.distance(c);
	}

	/// Vraca duzinu stranice CA
	public double getCA() {
		return c.distance(a);
	}

	// Implementacija logike apstraktne metode getObim
	@Override
	public double getObim() {
		return getAB() + getBC() + getCA();
	}

	// Implementacija logike apstraktne metode getPovrsina
	@Override
	public double getPovrsina() {
		double o = getObim()/2;
		return Math.sqrt(o * (o - getAB()) * (o - getBC()) * (o - getCA()));
	}

	@Override
	public String toString() {
		return "Trougao{centar = " + getCentar() + " A = " + a + " B = " + b + " C = " + c + "}";
	}
}
