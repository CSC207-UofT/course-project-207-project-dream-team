import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    //variables
    ArrayList<Course> courseList;


    //We don't need a constructor right?

    //methods

    //run
    public Course call(int order){
        //for each course instance
        String[] ask = {"course code", "type", "instructor", "day of week",
                "start time", "end time"};
        Scanner sc = new Scanner(System.in);
        String[] inputs = new String[6];
        for (int i = 0; i < inputs.length; i++)
        {
            System.out.println("What is the " + ask[i] + " of this course #"+String.valueOf(order)+"?");
            inputs[i] = sc.nextLine();
        }
        Course course = new Course(inputs[0], inputs[1], inputs[2],
                DayOfWeek.of(Integer.parseInt(inputs[3])), Integer.parseInt(inputs[4]), Integer.parseInt(inputs[5]));
        return course;
    }
    public ArrayList<Course> calls(){
        Scanner sc1 = new Scanner(System.in);
        String input = new String();
        System.out.println("How many courses would you like to enter?");
        input = sc1.nextLine();
        int num = Integer.parseInt(input);

        ArrayList<Course> result = new ArrayList<Course>();
        for (int i=0; i<num; i++){
            result.add(call(i+1));
        }
        return result;
    }

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