import java.util.ArrayList;

class DurationScheduler extends Scheduler{
    CourseManager pm;
    ArrayList<Course> courses;//courses to be arranged
    int y_n = pm.getPreferDuration();//1 or -1
    int hours;//exact hours

    public DurationScheduler(ArrayList<Course> courses, int y_n, int hours) {
        super(courses);
        this.y_n = y_n;
        this.hours = hours;
    }

    @Override
    public void Arrange(ArrayList<Course> courses, int y_n, Object hours){
        output = new ArrayList<Timetable>();
        //some operations
    }

}
