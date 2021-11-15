import org.junit.Test;
import EnterpriseBusinessRules.NewCourse;
import EnterpriseBusinessRules.Session;
import ApplicationBusinessRule.SimpleScheduler;
import ApplicationBusinessRule.Timetable;

import java.util.*;

import static org.junit.Assert.*;

public class SimpleSchedulerTest {

    @Test(timeout = 1000000)
    public void TestArrange(){
        ArrayList<NewCourse> courses = new ArrayList<>();

        // Initialize a new course CSC207
        Session csc207a = new Session("Gries", "CSC207H1F", "LEC0101", new Integer[]{41314});
        Session csc207b = new Session("Gries", "CSC207H1F", "LEC0201", new Integer[]{41415});
        Session csc207c = new Session("TBA", "CSC207H1F", "TUT0301", new Integer[]{11415, 11516});

        ArrayList<Session> csc207tut = new ArrayList<>();
        csc207tut.add(csc207c);
        ArrayList<Session> csc207lec = new ArrayList<>();
        csc207lec.add(csc207a);
        csc207lec.add(csc207b);

        courses.add(new NewCourse("CSC207H1F", csc207tut, csc207lec, new ArrayList<>()));

        // Initialize a new course MAT224
        Session mat224a = new Session("Soheil", "MAT224H1F", "LEC0101", new Integer[]{41314});
        Session mat224b = new Session("TBA", "MAT224H1F", "TUT0102", new Integer[]{11112});

        ArrayList<Session> mat224tut = new ArrayList<>();
        mat224tut.add(mat224b);
        ArrayList<Session> mat224lec = new ArrayList<>();
        mat224lec.add(mat224a);

        courses.add(new NewCourse("MAT224H1F", mat224tut, mat224lec, new ArrayList<>()));

        SimpleScheduler ss = new SimpleScheduler(courses);
        Timetable tb = new Timetable(new TreeMap<>(), new ArrayList<>());
        Set<String> seen = new HashSet<>();
        ArrayList<Timetable> solutions = ss.arrange(tb, seen);

        TreeMap<String, Session> map = new TreeMap<>();
        map.put("41415", csc207b);
        map.put("11415", csc207c);
        map.put("11516", csc207c);
        map.put("41314", mat224a);
        map.put("11112", mat224b);

        ArrayList<String> occupied = new ArrayList<>();
        occupied.add("41415");
        occupied.add("11415");
        occupied.add("11516");
        occupied.add("41314");
        occupied.add("11112");

        Timetable onlySol = new Timetable(map, occupied);
        assertEquals(1, solutions.size());
        assertEquals(solutions.get(0).toString(), onlySol.toString());
    }
}
