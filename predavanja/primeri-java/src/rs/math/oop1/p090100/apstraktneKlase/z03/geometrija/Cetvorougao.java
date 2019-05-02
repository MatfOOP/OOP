package rs.math.oop1.p070300.apstraktneKlase.z03.geometrija;

public class Cetvorougao extends GeometrijskiObjekat {
   private Tacka a;
   private Tacka b;
   private Tacka c;
   private Tacka d;

   public Cetvorougao(String oznaka, Tacka a, Tacka b,
            Tacka c, Tacka d) {
      super(oznaka);
      this.a = new Tacka(a);
      this.b = new Tacka(b);
      this.c = new Tacka(c);
      this.d = new Tacka(d);
   }

   public Cetvorougao(Tacka a, Tacka b, Tacka c, Tacka d) {
      this("", a, b, c, d);
   }

   public Cetvorougao(final Cetvorougao cetv) {
      this(cetv.getOznaka(), cetv.a, cetv.b, cetv.c,
               cetv.d);
   }

   @Override
   public void prikaziSe() {
      System.out.print( getOznaka() +":[");
      a.prikaziSe();
      System.out.print(";");
      b.prikaziSe();
      System.out.print(";");
      c.prikaziSe();
      System.out.print(";");
      d.prikaziSe();
      System.out.print("]");
   }

   public double obim() {
      return a.rastojanje(b) + b.rastojanje(c)
               + c.rastojanje(d) + d.rastojanje(a);
   }

   public double povrsina() {
      Prava p = new Prava(a, c);
      if (p.suSaRaznihStranaPrave(b, d)) {
         Trougao t1 = new Trougao(a, c, b);
         Trougao t2 = new Trougao(a, c, d);
         return t1.povrsina() + t2.povrsina();
      } else {
         Trougao t1 = new Trougao(b, d, a);
         Trougao t2 = new Trougao(b, d, c);
         return t1.povrsina() + t2.povrsina();
      }
   }

   public boolean sadrzi(Tacka t) {
      Prava p = new Prava(a, c);
      if (p.suSaRaznihStranaPrave(b, d)) {
         Trougao t1 = new Trougao(a, c, b);
         Trougao t2 = new Trougao(a, c, d);
         return t1.sadrzi(t)|| t2.sadrzi(t);
      } else {
         Trougao t1 = new Trougao(b, d, a);
         Trougao t2 = new Trougao(b, d, c);
         return t1.sadrzi(t)|| t2.sadrzi(t);
      }
   }

   @Override
   public boolean jeKonveksan() {
      Prava p = new Prava(a, b);
      if (p.suSaRaznihStranaPrave(c, d))
         return false;
      p = new Prava(b, c);
      if (p.suSaRaznihStranaPrave(a, d))
         return false;
      p = new Prava(c, d);
      if (p.suSaRaznihStranaPrave(a, b))
         return false;
      p = new Prava(d, a);
      if (p.suSaRaznihStranaPrave(b, c))
         return false;
      return true;
   }

   @Override
   public boolean jeOgranicen() {
      return true;
   }

}
