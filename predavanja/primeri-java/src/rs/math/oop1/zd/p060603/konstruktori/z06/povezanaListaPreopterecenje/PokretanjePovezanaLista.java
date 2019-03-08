package rs.math.oop1.zd.p060603.konstruktori.z06.povezanaListaPreopterecenje;

/*
 
Написати Јава програм којим се теестира рад са једноструко повезаном листом ниски.

Функционалност листе је издвојене у посбне класе Lista и ElemenatListe.
 
 */

// Задатак илуструје коришћење референци на објекте за реализацију динамичких структура
// (Lista, ElemenatListe).
// Задатак илуструје преоптерећење конструктора (Lista)

public class PokretanjePovezanaLista {

   public static void main(String[] argumenti) {
      String[] brojevi =
      { "jedan", "dva", "tri" };
      PovezanaLista lista1 = new PovezanaLista(brojevi);
      lista1.dodajElemenatNaPocetak("0");
      lista1.dodajElemenatNaKraj("4");
      String elem = lista1.getPrvi();
      while (elem != null) {
         System.out.print(elem + " ");
         elem = lista1.getSledeci();
      }
      System.out.println();
      lista1 = new PovezanaLista();
      for (int i = 1; i <= 3; i++)
         lista1.dodajElemenatNaKraj(String.valueOf(i));
      for (int i = 4; i <= 6; i++)
         lista1.dodajElemenatNaPocetak(String.valueOf(i));
      elem = lista1.getPrvi();
      while (elem != null) {
         System.out.print(elem + " ");
         elem = lista1.getSledeci();
      }
      System.out.println();
      System.out.println("Uklanja se elemenat "
               + lista1.ukloniElemenatSaPocetka() + "!");
      System.out.println("Uklanja se elemenat "
               + lista1.ukloniElemenatSaKraja() + "!");
      elem = lista1.getPrvi();
      while (elem != null) {
         System.out.print(elem + " ");
         elem = lista1.getSledeci();
      }
   }

}
