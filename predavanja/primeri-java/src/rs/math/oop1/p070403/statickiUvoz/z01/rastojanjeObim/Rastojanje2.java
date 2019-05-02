package rs.math.oop1.p070403.statickiUvoz.z01.rastojanjeObim;

import java.util.*;

import static java.lang.Math.*;

import static java.lang.System.*;

public class Rastojanje2 {

    static double rastojanje(double x1, double y1, double x2, double y2) {
        return sqrt(pow(x2 - x1, 2) + pow(y2 - y1, 2));
    }

    static double obimKruga(double poluprecnik) {
        return 2 * poluprecnik * PI;
    }

    public static void main(String[] args) {
        Scanner ulaz = new Scanner(in);
        out.println("Koordinate prve tacke");
        double x1 = ulaz.nextDouble();
        double y1 = ulaz.nextDouble();
        out.println("Koordinate druge tacke");
        double x2 = ulaz.nextDouble();
        double y2 = ulaz.nextDouble();
        out.println("Rastojanje između tačaka");
        out.println(rastojanje(x1, y1, x2, y2));
        out.println("Obim kruga čiji je prečnik određen datim tačkama");
        out.println(obimKruga(rastojanje(x1, y1, x2, y2) / 2));
        ulaz.close();
    }

}
