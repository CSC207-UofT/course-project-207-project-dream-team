import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.time.DayOfWeek;
import java.util.Objects;

public class Timetable {

    private final HashMap<String, Course> timeTable;
    public ArrayList<String> occupied;

    /* Notice that the hashmap is mapping from specific time to course.
     * A key-value pair might be (3, 17, 18), CSC207, -- Wednesday 17 - 18
     * meaning CSC207 takes place every Wednesday from 17 to 18.
     */

    public Timetable() {     // Constructor
        this.timeTable = new HashMap<String, Course>();
        for (int i = 1; i <= 5; i++) {
            for (int k = 9; k <= 21; k++) {
                int num_key = i*10000+k*100+k+1;
                String key = String.valueOf(num_key);
                this.timeTable.put(key, null);
            }
        }
        ArrayList<String> occupied = new ArrayList<String>();
        this.occupied = occupied;
    }

    public Integer[] hashcodeToSpan(String timecode){
        int day = Integer.parseInt(timecode.substring(0,1));
        int start_time = Integer.parseInt(timecode.substring(1,3));
        int end_time = Integer.parseInt(timecode.substring(3,5));
        int duration = end_time-start_time;
        Integer[] result = new Integer[] {day, start_time, end_time, duration};
        return result;
    }

    // Getter
    public HashMap<String, Course> getTable() {
        return timeTable;
    }


    // Check if the timeSpan is empty in timeTable
    public boolean isEmpty(String timecode) {
        int lenSpan = hashcodeToSpan(timecode)[3];  // the length of the span

        for (int i = 0; i < lenSpan; i = i + 1) {
            if (this.timeTable.get(timecode) != null) {
                return false;
            }
        }
        return true;
    }

    public boolean canAdd(Course course){
        Integer[] course_time = {course.day.getValue(), course.startTime, course.endTime};
        String timecode = String.valueOf(course_time[0]*10000+course_time[1]*100+course_time[2]);
        return this.isEmpty(timecode);
        }

    public boolean addCourse(Course course) {

        Integer[] course_time = {course.day.getValue(), course.startTime, course.endTime};  // info of the course
        String timecode = String.valueOf(course_time[0]*10000+course_time[1]*100+course_time[2]);
        int courseDuration = hashcodeToSpan(timecode)[3];  // how long the course would last

        if (this.isEmpty(timecode)) {
            for (int j = 0; j < courseDuration; j++) {    // add course to the timeTable
                String time_key = String.valueOf(course_time[0]*10000+(course_time[1]+j)*100+course_time[2]+j);
                this.timeTable.put(time_key, course);
                this.occupied.add(time_key);
            }
        } else return false;  // return false if timeSpan in timeTable is not empty.

        return true;
    }


    // the form of output is: an ArrayList contains several Arrays
    // { {"9-10", "", "CSC258 Lec0101", "", "CSC236 TUT0301", "EAS220 LEC0201"}
    //   {"11-12", "CSC301 Lec0101", "CSC300 Lec0101", "", "CSC236 TUT0301", "EAS220 LEC0201"}}


    //public ArrayList<String[]> presentable() {

        // initialize an empty ArrayList as output
        //ArrayList<String[]> output = new ArrayList<>(5);

        // loop over the HashMap to access timeSlot
        // for (Integer[] timeSlot: timeTable.keySet()) {

           // String[] specificTime =


    public ArrayList<String[]> Presentable(){
        ArrayList<String[]> result = new ArrayList<String[]>();
        result.add(new String[] {"","","","","",""});
        for (String k:this.occupied){
            boolean flag = false;
            for (int line=0; line<result.size(); line++){
                if ((Objects.equals(result.get(line)[1], k.substring(1,5)))& (this.timeTable.get(k) != null)) {
                    result.get(line)[Integer.parseInt(k.substring(0,1))] = this.timeTable.get(k).courseCode;
                    flag = true;
                }
            }
            if (!flag) {
                String[] newString = new String[]{k.substring(1, 5), "", "", "", "", ""};
                newString[Integer.parseInt(k.substring(0,1))] = this.timeTable.get(k).courseCode+
                        " "+this.timeTable.get(k).type;
                result.add(newString);
            }
        }

        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.size() - 1 - i; j++)
                if (Integer.parseInt(result.get(j)[0]) > Integer.parseInt(result.get(j + 1)[0])) {
                    Collections.swap(result, j, j + 1);
                }
        }
        return result;
    }




   /* public static void main(String[] args) {
        Course c1 = new Course("CSC207","TUT101","PIAO", DayOfWeek.FRIDAY, 9, 10);
        Course c2 = new Course("CSC207","LEC101","PIAO", DayOfWeek.MONDAY, 9,10);
        ArrayList<Course> courses = new ArrayList<>();
        courses.add(c1);
        courses.add(c2);
        SimpleScheduler ss = new SimpleScheduler(courses);
        Timetable tt = new Timetable();
        ArrayList<Timetable> tts = ss.arrange(tt);
        ArrayList<String[]> presentable = tts.get(0).Presentable();
        Presenter st = new Presenter();
        st.addRow(presentable.get(0));
        System.out.println(presentable.get(0)[0]);
    }*/

}