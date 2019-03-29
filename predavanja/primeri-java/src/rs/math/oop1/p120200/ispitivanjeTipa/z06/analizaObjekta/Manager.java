package rs.math.oop1.p120200.ispitivanjeTipa.z06.analizaObjekta;

public class Manager extends Employee
{
  double bonus;
	
	public void setBonus( double bonus )
	{
		this.bonus = bonus;
	}

	public Manager( String n, double s, double b )
	{
		super( n, s );
		bonus = b;
	}
	
}
