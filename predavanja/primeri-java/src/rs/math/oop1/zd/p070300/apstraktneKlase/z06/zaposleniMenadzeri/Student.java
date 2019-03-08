package rs.math.oop1.zd.p070300.apstraktneKlase.z06.zaposleniMenadzeri;

class Student extends Person
{
	public Student( String n, String s, int year, int month, int day )
	{
		super( n, year, month, day );
		usmerenje = s;
	}
	
	public String getUsmerenje()
	{
		return usmerenje;
	}
	
	private String usmerenje;
}
