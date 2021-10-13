import java.util.ArrayList;

public class CourseManager {
    //Possible preferences.
    // 0: no preference; 1: prefer; -1: avoid.
    public int prefer_instructor;
    public int prefer_timeslot;
    public int prefer_duration;//0: no preference; 1: max duration; -1: min duration.
    public int prefer_back_to_back;

    //Searching strategy.
    // 0: no preference;
    // 1: search for results meeting all preferences;
    // -1: search for results meeting any preferences.
    public int general_preference;

    public CourseManager(int prefer_instructor,
                         int prefer_timeslot,
                         int prefer_duration,
                         int prefer_back_to_back,
                         int general_preference) {
        this.prefer_instructor = prefer_instructor;
        this.prefer_timeslot = prefer_timeslot;
        this.prefer_duration = prefer_duration;
        this.prefer_back_to_back = prefer_back_to_back;
        this.general_preference = general_preference;
    }

    public ArrayList<Course[]> Arranging(){
        //The return type can also be ArrayList<String[]> if we choose to return the course codes only.
        ArrayList<Course[]> output = new ArrayList<>();
        if (this.general_preference == 1){
            //some operations
            return output;
        }else if (this.general_preference == -1){
            //some operations
            return output;
        }else{
            //some operations
            return output;
        }
    }

    //getter methods
    public int getPrefer_instructor(){
        return prefer_instructor;
    }
    public int getPrefer_timeslot(){
        return this.prefer_timeslot;
    }
    public int getPrefer_duration(){
        return this.prefer_duration;
    }
    public int getPrefer_back_to_back(){
        return this.prefer_back_to_back;
    }

    public static void main(String[] args) {
        CourseManager pm = new CourseManager
                (1,1,1,1,1);
        //some operations
        System.out.println(pm.Arranging());
    }
}