package rs.math.oop1.p060901.objekti.z01.radSaObjektima;

class Employee {
    private String name;
    private double salary;

    public Employee(String n, double s) {
        name = n;
        salary = s;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    @Override
    public String toString() {
        return String.format("Zaposleni - ime: %s, plata: %.2f.", name, salary);
    }
}

public class RadSaObjektimaiNiske {

    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(o);
        RadSaObjektimaiNiske rso = new RadSaObjektimaiNiske();
        System.out.println(rso);
        int i = 42;
        Integer ii = new Integer(i);
        System.out.println(ii);
        String s = "42";
        System.out.println(s);
        Employee miki = new Employee("Miki Maus", 42_000);
        System.out.println(miki);
    }

}
