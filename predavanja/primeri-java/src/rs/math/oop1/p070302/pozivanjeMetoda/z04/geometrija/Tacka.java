package rs.math.oop1.p070302.pozivanjeMetoda.z04.geometrija;

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

//   void prikaziSe(boolean bezOznake) {
//      if (!bezOznake)
//         System.out.print(oznaka + "(" + x + "," + y + ")");
//      else
//         System.out.print("(" + x + "," + y + ")");
//   }

}
