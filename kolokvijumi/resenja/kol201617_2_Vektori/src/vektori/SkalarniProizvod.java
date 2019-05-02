package vektori;

public class SkalarniProizvod extends VektorOperacija {

	private Vektor v1, v2;
	
	public SkalarniProizvod(Vektor v1, Vektor v2) {
		this.v1 = new Vektor(v1);
		this.v2 = new Vektor(v2);
	}

	public Vektor getV1() {
		return v1;
	}
	
	public Vektor getV2() {
		return v2;
	}
	
	@Override
	public double izracunaj() {
		return v1.getX() * v2.getX() + v1.getY() * v2.getY() + v1.getZ() * v2.getZ();
	}
	
	public String toString(){
		return v1 + " . " + v2 + " = " + this.izracunaj();
	}

}
