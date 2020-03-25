package rs.math.oop1.z080100.apstraktneKlase.z01.fakultet;

public abstract class Covek {

    private String ime = "";
    private String prezime = "";
    private String nadimak;

    public Covek(String ime, String prezime, String nadimak) {
        this.ime = ime;
        this.prezime = prezime;
        this.nadimak = nadimak;
    }

    public Covek(String ime, String prezime) {
        this.ime = ime;
        this.prezime = prezime;
    }

    public String vratiIme() {

        return ime;
    }

    public void postaviIme(String ime) {

        this.ime = ime;
    }

    public String vratiPrezime() {

        return prezime;
    }

    public void postaviPrezime(String prezime) {

        this.prezime = prezime;
    }

    public String vratiNadimak() {

        return nadimak;
    }

    public void postaviNadimak(String nadimak) {

        this.nadimak = nadimak;
    }

    public abstract void prikazi();

}