package rs.math.oop1.p170202.predefinisaniFunkcionalniInterfejsi.z03.folksConsumer;

public class InferredParameterNotFinal
{
	public static void main( final String[] args )
	{
		Folks.friends.forEach(name -> {
			name = name.toUpperCase().concat( " " + name );
			System.out.println( name );
		} );
	}
}
