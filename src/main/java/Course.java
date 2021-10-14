import com.intellij.application.options.codeStyle.arrangement.action.ArrangementRemoveConditionAction;
import com.intellij.psi.search.TodoAttributes;
import com.sun.xml.bind.v2.TODO;

import java.util.ArrayList;
import java.util.Arrays;

public class Course {
    private final String courseCode;
    private final ArrayList<String> sessions;
    private final ArrayList<String> deliveryMethod;
    private final ArrayList<String> instructor;
    private final ArrayList<String> timeSpan;
    private final ArrayList<String> location;

    //constructor
    public Course(String courseCode, ArrayList<String> sessions, ArrayList<String> deliveryMethod,
                  ArrayList<String> instructor, ArrayList<String> timeSpan, ArrayList<String> location) {
        this.courseCode = courseCode;
        this.sessions = sessions;
        this.deliveryMethod = deliveryMethod;
        this.timeSpan = timeSpan;
        this.instructor = instructor;
        this.location = location;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseCode='" + courseCode + '\'' +
                ", sessions=" + sessions +
                ", deliveryMethod=" + deliveryMethod +
                ", instructor=" + instructor +
                ", timeSpan=" + timeSpan +
                ", location=" + location +
                '}';
    }



    //getter methods
    public String getCourseCode() {
        return this.courseCode;
    }
    public ArrayList<String> getSessions() {
        return this.sessions;
    }
    public ArrayList<String> getDeliveryMethod() {
        return this.deliveryMethod;
    }
    public ArrayList<String> getTimeSpan() {
        return this.timeSpan;
    }
    public ArrayList<String> getInstructor() {
        return this.instructor;
    }
    public ArrayList<String> getLocation() {
        return this.location;
    }


    public boolean addSession(String session, String deliveryMethod, String timeSpan,
                              String instructor, String location) {
        if (this.sessions.size() != 12) {
            this.sessions.add(session);
            this.deliveryMethod.add(deliveryMethod);
            this.timeSpan.add(timeSpan);
            this.instructor.add(instructor);
            this.location.add(location);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<String> sessions = new ArrayList<>();
        ArrayList<String> deliveryMethod = new ArrayList<>();
        ArrayList<String> timeSpan = new ArrayList<>();
        ArrayList<String> instructor = new ArrayList<>();
        ArrayList<String> location = new ArrayList<>();
        sessions.add("LEC5201");
        deliveryMethod.add("Online/In-Person Sync");
        timeSpan.add("6.00/8.00/THUR");
        instructor.add("Lindsey Shorser");
        location.add("Online");
        Course csc207 = new Course("CSC207", sessions, deliveryMethod,
                timeSpan, instructor, location);
        System.out.println(csc207);
    }
}