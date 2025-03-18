package primer02Izraz;

// Klasa Mnozenje kao binarna operacija nasledjuje
// odgovarajucu klasu i implementirace metodu izracunaj() iz klase Izraz.
public class Mnozenje extends BinarnaOperacija {

	public Mnozenje(Izraz levi, Izraz desni) {
		super(levi, desni);
	}

	// Metoda izracunaj ovde predstavlja proizvod izracunavanja levog i desnog izraza
	@Override
	public double izracunaj() {
		// Ovde vidimo da postoji mogucnost ulancavanje metoda
		return getLevi().izracunaj() * getDesni().izracunaj();
	}
	
	@Override
	public String toString() {
		return getLevi().toString() + " * " + getDesni().toString();
	}
}
