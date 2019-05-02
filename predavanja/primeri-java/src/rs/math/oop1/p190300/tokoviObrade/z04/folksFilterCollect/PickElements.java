package rs.math.oop1.p190300.tokoviObrade.z04.folksFilterCollect;

import java.util.List;
import static rs.math.oop1.p190300.tokoviObrade.z04.folksFilterCollect.Folks.friends;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class PickElements
{
	public static void main( final String[] args )
	{
		{
			final List<String> startsWithN = new ArrayList<String>();
			for( String name : friends )
			{
				if( name.startsWith( "N" ) )
				{
					startsWithN.add( name );
				}
			}
			
			System.out
					.println( String.format( "Found %d names", startsWithN.size() ) );
		}
		
		System.out.println( "//" + "START:FILTER_OUTPUT" );
		final List<String> startsWithN = friends.stream()
				.filter( name -> name.startsWith( "N" ) )
				.collect( Collectors.toList() );
				
		System.out.println( String.format( "Found %d names", startsWithN.size() ) );
		
		System.out.println( "//" + "END:FILTER_OUTPUT" );
	}
}
