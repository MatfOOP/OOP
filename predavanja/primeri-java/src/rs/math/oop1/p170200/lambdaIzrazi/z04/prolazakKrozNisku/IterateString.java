package rs.math.oop1.p170200.lambdaIzrazi.z04.prolazakKrozNisku;

public class IterateString
{
	private static void printChar( int aChar )
	{
		System.out.println( (char) (aChar) );
	}
	
	public static void main( String[] args )
	{
		System.out.println( "//" + "START:ITERATE_OUTPUT" );
		
		final String str = "w00t";
		
		str.chars().forEach( ch -> System.out.println( ch ) );
		System.out.println( "//" + "END:ITERATE_OUTPUT" );
		
		str.chars().forEach( System.out::println );
		
		System.out.println( "//" + "START:FIX_OUTPUT" );
		str.chars().forEach( IterateString::printChar );
		System.out.println( "//" + "END:FIX_OUTPUT" );
		
		str.chars().mapToObj( ch -> Character.valueOf( (char) ch ) )
				.forEach( System.out::println );
				
		System.out.println( "//" + "START:FILTER_OUTPUT" );
		str.chars().filter( ch -> Character.isDigit( ch ) )
				.forEach( ch -> printChar( ch ) );
		System.out.println( "" );
		System.out.println( "//" + "END:FILTER_OUTPUT" );
		
		str.chars().filter( ch -> Character.isDigit( ch ) );
		
		str.chars().filter( Character::isDigit );
		
		str.chars().filter( Character::isDigit )
				.forEach( IterateString::printChar );
				
	}
}
