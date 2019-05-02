/*
 
 Написати Јава програм који за унесене бројеве врши рачунање биномног
 коефицијента на два начина (рекурзивно и динамичким програмирањем) и
 приказује добијене резултате и времена извршавања за оба начина.
 
 */

// Задатак представља илустрацију мерења времена

package rs.math.oop1.p050602.merenjeVremena.z02.protekloVremeBK;

public class ProteklVremePritisakTastera {

   static int[][] koeficijenti;

   static int bk1(int n, int k) {
      if (n == 0 || n == 1)
         return 1;
      if (k == 0 || k == n)
         return 1;
      return bk1(n - 1, k) + bk1(n - 1, k - 1);
   }

   static int bk2(int n, int k) {
      if (koeficijenti[n][k] >= 0)
         return koeficijenti[n][k];
      koeficijenti[n][k] = bk2(n - 1, k)
               + bk2(n - 1, k - 1);
      return koeficijenti[n][k];
   }

   public static void main(String[] args) {
      System.out.println("Racunanje binomnog koeficijenta");
      System.out.println("Unesi n i k:");
      java.util.Scanner skener = new java.util.Scanner(System.in);
      int n = skener.nextInt();
      int k = skener.nextInt();
      skener.close();
      long vremePocetka = System.nanoTime();
      int rez = bk1(n, k);
      double trajanje = (System.nanoTime() - vremePocetka)
               / 1e6;
      System.out.printf(
               "Cisto rekurzivnim putem dobijen je\n");
      System.out.printf("rezultat %d, za vreme %10.4f msec",
               rez, trajanje);
      vremePocetka = System.nanoTime();
      // alociraj trougaoni niz
      koeficijenti = new int[n + 1][];
      for (int i = 0; i < koeficijenti.length; i++)
         koeficijenti[i] = new int[i + 1];
      // inicijalizuj trougaoni niz
      for (int i = 0; i < koeficijenti.length; i++)
         for (int j = 0; j < koeficijenti[i].length; j++)
            koeficijenti[i][j] = -1;
      koeficijenti[0][0] = koeficijenti[1][0] = koeficijenti[1][1] = 1;
      for (int i = 0; i < koeficijenti.length; i++)
         koeficijenti[i][0] = koeficijenti[i][koeficijenti[i].length
                  - 1] = 1;
      double trajanjeInit = (System.nanoTime()
               - vremePocetka) / 1e6;
      vremePocetka = System.nanoTime();
      int rez2 = bk2(n, k);
      double trajanjeRacun = (System.nanoTime()
               - vremePocetka) / 1e6;
      System.out.printf(
               "\nDinamickim programiranjem dobijen je\n");
      System.out.printf(
               "rezultat %d, za vreme %10.4f msec\n", rez2,
               trajanjeInit + trajanjeRacun);
      System.out.printf(
               "vreme inicijalizacije pomocnog niza je %10.4f msec\n",
               trajanjeInit);
      System.out.printf(
               "vreme izracunavanja je                 %10.4f msec\n",
               trajanjeRacun);
   }
}
