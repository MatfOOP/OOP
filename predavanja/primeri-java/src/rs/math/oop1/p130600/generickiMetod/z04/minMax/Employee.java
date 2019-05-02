package rs.math.oop1.p110600.generickiMetod.z04.minMax;

public class Employee
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
	
}
