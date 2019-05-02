package rs.math.oop1.p070602.visekriterijumskoUredjenje.z02.zaposleni;

import java.util.*;

public class EmployeeSortTest
{
	public static void main( String[] args )
	{
		Employee[] staff = new Employee[4];
		
		staff[0] = new Employee( "Harry Hacker", 75000 );
		staff[1] = new Employee( "Carl Cracker", 75000 );
		staff[2] = new Employee( "Tony Tester", 38000 );
		staff[3] = new Employee( "Johnny Bravo", 18000 );
		
		System.out.println( "-Pre sortiranja-" );
		for (Employee e : staff)
			System.out.println( "name=" + e.getName() + ",salary=" + e.getSalary() );
		
		System.out.println( "-Podrazumevano-" );
		Arrays.sort( staff );
		for (Employee e : staff)
			System.out.println( "name=" + e.getName() + ",salary=" + e.getSalary() );	
		
		System.out.println( "-Po imenu-" );
		Comparator c = new EmployeeNameComparator();
		Arrays.sort( staff, c );
		for (Employee e : staff)
			System.out.println( "name=" + e.getName() + ",salary=" + e.getSalary() );
		
		System.out.println( "-Po imenu obratno-" );
		Arrays.sort( staff, new EmployeeNameReverseComparator() );
		for (Employee e : staff)
			System.out.println( "name=" + e.getName() + ",salary=" + e.getSalary() );
		
		System.out.println( "-Po plati-" );
		Arrays.sort( staff, new EmployeeSalaryComparator() );
		for (Employee e : staff)
			System.out.println( "name=" + e.getName() + ",salary=" + e.getSalary() );


	}
}
