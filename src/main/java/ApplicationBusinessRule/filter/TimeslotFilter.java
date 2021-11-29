package ApplicationBusinessRule.filter;
import ApplicationBusinessRule.Timetable;
import ApplicationBusinessRule.filter.Filter;

import java.util.ArrayList;

public class TimeslotFilter extends Filter {

    public TimeslotFilter(ArrayList<Timetable> input, ArrayList<String> unwanted) {
        super(input, unwanted);
    }

    @Override
    public ArrayList<Timetable> sort() {

        for (Timetable singleTimetable : this.getInput()) {

            boolean tag = true;
            for (String timeslot : this.getUnwanted()) {
                if (singleTimetable.getOccupied().contains(timeslot)) {
                    tag = false;
                    break;
                }
            }
            if (tag) {
                this.getOutput().add(singleTimetable);
            }
        }
        return this.getOutput();
    }
}