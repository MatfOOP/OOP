package rs.math.oop1.p170202.predefinisaniFunkcionalniInterfejsi.z03.folksConsumer;

import java.util.function.Consumer;

public class Iteration
{
	public static void main( final String[] args )
	{
		for(int i = 0; i < Folks.friends.size(); i++ )
		{
			System.out.println( Folks.friends.get( i ) );
		}
		
		for( String name : Folks.friends )
		{
			System.out.println( name );
		}
		
		System.out.println( "//" + "START:INTERNAL_FOR_EACH_OUTPUT" );
		
		Folks.friends.forEach(new Consumer<String>()
		{
			public void accept( final String name )
			{
				System.out.println( name );
			}
		} );
		
		System.out.println( "//" + "END:INTERNAL_FOR_EACH_OUTPUT" );
		
		System.out.println( "//" + "START:INTERNAL_OUTPUT" );
		Folks.friends.forEach( (final String name ) -> System.out.println( name ) );
		System.out.println( "//" + "END:INTERNAL_OUTPUT" );
		
		Folks.friends.forEach( (name ) -> System.out.println( name ) );
		
		Folks.friends.forEach(name -> System.out.println( name ) );
		
		Folks.friends.forEach( System.out::println );
	}
}
