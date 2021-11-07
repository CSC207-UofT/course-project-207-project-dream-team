import java.io.*;
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
    }

    public static ArrayList<Course> upload(String path) throws IOException{
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

    public static boolean inputExists(String path) throws IOException {//path = "src\\input.txt"
        File f = new File(path);//the path should be changed after packaging
        if (f.exists()){
            return true;
        }else{
            initInput(f);
            return false;
        }
    }

    public static String[] initHeader(){
        String[] header = new String[5];//{courseCode, backToBack, duration, instructor, timeslots}
        header[0]="Course Codes,\n";
        header[1]="Back-to-back,\n";
        header[2]=("Max Duration,\n");
        header[3]=("Instructors,\n");
        header[4]=("Timeslots,\n");
        return header;
    }

    public static void initInput(File f) throws IOException {
        f.createNewFile();
        FileWriter fwriter = new FileWriter(f.getAbsolutePath());
        BufferedWriter bwriter = new BufferedWriter(fwriter);
        String[] header = initHeader();
        for (String line:header){
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
        System.out.println(inputExists("src\\input.txt"));
    }
}
