package primer03IzrazKloniranje;

// BinarnaOperacija je klasa koja ima dva izraza, levi i desni.
// Ona je apstraktna i nece implementirati apstraktnu metodu izracunaj() i klon()
// iz klase Izraz, vec ce to odloziti svojim podklasama.
public  abstract class BinarnaOperacija extends Izraz {
	private Izraz levi, desni;

	// Konstruktor koji dobija levi i desni izraz
	// podrazumevamo da nece zeleti da referencira na njih
	// vec da zelimo da promene sa klasom ne uticu na inicijalne izrace
	// i zato cemo koristiti klonove tih izraza
	public BinarnaOperacija(Izraz levi, Izraz desni) {
		// Umesto this.levi = levi
		// koristimo polimorfnu funkciju 'klon' koja pravi
		// kopiju prosledjenog objekta.
		this.levi = levi.klon();
		this.desni = desni.klon();
	}
	
	public Izraz getLevi() {
		return levi;
	}
	
	public Izraz getDesni() {
		return desni;
	}
}
