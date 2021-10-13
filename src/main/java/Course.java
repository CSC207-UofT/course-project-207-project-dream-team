import java.util.ArrayList;
import java.util.Arrays;

public class Course {
    public String courseCode;
    public String[] sessions;
    public String[] deliveryMethod;
    public String[] instructor;
    public String[] timeSpan;
    public String[] location;

    //constructor
    public Course(String courseCode, String[] sessions, String[] deliveryMethod,
                  String[] instructor, String[] timeSpan, String[] location) {
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
                ", sessions=" + Arrays.toString(sessions) +
                ", deliveryMethod=" + Arrays.toString(deliveryMethod) +
                ", instructor=" + Arrays.toString(instructor) +
                ", timeSpan=" + Arrays.toString(timeSpan) +
                ", location=" + Arrays.toString(location) +
                '}';
    }

    //getter methods
    public String getCourseCode() {
        return this.courseCode;
    }
    public String[] getSessions() {
        return this.sessions;
    }
    public String[] getDeliveryMethod() {
        return this.deliveryMethod;
    }
    public String[] getTimeSpan() {
        return this.timeSpan;
    }
    public String[] getInstructor() {
        return this.instructor;
    }
    public String[] getLocation() {
        return this.location;
    }

    public static void main(String[] args) {
        Course csc207 = new Course("CSC207", new String[]{"LEC5201"},
                new String[]{"Online/In-Person Sync"}, new String[]{"6.00/8.00/THUR"},
                new String[]{"Lindsey Shorser"}, new String[]{"Online"});
        System.out.println(csc207);
    }
}