package rs.math.oop1.p070502.prevazilazenje.z04.ljudi;

class Nastavnik
{
  String ime;
  String prezime;
  String predmet;
  int godinaStaza;

  void predstaviSe()
  {
    System.out.println("Nastavnik: " 
      + ime + " " + prezime + " " 
      + predmet +" " + godinaStaza + ".");
  }
}