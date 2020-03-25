package rs.math.oop1.z120500.generickiInterfejs.z03.zaposleni;

import rs.math.oop1.z090401.anonimneUnutrasnje.z02.zaposleniSortiranje.Employee;

import java.util.Arrays;
import java.util.Comparator;

public class EmployeeSortTest2 {
    public static void main(String[] args) {
        Employee[] staff = new Employee[4];

        staff[0] = new Employee("Harry Hacker", 35000);
        staff[1] = new Employee("Carl Cracker", 75000);
        staff[2] = new Employee("Tony Tester", 38000);
        staff[3] = new Employee("Johnny Bravo", 18000);

        System.out.println("-Pre sortiranja-");
        for (Employee e : staff)
            System.out.println(e);

        System.out.println("-Po imenu-");
        Arrays.sort(staff, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.getName().compareTo(e2.getName());
            }
        });
        for (Employee e : staff)
            System.out.println(e);

        System.out.println("-Po imenu obratno-");
        Arrays.sort(staff, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                   return - e1.getName().compareTo(e2.getName());
            }
        });
        for (Employee e : staff)
            System.out.println(e);

        System.out.println("-Po plati-");
        Arrays.sort(staff, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.getSalary() > o2.getSalary())
                    return -1;
                if (o1.getSalary() < o2.getSalary())
                    return 1;
                return 0;
            }
        });
        for (Employee e : staff)
            System.out.println(e);

        // Zasad ovo nismo detaljno objasnili - ali radi :)
        System.out.println("-Po imenu obratno (lambda)-");
        Arrays.sort(staff, (e1, e2) ->
                e2.getName().compareTo(e1.getName()) );
        for (Employee e : staff)
            System.out.println(e);

    }
}
