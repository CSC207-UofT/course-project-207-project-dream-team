import java.sql.Time;
import java.util.*;

public class Timetable {

    public HashMap<String, Session> timeTable;
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

    public ArrayList<Session> tutCanAdd(NewCourse course) {
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


    // Similar function to addCourse, but the structure is different.
    // Purpose: Add session (lec, tut, lab) to the timetable.
    // Use number to specify the type to add
    // 1: lec, 2: tut, 3: lab

//    public void addSession(NewCourse course, int type) {
//        if (type == 1) {
//            ArrayList<Session> availSessions = lecCanAdd(course);
//            Session sessionTOADD = availSessions.get(0);
//            for (int time : sessionTOADD.timeslots) {
//                String time1 = String.valueOf(time);
//                this.timeTable.put(time1, course);
//                this.occupied.add(time1);
//            }
//        }
//        if (type == 2) {
//            ArrayList<Session> availSessions = tutCanAdd(course);
//            Session sessionTOADD = availSessions.get(0);
//            for (int time : sessionTOADD.timeslots) {
//                String time1 = String.valueOf(time);
//                this.timeTable.put(time1, course);
//                this.occupied.add(time1);
//
//            }
//
//        }
//        if (type == 3) {
//            ArrayList<Session> availSessions = labCanAdd(course);
//            Session sessionTOADD = availSessions.get(0);
//            for (int time : sessionTOADD.timeslots) {
//                String time1 = String.valueOf(time);
//                this.timeTable.put(time1, course);
//                this.occupied.add(time1);
//            }
//        }
//    }

    // Return a mapping of course codes to collections of session codes, based on the sessions that are in timetable.
    // e.g. If timetable has tut0101 and lec0201 for CSC207, then we return {"CSC207": ["TUT0101", "LEC0201"]}.
    // Precondition: the timetable is set up correctly.

    private Map<String, Set<String>> courseToSession(){
        Collection<Session> sessionsInTimetable = this.timeTable.values();
        Map<String, Set<String>> result = new HashMap<>();

        for (Session s : sessionsInTimetable){
            if (result.containsKey(s.courseCode)){
                result.get(s.courseCode).add(s.sessionCode);
            }
            else {
                Set<String> newValue = new HashSet<>(Collections.singleton(s.sessionCode));
                result.put(s.courseCode, newValue);
            }
        }
        return result;
    }


    // Return true iff sessionToAdd has no time conflict with the Timetable, and is reasonable to be added
    // (i.e. we don't want a LEC0101 and a LEC0201 for CSC207 in the same timetable).
    private boolean hasNoConflict(Session sessionToAdd, Map<String, Set<String>> TimetableMapping){
        for (int time:sessionToAdd.timeslots){
            if (this.occupied.contains(Integer.toString(time))){
                return false;
            }
        }
        if (TimetableMapping.containsKey(sessionToAdd.courseCode)){
            return !TimetableMapping.get(sessionToAdd.courseCode).contains(sessionToAdd.sessionCode);
        }
        return true;
    }

    // Precondition: sessionToAdd has no conflict with this timetable.
    // Add this session.
    private void addSession(Session sessionToAdd){
        for (int time : sessionToAdd.timeslots){
            String timeString = Integer.toString(time);
            this.timeTable.put(timeString, sessionToAdd);
            this.occupied.add(timeString);
        }
    }



    // Return all possible timetables with one more potential session (that has no conflict) added.
    public ArrayList<Timetable> extensions (ArrayList<NewCourse> courses){
        ArrayList<Session> remainingSessions = this.neededSessions(courses);

    }
}

