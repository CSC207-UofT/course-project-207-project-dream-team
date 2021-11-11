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

            int size = 0;
            for (String timeslot : this.unwanted) {
                if (size == this.unwanted.size()) {
                    this.output.add(singleTimetable);
                }

                if (!singleTimetable.occupied.contains(timeslot)) {
                    size += 1;
                }
            }
        }
        return this.output;
    }
}