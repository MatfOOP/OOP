package rs.math.oop1.p190201.funkcionalniInterfejsi.z03a.osobe.osobe;

@FunctionalInterface
interface CheckPerson { 
	boolean test(Person p);

	default void prikaziSe(Person p){ System.out.println(p);}
}

