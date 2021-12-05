package InterfaceAdapters;

import EnterpriseBusinessRules.Session;

import java.util.ArrayList;
import java.util.TreeMap;

public class ConvertToUI {

    public static String[] allValidKey(int x, int y) {
        String strY = String.valueOf(y);
        if (strY.length() < 2) {
            strY = "0" + strY;
        }
        String singleHrKey = x + strY + (y + 1);
        String dualHrKey = x + strY + (y + 2);
        String tripleHrKey = x + strY + (y + 3);
        return new String[]{singleHrKey, dualHrKey, tripleHrKey};
    }

    public static ArrayList<ArrayList<String>> convertToUI(TreeMap<String, Session> timetable) {
        ArrayList<Integer> record = new ArrayList<>();
        ArrayList<ArrayList<String>> entireTable = new ArrayList<>();

        for (int yCoords = 9; yCoords < 21; yCoords++) {

            ArrayList<String> sameHr = new ArrayList<>();

            for (int xCoords = 1; xCoords < 6; xCoords++) {
                // convert the position of the current cell to timetable key format
                String[] keys = allValidKey(xCoords, yCoords);

                if (timetable.containsKey(keys[0])) {
                    sameHr.add(timetable.get(keys[0]).courseCode + "\n" + timetable.get(keys[0]).sessionCode.substring(0, 7));
                } else if (timetable.containsKey(keys[1])) {
                    sameHr.add(timetable.get(keys[1]).courseCode + "\n" +  timetable.get(keys[1]).sessionCode.substring(0, 7));
                    record.add(xCoords);
                } else if (timetable.containsKey(keys[2])) {
                    sameHr.add(timetable.get(keys[2]).courseCode + "\n" +  timetable.get(keys[2]).sessionCode.substring(0, 7));
                    record.add(xCoords);
                    record.add(xCoords);
                } else {
                    if (record.contains(xCoords)) {
                        sameHr.add(entireTable.get(yCoords - 9).get(xCoords));
                        record.remove(Integer.valueOf(xCoords));
                    } else {
                        sameHr.add(null);
                    }
                }
            }
            entireTable.add(sameHr);
        }
        return entireTable;
    }

    public static ArrayList<String> timeslotToStrings(Integer dayInString, ArrayList<String> timeslots){
        ArrayList<String> result = new ArrayList<>();
        for (String i:timeslots){
            String startTime = i.substring(0, 2);
            String endTime = i.substring(8, 10);
            String dayOfWeek = dayInString.toString();
            String timeCode = dayOfWeek + startTime + endTime;
            result.add(timeCode);
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<String> timeslots = new ArrayList<>();
        String t1 = "09:00 - 10:00";
        String t2 = "13:00 - 15:00";
        timeslots.add(t1);
        timeslots.add(t2);
        System.out.println(timeslotToStrings(1, timeslots));

        }
    }