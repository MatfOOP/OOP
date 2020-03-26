package rs.math.oop1.z150000.koriscenjeKolekcije.z04.mesanje;

import java.util.*;

/**
 * This program demonstrates the random shuffle and sort algorithms.
 * @version 1.10 2004-08-02
 * @author Cay Horstmann
 */
public class ShuffleTest
{
   public static void main(String[] args)
   {
      List<Integer> numbers = new ArrayList<>();
      for (int i = 1; i <= 49; i++)
         numbers.add(i);
      Collections.shuffle(numbers);
      List<Integer> winningCombination = numbers.subList(0, 6);
      Collections.sort(winningCombination);
      System.out.println(winningCombination);
   }
}
