import java.util.ArrayList;
import java.util.HashMap;

public class Timetable {

    public HashMap<String, Course> timeTable;
    public ArrayList<String> occupied;       // quick checker for time occupied in timeslot.

    /* Notice that the hashmap is mapping from specific time to course.
     * A key-value pair might be <"31718", CSC207>, meaning CSC207 takes on Wednesday from 17 to 18
     */

    // Constructor
    public Timetable() {
        this.timeTable = new HashMap<>();
        for (int i = 1; i <= 5; i ++) {
            for (int k = 9; k <= 21; k++) {
                int num_key = i * 10000 + k * 100 + k + 1;
                String key = String.valueOf(num_key);
                this.timeTable.put(key, null);
            }
        }
        this.occupied = new ArrayList<>();
    }

    public Integer[] timeConverter(String timeCode){
        int day = Integer.parseInt(timeCode.substring(0, 1));
        int start_time = Integer.parseInt(timeCode.substring(1, 3));
        int end_time = Integer.parseInt(timeCode.substring(3, 5));
        int duration = end_time - start_time;
        return new Integer[] {day, start_time, end_time, duration};
    }
    
    // Check if the timeSpan is empty in timeTable
    public boolean isEmpty(String timeCode) {
        for (String occupied_time: occupied){       // check timeCode is already in the occupied list.
            if (timeCode.equals(occupied_time)) {
                return false;
            }
        }
        return true;
    }

    // Big Function change:
    // Purpose: return ArrayList of lecture sessions that can be added to the timeTable
    // Criteria: if the Session has one lecture time can be added, then the session is added to the output.
    public ArrayList<Session> lecCanAdd(NewCourse course){

        ArrayList<Session> availableLEC= new ArrayList<>();     // the output

        for (Session session: course.lectures) {                // loop all the lecture sessions of this course

            for (Integer time: session.timeslots) {             // loop timeslots of the session

                // if ANYONE TIME is not in occupied in timetable, then add the session
                if (!occupied.contains(time.toString()) && !availableLEC.contains(session))
                    availableLEC.add(session);
            }
        }
    return availableLEC;
    }




    public void addCourse(Course course) {

        Integer[] course_time = {course.day.getValue(), course.startTime, course.endTime};  // info of the course
        String timeCode = String.valueOf(course_time[0] * 10000 + course_time[1] * 100 + course_time[2]);
        int courseDuration = timeConverter(timeCode)[3];  // how long the course would last

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