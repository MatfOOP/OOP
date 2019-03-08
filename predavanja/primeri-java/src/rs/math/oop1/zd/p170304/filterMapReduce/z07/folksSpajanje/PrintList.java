
package rs.math.oop1.zd.p170304.filterMapReduce.z07.folksSpajanje;

import static java.util.stream.Collectors.joining;
import static rs.math.oop1.zd.p170304.filterMapReduce.z07.folksSpajanje.Folks.friends;

public class PrintList
{
	public static void main( final String[] args )
	{
		System.out.println( "//" + "START:FOREACH_OUTPUT" );
		for( String name : friends )
		{
			System.out.print( name + ", " );
		}
		System.out.println();
		System.out.println( "//" + "END:FOREACH_OUTPUT" );
		
		System.out.println( "//" + "START:FOR_OUTPUT" );
		for( int i = 0; i < friends.size() - 1; i++ )
		{
			System.out.print( friends.get( i ) + ", " );
		}
		
		if( friends.size() > 0 )
			System.out.println( friends.get( friends.size() - 1 ) );
		System.out.println( "//" + "END:FOR_OUTPUT" );
		
		System.out.println( "//" + "START:JOIN_OUTPUT" );
		System.out.println( String.join( ", ", friends ) );
		System.out.println( "//" + "END:JOIN_OUTPUT" );
		
		System.out.println( "//" + "START:MAP_JOIN_OUTPUT" );
		System.out.println( friends.stream().map( String::toUpperCase )
				.collect( joining( ", " ) ) );
		System.out.println( "//" + "END:MAP_JOIN_OUTPUT" );
		
	}
}
