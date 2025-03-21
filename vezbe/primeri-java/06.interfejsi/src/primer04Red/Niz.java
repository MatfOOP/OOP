package primer04Red;

public class Niz implements Red {
	private int kapacitet = 1025;
	private int[] xs = new int[kapacitet];
	private int pocetak, kraj, brElemenata;
	
	// Ne navodimo konstruktor, dovoljan nam je podrazumevani.

	@Override
	public void add(int x) {
		//ukoliko je red popunjen
		if (brElemenata == kapacitet-1) {
			System.err.println("Queue overflow!");
			return;
		}

		xs[kraj] = x;
		brElemenata++;
		//Umesto pomeranja elemenata u nizu, ovde koristimo moduo operaciju (% kapacitet)
		//da "uvijemo" pokazivače pocetak i kraj, čime optimalno koristimo memoriju i izbegavamo fragmentaciju.
		kraj = (kraj + 1) % kapacitet;
	}

	@Override
	public int remove() {
		//ako je red prazan
		if (brElemenata == 0) {
			System.err.println("Queue underflow!");
			return 0;
		}

		int tmp = xs[pocetak];
		//Umesto pomeranja elemenata u nizu, ovde koristimo moduo operaciju (% kapacitet)
		//da "uvijemo" pokazivače pocetak i kraj, čime optimalno koristimo memoriju i izbegavamo fragmentaciju.
		pocetak = (pocetak + 1) % kapacitet;
		brElemenata--;
		return tmp;
	}

	@Override
	public int head() {
		if (brElemenata == 0) {
			System.err.println("Queue underflow!");
			return 0;
		}
		return xs[pocetak];
	}

	@Override
	public int back() {
		if (brElemenata == 0) {
			System.err.println("Queue underflow!");
			return 0;
		}
		if (kraj == 0)
			return xs[kapacitet-1];
		else
			return xs[kraj-1];
	}

	@Override
	public void prikaziRed() {
		System.out.print("[ ");
		
		int i = pocetak;
		while (i != kraj) {
			System.out.print(xs[i] + " ");
			i = (i + 1) % kapacitet;
		}
		
		System.out.println("]");
	}

	@Override
	public int size() {
		return brElemenata;
	}
}
