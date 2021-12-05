package ApplicationBusinessRule;

import EnterpriseBusinessRules.NewCourse;
import FrameworksDrivers.WebParse;

import java.io.IOException;
import java.util.*;

public class SimpleScheduler {

    public ArrayList<NewCourse> coursesToSchedule;

    /**
     * Construct a scheduler for a given collection of courses.
     * @param courses the courses that we wish to schedule.
     */
    public SimpleScheduler(ArrayList<NewCourse> courses){
        coursesToSchedule = courses;
    }

    /**
     * Schedule the courses in SimpleScheduler to the initial timetable tb, and ignore the timetable solutions
     * specified in seen.
     * @param tb the initial timetable that we start with
     * @param seen the string representation of timetables that we wish to ignore, that is, these timetables are not
     *             included in the returned collection of timetables.
     * @return the collection of all possible course combinations based on the given courses, where each course
     * combination is represented by a timetable.
     */
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





}