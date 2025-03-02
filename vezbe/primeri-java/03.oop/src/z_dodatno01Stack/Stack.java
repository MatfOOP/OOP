package z_dodatno01Stack;

public class Stack {

	// Zelimo da implementiramo stek pomocu obicnog niza.
	// Stoga nam je od polja klase potreban sam niz elemenata
	// koji se nalaze na steku, kao i pokazivac na mesto
	// u nizu gde treba ubaciti novi element
	private int[] elements;
	private int headPtr;
	
	public Stack() {
		elements = new int[3];
		headPtr = 0;
	}
	
	private void checkCapacity() {
		// Ako smo popunili ceo niz, alociramo jos prostora 
		// (duplo od prethodne velicine - The reason behind doubling is that it turns repeatedly 
		// appending an element into an amortized O(1) operation. Put another way, appending n elements takes O(n) time.) 

		if (headPtr == elements.length-1) {
			// Debugging purposes
			// System.out.println("Reallocating array from size " + elements.length + " to " + 2*elements.length + "...");

			// Copies elements of given array into a new one, the rest of specified lenght is filled
			// with neutral values for array type (in our case, 0 for int)
			elements = java.util.Arrays.copyOf(elements, 2 * elements.length);
		}
	}
	
	public void push(int val) {
		checkCapacity();
		elements[headPtr++] = val;
	}
	
	public int top() {
		// headPtr je pokazivac na sledece slobodno mesto
		// u nizu, pa se poslednji dodati element nalazi
		// na poziciji iza headPtr pokazivaca
		
		// za vezbu dodati proveru da li uopste ima elemenata
		// koji se nalaze na steku
		return elements[headPtr];
	}
	
	public int size() {
		return headPtr;
	}
	
	public int capacity() {
		return elements.length;
	}
	
	public void showContent() {
		System.out.println("size: " + headPtr + " capacity: " + elements.length);
		for (int i = 0; i < headPtr; i++)
			System.out.print(elements[i] + " ");
		System.out.println();
	}
	
	public int pop() {
		if (headPtr > 0) {
			headPtr--;
			return elements[headPtr+1];
		} else {
			System.out.println("Stack underflow...");
			return 0;
		}
	}
}
