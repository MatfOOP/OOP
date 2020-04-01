package rs.math.oop1.z070903.prevazilazenje.z02.niskaReprezentacijaZaposleniMenadzeri;

import java.util.*;

public class EMTest
{
	public static void main( String[] args )
	{
		Employee alice1 = new Employee( "Alice Adams", 75000, 1987, 12, 15 );
		Employee alice2 = alice1;
		Employee alice3 = new Employee( "Alice Adams", 75000, 1987, 12, 15 );
		Employee bob = new Employee( "Bob Brandson", 50000, 1989, 10, 1 );
		
		System.out.println( "alice1 == alice2: " + (alice1 == alice2) );
		
		System.out.println( "alice1 == alice3: " + (alice1 == alice3) );
		
		System.out.println( "alice1.equals(alice3): " + alice1.equals( alice3 ) );
		
		System.out.println( "alice1.equals(bob): " + alice1.equals( bob ) );
		
		System.out.println( "bob.toString(): " + bob );
		
		Manager carl = new Manager( "Carl Cracker", 80000, 1987, 12, 15 );
		Manager boss = new Manager( "Carl Cracker", 80000, 1987, 12, 15 );
		boss.setBonus( 5000 );
		System.out.println( "boss.toString(): " + boss );
		System.out.println( "carl.equals(boss): " + carl.equals( boss ) );
		System.out.println( "alice1.hashCode(): " + alice1.hashCode() );
		System.out.println( "alice3.hashCode(): " + alice3.hashCode() );
		System.out.println( "bob.hashCode(): " + bob.hashCode() );
		System.out.println( "carl.hashCode(): " + carl.hashCode() );
	}
}

class Employee
{
	private String name;
	private double salary;
	private Date hireDay;

	public Employee( String n, double s, int godina, int mesec, int dan )
	{
		name = n;
		salary = s;
		GregorianCalendar calendar = new GregorianCalendar( godina, mesec - 1, dan );
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
		return 7 * name.hashCode() + 11 * new Double( salary ).hashCode() + 13
				* hireDay.hashCode();
	}
	
	@Override
	public String toString()
	{
		return getClass().getName() + "[name=" + name + ",salary=" + salary
				+ ",hireDay=" + hireDay + "]";
	}
	
}

class Manager extends Employee
{
	private double bonus;

	public Manager( String n, double s, int godina, int mesec, int dan )
	{
		super( n, s, godina, mesec, dan );
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
	
	@Override
	public boolean equals( Object otherObject )
	{
		if (!super.equals( otherObject ))
			return false;
		if (!(otherObject instanceof Manager))
			return false;
		Manager other = (Manager) otherObject;
		// super.equals checked that this and other belong to the same class
		return (bonus == other.bonus);
	}
	
	@Override
	public int hashCode()
	{
		return super.hashCode() + 17 * new Double( bonus ).hashCode();
	}
	
	@Override
	public String toString()
	{
		return super.toString() + "[bonus=" + bonus + "]";
	}
}
