// Пример илуструје различите начине за декларисање променљивих.

package rs.math.oop1.p060101.definicijaKlase.z01.knjige;

public class PokretanjeKnjige {

    public static void main(String[] args) {
        // deklaracija jedne promenljive
        Knjiga k;

        k = new Knjiga();
        k.autor = "Petar Petrović Njegoš";
        k.godinaIzdavanja = 1976;
        k.naslov = "Gorski vijenac";
    }
}
