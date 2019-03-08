package rs.math.oop1.zd.p060602.klasniInicijalizacioniBlok.z01.tacke;

public class InicBlokTest {

    public static void main(String[] args) {

        Tacka tac1 = new Tacka();
        tac1.x = 2;
        tac1.y = 3;
        tac1.oznaka = "S";
        Tacka[] niz = {tac1, new Tacka(), new Tacka()};

        Tacka a = new Tacka();
        a.x = 45;
        a.y = 7;
        a.oznaka = "A";
        niz[0] = a;
        for (Tacka t : niz)
            t.prikaziSe();
        a.prikaziSe();
        System.out.println();
        System.out.println(Tacka.brojKreiranih);
    }

}
