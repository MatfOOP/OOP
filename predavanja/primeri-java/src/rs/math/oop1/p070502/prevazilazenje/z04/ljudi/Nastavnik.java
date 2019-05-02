package rs.math.oop1.p070101.prevazilazenje.z04.ljudi;

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