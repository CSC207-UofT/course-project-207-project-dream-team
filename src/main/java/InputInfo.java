import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
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
        int inputErrorCount;
        String manual = "";
        for (int i = 0; i < num; i ++){
            //for each course, call askSingleCourse to let that do the work
            System.out.println("What is the #" + Integer.toString(i + 1) + " course you want to enter?");
            String eachCourse = scanner.nextLine();
            inputErrorCount = 0;
            while (WebParse.courseParse(eachCourse).courseCode.equals("")){
                inputErrorCount ++;
                System.out.println("Sorry, we are not able to process your input, could you check your spelling? \n" +
                        "Please include every component of your course code. ex. CSC207H1F \n");
                if (inputErrorCount > 1){
                    System.out.println("If the problem persists, this could be due to that we don't have your course " +
                            "in our system. \n If you would like to add a course manually, enter manual");
                }
                manual = scanner.nextLine();
                if (manual.toLowerCase(Locale.ROOT).equals("manual")){
                    result.add(askSingleCourse());
                }
            }
            result.add(WebParse.courseParse(eachCourse));
        }
        return result;
    }

    private static NewCourse askSingleCourse(){
        //Doing work for askCourses, return one course at a time

        //the list of session types, can change
        String[] ask = {"tut", "lec", "lab"};
        Scanner sc = new Scanner(System.in); //setup scanner for all user inputs

        //determine the course code
        System.out.println("What is the course code for this course?");
        String courseCode = sc.nextLine();

        //initialize an ArrayList to store the three types of session separately
        ArrayList<ArrayList<Session>> records = new ArrayList<>();

        for (String s : ask) {
            //for each type in ask, we call askSessions to let that do the work
            System.out.println("Please enter information about " + s + "'s of this course");
            records.add(askSessions(courseCode, s));
        }
        //assign each type to the NewCourse instance and return the one course
        return new NewCourse(courseCode, records.get(0), records.get(1), records.get(2));
    }

    private static ArrayList<Session> askSessions(String courseCode, String type){
        //Doing work for askSingleCourse, * no type differentiation other than user prompt *

        //setup scanner for all user inputs
        Scanner sc1 = new Scanner(System.in);
        //this will be the number of sessions program asks for
        String numberOfSessions;
        System.out.println("How many " + type + "'s for this course would you like to enter?");
        //the value is given here
        numberOfSessions = sc1.nextLine();
        int num = Integer.parseInt(numberOfSessions);

        //initialize an ArrayList to store each single session from user input
        ArrayList<Session> result = new ArrayList<>();
        for (int i = 0; i < num; i ++){
            //for each session, call askSingleSession to do the work
            result.add(askSingleSession(i + 1, courseCode, i + 1));
        }
        return result;
    }

    private static Session askSingleSession(int order, String courseCode, int sessionNum){
        //Doing work for askSessions, return one session at a time

        //the list of general info we don't have of each session, can change
        String[] ask = {"instructor", "session code"};
        //setup scanner for all user inputs
        Scanner sc = new Scanner(System.in);

        //initialize an Array to store the general info from user input
        String[] inputs = new String[ask.length];
        for (int i = 0; i < ask.length; i++)
        {
            System.out.println("What is the " + ask[i] + " of this session #" + String.valueOf(order) + "?");
            inputs[i] = sc.nextLine();
        }
        //each session could have several slots, call askTimeSlots to finish the job
        Integer[] timeSlots = askTimeSlots(sessionNum).toArray(new Integer[0]);

        //plugging in value for each attribute of a single Session and return
        return new Session(inputs[0], courseCode, inputs[1], timeSlots);
    }

    private static ArrayList<Integer> askTimeSlots(int sessionNum){
        //Doing job for askSingleSession, collects all time slots for a single session

        //setup scanner for all user inputs
        Scanner scanner = new Scanner(System.in);
        //this will be the number of time slots this session has
        String numberOfTimeSlots;
        System.out.println("How many time slots does this session have?");
        //the value is given here
        numberOfTimeSlots = scanner.nextLine();
        int num = Integer.parseInt(numberOfTimeSlots);

        //initialize an ArrayList to store all formatted time information for this session
        ArrayList<Integer> slotList = new ArrayList<>();
        for (int i = 0; i < num; i ++) {
            //collects one slot's day of week, start time, and end time from user
            System.out.println("What is the day of week for slot #" + String.valueOf(i)
                    + "Session #" + String.valueOf(sessionNum));
            String day = (scanner.nextLine());
            System.out.println("What is the start time for this slot on " +
                    String.valueOf(day) + " day?"); //polish later
            String start = (scanner.nextLine());
            System.out.println("What is the end time for this slot on " +
                    String.valueOf(day) + " day?");
            String end = (scanner.nextLine());

            //format and store one slot in slotList
            int timeFormatted = Integer.parseInt(day + start + end);
            slotList.add(timeFormatted);
        }
        return slotList;
    }


}
