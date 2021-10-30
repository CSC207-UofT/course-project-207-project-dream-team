import java.util.ArrayList;
import java.util.Scanner;

public class InputInfo {

    public static ArrayList<Session> askSessions(String courseCode){
        Scanner sc1 = new Scanner(System.in);
        String numberOfCourses;
        System.out.println("How many sessions for this course would you like to enter?");
        numberOfCourses = sc1.nextLine();
        int num = Integer.parseInt(numberOfCourses);

        ArrayList<Session> result = new ArrayList<>();
        for (int i = 0; i < num; i ++){
            result.add(askSingleSession(i + 1, courseCode, i + 1));
        }
        return result;
    }

    private static Session askSingleSession(int order, String courseCode, int sessionNum){
        //for each course instance
        String[] ask = {"instructor", "session code"};
        Scanner sc = new Scanner(System.in);
        String[] inputs = new String[3];
        for (int i = 0; i < ask.length; i++)
        {
            System.out.println("What is the " + ask[i] + " of this session #" + String.valueOf(order) + "?");
            inputs[i] = sc.nextLine();
        }
        Integer[] timeSlots = askTimeSlots(sessionNum).toArray(new Integer[0]);
        return new Session(inputs[0], courseCode, inputs[1], timeSlots);
    }

    private static ArrayList<Integer> askTimeSlots(int sessionNum){
        Scanner scanner = new Scanner(System.in);
        String numberOfTimeSlots;
        System.out.println("How many time slots does this session have?");
        numberOfTimeSlots = scanner.nextLine();
        int num = Integer.parseInt(numberOfTimeSlots);

        ArrayList<Integer> slotList = new ArrayList<>();
        for (int i = 0; i < num; i ++) {
            System.out.println("What is the day of week for slot #" + String.valueOf(i)
                    + "Session #" + String.valueOf(sessionNum));
            String day = (scanner.nextLine());
            System.out.println("What is the start time for this slot on " +
                    String.valueOf(day) + " day?"); //polish later
            String start = (scanner.nextLine());
            System.out.println("What is the end time for this slot on " +
                    String.valueOf(day) + " day?");
            String end = (scanner.nextLine());

            int timeFormatted = Integer.parseInt(day + start + end);
            slotList.add(timeFormatted);
        }
        return slotList;
    }

}
