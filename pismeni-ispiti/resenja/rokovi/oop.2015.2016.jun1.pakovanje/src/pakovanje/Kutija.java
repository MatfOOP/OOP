package pakovanje;

public class Kutija extends Paket {
	private double a, b, c;

	public Kutija(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public double zapremina() {
		return a * b * c;
	}

	public double povrsina() {
		return 2 * (a * b + a * c + b * c);
	}

	public char vrsta() {
		return 'K';
	}

	public String toString() {
		return super.toString() + '(' + a + ',' + b + ',' + c + ')' + ", V = " + String.format( "%.2f", zapremina() );
	}
}
