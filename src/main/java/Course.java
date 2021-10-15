import java.time.DayOfWeek;
import java.util.ArrayList;

public class Course implements Comparable<Course>{

    public String courseCode; // CSC207H1F
    public String session; //TUT0101
    public String type;  //TUT, LAB, LEC
    public String instructor;
    public ArrayList<Object[]> timeslots; //<[MONDAY,2,4],[FRIDAY,2,4]>
    public int duration;


    public Course (String courseCode, String session,
                   String instructor, ArrayList<Object[]> timeslots) {

        int duration = 0;
        for (int i=0; i<timeslots.size(); i++){
            duration = duration + (int) timeslots.get(i)[2] - (int) timeslots.get(i)[1];
        }

        this.courseCode = courseCode;
        this.session = session;
        this.type = session.substring(0,3);
        this.instructor = instructor;
        this.timeslots = timeslots;
        this.duration = duration;
    }

    @Override
    public int compareTo(Course other) {
        if (this.type != other.type) {
            if (this.type == "LEC") {
                return 1;
            } else if (other.type == "TUT") {
                return 1;
            } else {
                return -1;
            }
        } else {
            if (this.duration > other.duration) {
                return 1;
            } else if (this.duration < other.duration) {
                return -1;
            } else {
                return 0;
            }
        }
    }

}