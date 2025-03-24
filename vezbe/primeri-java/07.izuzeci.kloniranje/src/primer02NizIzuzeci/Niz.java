package primer02NizIzuzeci;

public class Niz {
	private int[] a;
	
	public Niz(int n) {
		a = new int[n];
	}
	
	public Niz(int[] tmp) {
		a = new int[tmp.length];
		for (int i = 0; i < tmp.length; i++)
			a[i] = tmp[i];
	}
	
	public int length() {
		return a.length;
	}
	
	public int get(int i) {
		// Java nudi i mogucnost "ispaljivanja" izuzetka od
		// strane programera. Zasto je "ispaljivanje" izuzetaka korisno?
		// Na primer, ukoliko je potrebno da korisnik u neku anketu unese 
		// koliko ima godina, znamo da taj broj ne moze biti manji od 0
		// ali ni veci od 100 (u najvecem broju slucajeva). Recimo da 
		// korisnik unese da ima 200 godina. Ni kompajler ni JVM ne bi 
		// prepoznali da se radi o gresci. Stoga je korisno imati
		// mogucnost "ispaljivanja" izuzetaka.  
		// Primer kako mozemo da "ispalimo" izuzetak kada
		// detektujemo odredjenu gresku u nasem kodu.
		if (i < 0 || i >= a.length)
			// throw new ArrayIndexOutOfBoundsException();
			// Ukoliko navedemo String u konstruktoru, taj string se
			// vraca kada se nad izuzetkom pozove metod 'getMessage'.
			throw new ArrayIndexOutOfBoundsException("Lose indeksiranje!");
			// Ispaljivanje ovog izuzetka prekida izvrsavanje funkcije.
		return a[i];
	}
	
	@Override
	public String toString() {
		return java.util.Arrays.toString(a);
	}
	
}

