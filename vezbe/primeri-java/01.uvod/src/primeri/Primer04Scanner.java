package primeri;

// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
// Program prikazuje kako koriscenjem klase 'Scanner' mozemo
// citati sa standardnog ulaza.
// U jeziku C smo to radili koristeci funkciju 'scanf'.
//
// Potrebno kako bismo mogli da koristimo Scanner.
// Ovo je slicno konstrukciji:
// #include <stdio.h>
// u programskom jeziku C.
// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
import java.util.Scanner;

public class Primer04Scanner {

	public static void main(String[] args) {
		// ------------------------------------------------------------------------------
		// Pravimo promenljivu 'sc' tipa 'Scanner'.
		Scanner sc;
		// Dodeljujemo joj vrednost.
		// NAPOMENA: new Scanner(System.in) ce biti objasnjen nesto kasnije.
		// UKRATKO: Pravi scanner koji ce citati sa standardnog ulaza.
		sc = new Scanner(System.in);
		// ------------------------------------------------------------------------------
		
		// ------------------------------------------------------------------------------
		// Slede primeri kako mozemo citati sa standardnog ulaza.
		// ------------------------------------------------------------------------------
		System.out.println("Unesite ceo broj:");
		int x = sc.nextInt(); //Ukoliko ocekujemo Int na ulazu
		System.out.println("Uneli ste broj: " + x);
		
		System.out.println("Unesite realan broj:");
		double y = sc.nextDouble(); //Ukoliko ocekujemo Double na ulazu
		System.out.println("Uneli ste broj: " + y);
		
		System.out.println("Unesite rec:");
		String word = sc.next(); //Cita bilo koji sledeci token sa ulaza
		System.out.println("Uneta je rec: " + word);


		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Scanner nema metod koji ucitava karakter tako da se mozemo dovijati
		// koristeci metod 'next' koji vraca ucitanu rec, a onda od nje
		// mozemo izdvojiti nulti karakter.
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

		System.out.println("Unesite 1 karakter:");
		String tmp = sc.next();
		char z = tmp.charAt(0);
		System.out.println("Unet je karakter: " + z);
		
		// ------------------------------------------------------------------------------
		// Zatvaramo scanner (slicno zatvaranju datoteke u C-u)
		// ------------------------------------------------------------------------------
		sc.close();
	}

}
