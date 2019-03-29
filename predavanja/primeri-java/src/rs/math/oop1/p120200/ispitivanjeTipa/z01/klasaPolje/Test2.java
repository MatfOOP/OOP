package rs.math.oop1.p120200.ispitivanjeTipa.z01.klasaPolje;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

interface Interfejs1
{
	int m1();
}

class Klasa1 implements Interfejs1
{
	public int i = 6;
	private int j = 7;
	
	@Override
	public int m1()
	{
		return i;
	}
}

class Klasa2 extends Klasa1 implements Cloneable
{
	private int nestoPametno = 7;
	public int nestoGlupo = 6;
		
	public String proba(int i)
	{
		return "Miki_" + i;
	}

	private String proba2()
	{
		return "Miki";
	}
}

public class Test2
{
	
	public static void main( String[] args )
	{
		Klasa2 p2 = new Klasa2();
		Class<?> k2 = null;
		//k2 = p2.getClass();
		//k2 = Klasa2.class;
		try
		{
			k2 = Class.forName( "rs.ac.bg.matf.oop_p.p1215a.reflection.interfejsi.Klasa2" );
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		System.out.println( k2.getName() );
		Class<?>[] i2 = k2.getInterfaces();
		for( Class<?> i: i2)
			System.out.print( i.getName() + " " );
		System.out.println();
	
		Field[] polja2 =  k2.getFields();
		for( Field f: polja2)
			System.out.print( f.getName() + " " );
		System.out.println();
		Method[] metodi2 =  k2.getMethods();
		for( Method m: metodi2)
			System.out.print( m.getName() + " " );
		System.out.println();
		
		System.out.println();
		Class k1 = k2.getSuperclass();
		System.out.println( k1.getName() );
		Class[] i1 = k1.getInterfaces();
		for( Class i: i1)
			System.out.print( i.getName() + " " );
		Field[] polja1 =  k1.getDeclaredFields();
		System.out.println();
		for( Field f: polja1)
			System.out.print( f.getName() + " " );
		System.out.println();
		Method[] metodi1 =  k1.getDeclaredMethods();
		for( Method m: metodi1)
			System.out.print( m.getName() + " " );
		System.out.println();
		
	}
}