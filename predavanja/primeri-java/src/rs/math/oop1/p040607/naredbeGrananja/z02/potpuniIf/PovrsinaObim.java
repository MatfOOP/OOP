// Пример илуструје употребу потпуног if израза који омогућава разматрање свих могућих вредности посматраног услова.

package rs.math.oop1.p040607.naredbeGrananja.z02.potpuniIf;

public class PovrsinaObim {

   public static void main(String[] args) {
       double obim, povrsina;
       double pi = 3.14159265359;
       String figura = "krug";
       double x = 10;

       if (figura.equals("krug")) {
           obim = 2 * pi * x;
           povrsina = pi * x * x;
       } else if(figura.equals("kvadrat")){
           obim = 4 * x;
           povrsina = x * x;
       }else{
           //izlazimo, nismo predvideli racunanje za bilo sta drugo osim za kvadrat i krug
           return;
       }
       System.out.println("Povrsina "+povrsina+". Obim "+obim+".");
   }
}
