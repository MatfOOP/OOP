package rs.math.oop1.p070602.visekriterijumskoUredjenje.z01.niske;

import java.util.Arrays;

public class StringDefaultSort
{
	
	public static void main( String[] args )
	{
		String[] niz = {"Miki", "Paja", "Mini", "Silja", "Mirko", "Slavko"};

		System.out.println("Pre sortiranja");
		for( String s: niz)
			System.out.print( s + " " );
		System.out.println();
		
		Arrays.sort( niz );
		
		System.out.println("Posle sortiranja");
		for( String s: niz)
			System.out.print( s + " " );
		System.out.println();
	}
	
}
