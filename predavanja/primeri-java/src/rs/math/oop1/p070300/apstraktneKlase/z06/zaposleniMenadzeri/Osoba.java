package rs.math.oop1.p070300.apstraktneKlase.z06.zaposleniMenadzeri;

import java.util.Date;
import java.util.GregorianCalendar;

public abstract class Osoba
{
    private String ime;
    private Date rodjen;

  public Osoba(String n, int year, int month, int day)
  {
     ime = n;
     GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
     rodjen = calendar.getTime();
  }

	public String getIme()
  {
     return ime;
  }

  public Date getRodjen()
  {
     return rodjen;
  }


}
