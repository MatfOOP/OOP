package rs.math.oop1.z170100.binarnaSerijalizacija.z01.koriscenje;

public class Manager extends Employee
{
	public Manager( String n, double s, int godina, int mesec, int dan )
	{
		super( n, s, godina, mesec, dan );
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

