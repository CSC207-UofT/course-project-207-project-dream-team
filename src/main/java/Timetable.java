import java.util.HashMap;
import java.util.ArrayList;
import java.time.DayOfWeek;

public class Timetable {

    private final HashMap<Integer[], Course> timeTable;

    /* Notice that the hashmap is mapping from specific time to course.
     * A key-value pair might be (3, 17, 18), CSC207, -- Wednesday 17 - 18
     * meaning CSC207 takes place every Wednesday from 17 to 18.
     */

    public Timetable() {     // Constructor
        this.timeTable = new HashMap<Integer[], Course>();
        for (int i = 1; i <= 5; i++) {
            for (int k = 9; k <= 21; k++) {
                Integer[] tempArray = {i, k, k + 1};
                this.timeTable.put(tempArray, null);
            }
        }
    }

    // Getter
    public HashMap<Integer[], Course> getTable() {
        return timeTable;
    }


    // Check if the timeSpan is empty in timeTable
    public boolean isEmpty(Integer[] timeSpan) {
        int day_timeSpan = timeSpan[0], start_timeSpan = timeSpan[1], end_timeSpan = timeSpan[2];
        int lenSpan = end_timeSpan - start_timeSpan;  // the length of the span

        for (int i = 0; i < lenSpan; i = i + 1) {
            Integer[] time = {day_timeSpan, start_timeSpan + i, start_timeSpan + i + 1};
            if (this.timeTable.get(time) != null) {
                return false;
            }
        }
        return true;
    }

    public boolean allEmpty(Course course){
        ArrayList<Integer[]> timeSpans = this.courseToTimespan(course);
        boolean result = true;
        for (int j=0; j<timeSpans.size(); j++){
            result = result && (this.isEmpty(timeSpans.get(j)));
        }
        return result;
    }

    public ArrayList<Integer[]> courseToTimespan(Course course){
        ArrayList<Integer[]> timeSpans = new ArrayList<Integer[]>();
        for (int k=0; k<course.timeslots.size(); k++){
            Integer[] class_time = {((DayOfWeek) course.timeslots.get(k)[0]).getValue(),
                    (int) course.timeslots.get(k)[1], (int) course.timeslots.get(k)[2]};
            timeSpans.add(class_time);
        }
        return timeSpans;
    }


    public boolean addCourse(Course course) {
        ArrayList<Integer[]> timeSpans = this.courseToTimespan(course);

        if (this.allEmpty(course)){
            for (int m=0; m<course.timeslots.size(); m++){
                for (int n=0; n<((int) course.timeslots.get(m)[2]- (int) course.timeslots.get(m)[1]); n++){
                    Integer[] time_key = {((DayOfWeek) course.timeslots.get(m)[0]).getValue(),
                            (int) course.timeslots.get(m)[1]+n, (int) course.timeslots.get(m)[1]+n+1};
                    this.timeTable.put(time_key, course);
                }
            }
        } else {
            return false;
        }
        return true;
    }
}