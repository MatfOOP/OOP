package rs.math.oop1.p160100.binarnaSerijalizacija.z01.koriscenje;

public class Manager extends Employee
{
	public Manager( String n, double s, int year, int month, int day )
	{
		super( n, s, year, month, day );
		secretary = null;
	}
	
	public void setSecretary( Employee s )
	{
		secretary = s;
	}
	
	public String toString()
	{
		return super.toString() + "[secretary=" + secretary + "]";
	}
	
	private Employee secretary;
}

