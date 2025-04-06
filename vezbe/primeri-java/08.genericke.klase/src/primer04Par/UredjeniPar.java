package primer04Par;

// U ovom slucaju radimo s klasom UredjeniPar.
// Kako u uredjenom paru mozemo da imamo par razlicith tipova
// tako ce i nasa genericka klasa sada imati dva parametra T1.
public class UredjeniPar<T1, T2>
{
    private T1 a;
    private T2 b;

    public UredjeniPar(T1 a, T2 b)
    {
        this.a = a;
        this.b = b;
    }

    public T1 prvi()
    {
        return a;
    }

    public T2 drugi()
    {
        return b;
    }

    @Override
    public String toString()
    {
        return "(" + a + ", " + b + ")";
    }
}
