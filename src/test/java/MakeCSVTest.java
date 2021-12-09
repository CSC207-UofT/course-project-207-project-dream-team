import ApplicationBusinessRule.Timetable;
import EnterpriseBusinessRules.NewCourse;
import EnterpriseBusinessRules.Session;
import FrameworksDrivers.WebParse;
import InterfaceAdapters.ConvertToUI;
import InterfaceAdapters.MakeCSV;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class MakeCSVTest {


    @Test(timeout = 1000000)
    public void TestSort() throws IOException {
        Timetable timetable = new Timetable();
        NewCourse csc207 = WebParse.courseParse("CSC207");
        NewCourse csc165 = WebParse.courseParse("CSC165");
        Session s1 = csc165.getLectures().get(0);
        Session s3 = csc207.getLectures().get(0);
        timetable = timetable.addSession(s1);
        timetable = timetable.addSession(s3);

        ArrayList<Timetable> timetables = new ArrayList<>();
        timetables.add(timetable);
        timetables.add(timetable);

        ArrayList<TreeMap<String, Session>> maps = MakeCSV.convertTimetables(timetables);

        assertEquals(2, maps.size());

        ArrayList<ArrayList<String>> uiMaps = ConvertToUI.timetableToUI(timetables.get(0).getTimeTable());
        ArrayList<String> uiMap = uiMaps.get(0);
        String twoRows = MakeCSV.twoRows(uiMap);

        assertEquals(38, twoRows.length());

        boolean result1 = MakeCSV.makeCSV(timetables);
        assertTrue(result1);

        boolean result2 = MakeCSV.makeCSV2(timetables.get(0).getTimeTable());
        assertTrue(result2);
    }
}