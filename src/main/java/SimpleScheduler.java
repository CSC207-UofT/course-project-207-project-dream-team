import java.sql.Time;
import java.util.ArrayList;

class SimpleScheduler extends Scheduler {

    public SimpleScheduler(ArrayList<Course> courses){
        super(courses);
    }

    @Override
    public ArrayList<Timetable> arrange(Timetable timetable) {
        ArrayList<Timetable> result = new ArrayList<>();
        for (Course course : this.courses) {
            if (timetable.canAdd(course)) {
                timetable.addCourse(course);
            }
        }
        result.add(timetable);
        return result;
    }
}