package rs.math.oop1.zd.p070300.apstraktneKlase.z06.zaposleniMenadzeri;

import java.util.*;

/**
 * This program demonstrates inheritance.
 * 
 * @version 1.21 2004-02-21
 * @author Cay Horstmann
 */
public class ManagerTest
{
	public static void main( String[] args )
	{
		// construct a Manager object
		Manager boss = new Manager( "Carl Cracker", 80000, 1987, 12, 15 );
		boss.setBonus( 5000 );
		
		Employee[] staff = new Employee[3];
		
		staff[0] = boss;
		staff[1] = new Employee( "Harry Hacker", 50000, 1989, 10, 1 );
		staff[2] = new Employee( "Tommy Tester", 40000, 1990, 3, 15 );
		
		Student s = new Student( "M M", "Inf.", 17, 2, 1990 );
		Person[] p = new Person[4];
		for (int i = 0; i < 3; i++)
			p[i] = staff[i];
		p[3] = s;
		for (Person per : p)
			System.out.println( per );
	}
}
