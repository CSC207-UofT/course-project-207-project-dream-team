import org.junit.Before;
import org.junit.Test;
import java.time.DayOfWeek;
import static org.junit.Assert.*;

public class TimetableTest {

    Timetable newTimetable;

    @Before
    public void setUp() {
        newTimetable = new Timetable();
    }

    @Test(timeout = 50)
    public void testTimetable() {
        Course course1 = new Course("CSC207", "LEC", "Piao",
                DayOfWeek.FRIDAY, 12, 17);
        Course course2 = new Course("CSC263", "LEC", "Er",
                DayOfWeek.THURSDAY, 15, 17);
        // Timetable newTimetable = new Timetable();
        newTimetable.addCourse(course1);
        newTimetable.addCourse(course2);
        assertFalse(newTimetable.canAdd(course1));
    }

}

//    DrivableMap dm;
//    @Before
//    public void setUp() {
//        dm = new DrivableMap();
//    }
//
//    @Test(timeout = 50)
//    public void testAddDrivable() {
//        Horse h = new Horse();
//        assertTrue(dm.addDrivable("Name", h));
//        assertFalse(dm.addDrivable("Name", h));
//        assertTrue(dm.addDrivable("Name2", h));
//    }
