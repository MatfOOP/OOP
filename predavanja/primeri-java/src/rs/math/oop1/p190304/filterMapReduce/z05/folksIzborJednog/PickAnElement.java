package rs.math.oop1.p170304.filterMapReduce.z05.folksIzborJednog;

import java.util.List;
import static rs.math.oop1.p170304.filterMapReduce.z05.folksIzborJednog.Folks.friends;

public class PickAnElement
{
	public static void pickName( final List<String> names,
			final String startingLetter )
	{
		String foundName = null;
		for( String name : names )
		{
			if( name.startsWith( startingLetter ) )
			{
				foundName = name;
				break;
			}
		}
		System.out
				.print( String.format( "A name starting with %s: ", startingLetter ) );
				
		if( foundName != null )
		{
			System.out.println( foundName );
		}
		else
		{
			System.out.println( "No name found" );
		}
	}
	
	public static void main( final String[] args )
	{
		pickName( friends, "N" );
		pickName( friends, "Z" );
	}
}
