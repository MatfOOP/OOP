import java.time.LocalDate;

public class P050601DatumVremeZ01LocalDatePokretanje {
   public static void main(String[] args) {
      LocalDate datum1 = LocalDate.parse("2020-02-03");
      LocalDate datum2 = LocalDate.parse("2020-03-03");
      LocalDate datum3 = LocalDate.of(2020,2, 7);

      System.out.println(datum1);
      System.out.println(datum2);
      System.out.println(datum3);
      System.out.println(datum1.equals(datum2));
      System.out.println(datum1.compareTo(datum2));

      System.out.println(datum3.minusDays(2));
   }
}


