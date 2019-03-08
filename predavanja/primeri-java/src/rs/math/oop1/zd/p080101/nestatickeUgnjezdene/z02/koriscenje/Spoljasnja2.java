package rs.math.oop1.zd.p080101.nestatickeUgnjezdene.z02.koriscenje;

public class Spoljasnja2
{
	private int j = 24;
	
	public void uvecajKodUnutrasnje()
	{
		Unutrasnja u = new Unutrasnja();
		u.i ++;
		System.out.println( u );
	}
	
	public class Unutrasnja
	{
		private int i = 12;
		
		
		public Unutrasnja()
		{
		}
		
		public Unutrasnja(int i)
		{
			this.i = i;
		}
		
		@Override
		public String toString()
		{
			return "i = " + i + ", j=" + j;
		}
	}
	
	
}
