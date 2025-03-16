package primer02Izraz;

// Klasa Sabiranje kao binarna operacija nasledjuje
// odgovarajucu klasu i implementirace metodu izracunaj() iz klase Izraz.
public class Sabiranje extends BinarnaOperacija {
	
	public Sabiranje(Izraz levi, Izraz desni) {
		super(levi, /*NMDD*/ desni);
	}

	// Metoda izracunaj ovde predstavlja zbir izracunavanja levog i desnog izraza
	@Override
	public double izracunaj() {
		return getLevi().izracunaj() + getDesni().izracunaj();
	}
	
	@Override
	public String toString() {
		return getLevi().toString() + " + " + getDesni().toString();
	}
}
