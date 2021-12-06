import EnterpriseBusinessRules.NewCourse;
import EnterpriseBusinessRules.Session;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

public class MakeCSVTest {
    @Test(timeout = 1000000)
    public void TestSort() throws IOException {

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

        ArrayList<TreeMap> maps = new ArrayList<>();
        maps.add(map);
        maps.add(map);

    }
}
