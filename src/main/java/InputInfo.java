import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class InputInfo {

    public static ArrayList<NewCourse> askCourses() throws IOException {
        //set up scanner
        Scanner scanner = new Scanner(System.in);

        //this will be the number of courses program asks for
        String numberOfCourses;
        System.out.println("How many course would you like to enter for the fall&winter term?");
        //its value is given here
        numberOfCourses = scanner.nextLine();
        int num = Integer.parseInt(numberOfCourses);

        //initialize an ArrayList to store the list of courses from user input
        ArrayList<NewCourse> result = new ArrayList<>();
        for (int i = 0; i < num; i ++){
            //for each course, call askSingleCourse to let that do the work
            System.out.println("What is the #" + Integer.toString(i + 1) + " course you want to enter?");
            String eachCourse = scanner.nextLine();
            result.add(WebParse.courseParse(eachCourse));
        }
        return result;
    }

}
