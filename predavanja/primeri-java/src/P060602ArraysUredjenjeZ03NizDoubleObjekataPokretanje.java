import java.util.Arrays;

class PokretanjeArraysUredjenjeNizDoubleOбjekata
{
	
	public static void main( String[] args )
	{
		Double[] niz = { 1.0,-2.5, 1.4, 2.1e-1, -1/0.0, +2.3/0.0, 0.0/0.0 };
		for( Double d : niz )
			System.out.print( d + " " );
		System.out.println();
		
		Arrays.sort( niz );
		
		for( double d : niz )
			System.out.print( d + " " );
		System.out.println();
	}
	
}
