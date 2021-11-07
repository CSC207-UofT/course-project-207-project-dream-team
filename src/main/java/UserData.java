import java.io.*;
import java.lang.reflect.AnnotatedArrayType;
import java.nio.file.Files;
import java.time.DayOfWeek;
import java.util.ArrayList;

public class UserData {
    /*public static void download(ArrayList<Course> courses, String path) {
        try {
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter(path));
            for (Course course : courses) {
                String line =
                        course.courseCode + "," + course.type + "," +
                                course.instructor + "," + course.day.toString() + "," +
                                course.startTime + "," +
                                course.endTime + "\n";
                bw.write(line);
            }
            bw.close();
        } catch (Exception ex) {
            return;
        }
    }*/

    /*public static ArrayList<Course> upload(String path) throws IOException{
        BufferedReader br = new BufferedReader(
                new FileReader(path));
        ArrayList<Course> courses = new ArrayList<Course>();
        while (br.readLine() != null){
            String[] attributes = br.readLine().split(",");
            Course course = new Course(
                    attributes[0], attributes[1], attributes[2],
                    DayOfWeek.valueOf(attributes[3]),
                    Integer.parseInt(attributes[4]), Integer.parseInt(attributes[5]));
            courses.add(course);
        }
        br.close();
        return courses;
    }*/


    final static String path = "src\\input.txt";//the path should be changed after packaging
    final static File f = new File(path);

    public static boolean inputExists() throws IOException {
        if (f.exists()){
            return true;
        }else{
            initInput();
            return false;
        }
    }

    public static String[] initHeader(){
        String[] header = new String[5];//{courseCode, backToBack, duration, instructor, timeslots}
        header[0]="Course Codes,";
        header[1]="\nBack-to-back,";
        header[2]=("\nMax Duration,");
        header[3]=("\nInstructors,");
        header[4]=("\nTimeslots,");
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

    public static String[] readAllLines() throws IOException{
        FileReader freader = new FileReader(f.getAbsolutePath());
        BufferedReader breader = new BufferedReader(freader);
        String[] lines = new String[5];
        int i = 0;
        for(String line = breader.readLine(); line != null; line = breader.readLine()){
            lines[i] = "\n" + line;
            i++;
        }
        lines[0] = lines[0].substring(1,lines[0].length());
        return lines;
    }

    public static void inputCourse(String courseCode) throws IOException{
        String[] lines = readAllLines();
        FileWriter fwriter = new FileWriter(f.getAbsolutePath());
        BufferedWriter bwriter = new BufferedWriter(fwriter);
        lines[0] = lines[0] + courseCode + ",";
        for (String line:lines){
            bwriter.write(line);
        }
        bwriter.close();
    }

    public static Integer typeToNum(String type){
        if (type == "backtoback"){
            return 1;
        }else if (type == "duration"){
            return 2;
        }else if (type == "instructor"){
            return 3;
        }else{
            return 4;
        }
    }

    public static void inputPreference(Integer type, String content) throws IOException{
        String[] lines = readAllLines();
        FileWriter fwriter = new FileWriter(f.getAbsolutePath());
        BufferedWriter bwriter = new BufferedWriter(fwriter);
        lines[type] = lines[type] + content + ",";
        for (String line:lines){
            bwriter.write(line);
        }
        bwriter.close();
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
        inputCourse("CSC108H1F");
        inputPreference(4, "11012");
    }
}
