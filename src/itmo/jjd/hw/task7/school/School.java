package itmo.jjd.hw.task7.school;

public class School {
    private final String nameSchool;
    private Director director;
    private Teacher[] teachers;
    private Student[] students;

    public School(String nameSchool,Director director,Teacher[] teachers,Student[] students){
        if (nameSchool == null){
            throw new IllegalArgumentException("nameSchool н.б. null");
        }
        if (director == null){
            throw new IllegalArgumentException("director н.б. null");
        }
        if (teachers == null){
            throw new IllegalArgumentException("teachers н.б. null");
        }
        if (students == null){
            throw new IllegalArgumentException("students н.б. null");
        }
        this.nameSchool = nameSchool;
        this.director = director;
        this.teachers = teachers;
        this.students = students;
    }
    public void oneDayInSchool(){
        this.director.startEducation();
        for (int i = 0; i < students.length; i++) {
            for (int j = 0; j < teachers.length; j++) {
                if (this.students[i].getStudySubject().
                        equals(this.teachers[j].getTeachSubject())) {
                    this.teachers[j].teach(this.students[i]);
                break;
            }
        }
    }
    this.director.endEducation();
    }
}