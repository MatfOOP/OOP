package rs.math.oop1.zd.p170201.funkcionalniInterfejsi.z02.osobe;

import java.util.List;

import rs.math.oop1.zd.p170201.funkcionalniInterfejsi.z02.osobe.Person.Sex;

public class LambdaTest01
{
	static void printPersons( List<Person> roster, CheckPerson filter )
	{
		for( Person p : roster )
		{
			if( filter.test( p ) )
			{
				p.printPerson();
			}
		}
	}
	
	public static void main( String[] args )
	{
		printPersons( Person.LJUDI, new CheckPerson()
		{			
			@Override
			public boolean test( Person p )
			{
				if( p.getAge()>= 80)
					return true;
				else
					return false;
			}
		});	
		System.out.println();
		
		printPersons( Person.LJUDI, new CheckPerson()
		{			
			@Override
			public boolean test( Person p )
			{
				return ( p.getAge()>= 80 && p.getAge()<=85);
			}
		});
		System.out.println();
		
		printPersons( Person.LJUDI, new CheckPerson()
		{			
			@Override
			public boolean test( Person p )
			{
				return ( p.emailAddress.indexOf( "disney") >= 0 );
			}
		});

	}
	
}
