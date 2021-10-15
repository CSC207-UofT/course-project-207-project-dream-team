import java.awt.*;
import java.util.ArrayList;

public class CourseManager {
    public ArrayList<Course> courses;
    //Possible preferences.
    // 0: no preference; 1: prefer; -1: avoid.
    public int preferInstructor;
    public int preferTimeslot;
    public int preferDuration;//0: no preference; 1: max duration; -1: min duration.
    public int preferBackToBack;

    //Searching strategy.
    // 0: no preference;
    // 1: search for results meeting all preferences;
    // -1: search for results meeting any preferences.
    public int generalPreference;

    public CourseManager(ArrayList<Course> courses,
                         int preferInstructor,
                         int preferTimeslot,
                         int preferDuration,
                         int preferBackToBack,
                         int generalPreference) {
        this.courses = courses;
        this.preferInstructor = preferInstructor;
        this.preferTimeslot = preferTimeslot;
        this.preferDuration = preferDuration;
        this.preferBackToBack = preferBackToBack;
        this.generalPreference = generalPreference;
    }

    @Override
    public String toString() {
        return "CourseManager{" +
                "courses=" + courses +
                ", preferInstructor=" + preferInstructor +
                ", preferTimeslot=" + preferTimeslot +
                ", preferDuration=" + preferDuration +
                ", preferBackToBack=" + preferBackToBack +
                ", generalPreference=" + generalPreference +
                '}';
    }

    //getter methods
    public int getPreferInstructor()
    {
        return this.preferInstructor;
    }
    public int getPreferTimeslot(){
        return this.preferTimeslot;
    }
    public int getPreferDuration(){
        return this.preferDuration;
    }
    public int getPreferBackToBack(){
        return this.preferBackToBack;
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
        ArrayList<Course> courses = new ArrayList<Course>();
        courses.add(csc207);
        CourseManager pm = new CourseManager
                (courses, 0, 0, 0, 0,0);
        //some operations
        System.out.println(pm);
    }
}