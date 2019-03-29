package rs.math.oop1.p070101.prevazilazenje.z04.ljudi;

public class Apsolvent
{
  String ime;
  String prezime;
  String smer;
  String brojIndeksa;
  int godinaStudija;
  int brojRokovaDoIstekaStaza;
  
  void predstaviSe()
  {
    System.out.println("Apsolvent: " 
      + ime + " " + prezime + " " 
      + smer +" " + brojIndeksa + " "
      + godinaStudija + " "
      + brojRokovaDoIstekaStaza + ".");
  }
}
