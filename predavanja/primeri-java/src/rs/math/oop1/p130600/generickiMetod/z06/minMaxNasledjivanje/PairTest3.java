package rs.math.oop1.p130600.generickiMetod.z06.minMaxNasledjivanje;

import java.util.*;

class Employee
{
	private String name;
	private double salary;
	private Date hireDay;

	public Employee( String n, double s, int year, int month, int day )
	{
		name = n;
		salary = s;
		GregorianCalendar calendar = new GregorianCalendar( year, month - 1, day );
		hireDay = calendar.getTime();
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getSalary()
	{
		return salary;
	}
	
	public Date getHireDay()
	{
		return hireDay;
	}
	
	public void raiseSalary( double byPercent )
	{
		double raise = salary * byPercent / 100;
		salary += raise;
	}
}

class Manager extends Employee
{
	private double bonus;

	public Manager( String n, double s, int year, int month, int day )
	{
		super( n, s, year, month, day );
		bonus = 0;
	}
	
	@Override
	public double getSalary()
	{
		double baseSalary = super.getSalary();
		return baseSalary + bonus;
	}
	
	public void setBonus( double b )
	{
		bonus = b;
	}
	
	public double getBonus()
	{
		return bonus;
	}
	
}

class PairAlg
{
	public static boolean hasNulls( Pair<?> p )
	{
		return p.getFirst() == null || p.getSecond() == null;
	}
	
	public static void swap( Pair<?> p )
	{
		swapHelper( p );
	}
	
	public static <T> void swapHelper( Pair<T> p )
	{
		T t = p.getFirst();
		p.setFirst( p.getSecond() );
		p.setSecond( t );
	}
}


public class PairTest3
{
	public static void printBuddies( Pair<? extends Employee> p )
	{
		Employee first = p.getFirst();
		Employee second = p.getSecond();
		System.out.println( first.getName() + " i " + second.getName()
				+ " su drugari." );
	}
	
	public static void minmaxBonus( 
			Manager[] a, Pair<? super Manager> result )
	{
		if (a == null || a.length == 0)
			return;
		Manager min = a[0];
		Manager max = a[0];
		for (int i = 1; i < a.length; i++)
		{
			if (min.getBonus() > a[i].getBonus())
				min = a[i];
			if (max.getBonus() < a[i].getBonus())
				max = a[i];
		}
		result.setFirst( min );
		result.setSecond( max );
	}
	
	public static void maxminBonus( Manager[] a, Pair<? super Manager> result )
	{
		minmaxBonus( a, result );
		PairAlg.swapHelper( result ); // OK--swapHelper captures wildcard type
	}

	public static void main( String[] args )
	{
		Manager ceo = new Manager( 
				"Gus Greedy", 800_000, 2003, 12, 15 );
		Manager cfo = new Manager( 
				"Sid Sneaky", 600_000, 2003, 12, 15 );
		Manager vlasnikovSin = new Manager( 
				"Tatin sin", 800_000, 2012, 1, 12 );
		Pair<Manager> buddies = new Pair<Manager>( ceo, cfo );
		printBuddies( buddies );
		
		ceo.setBonus( 1_000_000 );
		cfo.setBonus( 1_500_000 );
		vlasnikovSin.setBonus( 450_000 );
		Manager[] managers = { ceo, cfo, vlasnikovSin };
		
		Pair<Employee> result = new Pair<>();
		minmaxBonus( managers, result );
		System.out.println( "first: " + result.getFirst().getName() + ", second: "
				+ result.getSecond().getName() );
		maxminBonus( managers, result );
		System.out.println( "first: " + result.getFirst().getName() + ", second: "
				+ result.getSecond().getName() );
	}
	
}


