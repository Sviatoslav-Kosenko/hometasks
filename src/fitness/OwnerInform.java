package fitness;

import java.util.Objects;

public class OwnerInform {
    private final String name;
    private final String surname;
    private final int yearOfBirth;

    public OwnerInform(String name, String surname, int yearOfBirth) {
        this.name = Objects.requireNonNull(name, "name н.б. null");
        this.surname = Objects.requireNonNull(surname, "surname н.б. null");
        if (yearOfBirth <= 0){
            throw new IllegalArgumentException("yearOfBirth д.б. больше 0");
        }
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OwnerInform that)) return false;
        return yearOfBirth == that.yearOfBirth && name.equals(that.name) && surname.equals(that.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, yearOfBirth);
    }
}