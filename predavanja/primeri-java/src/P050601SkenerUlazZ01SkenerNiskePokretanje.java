
public class P050601SkenerUlazZ01SkenerNiskePokretanje {


   public static void main(String[] args) {
      String izvor = "1 2 3 4 -3";
      java.util.Scanner skener = new java.util.Scanner(izvor);
      int suma = 0;
      while (skener.hasNext()) {
         int i = skener.nextInt();
         suma += i;
      }
      skener.close();
      System.out.printf("suma celih brojeva niske \"%s\":\n%d\n", izvor, suma);

      izvor = "1 2 3.5 4.3 -3";
      skener = new java.util.Scanner(izvor);
      double suma1 = 0;
      while (skener.hasNext()) {
         double x = skener.nextDouble();
         suma1 += x;
      }
      skener.close();
      System.out.printf("suma brojeva niske \"%s\":\n%f\n", izvor, suma1);

      izvor = "paja patak\n miki maus 12 23\n dusko dugousko";
      skener = new java.util.Scanner(izvor);
      StringBuilder rez = new StringBuilder();
      while (skener.hasNext()) {
         String s = skener.next();
         rez.append(s);
         rez.append("|");
      }
      skener.close();
      System.out.printf("nalepljene reci niske \"%s\":\n%s\n", izvor, rez);

   }
}
