package primer03Stek;

import java.util.Arrays;

public class Niz implements Stek {
	//niz koji ce predstavljati sam stek
	private int[] elementi;
	private int vrhSteka, kapacitet;

	//ako pravimo stek bez navodjenja kapaciteta, neka pocetni kapacitet bude npr. 10
	public Niz() {
		this(10);
	}

	//ako pravimo stek sa unapred zadatim kapacitetom
	public Niz(int kapacitet) {
		this.kapacitet = kapacitet;
		vrhSteka = 0;
		elementi = new int[kapacitet];
	}

	public int getKapacitet() {
		return kapacitet;
	}

	@Override
	public int pop() {
		//ukoliko nema elemenata u steku
		if (vrhSteka == 0) {
			System.err.println("Stack underflow!");
			return 0;
		}
		
		vrhSteka--;
		return elementi[vrhSteka];
	}

	@Override
	public void push(int x) {
		/*ukoliko je stek pun, dupliramo mu kapacitet, ovim dupliranjem postižemo:
		1. Efikasnost – Dupliranje kapaciteta smanjuje broj
		realokacija memorije u odnosu na linearno povećavanje.
		2. Izbegavanje čestih kopiranja – Ako bismo kapacitet povećavali
		za fiksan broj, često bismo morali da kopiramo niz u novi, veći niz.
		3. Amortizovana složenost – Operacija push ostaje efikasna jer se
		realokacija događa retko (u proseku O(1) složenost).
		-link za vise informacija : https://en.wikipedia.org/wiki/Buddy_memory_allocation
		 */
		if (vrhSteka == kapacitet) {
			kapacitet *= 2;
			elementi = Arrays.copyOf(elementi, kapacitet);
		}

		elementi[vrhSteka] = x;
		vrhSteka++;
	}

	@Override
	public int top() {
		//ukoliko je stek prazan
		if (vrhSteka == 0) {
			System.err.println("Stack underflow!");
			return 0;
		}

		return elementi[vrhSteka-1];
	}
	
	@Override
	public void show() {
		System.out.println("Sadrzaj: [ " + toString() + "]");
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < vrhSteka; i++)
			sb.append(elementi[i]).append(" ");
		return sb.toString();
	}

	@Override
	public int size() {
		return vrhSteka;
	}
}
