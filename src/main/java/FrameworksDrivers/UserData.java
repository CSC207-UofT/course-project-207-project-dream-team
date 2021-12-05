package FrameworksDrivers;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class UserData {

    static Integer flag = 0;
    final static String path = "input.txt";//the path should be changed after packaging
    final static File f = new File(path);

    public static Integer getFlag(){
        return flag;
    }

    public static boolean inputExists() throws IOException {
        if (f.exists()){
            flag = 1;
            return true;
        }else{
            initInput();
            return false;
        }
    }

    public static String[] initHeader(){
        String[] header = new String[4];//{courseCode, duration, instructor, timeslots}
        header[0]="Course Codes,";
        header[1]=("\nMax Duration,");
        header[2]=("\nInstructors,");
        header[3]=("\nTimeslots,");
        return header;
    }

    public static void initInput() throws IOException {
        f.createNewFile();
        FileWriter fwriter = new FileWriter(f.getAbsolutePath());
        BufferedWriter bwriter = new BufferedWriter(fwriter);
        String[] header = initHeader();
        for (String line:header){
            bwriter.write(line);
        }
        bwriter.close();
    }

    public static String getFilterType() throws IOException{
        String[] lines = readAllLines();
        for (int i=1; i<lines.length; i++){
            int counter = 0;
            for (int j = 0; j < lines[i].length(); j++){
                if (lines[i].charAt(j) == ','){
                    counter += 1;
                }
            }
            if (counter > 1){
                String result = lines[i].split(",")[0];
                result = result.substring(1);
                return result;
            }
        }
        return "No Filter";
    }

    public static void removeAll() throws IOException {
        FileWriter fwriter = new FileWriter(f.getAbsolutePath());
        BufferedWriter bwriter = new BufferedWriter(fwriter);
        bwriter.write("");
        bwriter.close();

        initInput();
    }

    public static String[] readAllLines() throws IOException{
        FileReader freader = new FileReader(f.getAbsolutePath());
        BufferedReader breader = new BufferedReader(freader);
        String[] lines = new String[4];
        int i = 0;
        for(String line = breader.readLine(); line != null; line = breader.readLine()){
            lines[i] = "\n" + line;
            i++;
        }
        lines[0] = lines[0].substring(1);
        return lines;
    }


    //Inputers
    public static void inputCourse(String courseCode) throws IOException{
       String[] lines = readAllLines();
        if (!lines[0].contains(courseCode)){
            FileWriter fwriter = new FileWriter(f.getAbsolutePath());
            BufferedWriter bwriter = new BufferedWriter(fwriter);
            lines[0] = lines[0] + courseCode + ",";
            for (String line : lines) {
                bwriter.write(line);
            }
            bwriter.close();
        }
    }

    public static void inputInstructor(ArrayList<String> names) throws IOException{
        String[] lines = readAllLines();
        for (String name:names) {
            if (lines[2].contains(name)) {
                return;
            } else {
                FileWriter fwriter = new FileWriter(f.getAbsolutePath());
                BufferedWriter bwriter = new BufferedWriter(fwriter);
                lines[2] = lines[2] + name + ",";
                for (String line : lines) {
                    bwriter.write(line);
                }
                bwriter.close();
            }
        }
    }

    public static void inputMaxDuration(String hour) throws IOException{
        String[] lines = readAllLines();
            if (!lines[1].contains(hour)) {
                FileWriter fwriter = new FileWriter(f.getAbsolutePath());
                BufferedWriter bwriter = new BufferedWriter(fwriter);
                lines[1] = lines[1] + hour + ",";
                for (String line : lines) {
                    bwriter.write(line);
                }
                bwriter.close();
            }
    }

    public static void inputTimeslot(ArrayList<String> times) throws IOException{
        String[] lines = readAllLines();
        for (String time:times) {
            if (lines[3].contains(time)) {
                return;
            } else {
                FileWriter fwriter = new FileWriter(f.getAbsolutePath());
                BufferedWriter bwriter = new BufferedWriter(fwriter);
                lines[3] = lines[3] + time + ",";
                for (String line : lines) {
                    bwriter.write(line);
                }
                bwriter.close();
            }
        }
    }

    //Removers
    public static void removeCourse(String courseCode) throws IOException{
        String[] lines = readAllLines();
        if (lines[0].contains(courseCode)){
            FileWriter fwriter = new FileWriter(f.getAbsolutePath());
            BufferedWriter bwriter = new BufferedWriter(fwriter);
            int ccLength = courseCode.length();
            lines[0] = lines[0].substring(0, lines[0].length()-ccLength-1);
            for (String line : lines) {
                bwriter.write(line);
            }
            bwriter.close();
        }
    }

    public static void clearCourses() throws IOException{
        String[] lines = readAllLines();
        lines[0] = lines[0].substring(0, 13);
        FileWriter fwriter = new FileWriter(f.getAbsolutePath());
        BufferedWriter bwriter = new BufferedWriter(fwriter);
        for (String line : lines) {
            bwriter.write(line);
        }
        bwriter.close();
        }

    public static ArrayList<String> readPreference() throws IOException {
        String filterType = getFilterType();
        String[] lines = readAllLines();
        ArrayList<String> result = new ArrayList<>();
        switch (filterType) {
            case "Max Duration":
                result = new ArrayList<>(Arrays.asList(lines[1].split(",")));
                result.remove("\nMax Duration");
                break;
            case "Instructors":
                result = new ArrayList<>(Arrays.asList(lines[2].split(",")));
                result.remove("\nInstructors");
                break;
            case "Timeslots":
                result = new ArrayList<>(Arrays.asList(lines[3].split(",")));
                result.remove("\nTimeslots");
                break;
        }
        return result;
    }

    //Readers
    public static ArrayList<String> readCourses() throws IOException{
        FileReader freader = new FileReader(f.getAbsolutePath());
        BufferedReader breader = new BufferedReader(freader);
        String firstLine = breader.readLine();
        ArrayList<String> courseCodes = new ArrayList<>(Arrays.asList(firstLine.split(",")));
        courseCodes.remove("Course Codes");
        return courseCodes;
    }

    public static void main(String[] args) throws IOException {
        /*String path = "C:\\Users\\user\\Desktop\\output.txt";
        Course c1 = new Course("csc207", "tut", "piao", DayOfWeek.MONDAY, 14, 16);
        Course c2 = new Course("csc207", "lec", "piao", DayOfWeek.FRIDAY, 10, 11);
        ArrayList<Course> courses = new ArrayList<Course>();
        courses.add(c1);
        courses.add(c2);
        UserData.download(courses, path);
        ArrayList<Course> cs = UserData.upload(path);
        System.out.println(cs.get(0).courseCode);*/

        inputExists();
        System.out.println(getFlag());
        inputCourse("CSC108H1F");
        inputCourse("CSC207H1F");
        inputCourse("CSC258H1F");

        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> times = new ArrayList<>();

        names.add("Piao");
        names.add("Ethan");
        names.add("Xuanyi");

        times.add("11019");
        times.add("51719");

        String duration = "2";

        inputTimeslot(times);
        inputInstructor(names);
        inputMaxDuration(duration);

        removeCourse("CSC104H1F");
        removeCourse("CSC108H1F");


        System.out.println(readCourses());
        System.out.println(getFlag());
        System.out.println(getFilterType());
        System.out.println(getFilterType().equals("Instructors"));
        System.out.println(readPreference());

        clearCourses();
        System.out.println(getFilterType());
        System.out.println(readPreference());


        removeAll();
        System.out.println(getFilterType());
        System.out.println(readPreference());
    }
}
