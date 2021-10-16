import java.util.ArrayList;
import java.util.HashMap;
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

    public boolean canAdd(Course course){
        Integer[] course_time = {course.day.getValue(), course.startTime, course.endTime};
        return this.isEmpty(course_time);
        }

    public boolean addCourse(Course course) {

        Integer[] course_time = {course.day.getValue(), course.startTime, course.endTime};  // info of the course
        int courseDuration = course.endTime - course.startTime;  // how long the course would last

        if (this.isEmpty(course_time)) {
            for (int j = 0; j < courseDuration; j++) {    // add course to the timeTable
                Integer[] time_key = {course.day.getValue(), course.startTime + j, course.startTime + j + 1};
                this.timeTable.put(time_key, course);
            }
        } else return false;  // return false if timeSpan in timeTable is not empty.

        return true;
    }

    public ArrayList<String[]> Presentable(){
        ArrayList<String[]> result = new ArrayList<String[]>();
        for (Integer[] k:this.timeTable.keySet()){
            for (String[] s:result){
                if (s[1].substring(0) == k[1].toString()){
                    s[k[0]] = this.timeTable.get(k).courseCode;
                } else {
                    String[] newString = new String[] {k[1]+"-"+k[2],"","","","",""};
                    newString[k[1]] = this.timeTable.get(k).courseCode;
                }
            }
        }
        return result;
    }

}