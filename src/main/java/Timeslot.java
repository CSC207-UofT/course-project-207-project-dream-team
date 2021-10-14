import java.util.ArrayList;

public class Timeslot {
    String day;
    float init_time;  // 6.00, 6.30
    float end_time;

    public Timeslot(String day, float init_time, float end_time) {
        this.day = day;
        this.init_time = init_time;
        this.end_time = end_time;
    }

    @Override
    public String toString() {
        return this.day + this.init_time + this.end_time;
    }


    public ArrayList<String> suitable_course_Time(Course course) {

        ArrayList<String> output = new ArrayList<String>();   // the output as list

        for (String time : course.timeSpan) {                // iterate over possible timeSlot of the course

            String[] time_data = time.split("/");

            float course_start_time = Float.parseFloat(time_data[0]);
            float course_end_time = Float.parseFloat(time_data[1]);
            String course_day = time_data[2];

            if (day.equals(course_day)) {
                if (course_start_time > this.init_time && course_end_time < this.end_time) {
                    output.add(time);
                }
            }
        }
        return output;
    }
}
