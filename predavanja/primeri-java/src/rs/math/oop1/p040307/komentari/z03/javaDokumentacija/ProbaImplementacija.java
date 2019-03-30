package rs.math.oop1.p040307.komentari.z03.javaDokumentacija;

/**
 * @author vlado
 * <p>
 * Класа <code> ProbaImplemenetacija </code> имплементира интерфејс <code>ProbaInterfejs</code>
 * <p>
 * @see ProbaInterfejs
 */
public class ProbaImplemenetacija implements ProbaInterfejs
{
	/**
	 * Sabira argumente
	 * 
	 * <p>Realizacija metoda za sabiranje dva cela broja.
	 * <p>Izradjena iskljucivo u svrhu demonstracije.
	 * 
	 * @see ProbaInterfejs#saberi(int, int)
	 * @see Integer#compareTo(Integer)
	 */
	@Override
	public int saberi( int a, int b )
	{
		return a+b;
	}
	
}
