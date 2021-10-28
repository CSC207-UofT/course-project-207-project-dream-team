import java.util.ArrayList;

public class NewCourse {
    public String courseCode;
    public ArrayList<Session> tutorials;
    public ArrayList<Session> lectures;

    public NewCourse(String courseCode,
                     ArrayList<Session> tutorials,
                     ArrayList<Session> lectures){
        this.courseCode = courseCode;
        this.tutorials = tutorials;
        this.lectures = lectures;
    }
}