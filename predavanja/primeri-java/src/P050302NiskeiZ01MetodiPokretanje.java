public class P050302NiskeiZ01MetodiPokretanje {
   public static void main(String[] args) {
      String niska1 = new String("Ovo je jedna niska.");
      String niska2 = "Ovo je druga niska.";

      System.out.printf("niska1: %s\n", niska1);
      System.out.printf("niska2: %s\n", niska2);

      int pozicija = 2;
      System.out.printf("niske1.charAt(%d): %c\n", pozicija, niska1.charAt(pozicija));
      pozicija = 10;
      System.out.printf("niska1.charAt(%d): %c\n", pozicija, niska1.charAt(pozicija));

      System.out.printf("niska1.length(): %d\n", niska1.length());

      int pozicijaPocev = 1;
      int pozicijaDo = 5;
      System.out.printf("niska1.substring( %d, %d): %s\n", pozicijaPocev, pozicijaDo,
            niska1.substring(pozicijaPocev, pozicijaDo));

      System.out.printf("spoj niski: %s \n", niska1.concat(niska2));
      System.out.printf("spoj niski: %s \n", niska1 + niska2);

      char slovo = 'j';
      System.out.printf("niska1.indexOf( %c): %d\n", slovo, niska1.indexOf(slovo));
      System.out.printf("niska1.lastIndexOf( %c): %d\n", slovo, niska1.lastIndexOf(slovo));

   }
}
