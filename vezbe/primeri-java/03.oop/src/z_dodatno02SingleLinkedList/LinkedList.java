package z_dodatno02SingleLinkedList;

public class LinkedList {
	// Zelimo da napravimo klasu koja ce imitirati jednostruko
	// povezanu listu. Elementi liste bice cvorovi koji ce cuvati
	// vrednost i pokazivac na sledeci element u listi
	
	// Kao polja liste cuvaju se informacije o pocetku(korenu) liste 
	// i njenoj velicini
	private Node root;
	private int size;
	
	public LinkedList() {
		// Na samom pocetku, lista nema elemenata, pa nema
		// ni koren, te ga stoga postavljamo na null. Iz
		// istog razloga, velicinu liste postavljamo na 0
		root = null;
		size = 0;
	}
	
	// Ubacujemo vrednost u listu tako sto napravimo novi
	// cvor koji ce sadrzati tu vrednost i povezemo ga sa 
	// dosadasnjom listom preko setNext() metoda. Zatim 
	// azuriramo koren(glavu) liste na upravo dodati cvor
	// i na kraju uvecamo brojac elemenata. 
	public void insert(int n) {
		Node tmp = new Node(n);
		tmp.setNext(root);
		root = tmp;
		size++;
	}
	
	// Vracamo vrednost koja se nalazi u i-tom cvoru liste
	public int get(int i) {
		// Provera validnosti indeksa
		if (i < 0 || i >= size) {
			System.out.println("Lose indeksiranje!");
			return 0;
		} 

		// Ukoliko je indeks validan, pratimo pokazivace
		// dok ne dodjemo do i-tog elementa i na kraju vracamo
		// vrednost koja se u tom cvoru nalazi.
		Node iter = root;
		while (i > 0) {
			i--;
			iter = iter.getNext();
		}
		return iter.getData();
	}
	
	// Vracamo glavu liste
	public Node getHead() {
		return root;
	}
	
	// Vracamo velicinu liste
	public int getSize() {
		return size;
	}
}
