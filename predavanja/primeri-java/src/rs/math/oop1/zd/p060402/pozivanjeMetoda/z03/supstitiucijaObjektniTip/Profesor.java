package rs.math.oop1.zd.p060402.pozivanjeMetoda.z03.supstitiucijaObjektniTip;

/*

Јава класа која представља професора

*/

class Profesor {
   String imePrezime;
   double plata;

   void init(String n, double p) {
      imePrezime = n;
      plata = p;
   }

   void povecajPlatu(double zaProcenat) {
      double iznosPovisice = plata * zaProcenat / 100;
      plata += iznosPovisice;
   }

}