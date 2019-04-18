package rs.math.oop1.p070300.apstraktneKlase.z01.fakultet;

public abstract class Covek {

    private String ime = "";
    private String prezime = "";
    private String nadimak;

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

    public String getPrezime() {

        return prezime;
    }

    public void setPrezime(String prezime) {

        this.prezime = prezime;
    }

    public abstract void prikazi();

    public String getNadimak() {
       return nadimak;
    }

    public void setNadimak(String nadimak) {
       this.nadimak = nadimak;
    }
}