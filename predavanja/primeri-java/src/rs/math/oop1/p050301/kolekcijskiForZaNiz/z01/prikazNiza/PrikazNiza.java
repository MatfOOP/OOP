/*
  
Написати Јава програм који омогућује да се оформи низ дате димензије, 
да сви чланови низа добију унаред задату вредност 
и да се потом применом колекцијског for циклуса прикажу вредности свих 
чланова низа. 
  
*/

// Програм илуструје алокацију низа, постављање вредности за елементе низа,
// очитавање вредности за елементе низа и колекцијску for петљу. 

package rs.math.oop1.p050301.kolekcijskiForZaNiz.z01.prikazNiza;

public class PrikazNiza {
    public static void main(String[] args) {
        int n = 0b0000_1001; //binarni broj
        double[] niz = new double[n];
        double x = -23.34e1;
        for (int i = 0; i < niz.length; i++)
            niz[i] = x + i;
        System.out.println();
        for (double d : niz)
            System.out.printf("%8.2f ", d);
    }
}
