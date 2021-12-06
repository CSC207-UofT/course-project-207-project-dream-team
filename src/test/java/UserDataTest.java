import EnterpriseBusinessRules.NewCourse;
import FrameworksDrivers.UserData;
import FrameworksDrivers.WebParse;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class UserDataTest {

    @Test(timeout = 1000000)
    public void TestSort() throws IOException {
        Boolean inputExists = UserData.inputExists();
        Boolean flag = (UserData.getFlag() == 1);
        assertEquals(flag, inputExists);

        UserData.removeAll();
        assertEquals(0, UserData.readCourses().size());
        assertEquals("No Filter", UserData.getFilterType());

        UserData.initInput();
        assertEquals(4, UserData.readAllLines().length);

        String[] readAllLines = UserData.readAllLines();
        assertEquals("Course Codes,", readAllLines[0]);

        UserData.inputCourse("CSC108H1F");
        UserData.inputCourse("CSC207H1S");
        UserData.inputCourse("CSC258H1F");

        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> times = new ArrayList<>();

        names.add("Piao");
        names.add("Ethan");
        names.add("Xuanyi");
        UserData.inputInstructor(names);

        assertEquals("Instructors", UserData.getFilterType());
        assertEquals(3, UserData.readPreference().size());

        UserData.clearPreference();
        times.add("11019");
        times.add("51719");

        UserData.inputTimeslot(times);
        assertEquals(2, UserData.readPreference().size());

        UserData.removeCourse("CSC104H1F");
        UserData.removeCourse("CSC108H1F");

        assertEquals("Timeslots", UserData.getFilterType());
        assertEquals(2 ,UserData.readCourses().size());

        UserData.clearCourses();
        assertEquals(0 ,UserData.readCourses().size());

        UserData.clearPreference();
        UserData.inputMaxDuration("3");
        assertEquals("Max Duration", UserData.getFilterType());
        assertEquals("3", UserData.readPreference().get(0));
    }
}