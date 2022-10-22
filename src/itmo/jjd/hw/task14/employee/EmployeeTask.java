package itmo.jjd.hw.task14.employee;

import java.util.Comparator;
import java.util.List;
import java.util.Collections;


public class EmployeeTask {
    public static void main(String[] args) {
        List<Employee> employeeList = Employee.employeeGenerator(50);
        // TODO 1: отсортировать список по имени
        // TODO 2: отсортировать список по имени и зп
        // TODO 3: отсортировать список по имени, зарплате, возрасту и компании
        System.out.println(employeeList);
        Comparator<Employee> comparatorName = new NameComparator();
        Comparator<Employee> comparatorNameSalary = new NameComparator().thenComparing(new SalaryComparator());
        Comparator<Employee> comparatorNameSalaryAgeCompany =
                new NameComparator().thenComparing(new SalaryComparator()).thenComparing(new AgeComparator())
                        .thenComparing(new NameComparator());
        System.out.println("Сортировка по имени: ");
        Collections.sort(employeeList,comparatorName);
        System.out.println(employeeList);
        System.out.println("Сортировка по имени и зарплате: ");
        Collections.sort(employeeList,comparatorNameSalary);
        System.out.println(employeeList);
        System.out.println("Сортировка по имени, зарплате, возрасту: ");
        Collections.sort(employeeList,comparatorNameSalaryAgeCompany);
        System.out.println(employeeList);
    }

    private static class NameComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }

    private static class SalaryComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee o1, Employee o2) {
            return Integer.compare(o1.getSalary(), o2.getSalary());
        }
    }

    private static class AgeComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee o1, Employee o2) {
            return Integer.compare(o1.getAge(), o2.getAge());
        }
    }
}
