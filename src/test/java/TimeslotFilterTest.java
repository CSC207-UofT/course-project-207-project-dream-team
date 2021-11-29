import ApplicationBusinessRule.filter.TimeslotFilter;
import org.junit.Test;
import EnterpriseBusinessRules.Session;
import ApplicationBusinessRule.Timetable;

import java.util.*;

import static org.junit.Assert.*;

public class TimeslotFilterTest {

    @Test(timeout = 1000000)
    public void TestSort() {

        // the data set that contains all the timetables to be filtered
        ArrayList<Timetable> timetables = new ArrayList<>();

        // the data set of all UNWANTED PROFESSORS
        ArrayList<String> unwanted = new ArrayList<>();
        unwanted.add("41314");


        // Initialize a new course CSC207
        Session csc207a =
                new Session("Gries", "CSC207H1F", "LEC0101", new Integer[]{41314});

        // A single timetable
        //  Timetable timetable1 = new Timetable();

        TreeMap<String, Session> mapTimeTable = new TreeMap<String, Session>();
        mapTimeTable.put("41314", csc207a);

        ArrayList<String> occupied = new ArrayList<String>();
        occupied.add("41314");

        Timetable timetable1 = new Timetable(mapTimeTable, occupied);

        timetables.add(timetable1);

        TimeslotFilter tt = new TimeslotFilter(timetables, unwanted);
        ArrayList<Timetable> output = tt.sort();

        assertEquals(0, output.size());

        // my git is working good now.!!!
    }
}

