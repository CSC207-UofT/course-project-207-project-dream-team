public class Course {
    public String courseCode;
    public String Session;
    public String deliveryMethod;
    public String instructor;
    public String timeSpanInfo;
    public String location;

    public Course(String courseCode, String Session, String deliveryMethod,
                  String instructor, String timeSpanInfo, String location) {
        this.courseCode = courseCode;
        this.Session = Session;
        this.deliveryMethod = deliveryMethod;
        this.timeSpanInfo = timeSpanInfo;
        this.instructor = instructor;
        this.location = location;
    }
}