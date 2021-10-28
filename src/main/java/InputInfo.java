import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Scanner;


public class InputInfo {

    public static ArrayList<Course> askCourses(){
        Scanner sc1 = new Scanner(System.in);
        String numberOfCourses;
        System.out.println("How many courses would you like to enter?");
        numberOfCourses = sc1.nextLine();
        int num = Integer.parseInt(numberOfCourses);

        ArrayList<Course> result = new ArrayList<>();
        for (int i = 0; i < num; i ++){
            result.add(askSingleCourse(i + 1));
        }
        return result;
    }

    public static Course askSingleCourse(int order){
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
        return new Course(inputs[0], inputs[1], inputs[2],
                DayOfWeek.of(Integer.parseInt(inputs[3])), Integer.parseInt(inputs[4]), Integer.parseInt(inputs[5]));
    }

}
