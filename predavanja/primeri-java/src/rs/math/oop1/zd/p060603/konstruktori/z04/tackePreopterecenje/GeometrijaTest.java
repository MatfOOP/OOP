package rs.math.oop1.zd.p060603.konstruktori.z04.tackePreopterecenje;

public class GeometrijaTest
{
	
	/**
	 * @param args
	 */
	public static void main( String[] args )
	{
		Tacka a = new Tacka( 2, 3, "A" );
		a.prikaziSe();
		System.out.println();
		
		Tacka b = new Tacka();
		b.prikaziSe();
		System.out.println();
		
		double x = Math.sqrt( Math.pow( a.x - b.x, 2 ) + Math.pow( a.y - b.y, 2 ) );
		System.out.println(
				"Rastojanje od " + a.oznaka + " do " + b.oznaka + " je " + x );
		System.out.println(
				"Rastojanje od " + a.oznaka + " do " + b.oznaka + " je " + 
		    a.rastojanje( b ) );
				
	}
	
}
