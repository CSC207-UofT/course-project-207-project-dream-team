package EnterpriseBusinessRules;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class NewCourse {
    private final String courseCode;  // CSC207H1F
    private final ArrayList<Session> tutorials;
    private final ArrayList<Session> lectures;
    private final ArrayList<Session> labs;

    public NewCourse(String courseCode,
                     ArrayList<Session> tutorials,
                     ArrayList<Session> lectures, ArrayList<Session> labs){
        this.courseCode = courseCode;
        this.tutorials = tutorials;
        this.lectures = lectures;
        this.labs = labs;
    }

    public Set<String> allRequiredSessions(){
        Set<String> result = new HashSet<>();
        if (!(this.labs.isEmpty())){
            result.add("LAB");
        }

        if (!(this.lectures.isEmpty())){
            result.add("LEC");
        }

        if (!(this.tutorials.isEmpty())){
            result.add("TUT");
        }
        return result;
    }

    public String getCourseCode() {
        return this.courseCode;
    }

    public ArrayList<Session> getTutorials() {
        return this.tutorials;
    }

    public ArrayList<Session> getLectures() {
        return this.lectures;
    }

    public ArrayList<Session> getLabs() {
        return this.labs;
    }
}