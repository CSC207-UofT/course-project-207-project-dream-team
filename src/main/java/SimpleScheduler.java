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
        ArrayList<ArrayList<Course>> sorted = this.sortCourses();
        for (int i=0; i<sorted.size(); i++){
            for (int j=0; j<sorted.get(i).size(); j++){
                if (tt1.allEmpty(sorted.get(i).get(j))){
                    tt1.addCourse(sorted.get(i).get(j));
                    break;
                }
            }
        }
        result.add(tt1);
        return result;
    }
}