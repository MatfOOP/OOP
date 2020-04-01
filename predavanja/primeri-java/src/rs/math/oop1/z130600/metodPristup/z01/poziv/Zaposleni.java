package rs.math.oop1.z130600.metodPristup.z01.poziv;

public class Zaposleni
{
	private String name;
	private double salary;
	
	public Zaposleni(String n, double s )
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
	public String toString()
	{
		return name + " " + salary;
	}
}
