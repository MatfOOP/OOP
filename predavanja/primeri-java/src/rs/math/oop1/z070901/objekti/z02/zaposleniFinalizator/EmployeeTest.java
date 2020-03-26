package rs.math.oop1.z070901.objekti.z02.zaposleniFinalizator;

class Employee {
    private int broj;
    private String ime;
    private double plata;

    public Employee(String n, int br, double s) {
        ime = n;
        broj = br;
        plata = s;
    }

    public String getName() {
        return ime;
    }

    public double getSalary() {
        return plata;
    }

    public void raiseSalary(double byPercent) {
        double raise = plata * byPercent / 100;
        plata += raise;
    }

    @Override
    public void finalize() {
        System.out.println("FINALIZUJEM! " + ime + ":" + broj);
    }
}

public class EmployeeTest {
    public static void main(String[] args) {

        // fill the staff array with three Employee objects
        if (1 > 0) {
            Employee[] staff = new Employee[3];
            staff[0] = new Employee("Carl Cracker", 1, 75000);
            staff[1] = new Employee("Harry Hacker", 2, 50000);
            staff[2] = new Employee("Tony Tester", 3, 40000);
            for (Employee e : staff)
                System.out.println(e);
        }
        System.gc();
        for (int i = 0; i < 10_000; i += 3) {
            Employee[] staff = new Employee[3];
            staff[0] = new Employee("Carl Cracker", i, 75000);
            staff[1] = new Employee("Harry Hacker", i + 1, 50000);
            staff[2] = new Employee("Tony Tester", i + 2, 40000);
            if (i % 300 == 0)
                System.gc();
        }

    }
}
