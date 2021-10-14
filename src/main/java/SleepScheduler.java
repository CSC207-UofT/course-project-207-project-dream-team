import java.util.ArrayList;

public class SleepScheduler extends Scheduler{
    CourseManager pm;
    ArrayList<Course> courses;//courses to be arranged
    int y_n;  //1 or -1
    ArrayList<Timeslot> timeslot;//exact timeslot(s)

    public SleepScheduler(ArrayList<Course> courses, int y_n, ArrayList<Timeslot> timeslot) {
        super(courses);
        this.y_n = y_n;
        this.timeslot = timeslot;
    }

    public void Arrange(ArrayList<Course> input, int y_n, Object timeslot) {
        output = new ArrayList<Timetable>();
        //some operations
    }
}