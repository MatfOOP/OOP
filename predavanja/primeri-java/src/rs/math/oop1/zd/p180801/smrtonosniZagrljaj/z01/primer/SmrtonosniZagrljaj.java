package rs.math.oop1.zd.p180801.smrtonosniZagrljaj.z01.primer;

public class SmrtonosniZagrljaj
{
	static class Japanac
	{
		private final String name;
		
		public Japanac( String name )
		{
			this.name = name;
		}
		
		public String getName()
		{
			return this.name;
		}
		
		public synchronized void nakloniSe( Japanac kolega )
		{
			System.out.format( "%s: %s" + "  se naklonio!%n",
					this.name,
					kolega.getName() );
			kolega.uzvratiNaklon( this );
		}
		
		public synchronized void uzvratiNaklon( Japanac kolega )
		{
			System.out.format( "%s: %s" + " je uzvratio naklon!%n",
					this.name,
					kolega.getName() );
		}
	}
	
	public static void main( String[] args )
	{
		final Japanac katsuki = new Japanac( "Tacuaki Katsuki" );
		final Japanac honda = new Japanac( "Keisuke Honda" );
		new Thread( new Runnable()
		{
			public void run()
			{
				katsuki.nakloniSe( honda );
			}
		} ).start();
		new Thread( new Runnable()
		{
			public void run()
			{
				honda.nakloniSe( katsuki );
			}
		} ).start();
	}
}