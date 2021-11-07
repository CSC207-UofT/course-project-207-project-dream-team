import java.util.ArrayList;

class SimpleScheduler {

    public NewCourse course1;
    public NewCourse course2;
    public NewCourse course3;
    public NewCourse course4;
    public NewCourse course5;
    public NewCourse course6;
    public ArrayList<Timetable> output;


    public SimpleScheduler(NewCourse course1, NewCourse course2,
                           NewCourse course3, NewCourse course4,
                           NewCourse course5, NewCourse course6) {
        this.course1 = course1;
        this.course2 = course2;
        this.course3 = course3;
        this.course4 = course4;
        this.course5 = course5;
        this.course6 = course6;
        this.output = new ArrayList<>();
    }
}