package rs.math.oop1.p120101.enumerisaniTipDodatnoInfo.z01.godisnjaDoba;

import java.util.Scanner;

import static java.lang.System.*;

public class PokretanjeGodisnjaDoba {

    public static void main(String[] args)
    {
        out.println("Unesite naziv godisnjeg doba:");
        Scanner sc = new Scanner(in);
        try {
            String ulaz = sc.next().toUpperCase().trim();
            GodisnjeDoba gd = (GodisnjeDoba) Enum.valueOf( GodisnjeDoba.class, ulaz);
            out.println(gd);
        }
        finally {
            sc.close();
        }
    }
}
