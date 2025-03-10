package b_matrice;

import java.util.Arrays;
import java.util.Scanner;

public class Primer01_Matrica {

	/**
	 * Matrice su realizovane kao niz nizova.
	 */
	public static void main(String[] args) {
		int[][] a = {
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9}
		};

		// a[0] je niz {1, 2, 3}, tj. prva vrsta matrice
		// a[0][0] je prvi element prve vrste matrice, tj. 1
		
		System.out.println("ispisi1(a):");
		ispisi1(a);
		
		System.out.println("\nispis2(a):");
		ispisi2(a);
		
		System.out.println("\nispis3(a):");
		ispisi3(a);
		
	}

	static void ispisi1(int[][] a) {
		// a.length -> broj vrsti
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) 		// a[i] -> niz, a[i].length -> duzina niza, tj. broj kolona matrice kod nas
				System.out.printf("%d ", a[i][j]);
			System.out.println();
		}
	}

	static void ispisi2(int[][] a) {
		// Imamo niz nizova, tako da su elementi niza nizovi.
		// Iteracija kroz ovakvu strukturu nam daje NIZOVE kroz koje potom  iteriramo.
		for (int[] tmp: a) {
			for (int e: tmp)
				System.out.print(e + " ");
			System.out.println();
		}

		//detaljnije objasnjenje: 
		//elementi matrice a su 3 niza : {1, 2, 3} , {4, 5, 6}, {7, 8, 9}, 
		//tako da kada hocemo da prodjemo kroz matricu, u spoljnoj petlji prolazimo kroz te nizove
		//pa je zato tmp tipa int[], 
		//a u unutrasnjoj petlji prolazimo kroz svaki element pojedinacnog niza, te je e tipa int
	}

	static void ispisi3(int[][] a) {
		//Na ovaj nacin mozemo ugradjenom metodom da ispisemo elemente matrice, probajte
		//sta bi se desilo kada bismo ispisivali samo a, ili samo Arrays.toString(a)
		System.out.println(Arrays.deepToString(a));
	}
}
