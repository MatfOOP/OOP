package rs.math.oop1.p060401.nizovi.z02.sortiranjeInt;

import java.util.Arrays;

public class PokreniSortInt {

    public static void main(String[] args) {
        int[] niz = {23, -7, 5, 6, 4, 34, -23};
        for (int x : niz)
            System.out.print(x + " ");
        System.out.println();

        Arrays.sort(niz);

        for (int x : niz)
            System.out.print(x + " ");
        System.out.println();

    }

}
