package rs.math.oop1.p150300.radSaTokovima.z01.tekstovneDatoteke;

import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Employee
{
  private String name;
  private double salary;
  private Date hireDay;

  public Employee()
  {
  }

  public Employee(String n, double s, int year, int month, int day)
  {
     name = n;
     salary = s;
     GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
     hireDay = calendar.getTime();
  }

  public String getName()
  {
     return name;
  }

  public double getSalary()
  {
     return salary;
  }

  public Date getHireDay()
  {
     return hireDay;
  }

  public void raiseSalary(double byPercent)
  {
     double raise = salary * byPercent / 100;
     salary += raise;
  }

  public String toString()
  {
     return getClass().getName() + "[name=" + name + ",salary=" + salary + ",hireDay=" + hireDay
           + "]";
  }


  public void writeData(PrintWriter out)
  {
     GregorianCalendar calendar = new GregorianCalendar();
     calendar.setTime(hireDay);
     out.println(name + "|" + salary + "|" + calendar.get(Calendar.YEAR) + "|"
           + (calendar.get(Calendar.MONTH) + 1) + "|" + calendar.get(Calendar.DAY_OF_MONTH));
  }

  public void readData(Scanner in)
  {
     String line = in.nextLine();
     String[] tokens = line.split("\\|");
     name = tokens[0];
     salary = Double.parseDouble(tokens[1]);
     int y = Integer.parseInt(tokens[2]);
     int m = Integer.parseInt(tokens[3]);
     int d = Integer.parseInt(tokens[4]);
     GregorianCalendar calendar = new GregorianCalendar(y, m - 1, d);
     hireDay = calendar.getTime();
  }
}
