package rs.math.oop1.z080302.visekriterijumskoUredjenje.z02.zaposleni;


public class Zaposleni implements Comparable
{
	private String name;
	private double salary;
	
	public Zaposleni( String n, double s )
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
		if (!(o instanceof Zaposleni))
			return -1;
		Zaposleni other = (Zaposleni) o;
		if (salary < other.salary)
			return 1;
		if (salary > other.salary)
			return -1;
		return 0;
	}
	
}
