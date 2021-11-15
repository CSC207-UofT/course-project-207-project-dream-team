import ApplicationBusinessRule.Timetable;
import EnterpriseBusinessRules.NewCourse;
import EnterpriseBusinessRules.Session;
import org.junit.Test;
import org.junit.Before;

import java.util.*;

import static org.junit.Assert.*;

public class TimetableTest {

    Timetable tb;

    ArrayList<NewCourse> coursesToSchedule;
    Session lecToAdd;
    Session tutToAdd;

    Session lecInTb;
    Session tutInTb;
    ArrayList<NewCourse> coursesInTb;

    @Before
    public void setup(){
        TreeMap<String, Session> map = new TreeMap<>();

        // Create the starting timetable, which has 1 course added already.
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

        tb = new Timetable(map, occupied);


        // Initialize an ArrayList of courses that we want to add to the timetable.
        lecToAdd = new Session("Soheil", "MAT224H1F", "LEC0101", new Integer[]{41314});
        tutToAdd = new Session("TBA", "MAT224H1F", "TUT0102", new Integer[]{11112});

        ArrayList<Session> mat224tut = new ArrayList<>();
        mat224tut.add(tutToAdd);
        ArrayList<Session> mat224lec = new ArrayList<>();
        mat224lec.add(lecToAdd);

        coursesToSchedule = new ArrayList<>(coursesInTb);
        coursesToSchedule.add(new NewCourse("MAT224H1F", mat224tut, mat224lec, new ArrayList<>()));
    }

    @ Test (timeout = 1000)
    public void testToString(){
        String expected = "CSC207H1FTUT0301[11415, 11516]TBACSC207H1FTUT0301[11415, 11516]TBACSC207H1FLEC0101[41314]Gries";
        assertEquals(expected, tb.toString());
    }


    @Test (timeout = 1000)
    public void testExtensions(){

        TreeMap<String, Session> map2 = new TreeMap<>(tb.getTimeTable());
        ArrayList<String> occupied2 = new ArrayList<>(tb.getOccupied());
        map2.put("11112", tutToAdd);
        occupied2.add("11112");
        Timetable extension2 = new Timetable(map2, occupied2);

        ArrayList<String> extensionStrings = new ArrayList<>();
        for (Timetable t : tb.extensions(coursesToSchedule)){
            extensionStrings.add(t.toString());
        }

        assertEquals(extensionStrings.size(), 1); // Assert there is only 1 possible extension
        assertTrue(extensionStrings.contains(extension2.toString())); // Assert the extension is the same as expected
    }


    @ Test (timeout = 1000)
    public void testIsSolved(){
        assertFalse(tb.isSolved(coursesToSchedule));
        assertTrue(tb.isSolved(coursesInTb));
    }

}
