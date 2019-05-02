package rs.math.oop1.p070300.apstraktneKlase.z02.ljudi;

/**
 * 
 * Program ilustruje koncept nasleđivanja i apstraktnih klasa.
 *
 */
public class LjudiMain
{

  public static void main(String[] args)
  {
    Student marko = new Student();
    marko.ime = "Marko";
    marko.prezime = "Markovic";
    marko.smer = "I smer";
    marko.brojIndeksa = "12/2009";
    marko.godinaStudija = 3;
    
    Student janko = new Apsolvent();
    janko.ime = "Janko";
    janko.prezime = "Jankovic";
    janko.smer = "I smer";
    janko.brojIndeksa = "12/2010";
    janko.godinaStudija = 3;
 
    
    Nastavnik milica = new Nastavnik();
    milica.ime = "Milica";
    milica.prezime = "Jankovic";
    milica.predmet = "OOP";
    milica.godinaStaza = 12;
    
    marko.predstaviSe();
    janko.predstaviSe();
    milica.predstaviSe();
  }

}
