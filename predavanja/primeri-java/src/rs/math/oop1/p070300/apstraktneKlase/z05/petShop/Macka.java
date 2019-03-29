package rs.math.oop1.p070300.apstraktneKlase.z05.petShop;

public class Macka extends Sisar
{
	
	public Macka( String ime, String klasifikacijaLine,
			double ocekivanaStarostGod, double trudnocaTrajeGod, double tezinaBebeKg )
	{
		super( ime, klasifikacijaLine, ocekivanaStarostGod, trudnocaTrajeGod,
				tezinaBebeKg );
	}
	
	@Override
	public int brojNogu()
	{
		return 4;
	}
	
	@Override
	public int[] naciniKretanja()
	{
		int[] nacini = new int[3];
		nacini[0] = NacinKretanja.Hodanje;
		nacini[1] = NacinKretanja.Skakanje;
		nacini[2] = NacinKretanja.Trcanje;
		return nacini;
	}
	
}
