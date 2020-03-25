package rs.math.oop1.z170100.binarnaSerijalizacija.z01.koriscenje;

import java.io.*;


class ObjectStreamWriteTest
{
	public static void main( String[] args )
	{
		Employee harry = new Employee( "Harry Hacker", 50000, 1989, 10, 1 );
		Manager carl = new Manager( "Carl Cracker", 80000, 1987, 12, 15 );
		carl.setSecretary( harry );
		Manager tony = new Manager( "Tony Tester", 40000, 1990, 3, 15 );
		tony.setSecretary( harry );
		
		Employee[] staff = new Employee[3];
		
		staff[0] = carl;
		staff[1] = harry;
		staff[2] = tony;
		
		try
		{
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream( "employee1.dat" ) );
			out.writeObject( staff );
			out.close();			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}

