package rs.math.oop1.p090200.interfejsi.z02.ljudi;

class Nastavnik extends Covek implements Deskripcija, Kvalitet
{
  String predmet;
  int godinaStaza;

  public void predstaviSe()
  {
    System.out.println("Nastavnik: " 
      + ime + " " + prezime + " " 
      + predmet +" " + godinaStaza + ".");
  }

	@Override
	public int jeDobar()
	{
		return 100;
	}

	@Override
	public int jePosten()
	{
		return 100;
	}
}