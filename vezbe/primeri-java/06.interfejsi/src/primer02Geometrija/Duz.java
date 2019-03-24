package primer02Geometrija;

// Duz ne implementira interfejse 'Povrsina' i 'Oblik' jer
// zelimo da izbegnemo racunanje povrsine i obima za duz.
public class Duz extends Oblik {
	private Tacka a, b;

	public Duz(Tacka a, Tacka b) {
		// Izracunavamo sredisnju tacku (centar oblika)
		super(new Tacka((a.getX()+b.getX())/2, (a.getY()+a.getY())/2));
		this.a = a;
		this.b = b;
	}
	
	public Tacka getA() {
		return a;
	}

	public Tacka getB() {
		return b;
	}
	
	@Override
	public String toString() {
		return "Duz";
	}
}
