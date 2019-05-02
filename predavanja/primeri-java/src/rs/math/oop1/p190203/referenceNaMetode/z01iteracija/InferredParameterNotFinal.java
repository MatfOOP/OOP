package rs.math.oop1.p190203.referenceNaMetode.z01iteracija;

public class InferredParameterNotFinal
{
	public static void main( final String[] args )
	{
		Folks.friends.forEach(name -> {
			name = name.toUpperCase();
			System.out.println( name );
		} );
	}
}
