package primer02_nasledjivanje;

public class Trougao extends Oblik {
	private Tacka a, b, c;

	// Konstruktor Trougla - kreira Trougao sa centrom centar i temenima a,b,c
	public Trougao(Tacka centar, Tacka a, Tacka b, Tacka c) {
		super(centar);
		init(a, b, c);
	}

	// Konstuktor Trougla - kreira Trougao na osovu tacaka a,b,c i postavlja centar na podrazumevanu vrednost.
	public Trougao(Tacka a, Tacka b, Tacka c) {
		// Umesto this(new Tacka(0, 0), a, b, c) bolje je navedeno
		// jer instanciramo jednu tacku manje (new Tacka(0, 0)) bi bio
		// privremeni objekat koji se prosledjuje konstruktoru nadklase,
		// a konstruktor nadklase pravi sopstvenu kopiju od privremenog objekta.
		// Java kompilator bi ovo trebalo da optimizuje, ali svejedno je lepo primetiti.
		super();
		init(a, b, c);
	}

	// Konstruktor Trougla - kreira Trougao sa zadatim centrom c i koordinatama temena - a1,a2 za a; b1,b2 za b; c1,c2 za c
	public Trougao(Tacka centar, double a1, double a2, double b1, double b2, double c1, double c2) {
		super(centar);
		init(a1, a2, b1, b2, c1, c2);
	}

	// Konstruktor Trougla - kreira Trougao sa koordinatama temena - a1,a2 za a; b1,b2 za b; c1,c2 za c
	// i postavlja centar na podrazumevanu vrednost (0,0)
	public Trougao(double a1, double a2, double b1, double b2, double c1, double c2) {
		this(0, 0, a1, a2, b1, b2, c1, c2);
	}

	// Konstruktor Trougla - kreira Trougao sa zadatim koordinatam centra - x1 i x2 i koordinatama temena - a1,a2 za a; b1,b2 za b; c1,c2 za c
	public Trougao(double x1, double x2, double a1, double a2, double b1, double b2, double c1, double c2) {
		super(x1, x2);
		init(a1, a2, b1, b2, c1, c2);
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
	
	public double getAB() {
		return a.distance(b);
	}
	
	public double getBC() {
		return b.distance(c);
	}
	
	public double getCA() {
		return c.distance(a);
	}

	// Pomocna metoda koja postavlja temena trougla na osnovu njihovih koordinata
	// Ova logika se ponavlja kroz klasu, pa smo je postavili kao metodu zbog citljivosti i manje mogucnosti greske
	private void init(double a1, double a2, double b1, double b2, double c1, double c2) {
		this.a = new Tacka(a1, a2);
		this.b = new Tacka(b1, b2);
		this.c = new Tacka(c1, c2);
	}

	// Pomocna metoda koja postavlja temena trougla
	// Ova logika se ponavlja kroz klasu, pa smo je postavili kao metodu zbog citljivosti i manje mogucnosti greske
	private void init(Tacka a, Tacka b, Tacka c) {
		this.a = new Tacka(a);
		this.b = new Tacka(b);
		this.c = new Tacka(c);
	}

	// Primetimo da je toString() metoda overrideovana i da ce se ova implementacija
	// koristiti umesto one iz nadklase.
	@Override
	public String toString() {
		return "Trougao a = " + a + " b = " + b + " c = " + c;
	}
}
