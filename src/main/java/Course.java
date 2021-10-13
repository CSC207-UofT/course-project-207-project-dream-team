public class Course {
    public String courseName;
    public String deliveryMethod;
    public String instructor;
    public String timeSpanInfo;
    public String location;

    public Course(String courseName, String deliveryMethod,
                  String instructor, String timeSpanInfo, String location) {
        this.courseName = courseName;
        this.deliveryMethod = deliveryMethod;
        this.instructor = instructor;
        this.timeSpanInfo = timeSpanInfo;
        this.location = location;
    }
}