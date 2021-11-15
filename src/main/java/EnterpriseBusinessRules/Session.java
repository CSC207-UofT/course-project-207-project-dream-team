package EnterpriseBusinessRules;

public class Session {
    public String instructor;
    public String courseCode;
    public String sessionCode;
    public Integer[] timeslots;
    public String type;

    public Session(String instructor,
                   String courseCode,
                   String sessionCode,
                   Integer[] timeslots){
        this.instructor = instructor;     //e.g. Paul
        this.courseCode = courseCode;     //e.g. CSC207H1F
        this.sessionCode = sessionCode;   //e.g. LEC0101
        this.timeslots = timeslots;       //e.g. [21415, 41315]
        this.type = sessionCode.substring(0,3);
    }
}
