package itmo.jjd.hw.task7.school;

public class Director extends Person {
    public Director(String name, int age){
        super (name, age);
    }
    public void startEducation(){
        System.out.println("Начало обучения");
    }
    public void endEducation(){
        System.out.println("Конец обучения");
    }
}
