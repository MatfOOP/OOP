package rs.math.oop1.p070300.klaseMetodi.z06.geometrija;

class Duz {
   String oznaka;
   Tacka a;
   Tacka b;

   void init(String o, Tacka t1, Tacka t2) {
      oznaka = o;
      a = t1;
      b = t2;
   }

   void prikaziSe() {
      System.out.print(oznaka + ":[");
      a.prikaziSe(false);
      System.out.print(";");
      b.prikaziSe(false);
      System.out.print("]");
   }

}
