import java.util.ArrayList;

abstract class Filter {

    public ArrayList<Timetable> input;  // take from the output of SimpleScheduler Class
    public ArrayList<Timetable> output; // filtered Timetables

    // initializer
    public Filter() {
        // this.input = input;
        this.output = new ArrayList<>();
    }

    // Start to sort
    public abstract void sort();

}
