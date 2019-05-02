package rs.math.oop1.p090301.uredjenje.z01.zaposleni;

import java.util.Arrays;

public class Sortiranje {

    public static void main(String[] args) {
        int[] a = {-2, 3, 5, 7, -10, 11};
        Arrays.sort(a);
        for(int x: a)
            System.out.print(x + " ");
        System.out.println();

        String[] b = {"-2", "3", "5", "7", "-10", "11"};
        Arrays.sort(b);
        for(String x: b)
            System.out.print(x + " ");
        System.out.println();
        Integer[] c = {-2, 3, 5, 7, -10, 11};
        Arrays.sort(c);
        for(int x: c)
            System.out.print(x + " ");
        System.out.println();
        Double[] d = {-2.0, 3.8, 5.7, 7.3, -10.5, 11.4};
        Arrays.sort(d);
        for(double x: d)
            System.out.print(x + " ");
        System.out.println();

    }
}
