package filter;

import timetable.Timetable;

import java.sql.Time;
import java.util.ArrayList;

public abstract class Filter {

    public ArrayList<Timetable> input;
    public ArrayList<Timetable> output; // timetables that meets users' preferences
    public ArrayList<Object> unwanted; // a list of unwanted instructors, timeslot etc.

    public Filter(ArrayList<Timetable> input, ArrayList<String> unwanted) {

        this.input = input;
        this.output = new ArrayList<Timetable>();
        this.unwanted = unwanted;

    }

    public abstract ArrayList<Timetable> sort();

}

//import java.util.ArrayList;
//
//abstract class Filter {
//
//    public ArrayList<Timetable> input;  // take from the output of SimpleScheduler Class
//    public ArrayList<Timetable> output; // filtered Timetables
//
//    // initializer
//    public Filter() {
//        // this.input = input;
//        this.output = new ArrayList<>();
//    }
//
//    // Start to sort
//    public abstract void sort();
//
//}

