package primer03IzrazKloniranje;

// Klasa Mnozenje kao binarna operacija nasledjuje
// odgovarajucu klasu i implementirace metode izracunaj() i klon() iz klase Izraz.
public class Mnozenje extends BinarnaOperacija {

	public Mnozenje(Izraz levi, Izraz desni) {
		super(levi, desni);
	}
	
	public Mnozenje(Mnozenje m) {
		super(m.getLevi(), m.getDesni());
	}

	// Oslanjamo se na konstruktor kopije, jednostavnija je logika
	@Override
	public Izraz klon() {
		return new Mnozenje(this);
	}

	// Metoda izracunaj ovde predstavlja proizvod izracunavanja levog i desnog izraza
	@Override
	public double izracunaj() {
		return getLevi().izracunaj() * getDesni().izracunaj();
	}
	
	@Override
	public String toString() {
		return getLevi().toString() + " * " + getDesni().toString();
	}
}
