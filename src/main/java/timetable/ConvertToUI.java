package timetable;

import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;

import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class ConvertToUI {

    public static String[] allValidKey(int x, int y){
        String strY = String.valueOf(y);
        if (strY.length() < 2) {
            strY = "0" + strY;
        }
        String singleHrKey = x + strY + (y + 1);
        String dualHrKey = x + strY + (y + 2);
        String tripleHrKey = x + strY + (y + 3);
        return new String[]{singleHrKey, dualHrKey, tripleHrKey};
    }

    public static ArrayList<ArrayList<String>> convertToUI(HashMap<String, Session> timetable){
        ArrayList<Integer> record = new ArrayList<>();
        ArrayList<ArrayList<String>> entireTable = new ArrayList<>();

        for (int yCoords = 9; yCoords < 21; yCoords ++) {

            ArrayList<String> sameHr = new ArrayList<>();

            for (int xCoords = 1; xCoords < 6; xCoords ++) {
                // convert the position of the current cell to timetable key format
                String[] keys = allValidKey(xCoords, yCoords);

                if (timetable.containsKey(keys[0])) {
                    sameHr.add(timetable.get(keys[0]).courseCode);
                } else if (timetable.containsKey(keys[1])) {
                    sameHr.add(timetable.get(keys[1]).courseCode);
                    record.add(xCoords);
                } else if (timetable.containsKey(keys[2])) {
                    sameHr.add(timetable.get(keys[2]).courseCode);
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
