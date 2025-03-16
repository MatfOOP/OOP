package primer01Geometrija;

// Nasledjujemo klasu Elipsa koja je vec nasledila apstraktnu klasu Oblik
// i vec implementirala apstraktne metode getObim i getPovrsina.
// Krug ce samo "iskoristiti" tu klasu kao i u 4. casu nasledjivanja
// postavljajuci odgovarajuce parametre za konstruktor.
public class Krug extends Elipsa {

	public Krug(Tacka centar, double r) {
		super(centar, r, r);
	}
	
	public Krug(double r) {
		super(r, r);
	}
	
	public double getR() {
		return getA();
	}
	
	@Override
	public String toString() {
		return "Krug{centar = " + getCentar() + " r = " + getR() + "}";
	}
}
