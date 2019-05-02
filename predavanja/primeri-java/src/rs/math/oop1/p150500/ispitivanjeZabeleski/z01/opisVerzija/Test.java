package rs.math.oop1.p150500.ispitivanjeZabeleski.z01.opisVerzija;

import java.lang.reflect.Method;

//Applying annotation to the class
@Description( author = "Mitar", date = "1.4.2016" )
@Version( minorVersion = 6 )
public class Test
{
	// Applying annotation to the method
	@Description( date = "aprli li li li" )
	@Version( majorVersion = 112, minorVersion = -7 )
	public static void testMethod()
	{
		System.out.println( "Welcome to Java" );
		System.out.println( "This is an example of Annotations" );
		System.out.println( "--------------------------" );
	}
	
	public static void main( String args[] )
	{
		testMethod();
		showAnnotations();
	}
	
	public static void showAnnotations()
	{
		Test test = new Test();
		try
		{
			Class<?> c = test.getClass();
			System.out.println( "Name of the class: " + c.getName() );
			Description annotDesc1 = c.getAnnotation( Description.class );
			System.out.println( "Author of the class: " + annotDesc1.author() );
			System.out.println( "Date of Writing the class: " + annotDesc1.date() );
			Version anotVer1 = c.getAnnotation( Version.class );
			System.out.println( "Version of the class: " + anotVer1.majorVersion()
					+ "." + anotVer1.minorVersion() );
			
			Method m = c.getMethod( "testMethod" );
			System.out.println( "Name of the method: " + m.getName() );
			Description annotation2 = m.getAnnotation( Description.class );
			System.out.println( "Author of the method: " + annotation2.author() );
			System.out.println( "Date of Writing the method: " + annotation2.date() );
			Version anotVer2 = m.getAnnotation( Version.class );
			System.out.println( "Version of the method: " + anotVer2.majorVersion()
					+ "." + anotVer2.minorVersion() );
		}
		catch (NoSuchMethodException ex)
		{
			System.out.println( "Invalid Method..." + ex.getMessage() );
		}
	}
}
