package rs.math.oop1.p160100.binarnaSerijalizacija.z01.koriscenje;

import java.io.*;

/**
 * @version 1.10 17 Aug 1998
 * @author Cay Horstmann
 */
class ObjectStreamReadTest
{
	public static void main( String[] args )
	{
		
		try
		{			
			// retrieve all records into a new array
			ObjectInputStream in = new ObjectInputStream(
					new FileInputStream( "employee1.dat" ) );
			Employee[] newStaff = (Employee[]) in.readObject();
			in.close();
			
			// raise secretary's salary
			newStaff[1].raiseSalary( 10 );
			
			// print the newly read employee records
			for( Employee e : newStaff )
				System.out.println( e );
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
