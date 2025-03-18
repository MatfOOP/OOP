package primer02Izraz;

// Broj nasledjuje klasu izraz i implmentira logiku za izracunaj()
public class Broj extends Izraz {
	private double vrednost;
	
	public Broj(double vrednost) {
		this.vrednost = vrednost;
	}
	
	public double getVrednost() {
		return vrednost;
	}

	// Sam broj za izracunaj vraca samo svoju vrednost
	@Override
	public double izracunaj() {
		return vrednost;
	}
	
	@Override
	public String toString() {
		return "" + vrednost;
	}
}
