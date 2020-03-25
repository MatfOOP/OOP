package rs.math.oop1.z70401.definicjeMetoda.z02.geometrija;

class Cetvorougao {
   String oznaka;
   Tacka a;
   Tacka b;
   Tacka c;
   Tacka d;

   void init(String o, Tacka t1, Tacka t2, Tacka t3,
             Tacka t4) {
      oznaka = o;
      a = new Tacka();
      a.init(t1.oznaka, t1.x, t1.y);
      b = new Tacka();
      b.init(t2.oznaka, t2.x, t2.y);
      c = new Tacka();
      c.init(t3.oznaka, t3.x, t3.y);
      d = new Tacka();
      d.init(t4.oznaka, t4.x, t4.y);
   }

   void prikaziSe() {
      System.out.print(oznaka + ":[");
      a.prikaziSe(true);
      System.out.print(";");
      b.prikaziSe(true);
      System.out.print(";");
      c.prikaziSe(true);
      System.out.print(";");
      d.prikaziSe(true);
      System.out.print("]");
   }

}
