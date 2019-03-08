package rs.math.oop1.zd.p070602.visekriterijumskoUredjenje.z01.niske;

import java.util.Comparator;

public class NumOfVowelsComparator implements Comparator
{
	private int numOfVowels(String s)
	{
		int ret=0;
		for( char ch: s.toCharArray() )
			if( "aeiouAEIOU".indexOf( ch ) >= 0 )
				ret++;
		return ret;
	}
	
	@Override
	public int compare( Object o1, Object o2 )
	{
		if( !(o1 instanceof String) )
			return 1;
		if( !(o2 instanceof String) )
			return -1;
		int razlika = numOfVowels((String) o2) -
				numOfVowels((String) o1);
		if( razlika != 0)
			return razlika;
		return ((String)o1).compareTo( (String)o2 );
	}
}
