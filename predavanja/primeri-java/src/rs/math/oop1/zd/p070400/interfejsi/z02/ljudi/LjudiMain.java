package rs.math.oop1.zd.p070400.interfejsi.z02.ljudi;

/**
 * 
 * Program ilustruje koncept nasleđivanja i interfejsa.
 *
 */
public class LjudiMain
{
	
	public static void main( String[] args )
	{
		Papagaj koko = new Papagaj();
		koko.predstaviSe();
    Deskripcija d0 = koko;
    d0.predstaviSe();
		
		Student marko = new Student();
		marko.ime = "Marko";
		marko.prezime = "Markovic";
		marko.smer = "I smer";
		marko.brojIndeksa = "12/2009";
		marko.godinaStudija = 3;
		marko.dobrota = 75;
		
		Student janko = new Student();
		janko.ime = "Janko";
		janko.prezime = "Jankovic";
		janko.smer = "I smer";
		janko.brojIndeksa = "12/2010";
		janko.godinaStudija = 3;
		janko.postenje = 99;
		
		Nastavnik milica = new Nastavnik();
		milica.ime = "Milica";
		milica.prezime = "Jankovic";
		milica.predmet = "OOP";
		milica.godinaStaza = 12;
		 
		
		marko.predstaviSe();
		Deskripcija d = marko;
		d.predstaviSe();
		Kvalitet k = marko;
		System.out.println( "dob: " + k.jeDobar() + " pos:" + k.jePosten() );
		
		janko.predstaviSe();
		((Deskripcija) janko).predstaviSe();
		System.out.println( "dob: " + ((Kvalitet) janko).jeDobar() + " pos:"
				+ ((Kvalitet) janko).jePosten() );
		
		milica.predstaviSe();
		((Deskripcija) milica).predstaviSe();
		System.out.println( "dob: " + ((Kvalitet) milica).jeDobar() + " pos:"
				+ ((Kvalitet) milica).jePosten() );
		
	}
	
}
