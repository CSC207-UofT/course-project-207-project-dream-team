import java.util.ArrayList;

public abstract class Scheduler {
    ArrayList<Course[]> courses;//courses ready to be arranged

    public Scheduler(ArrayList<Course[]> courses){
        this.courses = courses;
    }

    public abstract Timetable Arrange(){
/
    }
}
