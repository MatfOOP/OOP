package rs.math.oop1.p070601.uredjenje.z01.zaposleni;

import java.util.*;

public class EmployeeSortTest
{
	public static void main( String[] args )
	{
		Employee[] staff = new Employee[4];
		
		staff[0] = new Employee( "Harry Hacker", 45000 );
		staff[1] = new Employee( "Carl Cracker", 85000 );
		staff[2] = new Employee( "Tony Tester", 20000 );
		staff[3] = new Employee( "Mickey Mouse", 45000 );
		
		System.out.println( "Before sort" );
		for (Employee e : staff)
			System.out.println( e );
		
		Arrays.sort( staff );
		
		// print out information about all Employee objects
		System.out.println( "===================================" );
		System.out.println( "After sort" );
		for (Employee e : staff)
			System.out.println( e );
	}
}

class Employee implements Comparable
{
	private String imePrezime;
	private double plata;
	
	public Employee( String n, double s )
	{
		imePrezime = n;
		plata = s;
	}
	
	public String getImePrezime()
	{
		return imePrezime;
	}
	
	public double getPlata()
	{
		return plata;
	}
	
	public void raiseSalary( double byPercent )
	{
		double raise = plata * byPercent / 100;
		plata += raise;
	}

	@Override
	public String toString() {
		return "Employee: imePrezime=" + imePrezime + ",plata=" + plata;
	}

	@Override
	public boolean equals(Object o)
	{
		if( o == null )
			return false;
		if( getClass() != o.getClass())
			return false;
		Employee e = (Employee) o;
		return imePrezime.equals(e.imePrezime) && plata==e.plata;
	}

	@Override
	public int hashCode()
	{
		return 3 * imePrezime.hashCode() + 7 * new Double(plata).hashCode();
	}

	@Override
	public int compareTo( Object o )
	{
		if (!(o instanceof Employee))
			return -1;
		Employee other = (Employee) o;
		if (plata > other.plata)
			return -1;
		if (plata < other.plata)
			return 1;
		return imePrezime.compareTo( other.imePrezime);
	}
}
