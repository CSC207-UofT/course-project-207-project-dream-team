package ApplicationBusinessRule;

import EnterpriseBusinessRules.Session;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;


public class InstructorFilter extends Filter {

    // filter out the timetables with unwanted timetables

    public InstructorFilter(ArrayList<Timetable> input, ArrayList<String> unwanted) {
        super(input, unwanted);
    }

    @Override
    public ArrayList<Timetable> sort() {

        // ArrayList<Timetable> output = new ArrayList<>();            // initialize the output

        for (Timetable singleTimetable : this.getInput()) {                // loop every timetable

            // Get the data of timetable in TreeMap Form.
            TreeMap<String, Session> mapTimetable = singleTimetable.getTimeTable();

            // Due to property of TreeMap, all values in TreeMap are NON-NULL
            Set<String> keys = mapTimetable.keySet();

            // A checker
            int checker = 0;

            for (String key : keys) {

                if (!this.getUnwanted().contains(mapTimetable.get(key).instructor)) {
                    checker += 1;
                }

            }
            if (checker == keys.size()) {
                this.getOutput().add(singleTimetable);
            }
        }
        return this.getOutput();
    }
}



