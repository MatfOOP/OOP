package rs.math.oop1.p090303.kloniranje.z02.zaposleni;

import java.util.*;

public class PokreniKloniranje {
    public static void main(String[] args) {
        try {
            Employee original = new Employee("John Q. Public", 50000);
            original.setHireDay(2000, 1, 1);
            Employee copy = original.clone();
            System.out.println("Before changes");
            System.out.println("original=" + original);
            System.out.println("copy=" + copy);
            copy.raiseSalary(10);
            copy.setHireDay(2012, 12, 31);
            System.out.println("After changes");
            System.out.println("original=" + original);
            System.out.println("copy=" + copy);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}

class Employee implements Cloneable {
    private String name;
    private double salary;
    private Date hireDay;

    public Employee(String n, double s) {
        name = n;
        salary = s;
        hireDay = new Date();
    }

    @Override
    public Employee clone() throws CloneNotSupportedException {
        // clone mutable fields
        Date clonedDate = (Date) hireDay.clone();

        // call Object.clone()
        Employee cloned = (Employee) super.clone();

        // link mutable fields to clones
        cloned.hireDay = clonedDate;

        return cloned;
    }

    /**
     * Set the hire day to a given date.
     *
     * @param year  the year of the hire day
     * @param month the month of the hire day
     * @param day   the day of the hire day
     */
    public void setHireDay(int year, int month, int day) {
        Date newHireDay = new GregorianCalendar(year, month - 1, day).getTime();

        // Example of instance field mutation
        hireDay.setTime(newHireDay.getTime());
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public String toString() {
        return "Employee[name=" + name + ",salary=" + salary + ",hireDay="
                + hireDay + "]";
    }
}
