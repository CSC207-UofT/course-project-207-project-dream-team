package timetable;

import java.io.IOException;
import java.sql.Time;
import java.util.*;

class SimpleScheduler {

    public ArrayList<NewCourse> coursesToSchedule;

    public SimpleScheduler(ArrayList<NewCourse> courses){
        coursesToSchedule = courses;
    }

    public ArrayList<Timetable> arrange(Timetable tb, Set<String> seen) {

        ArrayList<Timetable> solutions = new ArrayList<>();
        // Base Cases
        // If we see a state that we have seen before, then we know either it has no solution or the solution is
        // already added to the answer, so return no solution.
        if (seen.contains(tb.toString())){
            return new ArrayList<>();
        }

//        // If we see a state that has no possible extensions and is not solved, return no solution.
//        if (tb.failFast(this.coursesToSchedule)){
//            return new ArrayList<>();
//        }

        if (tb.isSolved(this.coursesToSchedule)){
            solutions.add(tb);
            seen.add(tb.toString());
        }

        // At this point, the timetable is not in seen, is not solved, AND has a solution.

        // Add this timetable to seen, so in the future if we come back to the same state, we don't have to care
        // about it.
        seen.add(tb.toString());

        // Recursion

        for (Timetable extension : tb.extensions(this.coursesToSchedule)){
            solutions.addAll(this.arrange(extension, seen));
        }
        return solutions;

    }


    public static void main(String[] args) throws IOException {
        ArrayList<NewCourse> courses = new ArrayList<>();

//        Session csc207a = new Session("Paul Gries", "CSC207H1F", "LEC0101", new Integer[]{21314, 41314});
//        Session csc207b = new Session("Paul Gries", "CSC207H1F", "LEC0201", new Integer[]{21415, 41415});
//        Session csc207c = new Session("TBA", "CSC207H1F", "TUT0301", new Integer[]{11416});
//
//        ArrayList<Session> csc207tut = new ArrayList<>();
//        csc207tut.add(csc207c);
//
//        ArrayList<Session> csc207lec = new ArrayList<>();
//        csc207lec.add(csc207a);
//        csc207lec.add(csc207b);
//
//        courses.add(new NewCourse("CSC207H1F", csc207tut, csc207lec, new ArrayList<>()));
//
//
//        Session mat224a = new Session("Soheil", "MAT224H1F", "LEC0101", new Integer[]{11011, 31011, 41011});
//        Session mat224c = new Session("TBA", "MAT224H1F", "TUT0102", new Integer[]{11112});
//
//        ArrayList<Session> mat224tut = new ArrayList<>();
//        mat224tut.add(mat224c);
//
//        ArrayList<Session> mat224lec = new ArrayList<>();
//        mat224lec.add(mat224a);
//
//        courses.add(new NewCourse("MAT224H1F", mat224tut, mat224lec, new ArrayList<>()));

//        courses.add(WebParse.courseParse("CSC108H1F"));
        courses.add(WebParse.courseParse("CSC258H1F"));
        courses.add(WebParse.courseParse("CSC336H1F"));
        courses.add(WebParse.courseParse("CSC236H1F"));
        courses.add(WebParse.courseParse("STA257H1F"));





        SimpleScheduler ss = new SimpleScheduler(courses);
        Timetable tb = new Timetable(new TreeMap<>(), new ArrayList<>());
        Set<String> seen = new HashSet<>();
        ArrayList<Timetable> solutions = ss.arrange(tb, seen);
        for (Timetable t : solutions){
            System.out.println(t.toString());
        }
    }





}