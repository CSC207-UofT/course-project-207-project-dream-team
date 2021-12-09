package EnterpriseBusinessRules;

public class Session {
    //instance variables
    public String instructor;
    public String courseCode;
    public String sessionCode;
    public Integer[] timeslots;
    public String type;

    //Constructor

    /**
     * Construct a new session object based on given instructor, course code, session code and timeslot.
     *
     * @param instructor  the instructor of this session.
     * @param courseCode  the course code that this session belongs to.
     * @param sessionCode the session code of this session.
     * @param timeslots   the timeslots occupied by this session.
     */
    public Session(String instructor,
                   String courseCode,
                   String sessionCode,
                   Integer[] timeslots) {
        this.instructor = instructor;     //e.g. Paul
        this.courseCode = courseCode;     //e.g. CSC207H1F
        this.sessionCode = sessionCode;   //e.g. LEC0101
        this.timeslots = timeslots;       //e.g. [21415, 41315]
        this.type = sessionCode.substring(0, 3);
    }

}
