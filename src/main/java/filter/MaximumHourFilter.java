package filter;
import timetable.Timetable;
import timetable.Session;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;


public class MaximumHourFilter extends Filter {

    public MaximumHourFilter(ArrayList<Timetable> input, ArrayList<String> unwanted) {
        super(input, unwanted);
    }

    // Notice that:
    // Here, the unwanted is an ArrayList of String of length 1.
    // {"7"}: the maximum hour of study time not should not exceed 7 Hours per day.

    @Override
    public ArrayList<Timetable> sort() {

        // the maximum hour that should not be exceeded per day
        int maxHour = Integer.getInteger(this.unwanted.get(0));

        for (Timetable singleTimetable : this.input) {                // loop every timetable

            // get the data of timetable in hashmap form.
            HashMap<String, Session> mapTimetable = singleTimetable.timeTable;

            // get the keys of mapTimetable
            Set<String> keys = mapTimetable.keySet();

//            for (int i=0; i < 5; i++) {
//
//                for (String key: keys) {
//                    if (String key[0] == String.valueOf(i)) {
//                        String diff = key.substring(3, 6) - key.substring(1,3);
//                    }
//                }
//            }


        }
        return this.output;
    }
}
