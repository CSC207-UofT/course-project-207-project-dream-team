package filter;

import timetable.Session;
import timetable.Timetable;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;


public class InstructorFilter {

    // filter out the timetables with unwanted timetables

    public InstructorFilter() {
        super();
    }

    public ArrayList<Timetable> sort(ArrayList<Timetable> inputTimetables, ArrayList<String> unwantedProfs) {

        ArrayList<Timetable> output = new ArrayList<>();            // initialize the output

        for (Timetable singleTimetable : inputTimetables) {                // loop every timetable

            // Get the data of timetable in TreeMap Form.
            TreeMap<String, Session> mapTimetable = singleTimetable.getTimeTable();

            // Due to property of TreeMap, all values in TreeMap are NON-NULL
            Set<String> keys = mapTimetable.keySet();

            // A checker
            int checker = 0;

            for (String key : keys) {

                if (!unwantedProfs.contains(mapTimetable.get(key).instructor)) {
                    checker += 1;
                }

            }
            if (checker == keys.size()) {
                output.add(singleTimetable);
            }
        }
        return output;
    }
}



