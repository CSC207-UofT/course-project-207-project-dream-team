import java.sql.Time;
import java.util.ArrayList;

class SimpleScheduler extends Scheduler {

    public SimpleScheduler(ArrayList<Course> courses){
        super(courses);
    }

    @Override
    public ArrayList<Timetable> arrange(Timetable timetable) {
        ArrayList<Timetable> result = new ArrayList<Timetable>();
        for (Course cours : this.courses) {
            if (timetable.canAdd(cours)) {
                timetable.addCourse(cours);
            }
        }
        result.add(timetable);
        return result;
    }
}