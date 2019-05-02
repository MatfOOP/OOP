package rs.math.oop1.p110100.izuzeci.z01.nastanak;

public class TestTryCatch00Without {
    public static void main(String[] args) {
        int i = 11;
        int j = 0;

        System.out.println("Pocetak " + "i = " + i + " j = " + j);
        System.out.println(i / j); // Divide by 0 - exception thrown
        System.out.println("kraj");
        return;
    }
}
