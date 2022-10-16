package itmo.jjd.hw.task7.school;

public class Student extends Person implements Study {
    private String studySubject;
    private int iqLevel;

    public Student(String name, int age,String studySubject, int iqLevel){
        super(name, age);
        if (studySubject == null){
            throw new IllegalArgumentException("studySubject н.б. null");
        }
        if (iqLevel <= 0){
            throw new IllegalArgumentException("iqLevel д.б. больше 0");
        }
        this.studySubject = studySubject;
        this.iqLevel = iqLevel;
    }

    public String getStudySubject(){
        return studySubject;
    }
    public int getIqLevel() {
        return iqLevel;
    }

    @Override
    public void study() {
        this.iqLevel +=5;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studySubject='" + studySubject + '\'' +
                ", iqLevel=" + iqLevel +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
