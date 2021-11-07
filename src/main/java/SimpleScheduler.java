import java.sql.Time;
import java.util.ArrayList;

class SimpleScheduler extends Scheduler {

    public SimpleScheduler(ArrayList<Course> courses){
        super(courses);
    }


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