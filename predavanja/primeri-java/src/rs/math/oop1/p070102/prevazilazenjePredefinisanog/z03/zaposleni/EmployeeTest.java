package rs.math.oop1.p070102.prevazilazenjePredefinisanog.z03.zaposleni;

import java.util.*;

/**
 * This program tests the Employee class.
 * 
 * @version 1.11 2004-02-19
 * @author Cay Horstmann
 */
public class EmployeeTest
{
	public static void main( String[] args )
	{
		// fill the staff array with three Employee objects
		Employee[] staff = new Employee[10];
		
		staff[0] = new Employee( "Carl Cracker", 75000, 1987, 12, 15 );
		staff[1] = new Employee( "Harry Hacker", 50000, 1989, 10, 1 );
		staff[2] = new Employee( "Tony Tester", 40000, 1990, 3, 15 );
		
		for (int i = 3; i < staff.length; i++)
			staff[i] = new Employee( 1000, 2013, 11, 5 );
		
		// print out information about all Employee objects
		System.out.println( "Pre povisice:" );
		for (Employee e : staff)
			System.out.println( e );
		
		// raise everyone's salary by 5%
		for (Employee e : staff)
			e.raiseSalary( 5 );
		
		// print out information about all Employee objects
		System.out.println( "Posle povisice:" );
		for (Employee e : staff)
		{
			System.out.println( e );
		}
	}
}

class Employee
{
	private static int nextId;
	
	private int id;
	private String name;
	private double salary;
	private Date hireDay;

	// static initialization block
	static
	{
		nextId = (int) (Math.random() * 1000);
	}

	// instance initialization block
	{
		id = nextId++;
	}
	
	public Employee( String n, double s, int year, int month, int day )
	{
		name = n;
		salary = s;
		GregorianCalendar calendar = new GregorianCalendar( year, month - 1, day );
		// GregorianCalendar uses 0 for January
		hireDay = calendar.getTime();
	}
	
	public Employee( double s, int year, int month, int day )
	{
		name = "Zaposleni br. " + getId();
		salary = s;
		GregorianCalendar calendar = new GregorianCalendar( year, month - 1, day );
		// GregorianCalendar uses 0 for January
		hireDay = calendar.getTime();
	}
	
	@Override
	public boolean equals( Object otherObject )
	{
		// a quick test to see if the objects are identical
		if (this == otherObject)
			return true;
		
		// must return false if the explicit parameter is null
		if (otherObject == null)
			return false;
		
		// if the classes don't match, they can't be equal
		if (getClass() != otherObject.getClass())
			return false;
		
		// now we know otherObject is a non-null Employee
		Employee other = (Employee) otherObject;
		
		// test whether the fields have identical values
		return name.equals( other.name ) && salary == other.salary
				&& hireDay.equals( other.hireDay );
	}
	
	@Override
	public int hashCode()
	{
		return 7 * name.hashCode() + 11 * Double.valueOf( salary ).hashCode() + 13
				* hireDay.hashCode();
	}
	
	@Override
	public String toString()
	{
		return "Zaposl.[ime=" + getName() + ",plata=" + getSalary() + ",id="
				+ getId() + ",datum=" + getHireDay() + "]";
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
	
	public int getId()
	{
		return id;
	}
	
	public void raiseSalary( double byPercent )
	{
		double raise = salary * byPercent / 100;
		salary += raise;
	}
	
}
