package rs.math.oop1.p060903.objekti.z01;

public class PokreniEmployee {
    public static void main(String[] args) {

        Employee e1 = new Employee("Carl Cracker", 1, 75000);
        Employee e2 = new Employee("Harry Hacker", 2, 50000);
        Employee e3 = new Employee("Harry Hacker", 3, 40000);
        Employee e4 = new Employee("Carl Cracker", 1, 75000);
        Employee[] staff = { e1, e2, e3, e4, e1 };
        System.out.println("Elementi niza zaposlenih");
        for (Employee e : staff)
            System.out.println(e);
        System.out.println("==");
        for (int i = 0; i < staff.length; i++)
            for (int j = i + 1; j < staff.length; j++)
                System.out.printf("Poredimo sa == %d-ti i %d-ti: %s\n", i, j, staff[i] == staff[j]);
        System.out.println(".equals()");
        for (int i = 0; i < staff.length; i++)
            for (int j = i + 1; j < staff.length; j++)
                System.out.printf("Poredimo sa equals %d-ti i %d-ti: %s\n", i, j, staff[i].equals(staff[j]));
        System.out.println("HesKodovi niza zaposlenih");
        for (Employee e : staff)
            System.out.println(e.hashCode());

    }
}
