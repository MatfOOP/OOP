package primer01Student;

public class Main {

	public static void main(String[] args) {
		Student s1 = new Student("M", "Matematic", "mm0012016", 10.0);
		Student s2 = new Student("N", "Numerovic", "mn3142014", 9.5);
		Student s3 = new Student("V", "Verovatnic", "mv3142015", 8.5);
		Student s4 = new Student("N", "Nastavnic", "ml3142014", 9.5);
		Student s5 = new Student("R", "Racunalo", "mr3142017", 9.7);
		Student s6 = new Student("I", "Informatikovic", "mi3142015", 9.7);
		Student s7 = new Student("A", "Afikic", "af3142014", 8.5);
		Student s8 = new Student("A", "Ainformatikovic", "ai3142014", 8.5);
		
		Student[] studenti = {s1, s2, s3, s4, s5, s6, s7, s8};
		for (Student student : studenti)
			System.out.println(student);
		
		
		/*
			 sledeci poziv funkcije za ispis ekvivalentan je prethodnom, jer u  
			 slucaju da se funkciji za ispis ne prosledi nista osim objekta, 
			 implicitno se poziva bas toString() metod nad objektom
			
			 NAPOMENA: cak i u slucaju da toString() metod nije definisan u okviru
			 klase kojoj pripada objekat za koji je pozvan metod ispisa, nece doci
			 do greske, jer ce biti pozvan odgovarajuci metod koji se nalazi unutar klase 
			 Object() koju sve ostale klase koje pisemo nasledjuju (a o nasledjivanju ce
			 biti vise reci na sledecem casu :) )
			 
			System.out.println(student.toString());
			*/

	}

}
