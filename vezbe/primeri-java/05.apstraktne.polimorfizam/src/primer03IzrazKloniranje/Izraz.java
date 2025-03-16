package primer03IzrazKloniranje;


// Apstraktna klasa izraz koja ima, kao u proslom primeru,
// apstraktnu metodu izracunaj, ali sada dodajemo i apstraktnu metodu klon.
// Zasto je ovo dobra praksa?
// Zamislimo da imamo implementirane settere za klasu Broj na primer
// i da imamo sledeci kod: Izraz i1 = new Broj(5); Izraz i2 = i1; i2.setVrednost(2);
// Ove tri komande bi dovele do toga da i1 i i2 imaju vrednost 2 na kraju, a to nije nuzno ono sto zelimo.
// Da bismo mogli to da prevazidjemo, druga komanda bi bila promenjena na Izraz i2 = i1.klon();
// Tada bi ova dva izraza imala razlicite vrednosti na kraju.
public abstract class Izraz {
	public abstract double izracunaj();
	
	// Namecemo apstraktan metod koji ce klase hijerarhije
	// 	implementirati tako da vrate referencu na svoju kopiju.
	// Na ovaj nacin resavamo problem da kada imamo referencu na baznu klasu
	//  (iako je u stvari to objekat neke podklase) ipak mozemo izvrsiti kopiranje.
	public abstract Izraz klon();
}
