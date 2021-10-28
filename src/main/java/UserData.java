import java.io.*;
import java.time.DayOfWeek;
import java.util.ArrayList;

public class UserData {
    public static void download(ArrayList<Course> courses, String path) {
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

    public static ArrayList<Course> upload(String path) {
        try {
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
        } catch (Exception ex) {
            return null;
        }
    }


    public static void main(String[] args) {
        String path = "C:\\Users\\user\\Desktop\\output.csv";
        Course c1 = new Course("csc207", "tut", "piao", DayOfWeek.MONDAY, 14, 16);
        Course c2 = new Course("csc207", "lec", "piao", DayOfWeek.FRIDAY, 10, 11);
        ArrayList<Course> courses = new ArrayList<Course>();
        courses.add(c1);
        courses.add(c2);
        UserData.download(courses, path);
        ArrayList<Course> cs = UserData.upload(path);
        System.out.println(cs.get(1).courseCode);
    }
}

