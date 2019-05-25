package rs.math.oop1.p190202.predefinisaniFunkcionalniInterfejsi.z01.osobePredicate;

import java.util.List;
import java.util.function.Predicate;

public class LambdaTest01 {
    static void printPersons(List<Person> roster, Predicate<Person> filter) {
        for (Person p : roster) {
            if (filter.test(p)) {
                p.printPerson();
            }
        }
    }

    public static void main(String[] args) {
        printPersons(Person.LJUDI, (Person p) ->
                {
                    if (p.getAge() >= 79)
                        return true;
                    else
                        return false;
                }
        );
        System.out.println();

        printPersons(Person.LJUDI, p -> {
            return (p.getAge() >= 80 && p.getAge() <= 85);
        });
        System.out.println();


        printPersons(Person.LJUDI, p -> p.emailAddress.indexOf("disney") >= 0);

    }

}
