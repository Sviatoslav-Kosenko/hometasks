package itmo.jjd.hw.task17.student;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
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
        Map<Student.Gender, List<Student>> map01 = students.stream()
                .collect(Collectors.groupingBy(Student::getGender));
        System.out.println(map01);
        //  2. Найти средний возраст учеников
        List<Long> ages = students.stream().map(student -> ChronoUnit.YEARS.between(student.getBirth(), LocalDate.now()))
                .collect(Collectors.toList());
        for (Long age : ages) {
            avr += age;
        }
        System.out.println(avr/ages.size());

        //  3. Найти самого младшего ученика
        List<Student> junior = Collections.singletonList(students.stream()
                .min(Comparator.comparing(Student::getBirth)).get());
        System.out.println(junior);

        //  4. Найти самого старшего ученика
        List<Student> old = Collections.singletonList(students.stream()
                .max(Comparator.comparing(Student::getBirth)).get());
        System.out.println(old);

        // 5. Собрать учеников в группы по году рождения
        Map<Integer, List<Student>> map03 = students.stream()
                .collect(Collectors.groupingBy(student -> student.getBirth().getYear()));
        System.out.println(map03);

        //  6. Убрать учеников с одинаковыми именами, имена и дату рождения оставшихся вывести в консоль
        Map<String, List<Student>> map04 = students.stream()
                .collect(Collectors.groupingBy(student -> student.getName()));
        for (List<Student> studentList : map04.values()){
            if (students.size() == 1) System.out.println(
                    "Name: " + students.get(0).getName() + "Birth: " + students.get(0).getBirth());
        }
        System.out.println(map04);

        //  7. Отсортировать по полу, потом по дате рождения, потом по имени (в обратном порядке), собрать в список (List)
        List<Student> studentList01 = students.stream()
                .sorted(Comparator.comparing(Student::getGender).thenComparing(Student::getBirth)
                        .thenComparing((students1,students2) -> students2.getName().compareTo(students1.getName())))
                .collect(Collectors.toList());
        System.out.println(studentList01);

        //  8. Вывести в консоль всех учеников в возрасте от N до M лет

        //  9. Собрать в список всех учеников с именем=someName


    }
}