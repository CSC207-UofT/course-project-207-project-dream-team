import java.time.DayOfWeek;

public class Course {

    public String courseCode; // CSC207H1F
    public String type;  //TUT, LAB, LEC
    public String instructor;
    public DayOfWeek day;
    public int startTime; // 24 Clock
    public int endTime;

    public Course (String courseCode, String type,
                   String instructor, DayOfWeek day, int startTime, int endTime) {
        this.courseCode = courseCode;
        this.type = type;
        this.instructor = instructor;
        this.day = day;  // to get the int representation of DayOfWeek, just call day.getValue()
        this.startTime = startTime;
        this.endTime = endTime;
    }
}