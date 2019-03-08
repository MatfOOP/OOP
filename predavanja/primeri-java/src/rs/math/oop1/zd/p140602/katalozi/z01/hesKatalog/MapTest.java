package rs.math.oop1.zd.p140602.katalozi.z01.hesKatalog;

import java.util.*;

public class MapTest
{
   public static void main(String[] args)
   {
      Map<String, Employee> staff = new HashMap<>();
      staff.put("144-25-5464", new Employee("Amy Lee", 10));
      staff.put("567-24-2546", new Employee("Harry Hacker", 20));
      staff.put("157-62-7935", new Employee("Gary Cooper", 100));
      staff.put("456-62-5527", new Employee("Francesca Cruz"));

      // print all entries

      System.out.println(staff);

      // remove an entry

      staff.remove("567-24-2546");
      System.out.println("Uklonjen " + "567-24-2546");
      System.out.println(staff);

      // replace an entry

      staff.put("456-62-5527", new Employee("Francesca Miller", 3));
      System.out.println("Francesca Miller" + "sa sifrom " +"456-62-5527");
      System.out.println(staff);

      // look up a value

      System.out.println(staff.get("157-62-7935"));

      // iterate through all entries

      for (Map.Entry<String, Employee> entry : staff.entrySet())
      {
         String key = entry.getKey();
         Employee value = entry.getValue();
         System.out.println("key=" + key + ", value=" + value);
      }
   }
}

/**
 * A minimalist employee class for testing purposes.
 */
class Employee
{
  
  public Employee(String n, double salary)
  {
     name = n;
     this.salary = salary;
  }

   public Employee(String n)
   {
      this( n, 0);
   }

   public String toString()
   {
      return "[name=" + name + ", salary=" + salary + "]";
   }

   private String name;
   private double salary;
}
