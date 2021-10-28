import java.util.ArrayList;

public abstract class Scheduler {

    public ArrayList<Course> courses;  // courses to arrange

    public Scheduler(ArrayList<Course> courses){
        this.courses = courses;
    }

    abstract ArrayList<Timetable> arrange(Timetable timetable);
}
