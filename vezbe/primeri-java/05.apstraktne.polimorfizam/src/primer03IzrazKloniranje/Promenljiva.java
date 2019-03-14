package primer03IzrazKloniranje;

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
	
	@Override
	public double izracunaj() {
		return vrednost;
	}
	
	@Override
	public String toString() {
		return ime;
	}
}









