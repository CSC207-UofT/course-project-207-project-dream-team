import java.util.ArrayList;

public class InstructorScheduler extends Scheduler{
    CourseManager pm;
    ArrayList<Course> courses;//courses to be arranged
    int y_n = pm.getPreferInstructor();//1 or -1
    ArrayList<String> names;//name(s) of instructor(s)

    public InstructorScheduler(ArrayList<Course> courses, int y_n, ArrayList<String> names) {
        super(courses);
        this.y_n = y_n;
        this.names = names;
    }

    public void Arrange(ArrayList<Course> input, int y_n, Object names){
        output = new ArrayList<Timetable>();
        //some operations
    }
}
