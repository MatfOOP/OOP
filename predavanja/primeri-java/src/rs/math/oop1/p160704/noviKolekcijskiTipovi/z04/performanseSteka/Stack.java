package rs.math.oop1.p160704.noviKolekcijskiTipovi.z04.performanseSteka;

import java.util.Collection;
import java.util.EmptyStackException;

public interface Stack<E> extends Collection<E>
{
	void push(E elem);
	
	E peek() throws EmptyStackException;
	
	E pop() throws EmptyStackException;

	boolean empty();
}
