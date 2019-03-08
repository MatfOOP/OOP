package rs.math.oop1.zd.p080101.nestatickeUgnjezdene.z01.koriscenje;

public class Spoljasnja1
{
	private int j = 24;
	
	public class Unutrasnja
	{
		private int i = 12;
		
		@Override
		public String toString()
		{
			return "i = " + i + ", j=" + j;
		}
	}
	
}
