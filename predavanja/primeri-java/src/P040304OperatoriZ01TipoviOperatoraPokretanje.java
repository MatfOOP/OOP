// Програм илуструје неке од оператора програмског језика Јава.

class PokretanjeOperatori {

   public static void main(String[] args) {
	   int a=10;
       int b=5;
       int c=100;
       int d=10, e=10;

       //aritmeticki operatori
       System.out.println(a+b);//15
       System.out.println(a-b);//5
       System.out.println(a*b);//50
       System.out.println(a/b);//2 - celobrojno deljenje jer su oba operanda celobrojna
       System.out.println(a%b);//0 - ostatak pri deljenju

       System.out.println(10*10/5+3-1*4/2); //21 - malo slozeniji izraz
       System.out.println(10*10/(5+3)-1*4/2); //10 - zagradama mozemo promeniti podrazumevani prioritet operatora

       //unarni aritmeticki operatori - demonstracija pre/post-inkrementacije/dekrementacije
       System.out.println(c++);//100 (101 nakon ispisa)
       System.out.println(++c);//102
       System.out.println(c--);//102 (101 nakon ispisa)
       System.out.println(--c);//100

       System.out.println(d++ + ++d);//10+12=22 (prvi operand ulazi u zbir nepromenjen zbog postinkrementacije)
       System.out.println(e++ + e++);//10+11=21 (prvi ulazi nepromenjen, a drugi promenjen samo za prethodnu inkrementaciju)

       //relacioni operatori
       System.out.println(3>2);//true
       System.out.println(2>2);//false
       //System.out.println(3>2 == 20>-2);//true (true == true)
       //System.out.println(3>2 != 20>-2);//false (true != true)

       //logicki operatori
       //System.out.println(2>3 && 3<4);//false (false && true)
       System.out.println(a>3 && 3<4);//true (true && true)
       System.out.println(2>3 || 3<4);//true (false || true)
       System.out.println(!(2>3) && 3<4);//true (!false && true --> true && true)

       //operatori po bitovima
       int f = 12, g = 25, h = -5;
       //f  = 0...00001100
       //g  = 0...00011001
       //h  = 1...11111011

       System.out.println(f | g); //0...00011101 = 29
       System.out.println(f & g); //0...00001000 = 8
       System.out.println(h>>1); //1...11111101 = -3 (desni shift vodi racuna o znaku)
       System.out.println(h>>>1); //01...11111101 = 2147483645 (desni shift koji ne vodi racuna o znaku)
       System.out.println(h<<2); //1...11101100 = -20 (levi shift dodaje 0 sa desne strane)
       System.out.println(~f); //1...11110011 = -13 (komplement)
       System.out.println(f^g); //0...00010101 = 21 (ekskluzivna disjunkcija)

       //uslovni operator
       int min = (a<b)?a:b;
       System.out.println(min); //5 (a)

       //operatori dodele
       a+=3;//10+3
       System.out.println(a); //13
       a-=4;//13-4
       System.out.println(a); //9
       a*=2;//9*2
       System.out.println(a); //18
       a/=2;//18/2
       System.out.println(a); //9
       a+=(a*b); //9+(9*5)
       System.out.println(a); //54
   }
}
