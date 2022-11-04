package itmo.jjd.hw.task16.student;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class StudentTask {
    public static void main(String[] args) {
        long avr = 0;
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student(1, "Женя", Student.Gender.MALE, LocalDate.now().minusYears(10)),
                new Student(2, "Олег", Student.Gender.MALE, LocalDate.now().minusYears(7)),
                new Student(3, "Алена", Student.Gender.FEMALE, LocalDate.now().minusYears(6)),
                new Student(4, "Иван", Student.Gender.MALE, LocalDate.now().minusYears(12)),
                new Student(5, "Алексей", Student.Gender.MALE, LocalDate.now().minusYears(9)),
                new Student(6, "Петр", Student.Gender.MALE, LocalDate.now().minusYears(9)),
                new Student(7, "Иван", Student.Gender.MALE, LocalDate.now().minusYears(17)),
                new Student(8, "Петр", Student.Gender.MALE, LocalDate.now().minusYears(5)),
                new Student(9, "Алена", Student.Gender.FEMALE, LocalDate.now().minusYears(8)),
                new Student(10, "Алена", Student.Gender.FEMALE, LocalDate.now().minusYears(10)),
                new Student(11, "Григорий", Student.Gender.MALE, LocalDate.now().minusYears(7)),
                new Student(12, "Ирина", Student.Gender.FEMALE, LocalDate.now().minusYears(6))
        ));

        // TODO: Используя Stream API:
        //  1. Разделить учеников на две группы: мальчиков и девочек. Результат: Map<Student.Gender, ArrayList<Student>>
        //  2. Найти средний возраст учеников
        //  3. Найти самого младшего ученика
        //  4. Найти самого старшего ученика
        //  5. Собрать учеников в группы по году рождения
        //  6. Убрать учеников с одинаковыми именами, имена и дату рождения оставшихся вывести в консоль
        //  7. Отсортировать по полу, потом по дате рождения, потом по имени (в обратном порядке), собрать в список (List)
        //  8. Вывести в консоль всех учеников в возрасте от N до M лет
        //  9. Собрать в список всех учеников с именем=someName
        //  10. Собрать Map<Student.Gender, Integer>, где Student.Gender - пол, Integer - суммарный возраст учеников данного пола

        //  1. Разделить учеников на две группы: мальчиков и девочек. Результат: Map<Student.Gender, ArrayList<Student>>
        Map<Student.Gender, ArrayList<Student>> map01 = students.stream()
                .collect(Collectors.groupingBy(Student::getGender,
                        Collectors.toCollection(ArrayList::new)));
        System.out.println(map01);
        //  2. Найти средний возраст учеников
            System.out.println(
                students.stream().collect(Collectors.averagingInt(student-> LocalDate.now().getYear() -
                student.getBirth().getYear()))
        );
        //  3. Найти самого младшего ученика
        Student junior = students.stream().max(Comparator.comparing(Student::getBirth)).orElse(null);
        System.out.println(junior);
        //  4. Найти самого старшего ученика
        Student old = students.stream().min(Comparator.comparing(Student::getBirth)).orElse(null);
        System.out.println(old);
        // 5. Собрать учеников в группы по году рождения
        Map<Integer, List<Student>> mapByBirth = students.stream()
                .collect(Collectors.groupingBy(student -> student.getBirth().getYear()));
        System.out.println(mapByBirth);
        //  6. Убрать учеников с одинаковыми именами, имена и дату рождения оставшихся вывести в консоль
        Collection<Student> uniqueByName = students.stream()
                .collect(Collectors.toMap(
                        Student::getName,
                        Function.identity(),
                        ((stud1, stud2) -> stud1)
                )).values();
        uniqueByName.forEach(student -> System.out.println(student.getName() + ": " + student.getBirth()));
        //  7. Отсортировать по полу, потом по дате рождения, потом по имени (в обратном порядке), собрать в список (List)
       students.sort(
               Comparator.comparing(Student::getGender)
                       .thenComparing(Student::getBirth)
                       .thenComparing(Student::getName).reversed()
       );
        System.out.println(students);
        //  8. Вывести в консоль всех учеников в возрасте от N до M лет
        int from = 10;
        int to = 10;
        students.forEach(pupil -> {
            if (LocalDate.now().getYear() - pupil.getBirth().getYear() < to
                    && LocalDate.now().getYear() - pupil.getBirth().getYear() >= from){
                System.out.println(pupil);
            }
        });
        //  9. Собрать в список всех учеников с именем=someName
        List<Student> studentByName = students.stream()
                .filter(student -> student.getName().equals("Петр")).toList();
        // 10. Собрать Map<Pupil.Gender, Integer>,
        // где Pupil.Gender - пол, Integer - суммарный возраст учеников данного пола
        Map<Student.Gender, Integer> genderCount = students.stream()
                .collect(Collectors.groupingBy(Student::getGender
                ,Collectors.summingInt(student -> LocalDate.now().getYear()
                                - student.getBirth().getYear())));
        System.out.println(genderCount);
    }
}