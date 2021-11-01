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
        for (int i = 1; i <= 5; i++) {
            for (int k = 9; k <= 21; k++) {
                int num_key = i * 10000 + k * 100 + k + 1;
                String key = String.valueOf(num_key);
                this.timeTable.put(key, null);
            }
        }
        this.occupied = new ArrayList<>();
    }

    public Integer[] timeConverter(String timeCode) {
        int day = Integer.parseInt(timeCode.substring(0, 1));
        int start_time = Integer.parseInt(timeCode.substring(1, 3));
        int end_time = Integer.parseInt(timeCode.substring(3, 5));
        int duration = end_time - start_time;
        return new Integer[]{day, start_time, end_time, duration};
    }

    // Check if the timeSpan is empty in timeTable
    public boolean isEmpty(String timeCode) {
        for (String occupied_time : occupied) {       // check timeCode is already in the occupied list.
            if (timeCode.equals(occupied_time)) {
                return false;
            }
        }
        return true;
    }

    // Big Function change:  lecCanAdd, tutCanAdd, labCanAdd
    // return an arraylist that contains all the lecture sessions that can be added to the timetable
    // Criteria: the session is added IFF all times of the session is currently empty in timeslot
    // Notice: this is just a checker providing information but making NO CHANGE to the timetable.
    // lecCanAdd, tutCanAdd, labCanAdd have same scenario.
    public ArrayList<Session> lecCanAdd(NewCourse course) {
        ArrayList<Session> availableLEC = new ArrayList<>();     // the output
        for (Session session : course.lectures) {                // loop all the lecture sessions of this course
            int count = 0;
            for (Integer time : session.timeslots) {             // loop timeslots of the session
                if (!occupied.contains(time.toString()))
                    count++;
            }
            if (count == session.timeslots.length) {
                availableLEC.add(session);
            }
        }
        return availableLEC;
    }

    public ArrayList<Session> labCanAdd(NewCourse course) {
        ArrayList<Session> availableLAB = new ArrayList<>();
        for (Session session : course.labs) {
            int count = 0;
            for (Integer time : session.timeslots) {
                if (!occupied.contains(time.toString()))
                    count++;
            }
            if (count == session.timeslots.length) {
                availableLAB.add(session);
            }
        }
            return availableLAB;
        }


   public ArrayList<Session> tutCanAdd (NewCourse course){
        ArrayList<Session> availableTUT = new ArrayList<>();
        for (Session session : course.tutorials) {
            int count = 0;
            for (Integer time : session.timeslots) {
                if (!occupied.contains(time.toString()))
                    count++;
            }
            if (count == session.timeslots.length) {
                availableTUT.add(session);
            }
        }
        return availableTUT;
        }


    public void addCourse (Course course){

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