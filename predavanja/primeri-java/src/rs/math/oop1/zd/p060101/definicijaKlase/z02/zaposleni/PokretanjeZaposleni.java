package rs.math.oop1.zd.p060101.definicijaKlase.z02.zaposleni;

class Employee {
    String name;
    double salary;
}

public class PokretanjeZaposleni {
    public static void main(String[] args) {
        // fill the staff array with three Employee objects
        Employee e = new Employee();
        e.name = "Carl Cracker";
        e.salary = 75000;

        System.out.println("Initially");
        System.out.println("name=" + e.name + ",salary=" + e.salary);


        e.salary += 5000;

        System.out.println("After salary raise");
        System.out.println("name=" + e.name + ",salary=" + e.salary);
    }
}
