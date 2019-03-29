package rs.math.oop1.p070601.uredjenje.z01.zaposleni;

import java.util.*;

public class EmployeeSortTest
{
	public static void main( String[] args )
	{
		Employee[] staff = new Employee[4];
		
		staff[0] = new Employee( "Harry Hacker", 45000 );
		staff[1] = new Employee( "Carl Cracker", 85000 );
		staff[2] = new Employee( "Tony Tester", 45000 );
		staff[3] = new Employee( "Mickey Mouse", 20000 );
		
		System.out.println( "Before sort" );
		for (Employee e : staff)
			System.out.println( "name=" + e.getName() + ",salary=" + e.getSalary() );
		
		Arrays.sort( staff );
		
		// print out information about all Employee objects
		System.out.println( "===================================" );
		System.out.println( "After sort" );
		for (Employee e : staff)
			System.out.println( "name=" + e.getName() + ",salary=" + e.getSalary() );
	}
}

class Employee implements Comparable
{
	private String name;
	private double salary;
	
	public Employee( String n, double s )
	{
		name = n;
		salary = s;
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getSalary()
	{
		return salary;
	}
	
	public void raiseSalary( double byPercent )
	{
		double raise = salary * byPercent / 100;
		salary += raise;
	}
	
	@Override
	public int compareTo( Object o )
	{
		if (!(o instanceof Employee))
			return -1;
		Employee other = (Employee) o;
		if (salary > other.salary)
			return -1;
		if (salary < other.salary)
			return 1;
		return name.compareTo( other.name );
	}
}
