package rs.math.oop1.p140800.strukturisanje.z01.samorastuciNiz;

import java.lang.reflect.Array;

public class SamorastuciNiz<E>
{
	private E[] elementi;

	public SamorastuciNiz(int inicijalnaDimenzija)
	{
		Object noviNiz = Array.newInstance( E.class, inicijalnaDimenzija );
		elementi = (E[])noviNiz;
	}
}
