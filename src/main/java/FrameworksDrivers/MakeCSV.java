package FrameworksDrivers;


import EnterpriseBusinessRules.NewCourse;
import EnterpriseBusinessRules.Session;

import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.TreeMap;

import static InterfaceAdapters.ConvertToUI.timetableToUI;

public class MakeCSV {
    /**
     * Produce a csv file containing the selected timetable
     * @param timetable an ordered mapping of session time to course sessions, ordered from the earliest time to latest.
     */
    public static void makeCSV(TreeMap<String, Session> timetable) {
        PrintWriter pw;
        try {
            pw = new PrintWriter("test.csv");

            StringBuilder body = new StringBuilder();

            // write header
            pw.write("Time,Monday,Tuesday,Wednesday,Thursday,Friday");

            // write data
            ArrayList<ArrayList<String>> courses = timetableToUI(timetable);
            for (int y = 0; y < courses.size(); y ++) {

                String timeslot = (y + 9) + ":00-" + (y + 10) + ":00";
                body.append("\n").append(timeslot).append(",");

                for (int x = 0; x < courses.get(y).size(); x ++) {
                    if (courses.get(y).get(x) != null){
                        body.append(courses.get(y).get(x)).append(",");
                    } else {
                        body.append(",");
                    }
                }
            }
            pw.write(body.toString());
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
