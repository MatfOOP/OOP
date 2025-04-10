/*
 
 Написати Јава програм који омогућује рад са студентима и професорима.
 
 Подаци о студентима и професорима су организовани у посебним класама, 
 које се налазе у одвојеним датотекама.
 
   
 Активности студената и професора су оргаизовани тако да буду заједно
 са подацима. Информације о предметима су издвојене у посебну класу.
 
 */

// Задатак илуструје примену наредбе увоза (за класу java.util.Scanner).

package rs.math.oop1.z070403.metodiKlasni.z03.fakultet;

import java.util.Scanner;

public class PokretanjeFakultet {

   public static void main(String[] args) {
      String s = "Petar \n Petrovic \n RI \n docent \n da ne da da da";
      Scanner skener = new Scanner(s);
      Profesor prof = Profesor.ucitaj(skener, false);
      prof.prikazi();
      
      s = "Ivan \n Ivanovic \n R \n 112 \n 2016 \n 2 \n -1 -1 9 9 6  ";
      skener = new Scanner(s);
      Student stud = Student.ucitaj(skener, false);
      stud.prikazi();
   }
}


