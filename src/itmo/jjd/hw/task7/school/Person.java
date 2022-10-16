package itmo.jjd.hw.task7.school;

public class Person {
    protected String name;
    protected int age;

    public Person (String name, int age){
        if (name == null){
            throw new IllegalArgumentException("name н.б. null");
        }
        if (age <= 0){
            throw new IllegalArgumentException("age д.б. больше 0");
        }
        this.name = name;
        this.age = age;
    }

    public String getName (){
        return name;
    }

    public int getAge(){
        return age;
    }
}
