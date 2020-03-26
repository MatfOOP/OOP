package rs.math.oop1.z080100.apstraktneKlase.z06.zaposleniMenadzeri;

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
		// construct a Direktor object
		Direktor boss = new Direktor( "Carl Cracker", 80000, 1987, 12, 15 );
		boss.setBonus( 5000 );
		
		Zaposleni[] staff = new Zaposleni[3];
		
		staff[0] = boss;
		staff[1] = new Zaposleni( "Harry Hacker", 50000, 1989, 10, 1 );
		staff[2] = new Zaposleni( "Tommy Tester", 40000, 1990, 3, 15 );
		
		Student s = new Student( "M M", "Inf.", 17, 2, 1990 );
		Osoba[] p = new Osoba[4];
		for (int i = 0; i < 3; i++)
			p[i] = staff[i];
		p[3] = s;
		for (Osoba per : p)
			System.out.println( per );
	}
}
