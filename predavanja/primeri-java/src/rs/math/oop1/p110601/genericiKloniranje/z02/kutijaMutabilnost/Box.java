package rs.math.oop1.p110601.genericiKloniranje.z02.kutijaMutabilnost;

public class Box<T extends KloniraSe<T>>
{
	private T uKutiji;
	
	public Box( T t )
	{
		try
		{
			Object o = ((KloniraSe<T>)t).clone();
			uKutiji = (T) o;
		}
		catch (CloneNotSupportedException e)
		{
			System.out.println( e );
		}
	}
	
	public void set( T t )
	{
		uKutiji = t;
	}
	
	public T get()
	{
		return uKutiji;
	}
	
	public String toString()
	{
		return "[" + uKutiji + "]";
	}
	
}