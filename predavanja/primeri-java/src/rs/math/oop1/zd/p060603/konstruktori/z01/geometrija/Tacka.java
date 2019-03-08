package rs.math.oop1.zd.p060603.konstruktori.z01.geometrija;

class Tacka {
   double x;
   double y;
   String oznaka;

   Tacka(String o, double xKoord, double yKoord) {
      oznaka = o;
      x = xKoord;
      y = yKoord;
   }

   void prikaziSe() {
      System.out.printf(oznaka + "(" + x + "," + y + ")");
   }

   double rastojanje(Tacka t) {
      return (Math.sqrt(Math.pow(t.x - x, 2)
               + Math.pow(t.y - y, 2)));
   }

}
