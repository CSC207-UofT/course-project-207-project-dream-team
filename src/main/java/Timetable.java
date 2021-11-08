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

    // Overloaded Constructor
    public Timetable(HashMap<String, Session> timeTable, ArrayList<String> occupied){
        this.timeTable = timeTable;
        this.occupied = occupied;
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


    // Return a mapping of course codes to what typeS of sessions are already in the timetable (e.g. Lec, Tut), based on
    // the sessions that are in timetable.
    // e.g. If timetable has tut0101 and lec0201 for CSC207, then we return {"CSC207": ["TUT", "LEC"]},
    // where {} means a dictionary and [] means a set.
    // Precondition: the timetable is set up correctly.

    private Map<String, Set<String>> courseToSession(){
        Collection<Session> sessionsInTimetable = this.timeTable.values();
        Map<String, Set<String>> result = new HashMap<>();

        for (Session s : sessionsInTimetable){
            if (result.containsKey(s.courseCode)){
                result.get(s.courseCode).add(s.sessionCode.substring(0, 3));
            }
            else {
                Set<String> newValue = new HashSet<>(Collections.singleton(s.sessionCode.substring(0, 3)));
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
            return !TimetableMapping.get(sessionToAdd.courseCode).contains(sessionToAdd.sessionCode.substring(0,3));
        }
        return true;
    }

    // Precondition: sessionToAdd has no conflict with this timetable.
    // Return a new timetable with this session added.
    private Timetable addSession(Session sessionToAdd){
        HashMap<String, Session> newMapping = new HashMap<>(this.timeTable);
        ArrayList<String> newOccupied = new ArrayList<>(this.occupied);

        for (int time : sessionToAdd.timeslots){
            String timeString = Integer.toString(time);
            newMapping.put(timeString, sessionToAdd);
            newOccupied.add(timeString);
        }

        return new Timetable(newMapping, newOccupied);
    }



    // Return all possible timetables with one more potential session (that has no conflict) added.
    public ArrayList<Timetable> extensions (ArrayList<NewCourse> courses){
        Map<String, Set<String>> mapping = this.courseToSession();
        ArrayList<Timetable> result = new ArrayList<>();

        Set<Session> courseSessions = new HashSet<>();
        for (NewCourse course : courses){
            courseSessions.addAll(course.lectures);
            courseSessions.addAll(course.labs);
            courseSessions.addAll(course.tutorials);
        }

        for (Session s : courseSessions){
            if (this.hasNoConflict(s, mapping)){
                result.add(this.addSession(s));
            }
        }
        return result;
    }
}