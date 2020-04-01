package rs.math.oop1.z080304.kloniranje.z01.zaposleni;

import java.util.*;

public class PokreniKloniranje
{
	public static void main( String[] args )
	{
		try
		{
			Zaposleni original = new Zaposleni( "Jovan Petović", 50000 );
			original.setHireDay( 2000, 1, 1 );
			Zaposleni copy = original.clone();
			System.out.println( "Before changes" );
			System.out.println( "original=" + original );
			System.out.println( "copy=" + copy );
			copy.povecajPlatu( 10 );
			copy.setHireDay( 2012, 12, 31 );
			System.out.println( "After changes" );
			System.out.println( "original=" + original );
			System.out.println( "copy=" + copy );
		}
		catch (CloneNotSupportedException e)
		{
			e.printStackTrace();
		}
	}
}

class Zaposleni implements Cloneable
{
	private String ime;
	private double plata;
	private Date hireDay;

	public Zaposleni( String n, double s )
	{
		ime = n;
		plata = s;
		hireDay = new Date();
	}
	
	@Override
	public Zaposleni clone() throws CloneNotSupportedException
	{
		Zaposleni cloned = (Zaposleni) super.clone();
		return cloned;
	}
	
	public void setHireDay( int godina, int mesec, int dan )
	{
		Date newHireDay = new GregorianCalendar( godina, mesec - 1, dan ).getTime();
		// Example of instance field mutation
		hireDay.setTime( newHireDay.getTime() );
	}
	
	public void povecajPlatu( double zaProcenat )
	{
		double iznosPovisice = plata * zaProcenat / 100;
		plata += iznosPovisice;
	}
	
	public String toString()
	{
		return "Zaposleni[ime=" + ime + ",plata=" + plata + ",hireDay="
				+ hireDay + "]";
	}
	
}
