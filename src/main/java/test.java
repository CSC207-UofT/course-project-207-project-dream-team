import java.time.DayOfWeek;
import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        Course c1 = new Course("CSC207","TUT101","PIAO", DayOfWeek.FRIDAY, 1, 2);
        Course c2 = new Course("CSC207","LEC101","PIAO", DayOfWeek.MONDAY, 1,2);
        ArrayList<Course> courses = new ArrayList<>();
        courses.add(c1);
        courses.add(c2);
        SimpleScheduler ss = new SimpleScheduler(courses);
        ArrayList<Timetable> tt = ss.Arrange();
        ArrayList<String[]> presentable = tt.get(0).Presentable();
        Presenter st = new Presenter();
        st.Present(presentable);
    }
}
