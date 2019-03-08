package rs.math.oop1.zd.p070602.visekriterijumskoUredjenje.z02.zaposleni;

import java.util.Comparator;

public class EmployeeNameReverseComparator implements Comparator
{
	@Override
	public int compare( Object o1, Object o2 )
	{
		if( !(o1 instanceof Employee) )
			return 1;
		if( !(o2 instanceof Employee) )
			return -1;
		Employee e1 = (Employee) o1;
		Employee e2 = (Employee) o2;
		return e2.getName().compareTo( e1.getName() );
	}
}
