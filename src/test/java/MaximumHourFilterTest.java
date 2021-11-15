import ApplicationBusinessRule.MaximumHourFilter;
import org.junit.Test;
import EnterpriseBusinessRules.Session;
import ApplicationBusinessRule.Timetable;

import java.io.IOException;
import java.util.ArrayList;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class MaximumHourFilterTest {

    @Test(timeout = 1000000)
    public void TestSort() throws IOException {

        // the data set that contains all the timetables to be filtered
        ArrayList<Timetable> timetables = new ArrayList<>();

        // the data set of all UNWANTED PROFESSORS
        ArrayList<String> unwanted = new ArrayList<>(1);
        unwanted.add("2");


        // Initialize a new course CSC207
        Session csc207a =
                new Session("Gries", "CSC207H1F", "LEC0101", new Integer[]{11314});

        // A single timetable
        //  Timetable timetable1 = new Timetable();

        TreeMap<String, Session> mapTimeTable = new TreeMap<String, Session>();
        mapTimeTable.put("11314", csc207a);

        ArrayList<String> occupied = new ArrayList<String>();
        occupied.add("11314");

        Timetable timetable1 = new Timetable(mapTimeTable, occupied);

        timetables.add(timetable1);

        MaximumHourFilter mm = new MaximumHourFilter(timetables, unwanted);

        ArrayList<Timetable> output = mm.sort();

        assertEquals(1, output.size());
    }
}

