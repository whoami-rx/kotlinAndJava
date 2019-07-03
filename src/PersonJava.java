import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

public class PersonJava {
    private static Long nextId = 0L;
    private Long id;
    private String title;
    private String firstName;
    private String surname;
    private final Calendar dateOfBirth;

    public PersonJava(String title, String firstName, String surname, Calendar dateOfBirth) {
        id = nextId;
        nextId++;
        this.title = title;
        this.firstName = firstName;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getTitle() { return title; }
    public String getSurname() { return surname; }

    @Override
    public String toString() {
        return title + " " + firstName + " " + surname;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || this.getClass() != other.getClass()) return false;
        PersonJava that = (PersonJava) other;
        return Objects.equals(id, that.id) &&
                Objects.equals(title, that.title) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(surname, that.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, surname);
    }

    public static int getAge(Calendar dateOfBirth) {
        if (dateOfBirth == null) return -1;
        Calendar today = new GregorianCalendar();
        int years = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
        if (dateOfBirth.get(Calendar.DAY_OF_YEAR) >= today.get(Calendar.YEAR)) {
            return years - 1;
        }
        return years;
    }
}
