package rs.math.oop1.z150704.noviKolekcijskiTipovi.z04.performanseSteka;

import java.util.Date;
import java.util.EmptyStackException;

public class ExceptionalTest {
    public static void main(String[] args) {
        int i = 0;
        int ntry = 10_000_000;
        Stack<String> s = new StekPrekoPovezaneListe<String>();
        long s1;
        long s2;


        // test a stack for emptiness ntry times
        System.out.println("Testing for empty stack");
        s1 = new Date().getTime();
        for (i = 0; i <= ntry; i++)
            if (!s.empty())
                s.pop();
        s2 = new Date().getTime();
        System.out.println((s2 - s1) + " milliseconds");

        // pop an empty stack ntry times and catch the resulting exception
        System.out.println("Catching EmptyStackException");
        s1 = new Date().getTime();
        for (i = 0; i <= ntry; i++) {
            try {
                s.pop();
            } catch (EmptyStackException e) {
            }
        }
        s2 = new Date().getTime();
        System.out.println((s2 - s1) + " milliseconds");
    }
}
