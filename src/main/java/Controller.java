import java.util.ArrayList;

public class Controller {
    //variables
    ArrayList<Course> courseList;

    public static void main(String[] args) {
        /*Course c1 = new Course("CSC207","TUT101","PIAO", DayOfWeek.FRIDAY, 17, 18);
        Course c2 = new Course("CSC207","LEC101","PIAO", DayOfWeek.MONDAY, 9,10);
        ArrayList<Course> courses = new ArrayList<>();
        courses.add(c1);
        courses.add(c2);*/
        Controller controller = new Controller();
        ArrayList<Course> courses = controller.calls();
        SimpleScheduler ss = new SimpleScheduler(courses);
        Timetable tt = new Timetable();
        ArrayList<Timetable> tts = ss.arrange(tt);
        ArrayList<String[]> psb = tts.get(0).Presentable();
        Presenter ps = new Presenter();
        ps.Present(psb);

    }
}