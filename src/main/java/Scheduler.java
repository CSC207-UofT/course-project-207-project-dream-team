import java.util.ArrayList;
import java.util.Collections;

public abstract class Scheduler {

    public ArrayList<Course> courses;  // courses to arrange

    public Scheduler(ArrayList<Course> courses){
        this.courses = courses;
    }

    abstract ArrayList<Timetable> Arrange();

    public ArrayList<ArrayList<Course>> sortCourses(){
        ArrayList<ArrayList<Course>> sorted = new ArrayList<ArrayList<Course>>();
        for (int i=0; i<this.courses.size(); i++){
            for (int j=0; j<sorted.size(); j++){
                if (sorted.get(j).get(0).courseCode == this.courses.get(i).courseCode){
                    sorted.get(j).add(this.courses.get(i));
                } else {
                    ArrayList<Course> newCourse = new ArrayList<Course>();
                    newCourse.add(this.courses.get(i));
                    sorted.add(newCourse);
                }
            }
        }

        ArrayList<Course> temp;
        for (int m=0; m<sorted.size()-1; m++){
            boolean flag = false;
            for (int n=0; n<sorted.size()-1-m; n++){
                if (sorted.get(n).get(0).compareTo(sorted.get(n+1).get(0)) == 1) {
                    Collections.swap(sorted, n, n+1);
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        return sorted;
    }
}

