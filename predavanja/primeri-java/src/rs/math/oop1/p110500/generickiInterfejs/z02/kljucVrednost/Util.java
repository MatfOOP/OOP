package rs.math.oop1.p110500.generickiInterfejs.z02.kljucVrednost;

public class Util
{
	// Generic static method
	public static <T, W> boolean compare( 
			Pair<T, W> p1, Pair<T, W> p2 )
	{
		return p1.getKey().equals( p2.getKey() )
				&& p1.getValue().equals( p2.getValue() );
	}
}