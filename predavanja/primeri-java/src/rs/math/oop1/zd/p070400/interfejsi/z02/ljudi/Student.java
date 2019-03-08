package rs.math.oop1.zd.p070400.interfejsi.z02.ljudi;

/**
 * Klasa <code> Student </code> opisuje Studenta
 * 
 * 
 * @author vlado
 *
 */
class Student extends Covek implements Deskripcija, Kvalitet
{
	String smer;
	String brojIndeksa;
	int godinaStudija;
	int dobrota = 95;
	int postenje = 90;
	
	public void predstaviSe()
	{
		System.out.println( "Student: " + ime + " " + prezime + " " + smer + " "
				+ brojIndeksa + " " + godinaStudija + "." );
	}
	
	public int jeDobar()
	{
		return dobrota;
  }
	
	public int jePosten()
	{
		return postenje;
	}
	
}