package ApplicationBusinessRule;

import EnterpriseBusinessRules.NewCourse;
import EnterpriseBusinessRules.Session;

import java.util.*;

public class Timetable {

    private final TreeMap<String, Session> timeTable;
    private final ArrayList<String> occupied;       // quick checker for time occupied in timeslot.

    /* Notice that the hashmap is mapping from specific time to course.
     * A key-value pair might be <"31718", CSC207>, meaning CSC207 takes on Wednesday from 17 to 18
     */

    public Timetable() {
        this.timeTable = new TreeMap<>();
        this.occupied = new ArrayList<>();
    }

    // Overloaded Constructor
    public Timetable(TreeMap<String, Session> timeTable, ArrayList<String> occupied){
        this.timeTable = timeTable;
        this.occupied = occupied;
    }

    public TreeMap<String, Session> getTimeTable(){
        return this.timeTable;
    }

    public ArrayList<String> getOccupied(){
        return this.occupied;
    }

    // Check if the timeSpan is empty in timeTable
    public boolean isEmpty(String timeCode) {
     return !this.occupied.contains(timeCode);
    }


    // toString method for testing purposes
    // Return a string comprised of every session in this timetable, sorted by time in ascending order.
    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        for (Session s : this.timeTable.values()){
            result.append(s.courseCode).append(s.sessionCode).append(Arrays.toString(s.timeslots)).append(s.instructor);
        }
        return result.toString();
    }


    // Return a mapping of course codes to what types of sessions are already in the timetable (e.g. Lec, Tut), based on
    // the sessions that are in timetable.
    // e.g. If timetable has tut0101 and lec0201 for CSC207, then we return {"CSC207": ["TUT", "LEC"]},
    // where {} means a dictionary and [] means a set.
    // Precondition: the timetable is set up correctly.

    private Map<String, Set<String>> courseToSession(){
        Collection<Session> sessionsInTimetable = this.timeTable.values();

        Map<String, Set<String>> result = new HashMap<>();

        if (sessionsInTimetable.isEmpty()){
            return result;
        }

        for (Session s : sessionsInTimetable){
            if (result.containsKey(s.courseCode)){
                result.get(s.courseCode).add(s.sessionCode.substring(0, 3));
            }
            else {
                Set<String> newVal = new HashSet<>(Collections.singleton(s.sessionCode.substring(0, 3)));
                result.put(s.courseCode, newVal);
            }
        }
        return result;
    }


    // Return true iff sessionToAdd has no time conflict with the Timetable, and is reasonable to be added
    // (i.e. we don't want a LEC0101 and a LEC0201 for CSC207 in the same timetable).
    private boolean hasNoConflict(Session sessionToAdd){
        Map<String, Set<String>> mapping = this.courseToSession();
        for (int time:sessionToAdd.timeslots){
            if (this.occupied.contains(Integer.toString(time))){
                return false;
            }
        }
        if (mapping.containsKey(sessionToAdd.courseCode)){
            return !mapping.get(sessionToAdd.courseCode).contains(sessionToAdd.sessionCode.substring(0,3));
        }
        return true;
    }

    // Precondition: sessionToAdd has no conflict with this timetable.
    // Return a new timetable with this session added.
    private Timetable addSession(Session sessionToAdd){
        TreeMap<String, Session> newMapping = new TreeMap<>(this.timeTable);
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
        ArrayList<Timetable> result = new ArrayList<>();

        Set<Session> courseSessions = new HashSet<>();
        for (NewCourse course : courses){
            courseSessions.addAll(course.getLectures());
            courseSessions.addAll(course.getLabs());
            courseSessions.addAll(course.getTutorials());
        }

        // Got Problems Here!!!
        for (Session s : courseSessions){
            if (this.hasNoConflict(s)){
                result.add(this.addSession(s));
            }
        }
        return result;
    }



    // Return true iff the timetable has all the sessions required.
    public boolean isSolved (ArrayList<NewCourse> courses) {
        Map<String, Set<String>> mapping = this.courseToSession();

        for (NewCourse course : courses){
            if (!(mapping.containsKey(course.getCourseCode()))){
                return false;
            }
            else {
                Set<String> currentSessions = mapping.get(course.getCourseCode());
                Set<String> allNeededSessions = course.allRequiredSessions();
                allNeededSessions.removeAll(currentSessions);
                if (!(allNeededSessions.isEmpty())){
                    return false;
                }
            }
        }
        return true;
    }


//    // Return true iff the timetable is not solved, and cannot be solved
//    public boolean failFast (ArrayList<NewCourse> courses){
//        return (this.extensions(courses).isEmpty() && !this.isSolved(courses));
//    }
}