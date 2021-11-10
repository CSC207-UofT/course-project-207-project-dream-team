import java.util.ArrayList;

public class DurationFilter{

    public DurationFilter() {
        super();
    }

    private int duration(int input) {
        // 21113
        String num = String.valueOf(input);
        String num1 = num.substring(1, 3);
        String num2 = num.substring(3, 5);
        return Integer.parseInt(num2) - Integer.parseInt(num1);
    }

//    public ArrayList<Timetable> sort(ArrayList<Timetable> inputTimetable, ArrayList<Integer> unwantedDuration) {
//
//        ArrayList<Timetable> output = new ArrayList<>();
//        for (Timetable singleTimetable: inputTimetable) {
//            for (Integer timeslot: unwantedDuration) {
//                if (singleTimetable.timeTable.
//            }
//        }
    }
    // to be implemented
}
