package java;

import java.sql.Time;
import java.util.ArrayList;

public abstract class Scheduler {
    ArrayList<Course> courses;//courses ready to be arranged
    ArrayList<Timetable> output;// a list of timetable results
    int y_n;
    Object detail;//another attribute to be used


    public Scheduler(ArrayList<Course> courses){
        this.courses = courses;
        this.output = new ArrayList<Timetable>();
    }

    public void Arrange(ArrayList<Course> courses, int y_n, Object detail){
        output = new ArrayList<Timetable>();
        //some code here
        //task: put courses into timetable
        for (Course course:courses){
            for (Timeslot grid:output[0]) {
                if (// course fits the grid){
                    //update the grid
                }
            }
        }


    }
}
