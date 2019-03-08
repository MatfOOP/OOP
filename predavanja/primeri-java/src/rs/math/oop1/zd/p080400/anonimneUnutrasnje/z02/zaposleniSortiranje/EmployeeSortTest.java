package rs.math.oop1.zd.p080400.anonimneUnutrasnje.z02.zaposleniSortiranje;

import java.util.*;

public class EmployeeSortTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[4];

        staff[0] = new Employee("Harry Hacker", 35000);
        staff[1] = new Employee("Carl Cracker", 75000);
        staff[2] = new Employee("Tony Tester", 38000);
        staff[3] = new Employee("Johnny Bravo", 18000);

        System.out.println("-Pre sortiranja-");
        for (Employee e : staff)
            System.out.println("name=" + e.getName() + ",salary=" + e.getSalary());

        System.out.println("-Po imenu-");
        Arrays.sort(staff, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (!(o1 instanceof Employee))
                    return 1;
                if (!(o2 instanceof Employee))
                    return -1;
                Employee e1 = (Employee) o1;
                Employee e2 = (Employee) o2;
                return e1.getName().compareTo(e2.getName());
            }
        });
        for (Employee e : staff)
            System.out.println("name=" + e.getName() + ",salary=" + e.getSalary());

        System.out.println("-Po imenu obratno-");
        Arrays.sort(staff, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (!(o1 instanceof Employee))
                    return 1;
                if (!(o2 instanceof Employee))
                    return -1;
                Employee e1 = (Employee) o1;
                Employee e2 = (Employee) o2;
                return e2.getName().compareTo(e1.getName());
            }
        });
        for (Employee e : staff)
            System.out.println("name=" + e.getName() + ",salary=" + e.getSalary());

        System.out.println("-Po plati-");
        Arrays.sort(staff, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (!(o1 instanceof Employee))
                    return 1;
                if (!(o2 instanceof Employee))
                    return -1;
                Employee e1 = (Employee) o1;
                Employee e2 = (Employee) o2;
                if (e1.getSalary() > e2.getSalary())
                    return -1;
                if (e1.getSalary() < e2.getSalary())
                    return 1;
                return 0;

            }
        });
        for (Employee e : staff)
            System.out.println("name=" + e.getName() + ",salary=" + e.getSalary());

    }
}
