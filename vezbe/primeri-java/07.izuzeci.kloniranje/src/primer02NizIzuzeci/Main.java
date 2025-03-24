package primer02NizIzuzeci;

public class Main {

	public static void main(String[] args) {
		int[] tmp = {1, 2, 3, 4};
		Niz niz = new Niz(tmp);
		
		System.out.println("niz[2] = " + niz.get(2));
		

		// Jedna od najcescih gresaka pri radu sa nizovima jeste
		// pokusaj pristupa elementu van granica niza, te bi bilo
		// pozeljno na vreme uociti gresku ako postoji.
		try {
			System.out.println("niz[100] = " + niz.get(100));
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println(e.getMessage());
			
			// Mozemo dobiti i trag steka (stack trace) koji ukljucuje
			// redosled pozivanja funkcija koje su dovele do ispaljivanja
			// izuzetka, klasu i liniju u kojoj je ispaljen izuzetak i 
			// slicno. Primetimo da ukoliko ne uhvatimo izuzetak, 
			// Java program upravo prikazuje stackTrace i prestaje 
			// sa izvrsavanjem.
			e.printStackTrace();
		}
	}

}