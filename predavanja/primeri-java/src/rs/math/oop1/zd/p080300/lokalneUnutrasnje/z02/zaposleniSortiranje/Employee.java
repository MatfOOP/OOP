package rs.math.oop1.zd.p080300.lokalneUnutrasnje.z02.zaposleniSortiranje;

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
	
	@Override
	public String toString()
	{
		return "name=" + getName() + ",salary=" + getSalary();
	}
	
	@Override
	public int compareTo(Object o)	
	{
		if( ! (o instanceof Employee) )
			return -1;
		Employee e = (Employee) o;	
		if( salary - e.getSalary() != 0)
			return -(int)(salary - e.getSalary());
		return name.compareTo( e.getName() );
	}
}
