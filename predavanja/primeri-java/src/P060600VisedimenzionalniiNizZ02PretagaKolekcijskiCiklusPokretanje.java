class PokretanjeVisedimenzionalniiNizPretagaKolekcijskaiCiklus {

   public static void main(String[] komandnaLinija) {
      int[][][] p = { { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }, { { 11, 12, 13, 14, 15 }, { 21, 22 } },
            { { 101, 102, 103 }, { 45, 56 } } };
      int x = 19; // Broj koji se traži
      boolean pronadjen = false;
      najspoljasnija: for (int[][] dvoDim : p) {
         u_sredini: for (int[] jednoDim : dvoDim)
            for (int elem : jednoDim)
               if (elem == x) {
                  pronadjen = true;
                  break najspoljasnija;
               }
      }
      if (pronadjen)
         System.out.println("Pronadjen");
      else
         System.out.println("Nije pronadjen");
   }
}
