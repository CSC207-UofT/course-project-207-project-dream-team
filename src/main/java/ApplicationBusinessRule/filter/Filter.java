package ApplicationBusinessRule.filter;

import ApplicationBusinessRule.Timetable;

import java.util.ArrayList;

public abstract class Filter {


    private final ArrayList<Timetable> input;
    private final ArrayList<Timetable> output;     // timetables that meets users' preferences
    private final ArrayList<String> unwanted;      // a list of unwanted instructors, timeslot etc.

    /**
     * abstract Filter Class with three child class.
     *
     * @param input    an Arraylist of timetable
     * @param unwanted an Arraylist of string (e.g. unwanted instructors, timeslots, maximum hours)
     */

    public Filter(ArrayList<Timetable> input, ArrayList<String> unwanted) {


        this.input = input;
        this.unwanted = unwanted;
        this.output = new ArrayList<>();
    }

    /**
     * sort out unwanted timetables
     *
     * @return an Arraylist of sorted timetable
     */
    public abstract ArrayList<Timetable> sort();

    /**
     * get the input
     *
     * @return an arraylist of timetable
     */
    public ArrayList<Timetable> getInput() {
        return this.input;
    }

    /**
     * get the output
     *
     * @return an arraylist of timetable
     */
    public ArrayList<Timetable> getOutput() {
        return this.output;
    }

    /**
     * get the unwanted objects
     *
     * @return an arraylist of string
     */
    public ArrayList<String> getUnwanted() {
        return this.unwanted;
    }
}
