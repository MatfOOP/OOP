// Програм илуструје валидну азбуку језика Јава. 

package rs.math.oop1.zd.p040200.azbukaJava.z01.brojkeSlova;

public class JavaAzbuka {

   public static void main(String[] args) {
	   //brojevi su validni elementi azbuke Java jezika
	   int n = 2353;

	   /* dozvoljena je upotreba UNICODE slova kako u nazivima promenljivih
	    * tako i u njihovim vrednostima, komentarima, itd.
	    */
	   String rečenica = "Ipak, ne-ASCII slova nisu poželjna u nazivima promenljivih.";
	   String реченица = "Ovako nešto je još gore!";
	   String recenica = "Ovako je bolje.";
	   String kombinovanaPisma = "Могу се mešati različita pisma, односно алфабети. Ово је нпр. нешто на тајландском: บางสิ่งบางอย่าง.";
	   System.out.println(kombinovanaPisma);
   }
}
