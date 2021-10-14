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
    private final Map<Integer, Map<Integer, Object>> week;
    //constructor
    public Timetable() {
        this.week = new HashMap<Integer, Map<Integer, Object>>(5);
        for (int i = 1; i <= 5; i ++) {
            HashMap<Integer, Object> day = new HashMap<Integer, Object>();
            for (int j = 0; j < 12; j ++) {
                HashMap<Integer, Object> emptySlot = new HashMap<>();
                emptySlot.put(0, true);
                day.put(j, emptySlot);
            }
            this.week.put(i, day);
        }
    }
    //getter
    public Map<Integer, Map<Integer, Object>> getTable() {
        return week;
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
    private int startTime(String timeSpan) {
        int start = Integer.parseInt(timeSpan.substring(0, timeSpan.indexOf(".")));
        if (start < 9) {
            start = start + 12;
        }
        return start;
    }

    //return the end time
    private int endTime(String timeSpan) {
        int end = Integer.parseInt(timeSpan.substring(timeSpan.indexOf("/") + 1, timeSpan.lastIndexOf(".")));
        if (end <= 9) {
            end = end + 12;
        }
        return end;
    }
    //this conversion works because there is no start time earlier than 9am and no end time later than 9pm

    //public methods
    public boolean isEmpty(String timeSpan) {
        //before the code body, we should make clear of the time conversions here.
        //We access weekdays starting from 1, so weekday = index
        //We access timeslot info using Hashmap keyed from 0, so key_value + 9 = start of the hour
        //Notice that here the time is converted from 12h to 24h
        int start = startTime(timeSpan);
        int end = endTime(timeSpan);
        int day = whatDay(timeSpan);
        for (int i = start; i < end; i ++) {
            //each hour is represented by its start hour
            if (this.week.get(day).get(i - 9) instanceof HashMap) {
                if (!(boolean) ((HashMap<?, ?>) this.week.get(day).get(i - 9)).get(0)) {
                    //I doubt this casting works, but I am literally out of ideas :(
                    return false;
                }
            }
        }
        return true;
    }

    public boolean addCourse(String timeSpan) {
        int start = startTime(timeSpan);
        int end = endTime(timeSpan);
        int day = whatDay(timeSpan);
        for (int i = start; i < end; i ++) {
            //each hour is represented by its start hour
            if (this.week.get(day).get(i - 9) instanceof HashMap) {
                if (this.isEmpty(timeSpan)) {
                    ((HashMap<Integer, Object>) this.week.get(day).get(i - 9))
                            .put(0, (!(boolean) ((HashMap<?, ?>) this.week.get(day).get(i - 9)).get(0)));
                    //I have no fucking idea how this can work
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        //TODO: make presentable timetable using string
        return "";
    }
}
