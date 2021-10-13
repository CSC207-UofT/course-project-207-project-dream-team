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

    public void Arrange(ArrayList<Course> course, int y_n, Object detail){
        //some code here
    }
}
