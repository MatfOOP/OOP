// Програм илуструје употребу различитих типова целобројних података. 

class PokretanjeCeoBrojOpsegVrednosti {

   public static void main(String[] args) {
	   byte byteBroj1 = 23;
	   //byte byteBroj2 = 423; //ne može da se prevede, jer je broj veći od 127
	   byte byteBroj3 = -128; //najmanji dozvoljeni broj ovog tipa podataka
	   
	   short shortBroj = 32333;
	   int intBroj1 = -2000000000; //-2 milijarde
	   //int intBroj2 = -2500000000; //-2 milijarde
	   int intBroj3 = intBroj1 - 500000000; //ako oduzmemo jos 500 miliona, desiće se potkoračenje
	   System.out.println(intBroj3); //ispisuje neki pozitivan broj, dakle, potkoračenje
	   
	   long longBroj1 = intBroj1 - 500000000;
	   //i dalje potkoračenje, jer je rezultat oduzimanja najpre prebačen u tip int, pa potom u long
	   System.out.println(longBroj1); 
	   //kvalifikator L forsira oduzimanje u aritmetici duple preciznosti (long)
	   long longBroj2 = intBroj1 - 500000000L; 
	   System.out.println(longBroj2); //sada je u redu

	   //char tip podataka je specifičan, jer ima dvostruku reprezentaciju
	   char charBroj1 = 97; //inicijalizacija brojem
	   char charBroj2 = 'b'; //inicijalizacija karakterom
	   System.out.println(charBroj1); //podrazumevani ispis je u karakterskoj reprezentaciji
	   System.out.println(charBroj2);

   }
}
