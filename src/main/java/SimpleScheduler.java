import java.util.ArrayList;
import java.util.Set;

class SimpleScheduler {
    public ArrayList<NewCourse> input;
    public ArrayList<String> occupied;       // quick checker for time occupied in timeslot.

    public SimpleScheduler(ArrayList<NewCourse> courses) {
        this.input = courses;
        this.occupied = new ArrayList<String>();
    }


    // return possible next steps of the current timetable
    public ArrayList<Timetable> extension(Timetable timetable) {

        // if the all courses in input are completely added

        // check the status of the current course
    }


    // return what type of current course should be added
    // use first 3 chars of sessionCode as identifier
    private String typeOFCourseLeft(Timetable timetable, NewCourse course) {  // maybe use session instead.
        if (allTypeAdd(timetable, course)) {
            return null;
        } else {

            // what type is already in the timetable
            ArrayList<String> alreadyIn = new ArrayList<>(3);
            for (String key : timetable.timeTable.keySet()) {
                if (timetable.timeTable.get(key).sessionCode.substring(0,3).equals("LEC")) {
                    alreadyIn.add("LEC");
                }
                if (timetable.timeTable.get(key).sessionCode.substring(0,3).equals("TUT")) {
                    alreadyIn.add("TUT");
                }
                if (timetable.timeTable.get(key).sessionCode.substring(0,3).equals("LAB")) {
                    alreadyIn.add("LAB");
                }
            }

            if (alreadyIn.size() ==

            //


        }


    }


    // check if lec / tut / lab of the single course are properly added if applicable
    private boolean allTypeAdd(Timetable timetable, NewCourse course) {
        // take down the courseCode here
        String coursecode = course.courseCode.substring(0, 6);  // like CSC207 is taken down
        // when there is applicable tuts and labs in the COURSE
        if (course.tutorials.size() != 0 && course.labs.size() != 0) {
            int counter = 0;
            for (String key : timetable.timeTable.keySet()) {
                if (timetable.timeTable.get(key).courseCode.substring(0, 6).equals(coursecode)) {
                    counter++;
                }
            }
            if (counter == 3) {
                return true;
            }
        }
        // when there is one tut or one lab, not simultaneously
        if (course.tutorials.size() != 0 | course.labs.size() != 0) {
            int counter = 0;
            for (String key : timetable.timeTable.keySet()) {
                if (timetable.timeTable.get(key).courseCode.substring(0, 6).equals(coursecode)) {
                    counter++;
                }
            }
            if (counter == 2) {
                return true;
            }
        }
        // when there is no tut and lab
        if (course.tutorials.size() == 0 && course.labs.size() == 0) {
            int counter = 0;
            for (String key : timetable.timeTable.keySet()) {
                if (timetable.timeTable.get(key).courseCode.substring(0, 6).equals(coursecode)) {
                    counter++;
                }
            }
            return counter == 1;
        }
        return false;
    }
}
