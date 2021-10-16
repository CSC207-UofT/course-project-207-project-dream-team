import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    //variables
    ArrayList<Course> courseList;

    private Course loadCourse() {
        String[] ask = {"course code", "type", "instructor", "day of week",
                "start time", "end time"};
        Scanner sc = new Scanner(System.in);
        String[] inputs = new String[6];
        for (int i = 0; i < inputs.length; i++)
        {
            System.out.println("What is the " + ask[i] + " of this course?");
            System.out.println("Please choose from LEC, TUT and LAB.");
            inputs[i] = sc.nextLine();
        }
        Course course = new Course(inputs[0], inputs[1], inputs[2],
                DayOfWeek.of(Integer.parseInt(inputs[3])), Integer.parseInt(inputs[4]), Integer.parseInt(inputs[5]));
        this.courseList.add(course);
        return course;
    }

    private void schedule() {
        // In demo, we only choose a simple scheduler to schedule
        // a small set of courses.


    }



    //We don't need a constructor right?

    //methods

    //run
    public static void main(String[] args) {
        //for each course instance


    }
}
