package z_dodatno01SingletonPattern;

public class Main {

	// Cesto se susrećemo sa situacijama kada želimo da osiguramo da postoji samo jedna instanca određene klase tokom izvršavanja programa.
	// Na primer, kada radimo sa logovanjem, konfiguracionim podešavanjima, konekcijama ka bazi podataka ili keširanjem, ne želimo da svaki deo koda kreira svoj novi objekat, već da svi koriste isti, zajednički objekat.
	//
	// Ovde na scenu stupa Singleton patern – dizajnerski obrazac koji garantuje da klasa ima samo jednu instancu i pruža globalnu tačku pristupa toj instanci.
	//
	// Kako Singleton radi?
	//
	// Sprečavamo spoljašnje klase da direktno kreiraju instancu (privatnim konstruktorom).
	// Čuvamo referencu na jedinu instancu u okviru statičkog atributa.
	// Koristimo javnu statičku metodu za vraćanje te instance.
	// U sledećem primeru ćemo demonstrirati Singleton patern kroz implementaciju jednostavnog Logger sistema.
	// Cilj je da obezbedimo da svi delovi programa koriste isti objekat za beleženje poruka i tako izbegnemo dupliranje podataka.

	public static void main(String[] args) {
		Logger.get().logInfoMsg("Hello, welcome to the world of design patterns!");

		Logger.get().logWarningMsg("Be warned, it's really a cool thing, this design patterns!");
		Logger.get().logWarningMsg("And you should really study them and try applying them in you projects!");
		
		Logger.get().logErrorMsg("Don't be discouraged if you encounter some error along the way.");
		Logger.get().logInfoMsg("It simply means you are learning new things, which is always cool!");

		Logger.get().logWarningMsg("While you should know how to implement a logger, you should prefer "
				+ "using some time tested class that's already implemented instead of reinventing the wheel :)");
		
		Logger.get().logInfoMsg("Fasten your seat belt and good luck on your ride!");
		
		System.out.println("\n\nFull log:\n" + Logger.get().getFullLogData());
	}

}
