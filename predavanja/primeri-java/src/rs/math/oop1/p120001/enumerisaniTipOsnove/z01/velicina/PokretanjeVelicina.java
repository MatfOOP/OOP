package rs.math.oop1.p120001.enumerisaniTipOsnove.z01.velicina;

enum Velicina {XS, S, M, L, XL}

public class PokretanjeVelicina {
    public static void main(String[] args) {

        Velicina v = Velicina.L;
        System.out.println(v);
        v = Velicina.M;
        System.out.println(v);
    }
}
