package rs.math.oop1.zd.p140602.katalozi.z02.drvoKatalog;

import java.util.*;

public class MapTest2 {
    public static void main(String[] args) {
        SortedMap<String, Employee2> staff = new TreeMap<>();
        staff.put("927-25-5464", new Employee2("Miki Maus", 10));
        staff.put("144-25-5464", new Employee2("Amy Lee", 10));
        staff.put("567-24-2546", new Employee2("Harry Hacker", 20));
        staff.put("157-62-7935", new Employee2("Gary Cooper", 100));
        staff.put("456-62-5527", new Employee2("Francesca Cruz"));

        // print all entries
        System.out.println(staff);
        System.out.println();

        SortedMap<String, Employee2> staff2 = new TreeMap<>(
                new Comparator<String>() {

                    @Override
                    public int compare(String o1, String o2) {
                        return o1.length();
                    }
                }
        );

    }
}

/**
 * A minimalist employee class for testing purposes.
 */
class Employee2 {

    public Employee2(String n, double salary) {
        name = n;
        this.salary = salary;
    }

    public Employee2(String n) {
        this(n, 0);
    }

    public String toString() {
        return "[name=" + name + ", salary=" + salary + "]\r\n";
    }

    private String name;
    private double salary;
}
