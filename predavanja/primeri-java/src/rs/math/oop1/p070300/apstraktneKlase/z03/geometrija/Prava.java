package rs.math.oop1.p070300.apstraktneKlase.z03.geometrija;

public class Prava extends GeometrijskiObjekat {

   private double a;
   private double b;
   private double c;

   public Prava(String oznaka, double a, double b,
            double c) {
      super(oznaka);
      this.a = a;
      this.b = b;
      this.c = c;
   }

   public Prava(double a, double b, double c) {
      this("", a, b, c);
   }

   public Prava(String oznaka, Tacka t1, Tacka t2) {
      super(oznaka);
      a = t2.getY() - t1.getY();
      b = t1.getX() - t2.getX();
      c = t1.getY() * (t2.getX() - t1.getX())
               - t1.getX() * (t2.getY() - t1.getY());
   }

   public Prava(Tacka t1, Tacka t2) {
      this("", t1, t2);
   }

   @Override
   public void prikaziSe() {
      System.out.print( getOznaka() +
               ":[a=" + a + ";b=" + b + ";c=" + c + "]");
   }

   private double uvrstiKoordinate(Tacka t) {
      return a * t.getX() + b * t.getY() + c;
   }

   public boolean sadrzi(Tacka t) {
      return (uvrstiKoordinate(t) == 0);
   }

   public boolean suSaIsteStranePrave(Tacka t1, Tacka t2) {
      return uvrstiKoordinate(t1)
               * uvrstiKoordinate(t2) > 0;
   }

   public boolean suSaRaznihStranaPrave(Tacka t1,
            Tacka t2) {
      return !suSaIsteStranePrave(t1, t2);
   }

   @Override
   public boolean jeKonveksan() {
      return true;
   }

   @Override
   public boolean jeOgranicen() {
      return false;
   }

}
