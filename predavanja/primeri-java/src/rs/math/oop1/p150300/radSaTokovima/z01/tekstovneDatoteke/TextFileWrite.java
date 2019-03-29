package rs.math.oop1.p150300.radSaTokovima.z01.tekstovneDatoteke;

import java.io.*;

/**
 * @version 1.12 2007-06-22
 * @author Cay Horstmann
 */
public class TextFileWrite
{
   public static void main(String[] args)
   {
      Employee[] staff = new Employee[3];

      staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
      staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
      staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);

      try
      {
         // save all employee records to the file employee.dat
         PrintWriter out = new PrintWriter("employee3.dat");
         writeData(staff, out);
         out.close();

          System.out.println("Zaposleni su upisani u datoteku employee3.dat.");
      }
      catch (IOException exception)
      {
         exception.printStackTrace();
      }
   }

   /**
    * Writes all employees in an array to a print writer
    * @param employees an array of employees
    * @param out a print writer
    */
   private static void writeData(Employee[] employees, PrintWriter out) throws IOException
   {
      // write number of employees
      out.println(employees.length);

      for (Employee e : employees)
         e.writeData(out);
   }

 }

