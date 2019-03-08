package rs.math.oop1.zd.p070300.apstraktneKlase.z06.zaposleniMenadzeri;

import java.util.Date;
import java.util.GregorianCalendar;

class Employee extends Person
{
	public Employee( String n, double s, int yearB, int monthB, int dayB,
			int yearH, int monthH, int dayH )
	{
		super( n, yearB, monthB, dayB );
		salary = s;
		GregorianCalendar calendar = new GregorianCalendar( yearH, monthH - 1, dayH );
		hireDay = calendar.getTime();
	}
	
	public Employee( String n, double s, int yearH, int monthH, int dayH )
	{
		this( n, s, 1, 1, 1970, yearH, monthH, dayH );
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
	
	private double salary;
	private Date hireDay;
}
