package rs.math.oop1.zd.p040307.komentari.z03.javaDokumentacija;

/**
 * 
 * @author vlado
 * 
 * Klasa <code> ProbaImplemenetacija </code>
 * implementira interfejs <code>ProbaInterfejs</code>
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
