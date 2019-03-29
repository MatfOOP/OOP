package rs.math.oop1.p070300.apstraktneKlase.z06.zaposleniMenadzeri;

import java.util.Date;
import java.util.GregorianCalendar;

public abstract class Person
{ 
  public Person(String n, int year, int month, int day)
  {
     name = n;
     GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
     bornDay = calendar.getTime();
  }

	public String getName()
  {
     return name;
  }

  public Date getBornDay()
  {
     return bornDay;
  }

  private String name;
  private Date bornDay;

}
