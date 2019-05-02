package rs.math.oop1.p060400.klaseMetodi.z05.tacke;

public class GeometrijaTest
{
	
	public static void main( String[] args )
	{
		Tacka a = new Tacka();
		a.x = 2;
		a.y = 3;
		a.oznaka = "A";
		a.prikaziSe();
		System.out.println();
		
		Tacka b = new Tacka();
		b.x = 10;
		b.y = 4;
		b.oznaka = "B";
		b.prikaziSe();
		System.out.println();
		
		double x = Math.sqrt( Math.pow( a.x - b.x, 2 ) + Math.pow( a.y - b.y, 2 ) );
		System.out.println(
				"Rastojanje od " + a.oznaka + " do " + b.oznaka + " je " + x );
				
	}
	
}
