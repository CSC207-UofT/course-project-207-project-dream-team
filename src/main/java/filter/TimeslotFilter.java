package filter;
import timetable.Timetable;
import java.util.ArrayList;

public class TimeslotFilter extends Filter {

    public TimeslotFilter(ArrayList<Timetable> input, ArrayList<String> unwanted) {
        super(input, unwanted);
    }

    @Override
    public ArrayList<Timetable> sort() {

        for (Timetable singleTimetable : this.input) {

            boolean tag = true;
            for (String timeslot : this.unwanted) {
                if (singleTimetable.getOccupied().contains(timeslot)) {
                    tag = false;
                    break;
                }
            }
            if (tag) {
                this.output.add(singleTimetable);
            }
        }
        return this.output;
    }
}