package rs.math.oop1.zd.p060906.nizovi.z03.sortiranjeDouble;

import java.util.Arrays;

public class PokreniSortDouble {

    public static void main(String[] args) {
        double[] niz = {23.5, -7.6, 5.0, 6, 4, 34.34, -23};
        for (double x : niz)
            System.out.print(x + " ");
        System.out.println();

        Arrays.sort(niz);

        for (double x : niz)
            System.out.print(x + " ");
        System.out.println();

    }

}
