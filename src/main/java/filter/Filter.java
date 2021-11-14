package filter;
import timetable.Timetable;
import java.util.ArrayList;

public abstract class Filter {

    private final ArrayList<Timetable> input;
    private ArrayList<Timetable> output;     // timetables that meets users' preferences
    private final ArrayList<String> unwanted;      // a list of unwanted instructors, timeslot etc.

    public Filter(ArrayList<Timetable> input, ArrayList<String> unwanted) {

        this.input = input;
        this.unwanted = unwanted;
        this.output = new ArrayList<>();
    }

    public abstract ArrayList<Timetable> sort();

    public ArrayList<Timetable> getInput() {
        return this.input;
    }

    public ArrayList<Timetable> getOutput() {
        return this.output;
    }

    public ArrayList<String> getUnwanted() {
        return this.unwanted;
    }

    public final void isFiltered() {
        try{
            if(this.sort().size() > 0){
                System.out.println("Timetables are sucessfully filtered.");
            }
        }
        catch (Exception e) {
            System.out.println("Timetable are not filtered.");
        }
    }
}