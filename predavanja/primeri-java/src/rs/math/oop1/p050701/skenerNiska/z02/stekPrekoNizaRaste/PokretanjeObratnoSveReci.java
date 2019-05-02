/*
  
Написати Јава програм који чита са стандардног улаза све унесене речи и те речи
потом приказује на стандардни излаз у обрнутом редоследу.
    
Задатак ће се реаизовати коришењем струкуре података стек.

Број речи није унапред познат, па треба оформити стек који по потреби "расте".

Комбинација тастера којом корисник означава крај уноса зависи од оперативног
система рачунара на ком се извршава овај програм, обично је то <Ctrl>+z за 
Windows системе, односно <Ctrl>+d за Unix системе 

*/

// Програм илуструје коришење стека који може да расте по потреби у циљу
// чувања и преписа података.

package rs.math.oop1.p050701.skenerNiska.z02.stekPrekoNizaRaste;


public class PokretanjeObratnoSveReci {

    public static void main(String[] args) {
        String tekst = new StringBuilder()
                .append("Ovo je priča koju vrlo rado pričam \n")
                .append("Priča o Boži zvanom PUB \n")
                .append("Jedni ga hvale, drugi žale... \n")
                .toString();
        System.out.println("Tekst:\n" + tekst);
        StekNiski reci = new StekNiski();
        reci.init();
        java.util.Scanner skener = new java.util.Scanner(tekst);
        while (skener.hasNext()) {
            String rec = skener.next();
            reci.push(rec);
        }
        skener.close();
        System.out.println("\nReci teksta u obratnom redosledu:\n");
        while (reci.brojElemenata() > 0)
            System.out.print(reci.pop() + " ");
    }
}
