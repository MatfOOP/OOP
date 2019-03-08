/**
 * Функције за одређивање НЗД за два и за три цела броја.
 */
package rs.math.oop1.pr.p020203.ucaurenje.z01.objektnoNzdNzs;

class CeoBroj {
    // вредност датог целог броја
    int vrednost;

    // конструктор
    CeoBroj(int vrednostBroja) {
        vrednost = vrednostBroja;
    }

    // метод за приказ целог броја
    void prikaz() {
        System.out.print(vrednost);
        System.out.println();
    }

    // одређивање НЗД датог броја и другог целог броја
    CeoBroj NZD(CeoBroj drugi) {
        int prvaVrednost = vrednost;
        int drugaVrednost = drugi.vrednost;
        while (true)
            if (prvaVrednost > drugaVrednost)
                // први је већи
                if (prvaVrednost % drugaVrednost == 0)
                    return new CeoBroj(drugaVrednost);
                else
                    prvaVrednost %= drugaVrednost;
            else
                // први је мањи или једнак
                if (drugaVrednost % prvaVrednost == 0)
                    return new CeoBroj(prvaVrednost);
                else
                    drugaVrednost %= prvaVrednost;
    }

    // одређивање НЗД датог целог броја, другог броја и трећег броја
    CeoBroj NZD(CeoBroj drugi, CeoBroj treci) {
        return NZD(drugi).NZD(treci);
    }

    // одређивање НЗС датог броја и другог целог броја
    CeoBroj NZS(CeoBroj drugi) {
        CeoBroj nzd = NZD(drugi);
        int nzs = (vrednost * drugi.vrednost) / nzd.vrednost;
        return new CeoBroj(nzs);
    }

    // одређивање НЗС датог целог броја, другог броја и трећег броја
    CeoBroj NZS(CeoBroj drugi, CeoBroj treci) {
        return NZS(drugi).NZS(treci);
    }

}
