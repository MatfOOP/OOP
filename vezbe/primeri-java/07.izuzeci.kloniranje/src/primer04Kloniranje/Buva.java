package primer04Kloniranje;

public class Buva extends Zivotinja implements Cloneable {

    private String ime;
    private String podvrsta;


    public Buva(String ime, String podvrsta )
    {
        super("Buva");
        this.ime = ime;
        this.podvrsta = podvrsta;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getIme() {
        return this.ime;
    }

    public String getPodvrsta() {
        return this.podvrsta;
    }

    public void zvuk() {
        System.out.println("Psst!");
    }

    public String toString() {
        return super.toString() + " - " + this.ime + ", " + this.podvrsta;
    }

    // Predefinisanje nasledjenog metoda clone() da bismo ga ucinili public
    // Ukoliko zelimo da naznacimo da metod moze da izbaci neki izuzetak, to
    // radimo tako sto navedemo kljucnu rec "throws" koju prati izuzetak koji
    // moze biti bacen (ukoliko metod moze da baci vise izuzetaka, oni se navode
    // redom, razdvojeni zarezima ili mozemo da objedinimo sve izuzetke i samo 
    // napisati "throws Exception"). 

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    // Zasto ovde naglasavamo da metod izbacuje izuzetak dok to nismo radili
    // u prethodnim primerima?  
    // Na primer, u vezbe/primeri-java/07.izuzeci.kloniranje/src/primer03VisestrukiCatchIzuzeci/Primer01.java
    // svi izuzeci koji su bili hvatani nastajali su u toku izvrsavanja. Ovakvi
    // izuzeci svi pripadaju superklasi RuntimeException koja moze da bude 
    // obradjivana bez throws klauze.
    // Za obican Exception kompajler ce prijaviti gresku ako nemamo 
    // obradu odmah ili propagiramo sa throws klauzulom
    // Posto izuzetak ne obradjujemo odmah u metodu, moramo ga propagirati. 

}
