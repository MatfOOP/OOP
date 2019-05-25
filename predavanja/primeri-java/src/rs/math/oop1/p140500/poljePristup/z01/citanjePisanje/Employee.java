package rs.math.oop1.p140500.poljePristup.z01.citanjePisanje;

public class Employee
{
	private String name;
	private double salary;
	
	public Employee(String n, double s )
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
