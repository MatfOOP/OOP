package primer01Covek;

/*Apstraktne klase vs interfejsi:

Apstraktne klase mogu imati i apstraktne (bez implementacije) i konkretne (sa implementacijom) metode,
kao i atribute. Koriste se kada želimo da definišemo osnovno ponašanje koje će biti
delimično isto za sve podklase. Klasa može naslediti samo jednu apstraktnu klasu (single inheritance).

Interfejsi sadrže samo apstraktne metode (do Jave 8), dok od Jave 8 mogu imati i podrazumevane (default)
metode sa implementacijom. Klasa može implementirati više interfejsa, što omogućava višestruko
nasleđivanje ponašanja (multiple inheritance putem interfejsa).

Apstraktne klase – kada postoji zajednička implementacija koju će deliti sve podklase.
Interfejsi – kada želimo samo specifikaciju ponašanja koje različite klase mogu implementirati na svoj način.
*/
public interface EngleskiJezik {
	void hello();
	void goodbye();
	void thanks();
}
