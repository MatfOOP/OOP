
public class NoviCeoBroj {
    // вредност датог целог броја
    private int vrednost;

    // конструктор
    public NoviCeoBroj(int vrednostBroja) {

        vrednost = vrednostBroja;
    }

    // метод за приказ целог броја
    public void prikaz() {
        System.out.print(vrednost);
        System.out.println();
    }

    // одређивање НЗД датог броја и другог целог броја
    public NoviCeoBroj NZD(NoviCeoBroj drugi) {
        int prvaVrednost = vrednost;
        int drugaVrednost = drugi.vrednost;
        while (true)
            if (prvaVrednost > drugaVrednost)
                // први је већи
                if (prvaVrednost % drugaVrednost == 0)
                    return new NoviCeoBroj(drugaVrednost);
                else
                    prvaVrednost %= drugaVrednost;
            else
                // први је мањи или једнак
                if (drugaVrednost % prvaVrednost == 0)
                    return new NoviCeoBroj(prvaVrednost);
                else
                    drugaVrednost %= prvaVrednost;
    }

    // одређивање НЗД датог целог броја, другог броја и трећег броја
    public NoviCeoBroj NZD(NoviCeoBroj drugi, NoviCeoBroj treci) {
        return NZD(drugi).NZD(treci);
    }

    // одређивање НЗС датог броја и другог целог броја
    public NoviCeoBroj NZS(NoviCeoBroj drugi) {
        NoviCeoBroj nzd = NZD(drugi);
        int nzs = (vrednost * drugi.vrednost) / nzd.vrednost;
        return new NoviCeoBroj(nzs);
    }

    // одређивање НЗС датог целог броја, другог броја и трећег броја
    public NoviCeoBroj NZS(NoviCeoBroj drugi, NoviCeoBroj treci) {
        return NZS(drugi).NZS(treci);
    }

}

