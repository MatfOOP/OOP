/*
  
Јава класа која представља матрицу.
 
 */

package rs.math.oop1.zd.p060603.konstruktori.z08.matricePreopterecenje;

public class Matrica {

   private double[][] mat;

   public int getBrojVrsta() {
      return mat.length;
   }

   public int getBrojKolona() {
      return mat[0].length;
   }

   private int getBrojElemenataUVrsti(int vrsta) {
      return mat[vrsta].length;
   }

   public double getElemenat(int vrsta, int kolona) {
      return mat[vrsta][kolona];
   }

   public void setElemenat(int vrsta, int kolona,
            double vrednost) {
      mat[vrsta][kolona] = vrednost;
   }

   private boolean jeKorektna() {
      if (mat == null)
         return true;
      int num = mat[0].length;
      for (int i = 0; i < mat.length; i++)
         if (mat[i].length != num)
            return false;
      return true;
   }

   public Matrica(int m, int n) {
      if (m <= 0 || n <= 0) {
         mat = null;
         return;
      }
      mat = new double[m][n];
      for (int i = 0; i < m; i++)
         for (int j = 0; j < n; j++)
            mat[i][j] = 0;
   }

   public Matrica(double[][] a) {
      mat = a;
      if (!jeKorektna())
         mat = null;
   }

   public void prikazi() {
      if (mat == null) {
         System.out.println("GRESKA!");
         return;
      }
      System.out.println("Elementi matrice su");
      for (double[] vrsta : mat) {
         for (double x : vrsta)
            System.out.printf("%15.4f", x);
         System.out.printf("\n");
      }
   }

   public Matrica saberi(Matrica b) {
      if (getBrojVrsta() != b.getBrojVrsta())
         return null;
      for (int i = 0; i < getBrojVrsta(); i++)
         if (getBrojElemenataUVrsti(i) != b
                  .getBrojElemenataUVrsti(i))
            return null;
      Matrica c = new Matrica(getBrojVrsta(),
               getBrojKolona());
      for (int i = 0; i < c.getBrojVrsta(); i++)
         for (int j = 0; j < c.getBrojKolona(); j++)
            c.setElemenat(i, j, getElemenat(i, j)
                     + b.getElemenat(i, j));
      return c;
   }

   public Matrica oduzmi(Matrica b) {
      if (getBrojVrsta() != b.getBrojVrsta())
         return null;
      for (int i = 0; i < getBrojVrsta(); i++)
         if (getBrojElemenataUVrsti(i) != b
                  .getBrojElemenataUVrsti(i))
            return null;
      Matrica c = new Matrica(getBrojVrsta(),
               getBrojKolona());
      for (int i = 0; i < c.getBrojVrsta(); i++)
         for (int j = 0; j < c.getBrojKolona(); j++)
            c.setElemenat(i, j, getElemenat(i, j)
                     - b.getElemenat(i, j));
      return c;
   }

   public Matrica pomnozi(Matrica b) {
      for (int i = 0; i < getBrojVrsta(); i++)
         if (getBrojElemenataUVrsti(i) != b.getBrojVrsta())
            return null;
      Matrica c = new Matrica(getBrojVrsta(),
               b.getBrojKolona());
      for (int i = 0; i < c.getBrojVrsta(); i++)
         for (int j = 0; j < c
                  .getBrojElemenataUVrsti(i); j++) {
            double x = 0;
            for (int k = 0; k < getBrojElemenataUVrsti(
                     i); k++)
               x += getElemenat(i, k) * b.getElemenat(k, j);
            c.setElemenat(i, j, x);
         }
      return c;
   }

   public boolean jeKvadratna() {
      return (jeKorektna() && mat.length == mat[0].length);
   }

   private double[][] iskljuci(double[][] a, int vrsta,
            int kolona) {
      int n = a.length;
      double[][] mat = new double[n - 1][n - 1];
      for (int i = 0; i < vrsta; i++)
         for (int j = 0; j < kolona; j++)
            mat[i][j] = a[i][j];
      for (int i = vrsta; i < n - 1; i++)
         for (int j = 0; j < kolona; j++)
            mat[i][j] = a[i + 1][j];
      for (int i = 0; i < vrsta; i++)
         for (int j = kolona; j < n - 1; j++)
            mat[i][j] = a[i][j + 1];
      for (int i = vrsta; i < n - 1; i++)
         for (int j = kolona; j < n - 1; j++)
            mat[i][j] = a[i + 1][j + 1];
      return mat;
   }

   public double determinanta() {
      int n = mat.length;
      if (n == 1)
         return mat[0][0];
      if (n == 2)
         return mat[0][0] * mat[1][1]
                  - mat[1][0] * mat[0][1];
      double det = 0;
      double znak = 1;
      for (int j = 0; j < n; j++) {
         Matrica m = new Matrica(iskljuci(mat, 0, j));
         det += znak * mat[0][j] * m.determinanta();
         znak = -znak;
      }
      return det;
   }

}
