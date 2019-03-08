package rs.math.oop1.zd.p110300.generickiTip.z03.kutija;

public class Box<T>
{
	private T uKutiji;
	
	public Box(T t)
	{
		uKutiji = t;
	}
	
	public void set( T t )
	{
		uKutiji = t;
	}
	
	public T get()
	{
		return uKutiji;
	}
	
	@Override
	public String toString()
	{
		return "["+ uKutiji + "]";
	}
	
}