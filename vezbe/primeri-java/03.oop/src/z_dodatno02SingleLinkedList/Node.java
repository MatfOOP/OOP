package z_dodatno02SingleLinkedList;

public class Node {
	// Svaki cvor jednostruko povazane liste cuvace
	// pokazivac na sledeci cvor, kao i vrednost
	// koju trenutni cvor sadrzi. Poslednji cvor liste
	// nema svog sledbenika, a ni vrednost, pa cemo mu
	// dodeliti nedostajucu vrednost. To ce nam ujedno pomoci 
	// i pri iteraciji kroz listu, tj. stigli smo do kraja onog 
	// trenutka kada cvor postane null.
	
	private Node next;
	private int data;
	
	public Node(int n) {
		data = n;
		// posto je upravo dodati cvor ujedno i poslednji koji
		// je dodat, on nema svog sledbenika, te sledeci cvor
		// u listi postavljamo na null
		next = null;
	}
	
	// Vracamo vrednost koju cvor cuva
	public int getData() {
		return data;
	}
	
	// Provera da li postoji sledeci cvor ili smo stigli do kraja
	public boolean hasNext() {
		if (next == null)
			return false;
		else
			return true;
	}
	
	// Vracamo sledeci cvor
	public Node getNext() {
		return next;
	}
	
	// Postavljamo sledeci cvor
	public void setNext(Node n) {
		next = n;
	}
	
	public String toString() {
		return "" + data;
	}
}
