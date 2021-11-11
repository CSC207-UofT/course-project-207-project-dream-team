package filter;

import timetable.Timetable;

import java.util.ArrayList;


public class TimeslotFilter extends Filter {

    public TimeslotFilter(ArrayList<Timetable> input, ArrayList<Object> unwanted) {
        super(input, unwanted);
    }

    @Override
    public ArrayList<Timetable> sort(){

        ArrayList<Timetable> output = new ArrayList<>();

        for (Timetable singleTimetable: this.input) {
            for (Object timeslot: this.unwanted) {
                String time = timeslot.toString();
                if (!singleTimetable.occupied.contains(time)) {
                    output.add(singleTimetable);
                }
            }
        }
        return output;
    }
    // to be implemented
}
