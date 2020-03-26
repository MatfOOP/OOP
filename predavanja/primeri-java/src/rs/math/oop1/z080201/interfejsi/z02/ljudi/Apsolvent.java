package rs.math.oop1.z080201.interfejsi.z02.ljudi;

/**
 * Klasa Apsolvent opisuje apsolventa
 * 
 * Natklasa klase Student
 * 
 * @see Student
 * 
 * @author vlado
 *
 */

class Apsolvent extends Student 
{
  int brojRokovaDoIstekaStaza;

  public Apsolvent(String smer, String brojIndeksa, int godinaStudija, int dobrota, int postenje,
  int brojRokovaDoIstekaStaza) {
    super(smer, brojIndeksa, godinaStudija, dobrota, postenje);
    this.brojRokovaDoIstekaStaza = brojRokovaDoIstekaStaza;
  }

  /**
   * Metod predstaviSe() prikazuje na standardnom izlazu
   * 
   */
  
  @Override
  public void predstaviSe()
  {
    System.out.println("Apsolvent: " 
      + ime + " " + prezime + " " 
      + smer +" " + brojIndeksa + " "
      + godinaStudija 
      + brojRokovaDoIstekaStaza + ".");
  }
  
  @Override
  public int jeDobar()
  {
  	return dobrota - 10;
  }
  
}
