package rs.math.oop1.p090100.apstraktneKlase.z02.ljudi;

/**
 * 
 * Program ilustruje koncept polimorfizma i apstraktnih klasa.
 *
 */
public class LjudiMain2
{
	
	public static void main( String[] args )
	{
		Apsolvent marko = new Apsolvent();
		marko.ime = "Marko";
		marko.prezime = "Markovic";
		marko.smer = "R smer";
		marko.brojIndeksa = "12/2008";
		marko.godinaStudija = 4;
		marko.brojRokovaDoIstekaStaza = 5;
		
		Student janko = new Student();
		janko.ime = "Janko";
		janko.prezime = "Jankovic";
		janko.smer = "I smer";
		janko.brojIndeksa = "12/2012";
		janko.godinaStudija = 3;
		
		Nastavnik milica = new Nastavnik();
		milica.ime = "Milica";
		milica.prezime = "Jankovic";
		milica.predmet = "OOP";
		milica.godinaStaza = 12;
		
		//Nastavnik perica = new Nastavnik();
		//perica.ucitajSe();
		
//		marko.predstaviSe();
//		janko.predstaviSe();
//		milica.predstaviSe();

		Covek c = marko;
		c.predstaviSe();
		c =janko;
		c.predstaviSe();
		c = milica;
		c.predstaviSe();
		
//		Covek[] niz = { marko, janko, milica };
//		for (int i = 0; i < niz.length; i++)
//		{
//			niz[i].predstaviSe();
//		}
//
	}
	
}
