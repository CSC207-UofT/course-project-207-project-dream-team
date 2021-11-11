import java.util.ArrayList;


public class TimeslotFilter {

    public TimeslotFilter() {
        super();
    }

    public ArrayList<Timetable> sort(ArrayList<Timetable> inputTimetables, ArrayList<String> unwantedTimeslot){

        ArrayList<Timetable> output = new ArrayList<>();

        for (Timetable singleTimetable: inputTimetables) {
            for (String timeslot: unwantedTimeslot) {
                if (!singleTimetable.occupied.contains(timeslot)) {
                    output.add(singleTimetable);
                }
            }
        }
        return output;
    }
    // to be implemented
}
