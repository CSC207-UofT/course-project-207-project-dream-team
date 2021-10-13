import java.util.ArrayList;

public class BackToBackScheduler extends Scheduler{
    CourseManager pm;
    ArrayList<Course> courses;//courses to be arranged
    private int y_n = pm.getPreferBackToBack();//1 or -1
    Object detail = null;

    public BackToBackScheduler(ArrayList<Course> courses, int y_n) {
        super(courses);
        this.y_n = y_n;
    }

    public void Arrange(ArrayList<Course> courses, int y_n, Object detail){
        output = new ArrayList<Timetable>();
        //some operations
    }
}
