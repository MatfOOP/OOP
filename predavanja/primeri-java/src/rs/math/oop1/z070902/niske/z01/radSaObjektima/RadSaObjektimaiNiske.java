package rs.math.oop1.z070902.niske.z01.radSaObjektima;

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
        return String.format("Employee - ime: %s, plata: %.2f.", name, salary);
    }
}

public class RadSaObjektimaiNiske {

    public static void main(String[] args) {
        Employee miki = new Employee("Miki Maus", 42_000);
        System.out.println(miki);
    }

}
