package ApplicationBusinessRule.filter;
import ApplicationBusinessRule.Timetable;

import java.util.ArrayList;

public class TimeslotFilter extends Filter {

    /**
     * constructor for TimeslotFilter
     * @param input an Arraylist of timetable
     * @param unwanted an Arraylist of unwanted timeslot
     */

    public TimeslotFilter(ArrayList<Timetable> input, ArrayList<String> unwanted) {
        super(input, unwanted);
    }

    /**
     * sort out timetable with unwanted timeslot
     * @return an Arraylist of timetable
     */
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