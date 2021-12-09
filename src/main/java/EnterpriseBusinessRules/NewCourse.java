package EnterpriseBusinessRules;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class NewCourse {
    //instance variables
    private final String courseCode;  // CSC207H1F
    private final ArrayList<Session> tutorials;
    private final ArrayList<Session> lectures;
    private final ArrayList<Session> labs;

    //Constructor

    /**
     * Construct a new course object based on given course code, and collections of tutorials, lectures and labs.
     *
     * @param courseCode the course code of the given course, in the format of department number, course number, then
     *                   semester (e.g. CSC207H1F).
     * @param tutorials  the tutorial sessions of this course.
     * @param lectures   the lecture sessions of this course.
     * @param labs       the lab sessions of this course.
     */
    public NewCourse(String courseCode,
                     ArrayList<Session> tutorials,
                     ArrayList<Session> lectures, ArrayList<Session> labs) {
        this.courseCode = courseCode;
        this.tutorials = tutorials;
        this.lectures = lectures;
        this.labs = labs;
    }

    //This method determines what this course needs as complements

    /**
     * Check what specific types of sessions are required by this course.
     *
     * @return the set of session types, in strings, required by this course.
     */
    public Set<String> allRequiredSessions() {
        Set<String> result = new HashSet<>();
        if (!(this.labs.isEmpty())) {
            result.add("LAB");
        }

        if (!(this.lectures.isEmpty())) {
            result.add("LEC");
        }

        if (!(this.tutorials.isEmpty())) {
            result.add("TUT");
        }
        return result;
    }

    /**
     * a getter for the private variable "courseCode".
     *
     * @return the course code of this course.
     */
    public String getCourseCode() {
        return this.courseCode;
    }

    /**
     * a getter for the private variable "tutorials".
     *
     * @return the collection of tutorials of this course.
     */
    public ArrayList<Session> getTutorials() {
        return this.tutorials;
    }

    /**
     * a getter for the private variable "lectures".
     *
     * @return the collection of lectures of this course.
     */
    public ArrayList<Session> getLectures() {
        return this.lectures;
    }

    /**
     * a getter for the private variable "labs".
     *
     * @return the collection of labs of this course.
     */
    public ArrayList<Session> getLabs() {
        return this.labs;
    }
}