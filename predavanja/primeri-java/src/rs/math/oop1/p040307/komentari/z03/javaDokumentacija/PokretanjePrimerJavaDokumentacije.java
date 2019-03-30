package rs.math.oop1.p040307.komentari.z03.javaDokumentacija;


public class PokreniJavaDokumentacija
{

	/**
	 * Полазна тачка при извршавању Јава програма
	 * @param args
	 */
	public static void main( String[] args )
	{
		ProbaImplemenetacija p = new ProbaImplemenetacija();
		ProbaInterfejs ip = p;
		
		System.out.printf("%.3f\n",702.42345);
		System.out.println(ProbaInterfejs.NULA);
		System.out.println(ip.NULA);
	}
	
}
