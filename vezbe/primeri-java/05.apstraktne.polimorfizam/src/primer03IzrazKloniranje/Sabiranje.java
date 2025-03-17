package primer03IzrazKloniranje;

// Klasa Sabiranje kao binarna operacija nasledjuje
// odgovarajucu klasu i implementirace metode izracunaj() i klon() iz klase Izraz.
public class Sabiranje extends BinarnaOperacija {
	
	public Sabiranje(Izraz levi, Izraz desni) {
		super(levi, /*NMDD*/ desni);
	}
	
	public Sabiranje(Sabiranje s) {
		// Ne vrsimo kloniranje operanada sabiranje vec
		// reference prosledjujemo nadklasi.
		// Klasa BinarnaOperacija
		// ciji konstruktor pozivamo, poziva kloniranje prosledjenih izraza.
		super(s.getLevi(), s.getDesni());
	}

	// Oslanjamo se na konstruktor kopije, jednostavnija je logika
	@Override
	public Izraz klon() {
		return new Sabiranje(this);
	}

	// Metoda izracunaj ovde predstavlja proizvod izracunavanja levog i desnog izraza
	@Override
	public double izracunaj() {
		return getLevi().izracunaj() + getDesni().izracunaj();
	}
	
	@Override
	public String toString() {
		return getLevi().toString() + " + " + getDesni().toString();
	}
}
