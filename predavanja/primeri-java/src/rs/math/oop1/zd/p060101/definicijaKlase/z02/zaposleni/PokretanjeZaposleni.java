package rs.math.oop1.zd.p060101.definicijaKlase.z02.zaposleni;

class Zaposleni {
    String imePrezime;
    double plata;
}

public class PokretanjeZaposleni {
    public static void main(String[] args) {
        // fill the staff array with three Employee objects
        Zaposleni e = new Zaposleni();
        e.imePrezime = "Carl Cracker";
        e.plata = 75000;

        System.out.println("Inicijalno");
        System.out.println("ime i prezime=" + e.imePrezime + ", plata=" + e.plata);

        e.plata += 5000;

        System.out.println("Posle povisice");
        System.out.println("ime i prezime=" + e.imePrezime + ", plata=" + e.plata);
    }
}

