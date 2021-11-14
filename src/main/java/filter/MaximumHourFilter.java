package filter;

import timetable.Timetable;
import timetable.Session;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;


public class MaximumHourFilter extends Filter{

    public MaximumHourFilter(ArrayList<Timetable> input, ArrayList<String> unwanted) {
        super(input, unwanted);
    }

    // Notice that:
    // Here, the unwanted is an ArrayList of String of length 1.
    // {"7"}: the maximum hour of study time not should not exceed 7 Hours per day.

    @Override
    public ArrayList<Timetable> sort() {

        // the output of after being filtered
        ArrayList<Timetable> output = new ArrayList<>();

        // the maximum hour that should not be exceeded per day   # As a constant
        int maxHour = Integer.getInteger(this.unwanted.get(0));

        // loop every timetable
        for (Timetable singleTimetable : this.input) {

            // Timetable is added iff weeklyCounter == 5
            // All study hours of five days are not exceeds the Maximum limit
            int weeklyCounter = 0;

            // # Get the information of the entire Timetable
            // Get the data of timetable in hashmap form.
            TreeMap<String, Session> dataTimetable = singleTimetable.timeTable;
            // Get the keys of dataTimetable
            Set<String> keys = dataTimetable.keySet();

            // i refers to the day: {1: Monday 2: Tuesday ...}
            for (int i=1; i < 6; i++) {

                // counter of the hours study everyday
                int dailyHour = 0;

                // Checker: filter sort the time of the same day::
                // "11517" -> all times on Monday
                for (String key: keys) {

                    // if statement here has the following functionality:
                    // the first char of key == the Day (Monday)
                    if (key.substring(0,1).equals(String.valueOf(i))){

                        int diff = Integer.getInteger(key.substring(3, 6)) -
                                Integer.getInteger(key.substring(1, 3));

                        dailyHour += diff;
                    }
                }
                if (dailyHour <= maxHour) {
                    weeklyCounter ++;}
            }
            // Check if all five day of the week satisfies.
            if (weeklyCounter == 5) {
                output.add(singleTimetable);
            }
        }
        return output;
    }
}

