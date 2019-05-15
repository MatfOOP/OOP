package rs.math.oop1.p130602.strukturisanjePodataka.z01.samorastuciNiz;

public class SamorastuciNiz<E>
{
	private int uvecanjeDimenzije = 10;
	private E[] elementi;

	public SamorastuciNiz(int inicijalnaDimenzija, int uvecanjeDimenzije)
	{
		elementi = (E[])new Object[inicijalnaDimenzija];
		this.uvecanjeDimenzije = uvecanjeDimenzije;
	}

	public SamorastuciNiz(){
		this(10, 10);
	}

	public E naPoziciji(int indeks) throws IndexOutOfBoundsException
	{
		if( indeks < 0 || indeks >= elementi.length)
			throw new IndexOutOfBoundsException();
		return elementi[indeks];
	}

	private void obezbediKapacitetPomocni(int noviKapacitet)
	{
		if(noviKapacitet > elementi.length)
		{
			E[] noviNiz = (E[])new Object[noviKapacitet];
			for(int i=0;i<elementi.length; i++)
				noviNiz[i] = elementi[i];
			elementi = noviNiz;
		}
	}

	public void postaviNaPoziciju(E element, int indeks) throws IndexOutOfBoundsException {
		if (indeks < 0)
			throw new IndexOutOfBoundsException();
		if( indeks >= elementi.length) {
			obezbediKapacitetPomocni(indeks+uvecanjeDimenzije);
		}elementi[indeks] = element;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		for(int i=0; i< elementi.length; i++){
			if( i % 10 == 0)
				sb.append("\r\n");
			sb.append(elementi[i] + "\t" );
		}
		return sb.toString();
	}
}
