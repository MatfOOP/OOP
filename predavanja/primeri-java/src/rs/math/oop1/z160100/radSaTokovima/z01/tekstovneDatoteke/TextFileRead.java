package rs.math.oop1.z160100.radSaTokovima.z01.tekstovneDatoteke;

import java.io.*;
import java.util.*;

/**
 * @version 1.12 2007-06-22
 * @author Cay Horstmann
 */
public class TextFileRead
{
   public static void main(String[] args)
   {
      try
      {
         Scanner in = new Scanner(new FileReader("employee3.dat"));
         Employee[] newStaff = readData(in);
         in.close();

          for (Employee e : newStaff)
            System.out.println(e);
      }
      catch (IOException exception)
      {
         exception.printStackTrace();
      }
   }

   private static Employee[] readData(Scanner in)
   {
      // retrieve the array size
      int n = in.nextInt();
      in.nextLine(); // consume newline

      Employee[] employees = new Employee[n];
      for (int i = 0; i < n; i++)
      {
         employees[i] = new Employee();
         employees[i].readData(in);
      }
      return employees;
   }
}

