package rs.math.oop1.z070702.modifikatoriPristupa.z02.zaposleni;

import java.util.Date;
import java.util.GregorianCalendar;

class Employee {
   private String name;
   private double salary;
   private Date hireDay;

   public Employee(String n, double s, int godina, int mesec, int dan) {
      name = n;
      salary = s;
      GregorianCalendar calendar = new GregorianCalendar(godina, mesec - 1, dan);
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
}

public class EmployeeTest {
   public static void main(String[] args) {
      // fill the staff array with three Employee objects
      Employee[] staff = new Employee[3];

      staff[0] = new Employee("Carl Cracker", 75000, 2007, 12, 15);
      staff[1] = new Employee("Harry Hacker", 50000, 2009, 10, 1);
      staff[2] = new Employee("Tony Tester", 40000, 2010, 3, 15);

      System.out.println("Before salary raise");
      for (Employee e : staff) {
         System.out.println("name=" + e.getName() + ",salary=" + e.getSalary()
               + ",hireDay=" + e.getHireDay());
      }

      for (Employee e : staff)
         e.raiseSalary(5);

      System.out.println("After salary raise");
      for (Employee e : staff) {
         System.out.println("name=" + e.getName() + ",salary=" + e.getSalary()
               + ",hireDay=" + e.getHireDay());
      }
   }
}