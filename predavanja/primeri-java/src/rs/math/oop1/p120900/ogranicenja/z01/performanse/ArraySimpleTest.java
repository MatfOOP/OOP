package rs.math.oop1.p120900.ogranicenja.z01.performanse;

import java.lang.reflect.Array;

public class ArraySimpleTest
{
	public static void main( String[] argumenti )
	{
		testArray();
	}
	
	public static void testArray()
	{
		Class<?> cls = String.class;
		int i = 10;
		
		long poc = System.nanoTime();
		Object arr = Array.newInstance( cls, i );
		Array.set( arr, 5, "this is a test" );
		String s = (String) Array.get( arr, 5 );
		System.out.println( s );
		System.out.println( "Preko refleksije trajalo "
				+ (System.nanoTime() - poc) / 10e6 + "msec." );
		poc = System.nanoTime();
		String[] arr2 = new String[i];
		arr2[5] = "this is a test";
		s = arr2[5];
		System.out.println( s );
		System.out.println( "Bez refleksije trajalo "
				+ (System.nanoTime() - poc) / 10e6 + "msec." );
	}
	
}
