package rs.math.oop1.p120200.ispitivanjeTipa.z05.klasaPolje;

import java.util.*;
import java.lang.reflect.*;

public class ReflectionTest3
{
		public static void printFields( Class<?> cl )
	{
		Field[] fields = cl.getDeclaredFields();
		for (Field f : fields)
		{
			Class<?> type = f.getType();
			String name = f.getName();
			System.out.print( "   " );
			String modifiers = Modifier.toString( f.getModifiers() );
			if (modifiers.length() > 0)
				System.out.print( modifiers + " " );
			System.out.println( type.getName() + " " + name + ";" );
		}
	}

	public static void printConstructors( Class<?> cl )
	{
		Constructor<?>[] constructors = cl.getDeclaredConstructors();
		for (Constructor<?> c : constructors)
		{
			String name = c.getName();
			System.out.print( "   " );
			String modifiers = Modifier.toString( c.getModifiers() );
			if (modifiers.length() > 0)
				System.out.print( modifiers + " " );
			System.out.print( name + "(" );			
			// print parameter types
			Class<?>[] paramTypes = c.getParameterTypes();
			for (int j = 0; j < paramTypes.length; j++)
			{
				if (j > 0)
					System.out.print( ", " );
				System.out.print( paramTypes[j].getName() );
			}
			System.out.println( ");" );
		}
	}
	
	public static void printMethods( Class<?> cl )
	{
		Method[] methods = cl.getDeclaredMethods();
		
		for (Method m : methods)
		{
			Class<?> retType = m.getReturnType();
			String name = m.getName();
			System.out.print( "   " );
			// print modifiers, return type and method name
			String modifiers = Modifier.toString( m.getModifiers() );
			if (modifiers.length() > 0)
				System.out.print( modifiers + " " );
			System.out.print( retType.getName() + " " + name + "(" );
			// print parameter types
			Class<?>[] paramTypes = m.getParameterTypes();
			for (int j = 0; j < paramTypes.length; j++)
			{
				if (j > 0)
					System.out.print( ", " );
				System.out.print( paramTypes[j].getName() );
			}
			System.out.println( ");" );
		}
	}
	
	public static void main( String[] args )
	{
		// read class name from command line args or user input
		String name;
		if (args.length > 0)
			name = args[0];
		else
		{
			Scanner in = new Scanner( System.in );
			System.out.println( "Enter class name (e.g. java.util.Date): " );
			name = in.next();
			in.close();
		}
		try
		{
			// print class name and superclass name (if != Object)
			Class<?> klasa = Class.forName( name );
			Class<?> nadklasa =klasa.getSuperclass();
			String modifiers = Modifier.toString(klasa.getModifiers() );
			if (modifiers.length() > 0)
				System.out.print( modifiers + " " );
			System.out.print( "class " + name );
			if (nadklasa != null && nadklasa != Object.class)
				System.out.print( " extends " + nadklasa.getName() );
			Class<?>[] interfaces =klasa.getInterfaces();
			System.out.println( (interfaces.length>0) ? " implements " : "");
			for (int i = 0; i < interfaces.length; ++i)
			{
				System.out.println( interfaces[i].getName() 
						+ ((i!=interfaces.length-1)?", ":"") );
			}
			System.out.print( "\n{\n" );
			printFields(klasa );
			System.out.println();
			printConstructors(klasa );
			System.out.println();
			printMethods(klasa );
			System.out.println( "}" );
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		System.exit( 0 );
	}
	
}
