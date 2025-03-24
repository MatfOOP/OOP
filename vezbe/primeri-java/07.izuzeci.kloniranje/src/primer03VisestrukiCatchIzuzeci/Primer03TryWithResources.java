package primer03VisestrukiCatchIzuzeci;

import java.util.Scanner;

public class Primer03TryWithResources {
	public static void main(String[] args) {
		// Mozemo koristiti konstrukciju 'try-with-resources'
		// koja omogucava da se "resurs" koji koristimo (npr. Scanner)
		// sam zatvori nakon izvrsavanja bloka koda.
		// 
		// Ovakva ideja da se automatski oslobadja resurs
		// (ili nesto slicno) postoji i u drugim jezicima.
		// C++: RAII - Resource Acquisition Is Initialization
		// C#: Naredba 'using'
		// Python: Naredba 'with'
		
		
		// Primetimo da nema catch bloka, nije neophodan kada
		// se Scanner vezuje za standardni ulaz.
		// Ukoliko bismo zeleli da u okviru istog try bloka otvorimo
		// vise resursa, to bismo mogli da uradimo pisanjem niza komandi
		// jednu za drugom razdvojene sa ;
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println(sc.nextLine());
		}
		
		// Nakon izvrsavanja try bloka, poziva se metod 'close()' nad
		// Scanner objektom (programer nije duzan da sam poziva).
		// Poziva se close cak iako je izbacen izuzetak, tako da je ova
		// konstrukcija analogna onoj oblika:
		// try {
		// 	...
		// 	...
		// } catch (...) {
		// 	...
		// 	...
		// } catch (...) {
		// 	...
		// 	...
		// } finally {
		// 	sc.close();
		// }
	}
}