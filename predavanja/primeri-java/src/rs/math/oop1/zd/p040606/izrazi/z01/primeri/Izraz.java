//Примери неких валидних израза.

package rs.math.oop1.zd.p040606.izrazi.z01.primeri;

public class Izraz {

    public static void main(String[] args) {
        int a = 7, b = 3, d = 2;
        double x = 1.2, y = 2.3;
        y *= (x = 5);
        System.out.println("Rezultat: " + y);
        x = y % x - 3.1 * (a / b + y) * Math.sqrt(x);
        System.out.println("Rezultat: " + x);
        --d;
        System.out.println("Rezultat: " + d);
    }
}
