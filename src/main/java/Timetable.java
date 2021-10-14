import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Timetable {
    //constants
    final static String MONDAY = "MOND";
    final static String TUESDAY = "TUES";
    final static String WEDNESDAY = "WEDN";
    final static String THURSDAY = "THUR";
    final static String FRIDAY = "FRID";
    //the Timetable class implementation uses tiled map
    //we will first create an empty tiled map
    private HashMap<Integer[], Course> timeTable;

    //constructor
    public Timetable() {
        this.timeTable = new Map<Integer[], Course>;
        for (int i = 1; i <= 5; i ++) {
            for (int k = 9; k <= 21; k++) {
                Integer[] tempArray = {i, k};
                this.timeTable.put(tempArray, null);
            }
        }
    }

    //getter
    public HashMap<Integer[], Course> getTable() {
        return timeTable;
    }

    //helper methods

    //return weekday
    private int whatDay(String timeSpan) {
        //we will assume any timeSpan input here is legal
        switch (timeSpan.substring(timeSpan.length() - 4)) {
            case MONDAY:
                return 1;
            case TUESDAY:
                return 2;
            case WEDNESDAY:
                return 3;
            case THURSDAY:
                return 4;
            case FRIDAY:
                return 5;
        }
        return -1;
    }

    //return the start time
//    private int startTime(String timeSpan) {
//        return Integer.parseInt(timeSpan.substring(0, timeSpan.indexOf(".")));
//    }
//
//    //return the end time
//    private int endTime(String timeSpan) {
//        return Integer.parseInt(timeSpan.substring(timeSpan.indexOf("/") + 1, timeSpan.lastIndexOf(".")));
//    }
    //this conversion works because there is no start time earlier than 9am and no end time later than 9pm

    //public methods
    public boolean isEmpty(Integer[] timeSpan) {
        // check whether timeSpan is in the key set.
        if (this.timeTable.containsKey(timeSpan)) {
            for (Integer[] key: this.timeTable.keySet()) {
                if (key == timeSpan) {
                    this.timeTable
                }
            }
        }

    }

    public boolean addCourse(Course course) {
//        int start = startTime(timeSpan);
//        int end = endTime(timeSpan);
//        int day = whatDay(timeSpan);
//        for (int i = start; i < end; i ++) {
//            //each hour is represented by its start hour
//            if (this.timeTable.get(day).get(i - 9) instanceof HashMap) {
//                if (this.isEmpty(timeSpan)) {
//                    ((HashMap<Integer, Object>) this.timeTable.get(day).get(i - 9))
//                            .put(0, (!(boolean) ((HashMap<?, ?>) this.timeTable.get(day).get(i - 9)).get(0)));
//                    //I have no fucking idea how this can work
//                } else {
//                    return false;
//                }
//            }
//        }
//        return true;
        return true;
    }

    @Override
    public String toString() {
        //TODO: make presentable timetable using string
        return "";
    }
}
