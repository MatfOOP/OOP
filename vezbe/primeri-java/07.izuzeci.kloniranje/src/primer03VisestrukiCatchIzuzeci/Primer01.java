package primer03VisestrukiCatchIzuzeci;

public class Primer01 {

	public static void testiranjeIzuzetaka(int x) {
		if (x == 1)
			throw new ArrayIndexOutOfBoundsException("x = 1 :)");
		else if (x == 2)
			throw new ArithmeticException("x = 2 :)");
		else if (x == 3)
			throw new NullPointerException("x = 3 :)");
	}
	
	// Ukoliko kod moze izbaciti vise izuzetaka, moguce je
	// svaki izuzetak hvatati u zasebnom catch bloku.
	// Ova opcija je pozeljna ukoliko razliciti izuzeci 
	// zahtevaju razlicit odgovor na njih. 
	public static void main(String[] args) {
		try {
			testiranjeIzuzetaka(1);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println(e.getMessage());
		} catch (ArithmeticException e) {
			System.err.println(e.getMessage());
		} catch (NullPointerException e) {
			System.err.println(e.getMessage());
		}
		
		// Sa druge strane, ukoliko je obrada svih izuzetaka ista, nema potrebe 
		// za visestrukim catch blokovima, dovoljno je sve moguce izuzetke 
		// navesti u jednom catch bloku razdvojene uspravnom crtom 
		// (od java7 standarda).
		try {
			testiranjeIzuzetaka(1);
		} catch (ArrayIndexOutOfBoundsException | ArithmeticException | NullPointerException e) {
			System.err.println(e.getMessage());
		}
	}

}
