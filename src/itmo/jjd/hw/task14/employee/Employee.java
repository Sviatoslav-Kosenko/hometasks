package itmo.jjd.hw.task14.employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Employee {
    private String name;
    private String company;
    private int salary;
    private int age;
    // TODO: добавить конструктор, необходимы геттеры и сеттеры

    public Employee(String name, String company, int salary, int age) {
        this.name = name;
        this.company = company;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = Objects.requireNonNull(name,"name н б NULL");
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = Objects.requireNonNull(company,"company н б NULL");
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        if (salary < 0){
            throw new IllegalArgumentException("salary н б меньше чем 0");
        }
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 21){
            throw new IllegalArgumentException("age  н б меньше чем 21");
        }
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
    // TODO: дописать реализацию метода для создания списка из объектов класса Employee.
    //  Объекты Employee создавать с рандомными значениями. Возраст от 21 до 60 и не забудьте про зп.
    //  num - количество объектов в списке
    public static List<Employee> employeeGenerator(int num) {
        String[] names = {"Mike", "Tom", "Alex", "John", "Peter", "Jack", "Charlie", "Max", "Jenifer", "Linda", "Elizabeth"}; // массив с именами
        String[] companies = {"Microsoft", "IBM", "Google", "General Electric", "Siemens", "Samsung", "Apple"}; // массив с названиями компаний

        ArrayList<Employee> employee = new ArrayList<>(num);
        // создание объектов, наполнение списка
        for (int i = 0; i < num; i++){
            employee.add(new Employee(names[(int)(Math.random() * names.length)],
                    companies[(int)(Math.random() * companies.length)],(int)(Math.random() * 4),
                    (int)(21 + Math.random() * 39) ));
        }
        return employee;
    }
}
