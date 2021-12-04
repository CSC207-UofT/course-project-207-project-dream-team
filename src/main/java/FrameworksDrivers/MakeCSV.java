package FrameworksDrivers;


import ApplicationBusinessRule.Timetable;
import EnterpriseBusinessRules.NewCourse;
import EnterpriseBusinessRules.Session;

import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.TreeMap;

import static InterfaceAdapters.ConvertToUI.allValidKey;
import static InterfaceAdapters.ConvertToUI.convertToUI;

public class MakeCSV {
    public static void makeCSV(TreeMap<String, Session> timetable) {
        PrintWriter pw;
        try {
            pw = new PrintWriter("test.csv");

            StringBuilder body = new StringBuilder("");

            // write header
            pw.write("Time,Monday,Tuesday,Wednesday,Thursday,Friday");

            // write data
            ArrayList<ArrayList<String>> courses = convertToUI(timetable);
            ArrayList<Integer> record = new ArrayList<>();
            String buffer = "";
            for (int y = 9; y < 21; y ++) {

                String timeslot = y + ":00-" + (y + 1) + ":00";
                body.append("\n").append(timeslot).append(",");

                for (int x = 1; x < 6; x ++) {
                    // convert the position of the current cell to timetable key format
                    String[] keys = allValidKey(x, y);

                    if (timetable.containsKey(keys[0])) {
                        body.append(timetable.get(keys[0]).courseCode).append(timetable.get(keys[0]).sessionCode.
                                substring(0, 3)).append(",");
                    } else if (timetable.containsKey(keys[1])) {
                        body.append(timetable.get(keys[1]).courseCode).append(timetable.get(keys[1]).sessionCode.
                                substring(0, 3)).append(",");
                        buffer = (timetable.get(keys[1]).courseCode + timetable.get(keys[1]).sessionCode.
                                substring(0, 3) + ",");
                        record.add(x);
                    } else if (timetable.containsKey(keys[2])) {
                        body.append(timetable.get(keys[2]).courseCode).append(timetable.get(keys[2]).sessionCode.
                                substring(0, 3)).append(",");
                        buffer = (timetable.get(keys[1]).courseCode + timetable.get(keys[1]).sessionCode.
                                substring(0, 3) + ",");
                        record.add(x);
                        record.add(x);
                    } else {
                        if (record.contains(x)) {
                            body.append(buffer);
                            record.remove(Integer.valueOf(x));
                        } else {
                            body.append(",");
                        }
                    }
                }
            }
            pw.write(body.toString());
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Session lecInTb;
        Session tutInTb;
        ArrayList<NewCourse> coursesInTb;
        TreeMap<String, Session> map = new TreeMap<>();
        lecInTb = new Session("Gries", "CSC207H1F", "LEC0101", new Integer[]{41314});
        map.put("41314", lecInTb);

        tutInTb = new Session("TBA", "CSC207H1F", "TUT0301", new Integer[]{11415, 11516});
        map.put("11415", tutInTb);
        map.put("11516", tutInTb);

        ArrayList<Session> csc207tut = new ArrayList<>();
        csc207tut.add(tutInTb);
        ArrayList<Session> csc207lec = new ArrayList<>();
        csc207lec.add(lecInTb);

        coursesInTb = new ArrayList<>();
        coursesInTb.add(new NewCourse("CSC207H1F", csc207tut, csc207lec, new ArrayList<>()));

        ArrayList<String> occupied = new ArrayList<>();
        occupied.add("41314");
        occupied.add("11415");
        occupied.add("11516");

        makeCSV(map);
    }
}
