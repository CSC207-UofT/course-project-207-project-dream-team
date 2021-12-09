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

    /**
     * Construct an empty timetable.
     */
    public Timetable() {
        this.timeTable = new TreeMap<>();
        this.occupied = new ArrayList<>();
    }

    /**
     * Construct a timetable with given sessions, and the corresponding timeslots that are occupied given by timeTable
     * and occupied.
     *
     * @param timeTable an ordered mapping of session time to course sessions, ordered from the earliest time to latest.
     * @param occupied  the session times that are occupied in this timetable.
     */
    // Overloaded Constructor
    public Timetable(TreeMap<String, Session> timeTable, ArrayList<String> occupied) {
        this.timeTable = timeTable;
        this.occupied = occupied;
    }

    /**
     * A getter for private variable "timetable".
     *
     * @return the ordered mapping of session time to course sessions.
     */
    public TreeMap<String, Session> getTimeTable() {
        return this.timeTable;
    }


    /**
     * A getter for private variable "occupied".
     *
     * @return the session times that are occupied in this timetable.
     */
    public ArrayList<String> getOccupied() {
        return this.occupied;
    }


    /**
     * Convert this timetable to a string.
     *
     * @return a string comprised of every session in this timetable, sorted by time in ascending order.
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Session s : this.timeTable.values()) {
            result.append(s.courseCode).append(s.sessionCode).append(Arrays.toString(s.timeslots)).append(s.instructor);
        }
        return result.toString();
    }


    /**
     * Convert this timetable to a collection of session codes that it contains, in every course it contains.
     * e.g. If timetable has tut0101 and lec0201 for CSC207, then we return {"CSC207": ["TUT", "LEC"]}, where {} means
     * a dictionary and [] means a set.
     * <p>
     * Precondition: the timetable is set up correctly.
     *
     * @return a mapping of course codes to what types of sessions are already in the timetable (e.g. Lec, Tut), based
     * on the sessions that are in timetable.
     */
    private Map<String, Set<String>> courseToSession() {
        Collection<Session> sessionsInTimetable = this.timeTable.values();

        Map<String, Set<String>> result = new HashMap<>();

        if (sessionsInTimetable.isEmpty()) {
            return result;
        }

        for (Session s : sessionsInTimetable) {
            if (result.containsKey(s.courseCode)) {
                result.get(s.courseCode).add(s.sessionCode.substring(0, 3));
            } else {
                Set<String> newVal = new HashSet<>(Collections.singleton(s.sessionCode.substring(0, 3)));
                result.put(s.courseCode, newVal);
            }
        }
        return result;
    }


    /**
     * Check whether a given session sessionToAdd has conflict with this timetable.
     *
     * @param sessionToAdd a session to be added to the timetable
     * @return true iff sessionToAdd has no time conflict with the Timetable, and is reasonable to be added, that is,
     * for example, we don't want a LEC0101 and a LEC0201 for CSC207 in the same timetable.
     */
    private boolean hasNoConflict(Session sessionToAdd) {
        Map<String, Set<String>> mapping = this.courseToSession();
        for (int time : sessionToAdd.timeslots) {
            if (this.occupied.contains(Integer.toString(time))) {
                return false;
            }
        }
        if (mapping.containsKey(sessionToAdd.courseCode)) {
            return !mapping.get(sessionToAdd.courseCode).contains(sessionToAdd.sessionCode.substring(0, 3));
        }
        return true;
    }


    /**
     * Add given session sessionToAdd to the timetable.
     * Precondition: this session has no conflict with the timetable.
     *
     * @param sessionToAdd a session that we add to the timetable.
     * @return a new timetable with the given session added
     */
    public Timetable addSession(Session sessionToAdd) {
        TreeMap<String, Session> newMapping = new TreeMap<>(this.timeTable);
        ArrayList<String> newOccupied = new ArrayList<>(this.occupied);

        for (int time : sessionToAdd.timeslots) {
            String timeString = Integer.toString(time);
            newMapping.put(timeString, sessionToAdd);
            newOccupied.add(timeString);
        }

        return new Timetable(newMapping, newOccupied);
    }


    /**
     * Find all possible extensions of our timetable based on a given set of courses.
     *
     * @param courses the collection of courses that we want to add to the timetable
     * @return all possible timetables with one more potential session (that has no conflict) added.
     */
    public ArrayList<Timetable> extensions(ArrayList<NewCourse> courses) {
        ArrayList<Timetable> result = new ArrayList<>();

        Set<Session> courseSessions = new HashSet<>();
        for (NewCourse course : courses) {
            courseSessions.addAll(course.getLectures());
            courseSessions.addAll(course.getLabs());
            courseSessions.addAll(course.getTutorials());
        }

        // Got Problems Here!!!
        for (Session s : courseSessions) {
            if (this.hasNoConflict(s)) {
                result.add(this.addSession(s));
            }
        }
        return result;
    }


    /**
     * Check whether the timetable contains all the courses that we wish to add, with all of their required sessions,
     * based on the given courses.
     *
     * @param courses the collection of courses that we wish to add to the timetable.
     * @return true iff timetable has all the sessions required, given by our collection of courses.
     */
    public boolean isSolved(ArrayList<NewCourse> courses) {
        Map<String, Set<String>> mapping = this.courseToSession();

        for (NewCourse course : courses) {
            if (!(mapping.containsKey(course.getCourseCode()))) {
                return false;
            } else {
                Set<String> currentSessions = mapping.get(course.getCourseCode());
                Set<String> allNeededSessions = course.allRequiredSessions();
                allNeededSessions.removeAll(currentSessions);
                if (!(allNeededSessions.isEmpty())) {
                    return false;
                }
            }
        }
        return true;
    }

}