package rs.math.oop1.zd.p060901.objekti.z02.zaposleniFinalizator;

import java.util.*;

class Employee {
    private int broj;
    private String name;
    private double salary;
    private Date hireDay;

    public Employee(String n, int br, double s,
                    int year, int month, int day) {
        name = n;
        broj = br;
        salary = s;
        GregorianCalendar calendar =
                new GregorianCalendar(year, month - 1, day);
        // GregorianCalendar uses 0 for January
        hireDay = calendar.getTime();
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Date getHireDay() {
        return hireDay;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    @Override
    public void finalize() {
        System.out.println("FINALIZUJEM!" + name + broj);
    }
}


public class EmployeeTest {
    public static void main(String[] args) {

        // fill the staff array with three Employee objects
        if (1 > 0) {
            Employee[] staff = new Employee[3];
            staff[0] = new Employee("Carl Cracker", 1, 75000, 2007, 12, 15);
            staff[1] = new Employee("Harry Hacker", 2, 50000, 2009, 10, 1);
            staff[2] = new Employee("Tony Tester", 3, 40000, 2010, 3, 15);
            for (Employee e : staff)
                System.out.println(e);
        }
        System.gc();
        for (int i = 0; i < 1_000; i++) {
            Employee[] staff = new Employee[3];
            staff[0] = new Employee("Carl Cracker", i, 75000, 2007, 12, 15);
            staff[1] = new Employee("Harry Hacker", i, 50000, 2009, 10, 1);
            staff[2] = new Employee("Tony Tester", i, 40000, 2010, 3, 15);
            if (i % 100 == 0)
                System.gc();
        }

    }
}


