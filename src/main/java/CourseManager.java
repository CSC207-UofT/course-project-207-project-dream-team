import java.util.ArrayList;

public class CourseManager {
    //basic course info
    public String courseCode;
    public String session;
    public String deliveryMethod;
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

    public CourseManager(int preferInstructor,
                         int preferTimeslot,
                         int preferDuration,
                         int preferBackToBack,
                         int generalPreference) {
        this.preferInstructor = preferInstructor;
        this.preferTimeslot = preferTimeslot;
        this.preferDuration = preferDuration;
        this.preferBackToBack = preferBackToBack;
        this.generalPreference = generalPreference;
    }

    public ArrayList<Course[]> Arranging(){
        //The return type can also be ArrayList<String[]> if we choose to return the course codes only.
        ArrayList<Course[]> output = new ArrayList<>();
        if (this.generalPreference == 1){
            //some operations
            return output;
        }else if (this.generalPreference == -1){
            //some operations
            return output;
        }else{
            //some operations
            return output;
        }
    }

    //getter methods
    public int getPreferInstructor(){
        return preferInstructor;
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
        CourseManager pm = new CourseManager
                (1,1,1,1,1);
        //some operations
        System.out.println(pm.Arranging());
    }
}