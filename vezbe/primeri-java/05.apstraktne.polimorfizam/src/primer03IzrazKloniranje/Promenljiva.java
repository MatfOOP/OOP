package primer03IzrazKloniranje;

// Klasa promenljiva nasledjuje apstraktnu klasu izraz
// i za razliku od klase Broj ona ima jos jedno polje
// koje predstavlja ime
public class Promenljiva extends Izraz {
	private String ime;
	private double vrednost;
	
	public Promenljiva(String ime, double vrednost) {
		this.ime = ime;
		this.vrednost = vrednost;
	}
	
	public Promenljiva(Promenljiva p) {
		this.ime = p.ime;
		this.vrednost = p.vrednost;
	}

	// Oslanjamo se na konstruktor kopije, jednostavnija je logika
	@Override
	public Izraz klon() {
		return new Promenljiva(this);
	}
	
	public String getIme() {
		return ime;
	}
	
	public double getVrednost() {
		return vrednost;
	}
	
	public void setVrednost(double vrednost) {
		this.vrednost = vrednost;
	}

	// Logika metode izracunaj je jednostavno vracanje vrednosti promenljive.
	@Override
	public double izracunaj() {
		return vrednost;
	}
	
	@Override
	public String toString() {
		return ime;
	}
}









