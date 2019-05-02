package rs.math.oop1.p190304.filterMapReduce.z01.osobeMapReduce;

public class LambdaTest01
{
	
	public static void main( String[] args )
	{
		Person.LJUDI.stream().filter( p -> {
			return p.gender == Person.Sex.MALE && p.emailAddress.indexOf( "disney" ) >= 0;
		} ).forEach( p -> p.printPerson() );
		
		Person.LJUDI.stream().filter( x -> (x.gender == Person.Sex.MALE) )
				.map( y -> y.name.length() )
				.forEach( i -> System.out.print( i + " " ) );
		System.out.println();
		System.out.println();
		
		Person.LJUDI.stream().filter( p -> {
			return p.gender == Person.Sex.MALE;
		} ).map( p -> p.getAge() - 50 )
				.forEach( x -> System.out.println( x - 50 ) );
		System.out.println();
		
		long sumaGodina = Person.LJUDI.stream().filter( p -> {
			return p.gender == Person.Sex.MALE && p.emailAddress.indexOf( "wb" ) >= 0;
		} ).mapToLong( p -> p.getAge() ).sum();
		System.out.println( sumaGodina );
		System.out.println();
		
		long sumaGodina2 = Person.LJUDI.stream().filter( p -> {
			return p.gender == Person.Sex.MALE && p.emailAddress.indexOf( "wb" ) >= 0;
		} ).map( p -> p.getAge() ).reduce( 0L, ( x, y ) -> {
			return x + y;
		} );
		System.out.println( sumaGodina2 );
		System.out.println();
		
		double proizvodGodina2 = Person.LJUDI.stream()
				.filter(
						p -> p.gender == Person.Sex.MALE && p.emailAddress.indexOf( "wb" ) >= 0 )
				.map( p -> p.getAge() ).reduce( 1L, ( x, y ) -> {
					return x * y;
				} );
		System.out.println( proizvodGodina2 );

		long minGodina = Person.LJUDI.stream().filter( p -> {
			return p.gender == Person.Sex.MALE && p.emailAddress.indexOf( "disney" ) >= 0;
		} ).map( p -> p.getAge() )
				.reduce( Long.MAX_VALUE, ( x, y ) -> ( x < y )? x:y	 );
		System.out.println( minGodina );
		System.out.println();

	}
	
}
