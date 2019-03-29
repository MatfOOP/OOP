package rs.math.oop1.p070300.apstraktneKlase.z06.zaposleniMenadzeri;

class Manager extends Employee
{
	/**
	 * @param n
	 *          the employee's name
	 * @param s
	 *          the salary
	 * @param year
	 *          the hire year
	 * @param month
	 *          the hire month
	 * @param day
	 *          the hire day
	 */
	public Manager( String n, double s, int yearB, int monthB, int dayB,
			int yearH, int monthH, int dayH )
	{
		super( n, s, yearB, monthB, dayB, yearH, monthH, dayH );
		bonus = 0;
	}
	
	public Manager( String n, double s, int yearH, int monthH, int dayH )
	{
		this( n, s, 1, 1, 1970, yearH, monthH, dayH );
	}
	
	public double getSalary()
	{
		double baseSalary = super.getSalary();
		return baseSalary + bonus;
	}
	
	public void setBonus( double b )
	{
		bonus = b;
	}
	
	private double bonus;
}
