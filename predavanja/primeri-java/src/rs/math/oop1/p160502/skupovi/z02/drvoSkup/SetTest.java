package rs.math.oop1.p160502.skupovi.z02.drvoSkup;

import java.util.*;

/**
 * This program uses a set to print all unique words in System.in.
 * @version 1.10 2003-08-02
 * @author Cay Horstmann
 */
public class SetTest
{
   public static void main(String[] args)
   {
      SortedSet<String> words = new TreeSet<>(); // HashSet implements Set
      long ukupnoVreme = 0;

      Scanner in = new Scanner(System.in);
      while (in.hasNext())
      {
         String word = in.next();
         long interval = System.nanoTime();
         words.add(word);
         interval = System.nanoTime() - interval;
         ukupnoVreme += interval;
      }

      Iterator<String> iter = words.iterator();
      for (int i = 1; i <= 20 && iter.hasNext(); i++)
         System.out.println(iter.next());
      System.out.println(". . .");
      System.out.println(words.size() + " distinct words. " + ukupnoVreme/10e6 + " milliseconds.");
   }
}
