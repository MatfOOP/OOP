package rs.math.oop1.p200300.javaNiti.z01.osnoveThread;


public class ProstaNit extends Thread
{
    public ProstaNit(String str)
    {
        super(str);
    }

    public void run()
    {
        for (int i = 0; i < 20; i++)
        {
            System.out.println(i + " " + getName());
            try
            {
                sleep((long) (Math.random() * 1000));
            }
            catch (InterruptedException e)
            {
            }
        }
        System.out.println("GOTOVO! " + getName());
    }
}