package primer01Covek;


//Zelimo da napravimo klasu Covek koja ce predstavljati coveka za koga zelimo da dodamo
//funkcionalnost da zna da prica srpski jezik, i da zna da prica engleski jezik
//To cemo uraditi tako sto cemo napraviti INTERFEJSE za srpski i za engleski jezik
public class Main {

	public static void main(String[] args) {
		Covek c = new Covek("Petar", "Sojic", 25);
		c.zdravo();
		c.hello();

		// Promenljiva 'c' referiše na objekat klase 'Covek',
		// ali je možemo kastovati u interfejs 'SrpskiJezik',
		// jer klasa 'Covek' implementira taj interfejs.
		// Time omogućavamo POLIMORFNO izvršavanje metoda definisanih u interfejsu,
		// dok korisnik ne mora da brine o tačnoj klasi objekta – dovoljno je da zna
		// koje metode interfejs pruža.
		SrpskiJezik sj = c;
		sj.dovidjenja();
		sj.hvala();
		
		EngleskiJezik ej = c;
		ej.goodbye();
		ej.hello();
		
		if (c instanceof SrpskiJezik)
			System.out.println("Klasa Covek implementira interfejs SrpskiJezik");
		if (c instanceof EngleskiJezik)
			System.out.println("Klasa Covek implementira interfejs EngleskiJezik");
	}

}
