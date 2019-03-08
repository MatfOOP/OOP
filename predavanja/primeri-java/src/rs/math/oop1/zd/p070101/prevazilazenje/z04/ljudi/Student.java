package rs.math.oop1.zd.p070101.prevazilazenje.z04.ljudi;

class Student
{
  String ime;
  String prezime;
  String smer;
  String brojIndeksa;
  int godinaStudija;

  void predstaviSe()
  {
    System.out.println("Student: " 
      + ime + " " + prezime + ", " 
      + smer +" " + brojIndeksa + " "
      + godinaStudija + ".");
  }
}