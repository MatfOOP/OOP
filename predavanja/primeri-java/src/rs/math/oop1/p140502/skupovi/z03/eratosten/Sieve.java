package rs.math.oop1.p140502.skupovi.z03.eratosten;

import java.util.*;

/**
 * This program runs the Sieve of Erathostenes benchmark. It computes all primes up to 2,000,000.
 * @version 1.21 2004-08-03
 * @author Cay Horstmann
 */
public class Sieve
{
   public static void main(String[] s)
   {
      int n = 4_000_000;
      long pocetak = System.nanoTime();
      BitSet b = new BitSet(n + 1);
      int count = 0;
      int i;
      for (i = 2; i <= n; i++)
         b.set(i);
      i = 2;
      while (i * i <= n)
      {
         if (b.get(i))
         {
            count++;
            int k = 2 * i;
            while (k <= n)
            {
               b.clear(k);
               k += i;
            }
         }
         i++;
      }
      while (i <= n)
      {
         if (b.get(i)) count++;
         i++;
      }
      System.out.println(b);
      long kraj = System.nanoTime();
      System.out.println(count + " primes");
      System.out.println((kraj - pocetak)/1e6 + " milliseconds");
   }
}
