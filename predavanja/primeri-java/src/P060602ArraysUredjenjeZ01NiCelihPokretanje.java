import java.util.Arrays;

public class P060602ArraysUredjenjeZ01NiCelihPokretanje {

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
