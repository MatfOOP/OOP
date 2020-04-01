package rs.math.oop1.z150000.koriscenjeKolekcije.z01.nizovnaLista;

import java.util.*;

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
	public String toString()
	{
		return "(" + name + ":" + hireDay + ":" + salary + ")";
	}
	
	@Override 
	public int hashCode()
	{
		return 3 * name.hashCode()+ 5 * hireDay.hashCode() 
				+ 7 *  new Double( salary).hashCode();				
	}
}

public class ArrayListTest
{
	
	public static void main( String[] args )
	{
		Collection c;
	    // fill the staff array list with three Employee objects
		Collection<Employee> staff = new ArrayList<Employee>();

		staff.add( new Employee( "Carl Cracker", 75000, 1987, 12, 15 ) );
		staff.add( new Employee( "Harry Hacker", 50000, 1989, 10, 1 ) );
		staff.add( new Employee( "Tony Tester", 40000, 1990, 3, 15 ) );
		
		// raise everyone's salary by 5%
		for (Employee e : staff)
			e.raiseSalary( 5 );
		
		// print out information about all Employee objects
//		for (Employee e : staff)
//			System.out.println( "name=" + e.getIme() + ",salary=" + e.getPlata()
//					+ ",hireDay=" + e.getHireDay() );
		
		System.out.println(staff);
    
//		ArrayList<Integer> a = new ArrayList<>();
//		for( int i=0; i <1_000; i++)
//			a.add( (i+1)*2 );
//		System.out.println(a);

	}
	
}
