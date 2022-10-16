package itmo.jjd.hw.task7.school;

public class Teacher extends Person implements Teach{
    private String teachSubject;
    public Teacher (String name, int age, String teachSubject){
        super(name,age);
        if (teachSubject == null){
            throw new IllegalArgumentException("teachSubject н.б. null");
        }
        this.teachSubject = teachSubject;
    }

    public String getTeachSubject(){
        return teachSubject;
    }

    @Override
    public void teach(Study student) {
        if (student == null){
            throw new IllegalArgumentException("student н.б. null");
        }
        student.study();
        return;
    }
}
