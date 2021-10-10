public class Course {
    public String courseCode;
    public String session;
    public String instructor;
    public String timeSlot;
    public String location;

    public Course(String courseCode, String session,
                  String instructor, String timeSlot, String location) {
        this.courseCode = courseCode;
        this.session = session;
        this.instructor = instructor;
        this.timeSlot = timeSlot;
        this.location = location;
    }
}
}