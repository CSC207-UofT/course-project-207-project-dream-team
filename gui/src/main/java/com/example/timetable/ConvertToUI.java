package com.example.timetable;

import java.util.ArrayList;
import java.util.HashMap;

public class ConvertToUI {

    public static ArrayList<ArrayList<String>> convertToUI(HashMap<String, Session> timetable){
        ArrayList<Integer> record = new ArrayList<>();
        ArrayList<ArrayList<String>> entireTable = new ArrayList<>();

        for (int yCoords = 9; yCoords < 21; yCoords ++) {

            ArrayList<String> sameHr = new ArrayList<>();

            for (int xCoords = 1; xCoords < 6; xCoords ++) {
                // convert the position of the current cell to timetable key format
                String strY = String.valueOf(yCoords);
                if (strY.length() < 2) {
                    strY = "0" + strY;
                }
                String singleHrKey = xCoords + strY + (yCoords + 1);
                String dualHrKey = xCoords + strY + (yCoords + 2);
                String tripleHrKey = xCoords + strY + (yCoords + 3);

                if (timetable.containsKey(singleHrKey)) {
                    sameHr.add(timetable.get(singleHrKey).courseCode);
                } else if (timetable.containsKey(dualHrKey)) {
                    sameHr.add(timetable.get(dualHrKey).courseCode);
                    record.add(xCoords);
                } else if (timetable.containsKey(tripleHrKey)) {
                    sameHr.add(timetable.get(dualHrKey).courseCode);
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
}
