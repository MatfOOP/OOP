package primer02Izraz;

// BinarnaOperacija je klasa koja ima dva izraza, levi i desni.
// Ona je apstraktna i nece implementirati apstraktnu metodu izracunaj()
// iz klase Izraz, vec ce to odloziti svojim podklasama.
public abstract class BinarnaOperacija extends Izraz {
	private Izraz levi, desni;
	
	public BinarnaOperacija(Izraz levi, Izraz desni) {
		this.levi = levi;
		this.desni = desni;
	}
	
	public Izraz getLevi() {
		return levi;
	}
	
	public Izraz getDesni() {
		return desni;
	}
}
