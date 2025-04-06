package primer01GenerickaFunkcija;

public class GenerickaFunkcija
{
    // Parametar <T> navodimo kako bi naznacili da je u pitanju genericki tip T
    // koji se na dalje koristi u definiciji funkcije.
    // Na ovaj nacin generalizujemo ispis. Ovo je veoma korisno za uopstavanje metoda
    // koje treba da imaju samo neke zajednicke osobine. U ovom slucaju je to metoda toString()
    // Ovo je posebno korisno kada želimo da pisemo metode koje funkcionisu sa vise tipova,
    // bez potrebe da pisemo posebnu verziju za svaki tip (npr. int, String, Tačka...).
    // Umesto toga, pišemo jednu genericku metodu koja može da obradi sve te tipove,
    // dokle god ispunjavaju potrebne uslove (npr. imaju implementiran toString(),
    // ili podržavaju poređenje itd.).
    public static <T> void print(T a)
    {
        System.out.println(a.toString());
    }

    public static void main(String[] args)
    {
        print(5);
        print("Hello world");
        print(new Tacka(2, 3));
    }
}
