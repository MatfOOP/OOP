package primer05GenerickiStek;

// Setite se da smo ranije na vezbama pravili stek koji je radio sa brojevima.
// Kako osobine steka, dodavnje, skidanje i posmatranje elementa na vrhu ne zavise od konkretnog tipa,
// dosao je svecani trenutak da napravimo genericki stek!
public interface GenerickiStek<T>
{
    // Vraca element sa vrha steka.
    T peek();

    // Skida element sa vrha stek i vraca ga.
    T pop();

    // Smesta t na vrh steka.
    void push(T v);
}
