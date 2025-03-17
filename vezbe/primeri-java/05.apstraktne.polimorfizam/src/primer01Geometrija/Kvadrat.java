package primer01Geometrija;

// Nasledjujemo klasu Pravougaonik koja je vec nasledila apstraktnu klasu Oblik
// i vec implementirala apstraktne metode getObim i getPovrsina.
// Kvadrat ce samo "iskoristiti" tu klasu kao i u 4. casu nasledjivanja
// postavljajuci odgovarajuce parametre za konstruktor.
public class Kvadrat extends Pravougaonik {
	public Kvadrat(Tacka centar, double dim) {
		super(centar, dim, dim);
	}

	public double getDimenzijaStranice() {
		return getSirina();
	}
	
	@Override
	public String toString() {
		return "Kvadrat{centar = " + getCentar() + " a = " + getSirina() + "}";
	}
}
