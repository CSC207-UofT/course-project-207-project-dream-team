package FrameworksDrivers;


import EnterpriseBusinessRules.NewCourse;
import EnterpriseBusinessRules.Session;

import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.TreeMap;

import static InterfaceAdapters.ConvertToUI.convertToUI;

public class MakeCSV {
    public static void makeCSV(TreeMap<String, Session> timetable) {
        PrintWriter pw;
        try {
            pw = new PrintWriter("test.csv");

            StringBuilder body = new StringBuilder();

            // write header
            pw.write("Time,Monday,Tuesday,Wednesday,Thursday,Friday");

            // write data
            ArrayList<ArrayList<String>> courses = convertToUI(timetable);
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
