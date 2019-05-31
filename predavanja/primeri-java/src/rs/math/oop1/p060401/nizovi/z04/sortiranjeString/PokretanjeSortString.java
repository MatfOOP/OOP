package rs.math.oop1.p060401.nizovi.z04.sortiranjeString;

import java.util.Arrays;

public class PokreniSortString {

    public static void main(String[] args) {
        String[] niz2 = {"23", "-7", "5", "54", "6", "4", "34", "-23"};
        for (String x : niz2)
            System.out.print(x + " ");
        System.out.println();

        Arrays.sort(niz2);

        for (String x : niz2)
            System.out.print(x + " ");
        System.out.println();
    }

}
