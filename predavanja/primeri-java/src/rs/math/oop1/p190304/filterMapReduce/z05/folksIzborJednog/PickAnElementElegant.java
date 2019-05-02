package rs.math.oop1.p190304.filterMapReduce.z05.folksIzborJednog;

import java.util.List;
import java.util.Optional;

public class PickAnElementElegant
{
	public static void pickName( final List<String> names,
			final String startingLetter )
	{
		
		final Optional<String> foundName = names.stream()
				.filter( name -> name.startsWith( startingLetter ) ).findFirst();
				
		System.out.println( String.format( "A name starting with %s: %s",
				startingLetter,
				foundName.orElse( "No name found" ) ) );
	}
	
	public static void main( final String[] args )
	{
		System.out.println( "//" + "START:NAME_OUTPUT" );
		pickName( Folks.friends, "N" );
		pickName( Folks.friends, "Z" );
		System.out.println( "//" + "END:NAME_OUTPUT" );
		
		final Optional<String> foundName = Folks.friends.stream()
				.filter( name -> name.startsWith( "N" ) ).findFirst();
				
		System.out.println( "//" + "START:CLOSURE_OUTPUT" );
		foundName.ifPresent( name -> System.out.println( "Hello " + name ) );
		System.out.println( "//" + "END:CLOSURE_OUTPUT" );
	}
}
