/*
 
Написати Јава програм који омогућује да се, коришћењем дводимензионалног низа, реализује
приказ Паскаловог троугла.

Биномни коефицијенти су добијени рекурзивним путем и коришћењем концепта динамичког
програмирања.
 
 */

// Програм илуструје рад са дводимензионалним низом, где се у свакој од врста налази различити 
// број елемената. 
// Такође, програм илуструје последице прекорачења опсега за целобројни тип, ќасније него у 
// првом случају, али ипак наступа прекорачење.
// На крају, програм илуструје како се динамичким програмирањем брже добија резултат
// (при чему се користи више меморије за смештај међурезултата).

package rs.math.oop1.zd.p050400.dvodimenzionalniNiz.z04.binomniKoeficijentiDinamickoProgramiranje;

public class RadSaPaskalovimTrouglom {
   // deklarisi trougaoni niz
   static int[][] koeficijenti;

   static int bk(int n, int k) {
      if (koeficijenti[n][k] >= 0)
         return koeficijenti[n][k];
      if (n == 0 || n == 1)
         return 1;
      if (k == 0 || k == n)
         return 1;
      koeficijenti[n][k] = bk(n - 1, k) + bk(n - 1, k - 1);
      return koeficijenti[n][k];
   }

   public static void main(String[] args) {
      int brojVrsta = 133; // 4
      // alociraj trougaoni niz
      koeficijenti = new int[brojVrsta + 1][];
      for (int n = 0; n <= brojVrsta; n++)
         koeficijenti[n] = new int[n + 1];
      // inicijalizuj trougaoni niz
      for (int i = 0; i < koeficijenti.length; i++)
         for (int j = 0; j < koeficijenti[i].length; j++)
            koeficijenti[i][j] = -1;
      // popuni trougaoni niz koriscenjem bk
      for (int n = 0; n < koeficijenti.length; n++)
         for (int k = 0; k < koeficijenti[n].length; k++)
            koeficijenti[n][k] = bk(n, k);
      // prikazi elemente niza
      for (int[] vrsta : koeficijenti) {
         for (int elem : vrsta)
            System.out.printf("%15d", elem);
         System.out.println();
      }
   }
}
