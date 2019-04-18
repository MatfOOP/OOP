package rs.math.oop1.p070300.apstraktneKlase.z06.zaposleniMenadzeri;

class Student extends Osoba
{
	private String usmerenje;

	public Student( String n, String s, int year, int month, int day )
	{
		super( n, year, month, day );
		usmerenje = s;
	}
	
	public String getUsmerenje()
	{
		return usmerenje;
	}

	public String toString()
	{
		return "Student: " + getIme() + ":" + getUsmerenje();
	}
	
}
