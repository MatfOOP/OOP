package primer02Kutija;

public class Main
{
    public static void main(String[] args)
    {
        // Tip predmeta nase kutije ce biti Integer
        // Razlog zasto nam je potreban Integer a ne int je sto se zahteva klasni a ne primitivni tip
        Kutija<Integer> kutija = new Kutija<>(); // Identicno kao Kutija<Integer> kutija = new Kutija<Integer>(), kompajler moze to sam da zakljuci
        System.out.println("Ubacuje se predmet 10");
        kutija.ubaciPredmet(10);
        System.out.println(kutija);

        System.out.println("Uklanja se predmet");
        // Primetimo da iako uzmiPredmet vraca Integer,
        // kompajler omogucava automatsku konverziju u primitivni tip
        int izvadjenPredmet = kutija.uzmiPredmet();
        System.out.println("Izvadjen predmet: " + izvadjenPredmet);
        System.out.println(kutija);
    }
}
