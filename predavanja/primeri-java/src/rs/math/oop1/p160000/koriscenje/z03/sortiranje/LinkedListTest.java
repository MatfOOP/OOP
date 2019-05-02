package rs.math.oop1.p140000.koriscenje.z03.sortiranje;

import java.util.*;

public class LinkedListTest {
    public static void main(String[] args) {
        List<String> a = new LinkedList<String>();
        a.add("Erica");
        a.add("Amy");
        a.add("Carl");
        a.add(2, "Bob");
        a.add(1, "Damir");
        System.out.println(a);

        Collections.sort(a);
        System.out.println(a);

        Collections.sort(a, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s2.compareTo(s1);
            }
        });
        System.out.println(a);

    }
}
