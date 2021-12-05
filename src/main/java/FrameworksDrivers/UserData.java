package FrameworksDrivers;

import java.io.*;
import java.lang.reflect.AnnotatedArrayType;
import java.nio.file.Files;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Arrays;

public class UserData {

    static Integer flag = 0;
    final static String path = "src\\input.txt";//the path should be changed after packaging
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
                return lines[i].split(",")[0];
            }
        }
        return "No Filter";
    }

    public static void removeAll() throws IOException {
        String[] lines = readAllLines();
        FileWriter fwriter = new FileWriter(f.getAbsolutePath());
        BufferedWriter bwriter = new BufferedWriter(fwriter);
        for (String line : lines) {
            bwriter.write("");
        }
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
        lines[0] = lines[0].substring(1,lines[0].length());
        return lines;
    }


    //Inputers
    public static void inputCourse(String courseCode) throws IOException{
       String[] lines = readAllLines();
        if (lines[0].contains(courseCode)){
            return;
        }else {
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
            if (lines[1].contains(hour)) {
                return;
            } else {
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
        if (!lines[0].contains(courseCode)){
            return;
        }else {
            FileWriter fwriter = new FileWriter(f.getAbsolutePath());
            BufferedWriter bwriter = new BufferedWriter(fwriter);
            Integer ccLength = courseCode.length();
            lines[0] = lines[0].substring(0, lines[0].length()-ccLength-1);
            for (String line : lines) {
                bwriter.write(line);
            }
            bwriter.close();
        }
    }

    public static void removePreference(Integer type, String content) throws IOException{
        String[] lines = readAllLines();
        if (!lines[type].contains(content)){
            return;
        }else {
            FileWriter fwriter = new FileWriter(f.getAbsolutePath());
            BufferedWriter bwriter = new BufferedWriter(fwriter);
            Integer cLength = content.length();
            lines[type] = lines[type].substring(0, lines[type].length()-cLength-1);
            for (String line : lines) {
                bwriter.write(line);
            }
            bwriter.close();
        }
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


        inputTimeslot(times);
        inputInstructor(names);

        removeCourse("CSC104H1F");
        removeCourse("CSC108H1F");

        removePreference(1, "6");
        removePreference(3, "11019");

        System.out.println(readCourses());
        System.out.println(getFlag());
        System.out.println(getFilterType());

        removeAll();
        System.out.println(getFilterType());
    }
}
