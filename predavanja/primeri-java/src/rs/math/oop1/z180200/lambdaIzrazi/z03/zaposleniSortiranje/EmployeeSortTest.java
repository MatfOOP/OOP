package rs.math.oop1.z180200.lambdaIzrazi.z03.zaposleniSortiranje;

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
        Arrays.sort(staff, (x, y) -> x.getName().compareTo(y.getName()));
        for (Employee e : staff)
            System.out.println("name=" + e.getName() + ",salary=" + e.getSalary());

        System.out.println("-Po plati-");
        Arrays.sort(staff, (x, y) -> (int) (x.getSalary() - y.getSalary()));
        for (Employee e : staff)
            System.out.println("name=" + e.getName() + ",salary=" + e.getSalary());
    }
}
