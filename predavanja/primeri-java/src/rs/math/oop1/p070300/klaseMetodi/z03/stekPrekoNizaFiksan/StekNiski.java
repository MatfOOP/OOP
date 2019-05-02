package rs.math.oop1.p060400.klaseMetodi.z03.stekPrekoNizaFiksan;

/*

Класа за реализацију стека који садржи целе бројеве.

Стек се реализује преко низа.
 
 */

class StekNiski {

   String[] elementi;
   int vrhSteka;

   void init(int dimenzija) {
      elementi = new String[dimenzija];
      vrhSteka = -1;
   }

   void push(String elem) {
      if (vrhSteka == elementi.length - 1) {
         System.out.println("Greska PUSH: Stek je pun!");
         return;
      }
      elementi[++vrhSteka] = elem;
   }

   String pop() {
      if (vrhSteka == -1) {
         System.out.println("Greska POP: Stek je prazan!");
         return "<nema>";
      }
      return elementi[vrhSteka--];
   }

   int brojElemenata() {
      return (vrhSteka + 1);
   }
}
