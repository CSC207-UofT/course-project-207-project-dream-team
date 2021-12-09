package InterfaceAdapters;


import ApplicationBusinessRule.Timetable;
import EnterpriseBusinessRules.Session;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.TreeMap;

import static InterfaceAdapters.ConvertToUI.timetableToUI;

public class MakeCSV {

    final static String path = "command_separated.csv";

    /**
     * Produce a csv file containing the selected timetable
     *
     * @param timetable an ordered mapping of session time to course sessions, ordered from the earliest time to latest.
     */
    public static boolean makeCSV2(TreeMap<String, Session> timetable) throws FileNotFoundException {
        PrintWriter pw;
        pw = new PrintWriter(path);

        StringBuilder body = new StringBuilder();

        // write header
        pw.write("Time,Monday,Tuesday,Wednesday,Thursday,Friday");

        // write data
        listToString(timetable, pw, body);
        pw.close();
        return true;
    }

    private static void listToString(TreeMap<String, Session> timetable, PrintWriter pw, StringBuilder body) {
        ArrayList<ArrayList<String>> courses = timetableToUI(timetable);
        for (int y = 0; y < courses.size(); y++) {

            String timeslot = (y + 9) + ":00-" + (y + 10) + ":00";
            body.append("\n").append(timeslot).append(",");
            body.append(twoRows(courses.get(y)));
        }
        pw.write(body.toString());
    }

    public static boolean makeCSV(ArrayList<Timetable> timetables) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(path);
        ArrayList<TreeMap<String, Session>> converted = convertTimetables(timetables);
        for (TreeMap<String, Session> stringSessionTreeMap : converted) {

            StringBuilder body = new StringBuilder();

            // write header
            pw.write("\nTime,Monday,Tuesday,Wednesday,Thursday,Friday");

            // write data
            listToString(stringSessionTreeMap, pw, body);
        }
        pw.close();
        return true;
    }

    public static ArrayList<TreeMap<String, Session>> convertTimetables(ArrayList<Timetable> timetables) {
        ArrayList<TreeMap<String, Session>> result = new ArrayList<>();
        for (Timetable timetable : timetables) {
            result.add(timetable.getTimeTable());
        }
        return result;
    }

    public static String twoRows(ArrayList<String> sessions) {
        StringBuilder twoRowsBuilder = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            if (sessions.get(i) != null) {
                twoRowsBuilder.append(sessions.get(i), 0, 6).append(",");
            } else {
                twoRowsBuilder.append(",");
            }
        }
        String twoRows = twoRowsBuilder.toString();
        StringBuilder twoRowsBuilder1 = new StringBuilder(twoRows + "\n" + ",");
        for (int j = 0; j < 5; j++) {
            if (sessions.get(j) != null) {
                twoRowsBuilder1.append(sessions.get(j).substring(sessions.get(j).length() - 7)).append(",");
            } else {
                twoRowsBuilder1.append(",");
            }
        }
        twoRows = twoRowsBuilder1.toString();
        return twoRows;
    }

}