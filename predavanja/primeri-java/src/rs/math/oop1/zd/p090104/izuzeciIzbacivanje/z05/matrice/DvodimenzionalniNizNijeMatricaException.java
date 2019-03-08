package rs.math.oop1.zd.p090104.izuzeciIzbacivanje.z05.matrice;

public class DvodimenzionalniNizNijeMatricaException extends Exception
{
	public DvodimenzionalniNizNijeMatricaException()
	{
		super();
	}
	
	@Override
	public String toString()
	{
		String s = super.toString();
		return "2D niz nije matrica. \n" + s;
	}
}
