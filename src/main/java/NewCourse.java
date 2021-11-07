import java.util.ArrayList;

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
}