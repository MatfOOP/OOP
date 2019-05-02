package rs.math.oop1.p050601.datumVreme.z02.lokalnо.lokalnо;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PoredjenjeDatuma {
   public static void main(String args[]) {

      // Date Comparison

      // 1st way: using before(), after(), equals()
      SimpleDateFormat dateformat3 = new SimpleDateFormat("dd/MM/yyyy");
      try {
         Date date1 = dateformat3.parse("17/07/1989");
         Date date2 = dateformat3.parse("15/10/2007");

         System.out.println("Date1 is: "+dateformat3.format(date1));
         System.out.println("Date2 is: "+dateformat3.format(date2));

         if (date1.after(date2)) {
            System.out.println("Date1 is later than Date2");
         }else if (date1.before(date2)) {
            System.out.println("Date1 is earlier than Date2");
         }else if (date1.equals(date2)) {
            System.out.println("Date1 is the same with Date2");
         }

         // 2nd way: using compareTo()
         date1 = dateformat3.parse("27/09/2012");
         date2 = dateformat3.parse("27/09/2009");

         System.out.println("Date1 is: "+dateformat3.format(date1));
         System.out.println("Date2 is: "+dateformat3.format(date2));

         if (date1.compareTo(date2) > 0) {
            System.out.println("Date1 is later than Date2");
         } else if (date1.compareTo(date2) < 0) {
            System.out.println("Date1 is earlier than Date2");
         } else if (date1.compareTo(date2) == 0) {
            System.out.println("Date1 is the same with Date2");
         }

      } catch (ParseException e) {
         e.printStackTrace();
      }

   }
}