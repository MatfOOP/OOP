package rs.math.oop1.zd.p070603.kloniranje.z01.zaposleni;

import java.util.*;

public class PokreniKloniranje
{
	public static void main( String[] args )
	{
		try
		{
			Employee original = new Employee( "Jovan Petović", 50000 );
			original.setHireDay( 2000, 1, 1 );
			Employee copy = original.clone();
			System.out.println( "Before changes" );
			System.out.println( "original=" + original );
			System.out.println( "copy=" + copy );
			copy.raiseSalary( 10 );
			copy.setHireDay( 2012, 12, 31 );
			System.out.println( "After changes" );
			System.out.println( "original=" + original );
			System.out.println( "copy=" + copy );
		}
		catch (CloneNotSupportedException e)
		{
			e.printStackTrace();
		}
	}
}

class Employee implements Cloneable
{
	private String name;
	private double salary;
	private Date hireDay;

	private Object o;
	
	public Employee( String n, double s )
	{
		name = n;
		salary = s;
		hireDay = new Date();
	}
	
	@Override
	public Employee clone() throws CloneNotSupportedException
	{
		Employee cloned = (Employee) super.clone();
		return cloned;
	}
	
	public void setHireDay( int year, int month, int day )
	{
		Date newHireDay = new GregorianCalendar( year, month - 1, day ).getTime();
		
		// Example of instance field mutation
		hireDay.setTime( newHireDay.getTime() );
	}
	
	public void raiseSalary( double byPercent )
	{
		double raise = salary * byPercent / 100;
		salary += raise;
	}
	
	public String toString()
	{
		return "Employee[name=" + name + ",salary=" + salary + ",hireDay="
				+ hireDay + "]";
	}
	
}
