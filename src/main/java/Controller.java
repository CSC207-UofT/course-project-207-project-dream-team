import java.util.ArrayList;

public class Controller {

    public static void main(String[] args) {

        // Step 1: Ask for user's information about courses
        ArrayList<Course> inputs = InputInfo.askCourses();

        // Step 2: Schedule the courses entered
        // return an ArrayList of timeTables with arranged courses
        SimpleScheduler newSchedule = new SimpleScheduler(inputs);
        Timetable newTable = new Timetable();
        ArrayList<Timetable> timeTables = newSchedule.arrange(newTable);

        // Step 3: Present the timeTables
        for (Timetable singleTable : timeTables) {

            // Step 3-1: Make Timetable readable for presenter
            ArrayList<String[]> toPrint = Presenter.Presentable(singleTable);

            // Present to user
            Presenter newPresenter = new Presenter();
            newPresenter.Present(toPrint);


        }
    }
}
