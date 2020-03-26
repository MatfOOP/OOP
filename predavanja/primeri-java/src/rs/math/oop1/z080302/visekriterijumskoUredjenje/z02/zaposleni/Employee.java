package rs.math.oop1.z080302.visekriterijumskoUredjenje.z02.zaposleni;


public class Employee implements Comparable
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
	
	public int compareTo( Object o )
	{
		if (!(o instanceof Employee))
			return -1;
		Employee other = (Employee) o;
		if (salary < other.salary)
			return 1;
		if (salary > other.salary)
			return -1;
		return 0;
	}
	
}
