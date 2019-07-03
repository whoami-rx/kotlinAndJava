import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

public class PersonJavaTest {
    static void printTitle(String message) {
        System.out.print(message);
        System.out.println("*".repeat(50));
    }
    public static void main(String[] args) {
        PersonJava john = new PersonJava(
                "Programmer",
                "John",
                "Smith",
                new GregorianCalendar(1991, 02, 02));
        PersonJava sarah = new PersonJava(
                "Designer",
                "Sarah",
                "Doe",
                new GregorianCalendar(1990, 5, 12));

        printTitle("Test toString() ");
        System.out.println(john);
        System.out.println(sarah);
        printTitle("Test equals() ");
        System.out.println("Should be false: " + john.equals(sarah));
        System.out.println("Should be true: " + john.equals(john));
        printTitle("Test hashCode()");
        Set<PersonJava> set = new HashSet<>();
        set.add(john);
        System.out.println("Should be false: " + set.contains(sarah));
        System.out.println("Should be true " + set.contains(john));
        printTitle("Test static method");
        System.out.println("1990 - 2019 = " + PersonJava.getAge(
                new GregorianCalendar(1990, 1, 1)
        ));
    }
}
