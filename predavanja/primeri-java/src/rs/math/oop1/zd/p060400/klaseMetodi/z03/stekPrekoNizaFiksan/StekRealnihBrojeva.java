package rs.math.oop1.zd.p060400.klaseMetodi.z03.stekPrekoNizaFiksan;

/*
  
Класа за реализацију стека који садржи бројеве у покретном зарезу.

Стек се реализује преко низа.
 
 */

class StekRealnihBrojeva {

   double[] elementi;
   int vrhSteka;

   void init(int dimenzija) {
      elementi = new double[dimenzija];
      vrhSteka = -1;
   }

   void push(double elem) {
      if (vrhSteka == elementi.length - 1) {
         System.out.println("Greska PUSH: Stek je pun!");
         return;
      }
      elementi[++vrhSteka] = elem;
   }

   double pop() {
      if (vrhSteka == -1) {
         System.out.println("Greska POP: Stek je prazan!");
         return -1;
      }
      return elementi[vrhSteka--];
   }

   int brojElemenata() {
      return (vrhSteka + 1);
   }
}
