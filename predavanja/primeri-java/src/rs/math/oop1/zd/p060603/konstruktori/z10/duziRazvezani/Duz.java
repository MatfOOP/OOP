package rs.math.oop1.zd.p060603.konstruktori.z10.duziRazvezani;

public class Duz {
  String oznaka;
  Tacka a;
  Tacka b;
  
  Duz( String o, Tacka t1, Tacka t2)
  {
	  oznaka = o;
	  a = new Tacka(t1.x, t1.y, t1.oznaka);
	  b = new Tacka(t2.x, t2.y, t2.oznaka);
  }
	
  
  void prikaziSe()
  {
	   System.out.print(oznaka + ":[" );
	   a.prikaziSe();
	   System.out.print(";");
	   b.prikaziSe();	  
	   System.out.print("]");
  }
}
