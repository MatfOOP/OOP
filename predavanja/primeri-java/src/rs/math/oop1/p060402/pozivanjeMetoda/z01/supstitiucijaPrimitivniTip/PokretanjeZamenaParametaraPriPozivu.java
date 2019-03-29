/*
 
 Направити Јава програм који тестира какав је ефекат позива метода: 
 1) Када  метод мења вредности параметра примитивног типа.
 2) Када се вредност резултата примитивног типа враће из метода као
    његов резултат.
*/

// Програм илуструје ефекте супституције параметра по вредности, која  
// се дешава у Јави приликом позива датог метода

package rs.math.oop1.p060402.pozivanjeMetoda.z01.supstitiucijaPrimitivniTip;

public class PokretanjeZamenaParametaraPriPozivu {

   static void utrostruci(double x) {
      System.out.println("\tUnutar metoda, na pocetku izvrsavanja: x=" + x);
      x = 3 * x;
      System.out.println("\tUnutar metoda, na kraju izvrsavanja:   x=" + x);
   }

   static double utrostruci1(double x) {
      System.out.println("\tUnutar metoda, na pocetku izvrsavanja: x=" + x);
      x = 3 * x;
      System.out.println("\tUnutar metoda, na kraju izvrsavanja:   x=" + x);
      return x;
   }

   public static void main(String[] args) {
      // Pokretanje 1: Metod ne moze promeniti vrednost parametara primitivnog tipa
      System.out.println("\nPokretanjeiranje metoda utrostruci():");
      double procenat = 10;
      System.out.println("Pre poziva:   procenat=" + procenat);
      utrostruci(procenat);
      System.out.println("Posle poziva: procenat=" + procenat);

      // Pokretanje 2: Metod moze da vrati vrednost primitivnog tipa kao rezultat
      System.out.println("\nPokretanjeiranje metoda utrostruci1():");
      double procenat1 = 10;
      System.out.println("Pre poziva:   procenat1=" + procenat1);
      procenat1 = utrostruci1(procenat1);
      System.out.println("Posle poziva: procenat1=" + procenat1);
   }
}
