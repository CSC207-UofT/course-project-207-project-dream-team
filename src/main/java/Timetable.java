import java.util.ArrayList;
import java.util.HashMap;

public class Timetable {

    public HashMap<String, Course> timeTable;
    public ArrayList<String> occupied;

    /* Notice that the hashmap is mapping from specific time to course.
     * A key-value pair might be (3, 17, 18), CSC207, -- Wednesday 17 - 18
     * meaning CSC207 takes place every Wednesday from 17 to 18.
     */

    public Timetable() {     // Constructor
        this.timeTable = new HashMap<>();
        for (int i = 1; i <= 5; i ++) {
            for (int k = 9; k <= 21; k++) {
                int num_key = i * 10000 + k * 100 + k + 1;
                String key = String.valueOf(num_key);
                this.timeTable.put(key, null);
            }
        }
        ArrayList<String> occupied = new ArrayList<>();
        this.occupied = occupied;
    }

    public Integer[] hashcodeToSpan(String timeCode){
        int day = Integer.parseInt(timeCode.substring(0, 1));
        int start_time = Integer.parseInt(timeCode.substring(1, 3));
        int end_time = Integer.parseInt(timeCode.substring(3, 5));
        int duration = end_time - start_time;
        return new Integer[] {day, start_time, end_time, duration};
    }



    // Check if the timeSpan is empty in timeTable
    public boolean isEmpty(String timeCode) {
        int lenSpan = hashcodeToSpan(timeCode)[3];  // the length of the span

        for (int i = 0; i < lenSpan; i = i + 1) {
            if (this.timeTable.get(timeCode) != null) {
                return false;
            }
        }
        return true;
    }

    public boolean canAdd(Course course){
        Integer[] course_time = {course.day.getValue(), course.startTime, course.endTime};
        String timeCode = String.valueOf(course_time[0] * 10000 + course_time[1] * 100 + course_time[2]);
        return this.isEmpty(timeCode);
    }

    public void addCourse(Course course) {

        Integer[] course_time = {course.day.getValue(), course.startTime, course.endTime};  // info of the course
        String timeCode = String.valueOf(course_time[0] * 10000 + course_time[1] * 100 + course_time[2]);
        int courseDuration = hashcodeToSpan(timeCode)[3];  // how long the course would last

        if (this.isEmpty(timeCode)) {
            for (int j = 0; j < courseDuration; j++) {    // add course to the timeTable
                String time_key = String.valueOf(course_time[0] * 10000 + (course_time[1] + j) * 100 +
                        course_time[1] + j + 1);
                this.timeTable.put(time_key, course);
                this.occupied.add(time_key);
            }
        }
    }
}