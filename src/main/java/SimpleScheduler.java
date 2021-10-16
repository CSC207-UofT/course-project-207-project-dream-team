import java.sql.Time;
import java.util.ArrayList;

class SimpleScheduler extends Scheduler {

    public SimpleScheduler(ArrayList<Course> courses){
        super(courses);
    }

    @Override
    public ArrayList<Timetable> Arrange() {
        Timetable tt1 = new Timetable();
        ArrayList<Timetable> result = new ArrayList<Timetable>();
        for (int i=0; i<this.courses.size(); i++){
                if (tt1.canAdd(this.courses.get(i))){
                    tt1.addCourse(this.courses.get(i));
                }
        }
        result.add(tt1);
        return result;
    }
}