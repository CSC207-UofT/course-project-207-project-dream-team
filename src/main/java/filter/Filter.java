package filter;
import timetable.Timetable;
import java.util.ArrayList;

public abstract class Filter {

    public ArrayList<Timetable> input;
    public ArrayList<Timetable> output;     // timetables that meets users' preferences
    public ArrayList<String> unwanted;      // a list of unwanted instructors, timeslot etc.

    public Filter(ArrayList<Timetable> input, ArrayList<String> unwanted) {

        this.input = input;
        this.unwanted = unwanted;
        this.output = new ArrayList<>();
    }

    public abstract ArrayList<Timetable> sort();

}