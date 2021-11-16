import ApplicationBusinessRule.InstructorFilter;
import org.junit.Test;
import EnterpriseBusinessRules.Session;
import ApplicationBusinessRule.Timetable;

import java.util.*;

import static org.junit.Assert.*;

public class InstructorFilterTest {

    @Test(timeout = 1000000)
    public void TestSort(){

        // the data set that contains all the timetables to be filtered
        ArrayList<Timetable> timetables = new ArrayList<>();

        // the data set of all UNWANTED PROFESSORS
        ArrayList<String> unwanted = new ArrayList<>();
        unwanted.add("Gries");


        // Initialize a new course CSC207
        Session csc207a =
                new Session("Gries", "CSC207H1F", "LEC0101", new Integer[]{41314});

        // A single timetable
       //  Timetable timetable1 = new Timetable();

        TreeMap<String, Session> mapTimeTable = new TreeMap<String, Session>();
        mapTimeTable.put("41314", csc207a);

        ArrayList<String> occupied = new ArrayList<String>();
        occupied.add("41314");

        Timetable timetable1 = new Timetable(mapTimeTable,occupied);

        timetables.add(timetable1);

        InstructorFilter is = new InstructorFilter(timetables, unwanted);

        ArrayList<Timetable> tt = is.sort();

        assertEquals(0, tt.size());
        
        // more test to be added in the near future !1!!!.
    }

}
