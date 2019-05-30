package rs.math.oop1.p190300.tokoviObrade.z02.osobeKonzumiranje;

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
		System.out.println("1.---");
		printPersons( Person.LJUDI, p -> p.getAge()>= 80,
			p -> p.printPerson()
		);

		System.out.println("2.---");
		printPersons( Person.LJUDI,
				p  ->	{ return ( p.getAge()>= 80 && p.getAge()<=89);},
				p -> {System.out.print("+++" + p + "+++");
							System.out.println(  );
						 });

		System.out.println("3.---");
		printPersons( Person.LJUDI,  
				p -> p.emailAddress.indexOf( "wb") < 0,
				q -> q.printPerson());

		System.out.println("4.---");
		Predicate<Person> filter = p -> p.emailAddress.indexOf( "wb") < 0;
		filter = filter.and(p->p.getAge()> 75);
		printPersons( Person.LJUDI,
				filter,
				q -> q.printPerson());

		System.out.println("5.---");
		Consumer<Person> aktivnost = p -> p.printPerson();
		aktivnost = aktivnost.andThen(p->System.out.println(">>>"));
		printPersons( Person.LJUDI,
				filter,
				aktivnost);

	}
	
}
