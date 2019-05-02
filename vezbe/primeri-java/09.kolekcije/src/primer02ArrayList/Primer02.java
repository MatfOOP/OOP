package primer02ArrayList;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Primer02 {
	public static void main(String[] args) {
		// --------------------------------------------------------------------
		// Kako da inicijalizujemo kolekciju?
		// --------------------------------------------------------------------
		// Staticka funkcija 'asList' vraca 'ArrayList' objekat koji sadrzi
		// prosledjene argumente kao elemente liste.
		List<Integer> xs = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		// --------------------------------------------------------------------
		// Mozemo da promesamo elemente.
		// --------------------------------------------------------------------
		Collections.shuffle(xs);
		System.out.println("Nakon mesanja elemenata:");
		System.out.println(xs + "\n");
		
		// --------------------------------------------------------------------
		// Razmena elemenata.
		// --------------------------------------------------------------------
		int i = 0, j = 5;
		Collections.swap(xs, i, j);
		System.out.println("Razmena elemenata na indeksima " + i + " i " + j);
		System.out.println(xs + "\n");
		
		// --------------------------------------------------------------------
		// Trazenje minimuma i maksimuma.
		// --------------------------------------------------------------------
		Integer maksimum = Collections.max(xs);
		Integer minimum = Collections.min(xs);
		System.out.println("Maksimum: " + maksimum);
		System.out.println("Minimum: " + minimum);
		
		// --------------------------------------------------------------------
		// Rotiranje elemenata za k.
		// --------------------------------------------------------------------
		System.out.println("Nakon rotacije za 3 mesta udesno:");
		Collections.rotate(xs, 3); 		// rotiramo udesno za 3 pozicije
		System.out.println(xs);
		Collections.rotate(xs, -3); 	// rotiramo ulevo za 3 pozicije
		System.out.println("Nakon rotacije za 3 mesta ulevo:");
		System.out.println(xs);
	}
}
