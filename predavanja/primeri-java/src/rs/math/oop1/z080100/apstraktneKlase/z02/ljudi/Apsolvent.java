package rs.math.oop1.z080100.apstraktneKlase.z02.ljudi;

public class Apsolvent extends Student
{
  int brojRokovaDoIstekaStaza;
  
  @Override
  void predstaviSe()
  {
    System.out.println("Apsolvent: " 
      + ime + " " + prezime + " " 
      + smer +" " + brojIndeksa + " "
      + godinaStudija + " "
      + brojRokovaDoIstekaStaza + ".");
  }
}
