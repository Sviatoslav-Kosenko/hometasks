package itmo.jjd.hw.task7.school;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        Teacher[] teachers = {
                new Teacher("Vladimir", 45, "physics"),
                new Teacher("Natalya", 33, "psychology"),
                new Teacher("Elena", 28, "economy"),
                new Teacher("Veronika", 25, "history")
        };

        Student[] students = {
                new Student("Boris", 14, "economy", 10),
                new Student("Denis", 15, "history", 20),
                new Student("Vasya", 10, "physics", 2),
                new Student("Nikolay", 16, "psychology", 25)
        };

        Director director = new Director("Big Boss", 52);

        School school = new School("The Best of the Best", director, teachers, students);
        System.out.println(Arrays.toString(students));
        school.oneDayInSchool();
        System.out.println(Arrays.toString(students));
    }
}
