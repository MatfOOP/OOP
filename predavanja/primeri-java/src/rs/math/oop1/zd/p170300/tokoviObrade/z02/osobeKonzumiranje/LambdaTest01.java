package rs.math.oop1.zd.p170300.tokoviObrade.z02.osobeKonzumiranje;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaTest01
{
	static void printPersons( List<Person> persons, 
			Predicate<Person> toFilter,
			Consumer<Person> toConsume)
	{
		persons
			.stream()
			.filter( toFilter )
			.forEach( toConsume );
	}
	
	public static void main( String[] args )
	{
		printPersons( Person.LJUDI, p -> p.getAge()>= 80,
			p -> p.printPerson()
		);
		
		System.out.println();
		printPersons( Person.LJUDI, 
				p  ->	{ return ( p.getAge()>= 80 && p.getAge()<=85);},
				p -> {System.out.print("+++" + p + "+++");
							System.out.println(  );
						 });
		System.out.println();
		
		printPersons( Person.LJUDI,  
				p -> p.emailAddress.indexOf( "wb") >= 0, 
				q -> q.printPerson());

	}
	
}
