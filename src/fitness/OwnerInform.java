package fitness;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class OwnerInform {
    private String name;
    private String surname;
    LocalDate yearBirth;
    private Area wantArea;

    public OwnerInform(String name, String surname, LocalDate yearBirth, Area wantArea) {
        setName(name);
        setSurname(surname);
        setYearBirth(yearBirth);
        setWantArea(wantArea);
    }

    public void setWantArea(Area wantArea) {
        this.wantArea = wantArea;
    }

    public void setName(String name) {
        if (name.length() < 1) {
            throw new IllegalArgumentException("Имя должно содержать хотя бы 1 символ.");
        }
        this.name = name;
    }
    public void setSurname(String surname){
        if (surname.length() < 1){
            throw new IllegalArgumentException("Фамилия должна содержать хотя бь 1 символ.");
        }
        this.surname = surname;
    }
    public void setYearBirth(LocalDate yearBirth){
        LocalDate now = LocalDate.now();
        long diffYears = ChronoUnit.YEARS.between(yearBirth,now);
        if (diffYears < 18 || diffYears > 90) {
            throw new IllegalArgumentException("Абонемент не может быть продан несовершеннолетним или людям старше 90 лет. ");
        }
        this.yearBirth = yearBirth;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getYearBirth() {
        return yearBirth;
    }

    public Area getWantArea() {
        return wantArea;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OwnerInform that)) return false;
        return yearBirth == that.yearBirth && name.equals(that.name) && surname.equals(that.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, yearBirth);
    }

    @Override
    public String toString() {
        return "OwnerInform{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", yearBirth=" + yearBirth +
                ", wantArea=" + wantArea +
                '}';
    }
}