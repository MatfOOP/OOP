package rs.math.oop1.z170100.binarnaSerijalizacija.z01.koriscenje;

import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

public class Employee implements Serializable
{
	private static final long serialVersionUID = 2084538915166046307L;
	private String name;
	private double salary;
	private Date hireDay;

	public Employee()
	{
	}
	
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
	
	public String toString()
	{
		return getClass().getName() + "[name=" + name + ",salary=" + salary
				+ ",hireDay=" + hireDay + "]";
	}	
}

