import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class NewCourse {
    public String courseCode;  // CSC207H1F
    public ArrayList<Session> tutorials;
    public ArrayList<Session> lectures;
    public ArrayList<Session> labs;

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
}