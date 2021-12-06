package InterfaceAdapters;


import ApplicationBusinessRule.Timetable;
import EnterpriseBusinessRules.Session;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.TreeMap;

import static InterfaceAdapters.ConvertToUI.timetableToUI;

public class MakeCSV {

    final static String path = "test.csv";
    /**
     * Produce a csv file containing the selected timetable
     * @param timetable an ordered mapping of session time to course sessions, ordered from the earliest time to latest.
     */
    public static boolean makeCSV2(TreeMap<String, Session> timetable) throws FileNotFoundException {
        PrintWriter pw;
        pw = new PrintWriter(path);

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
        return true;
    }

    public static boolean makeCSV(ArrayList<Timetable> timetables) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(path);
        ArrayList<TreeMap<String,Session>> converted = convertTimetables(timetables);
        for (TreeMap<String, Session> stringSessionTreeMap : converted) {

            StringBuilder body = new StringBuilder();

            // write header
            pw.write("\nTime,Monday,Tuesday,Wednesday,Thursday,Friday");

            // write data
            ArrayList<ArrayList<String>> courses = timetableToUI(stringSessionTreeMap);
            for (int y = 0; y < courses.size(); y++) {

                String timeslot = (y + 9) + ":00-" + (y + 10) + ":00";
                body.append("\n").append(timeslot).append(",");
                body.append(twoRows(courses.get(y)));
            }
            pw.write(body.toString());
        }
        pw.close();
        return true;
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