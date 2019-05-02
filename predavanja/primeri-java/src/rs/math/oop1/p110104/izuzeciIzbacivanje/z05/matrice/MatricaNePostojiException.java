package rs.math.oop1.p110104.izuzeciIzbacivanje.z05.matrice;

public class MatricaNePostojiException extends Exception
{	
	@Override
	public String toString()
	{
		String s = super.toString();
		return "Izuzetak nepostojece matrice. \n" + s;
	}
}
