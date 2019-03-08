package rs.math.oop1.zd.p080400.anonimneUnutrasnje.z01.koriscenje;

public class AnonimnaUnutrasnja
{
	
	private int j = 24;
	
	@Override
	public String toString()
	{
		return "Prikaz (spolja) " + j 
				+ "(unutra)" +  
		(new Object()
		{
			// Detalji unutrasnje klase ...
			private int i = 12;
			
			@Override
			public String toString()
			{
				return "(unutra) i = " + i + ", j=" + j;
			}
		});
	}
	
	public static void main( String[] args )
	{
		AnonimnaUnutrasnja sp = new AnonimnaUnutrasnja();
		System.out.println( sp );
	}
	
}
