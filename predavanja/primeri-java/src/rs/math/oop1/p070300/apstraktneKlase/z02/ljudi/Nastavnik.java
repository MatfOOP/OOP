package rs.math.oop1.p070300.apstraktneKlase.z02.ljudi;


class Nastavnik extends Covek
{
  String predmet;
  int godinaStaza;

  void predstaviSe()
  {
    System.out.println("Nastavnik: " 
      + ime + " " + prezime + " " 
      + predmet +" " + godinaStaza + ".");
  }
  
  void ucitajSe()
  {
  	java.util.Scanner ulaz = new java.util.Scanner( System.in );
  	System.out.print("Ime:");
  	ime = ulaz.next();
  	System.out.print("Prezime:");
  	prezime = ulaz.next();
  	System.out.print("Predmet:");
  	predmet = ulaz.next();
  	System.out.print("Staz:");
  	godinaStaza = ulaz.nextInt();
  	ulaz.close();
  }
}