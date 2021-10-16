import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Timetable {

    public HashMap<Integer[], Course> timeTable;

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

    // Convert the timetable into a form understandable by the Presenter
    public String[] outputRow(int startTime){

        String[] output = new String[6];
        output[0] = Integer.toString(startTime) + "-" + Integer.toString(startTime + 1);
        for (int week = 1; week <= 5; week++){
            if (this.timeTable.get(new Integer[]{week, startTime, startTime + 1}) == null){
                output[week] = "";
            } else{
                Course c = this.timeTable.get(new Integer[]{week, startTime, startTime + 1});
                output[week] = c.courseCode + " " + c.type;
            }
        }
        return output;
    }



    public static void main(String[] args) {
        Timetable tt = new Timetable();
        Integer[] key = {1, 9, 10};
        Course c = new Course("csc207", "1", "1", DayOfWeek.FRIDAY, 13, 14);
        tt.timeTable.put(key, c);
        System.out.println(c);
        System.out.println(tt.timeTable.get(key));
    }
}