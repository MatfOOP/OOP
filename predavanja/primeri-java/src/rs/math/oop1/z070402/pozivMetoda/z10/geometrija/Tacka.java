package rs.math.oop1.z070402.klaseMetodi.z06.geometrija;

class Tacka {
   double x;
   double y;
   String oznaka;

   void init(String o, double xKoord, double yKoord) {
      oznaka = o;
      x = xKoord;
      y = yKoord;
   }

   void prikaziSe(boolean bezOznake) {
      System.out.print((bezOznake ? "": oznaka) + "(" + x + "," + y + ")");
   }

}
