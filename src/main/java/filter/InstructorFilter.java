//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Set;
//import java.util.TreeMap;
//
//
//public class InstructorFilter {
//
//    // filter out the timetables with unwanted timetables
//
//    public InstructorFilter() {
//        super();
//    }
//
//    public ArrayList<Timetable> sort(ArrayList<Timetable> inputTimetables, ArrayList<String> unwantedProfs) {
//
//        ArrayList<Timetable> output = new ArrayList<>();            // initialize the output
//
//        for (Timetable singleTimetable : inputTimetables) {                // loop every timetable
//
//            // get the data of timetable in hashmap form.
//            TreeMap<String, Session> mapTimetable = singleTimetable.timeTable;
//
//            // get the keys of mapTimetable
//            Set<String> keys = mapTimetable.keySet();
//
//            // get the size of sessions
//            int size = 0;
//            for (String key : keys) {
//                if (mapTimetable.get(key) != null) {
//                    size++;
//                }
//            }
//
//            int checker = 0;           // used to check
//
//            for (String key : keys) {
//
//                if (!unwantedProfs.contains(mapTimetable.get(key).instructor)) {
//                    checker += 1;
//
//                }
//                if (size == checker) {
//                    output.add(singleTimetable);
//                }
//            }
//        }
//    return output;
//    }
//}


