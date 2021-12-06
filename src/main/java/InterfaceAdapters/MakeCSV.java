package InterfaceAdapters;


import ApplicationBusinessRule.Timetable;
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
    public static void makeCSV2(TreeMap<String, Session> timetable) {
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
                body.append(twoRows(courses.get(y)));
            }
            pw.write(body.toString());
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void makeCSV(ArrayList<Timetable> timetables){
        try{
        PrintWriter pw = new PrintWriter("test.csv");
        ArrayList<TreeMap<String,Session>> converted = convertTimetables(timetables);
        for (int z=0; z<converted.size(); z++) {

            StringBuilder body = new StringBuilder();

            // write header
            pw.write("\nTime,Monday,Tuesday,Wednesday,Thursday,Friday");

            // write data
            ArrayList<ArrayList<String>> courses = timetableToUI(converted.get(z));
            for (int y = 0; y < courses.size(); y++) {

                String timeslot = (y + 9) + ":00-" + (y + 10) + ":00";
                body.append("\n").append(timeslot).append(",");
                body.append(twoRows(courses.get(y)));
            }
            pw.write(body.toString());
        }
        pw.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<TreeMap<String,Session>> convertTimetables(ArrayList<Timetable> timetables){
        ArrayList<TreeMap<String,Session>> result = new ArrayList<>();
        for (Timetable timetable:timetables){
            result.add(timetable.getTimeTable());
        }
        return result;
    }

    public static String twoRows(ArrayList<String> sessions){
        String twoRows = "";
        for (int i=0; i<5;i++){
            if (sessions.get(i) != null){
                twoRows = twoRows + sessions.get(i).substring(0, 6)+ ",";
            }else{
                twoRows = twoRows + ",";
            }
        }
        twoRows = twoRows + "\n" + ",";
        for (int j=0; j<5; j++){
            if (sessions.get(j) != null){
                twoRows = twoRows + sessions.get(j).substring(sessions.get(j).length()-7)+ ",";
            }else{
                twoRows = twoRows + ",";
            }
        }
        return twoRows;
    }


}