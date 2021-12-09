package FrameworksDrivers;

import EnterpriseBusinessRules.NewCourse;
import EnterpriseBusinessRules.Session;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class WebParse {
    public static String suffix = "";

    /**
     * gets all contents start with a tag "span"
     *
     * @param courseCode a nine-digit course code to be searched
     * @return a list of elements, each represents a content with tag "span
     * @throws IOException if gets wrong input
     */
    public static Elements fullCourseToTags(String courseCode) throws IOException {
        String url_fy = "https://coursefinder.utoronto.ca/course-search/search/" +
                "courseInquiry?methodToCall=start&viewId=CourseDetails-" +
                "InquiryView&courseId=" + courseCode + "20219";
        String url_s = "https://coursefinder.utoronto.ca/course-search/search/" +
                "courseInquiry?methodToCall=start&viewId=CourseDetails-" +
                "InquiryView&courseId=" + courseCode + "20221";
        Document html;
        if (courseCode.endsWith("F") || courseCode.endsWith("Y")) {
            html = Jsoup.connect(url_fy).get();
        } else {
            html = Jsoup.connect(url_s).get();
        }
        return html.select("span");
    }

    /**
     * gets all contents start with a tag "span"
     *
     * @param courseCode a six-digit course code to be searched
     * @return a list of elements, each represents a content with tag "span
     * @throws IOException if gets wrong input
     */
    public static Elements halfCourseToTags(String courseCode) throws IOException {
        String courseCodeF = courseCode + "H1F";
        String courseCodeY = courseCode + "Y1Y";
        String courseCodeS = courseCode + "H1S";
        String[] courseCodes = {courseCodeF, courseCodeY, courseCodeS};
        Elements spans = null;
        for (String cc : courseCodes) {
            spans = fullCourseToTags(cc);
            if (spans.size() > 3) {
                suffix = cc.substring(6);
                return spans;
            }
        }
        return spans;
    }

    /**
     * get raw info from course code
     *
     * @param courseCode course code to be searched
     * @return a list of elements, each represents a content with tag "span"
     * @throws IOException if either courseToTags method runs abnormally
     */
    public static Elements courseToTags(String courseCode) throws IOException {
        if (courseCode.length() == 6) {
            return halfCourseToTags(courseCode);
        } else {
            return fullCourseToTags(courseCode);
        }
    }

    /**
     * test whether spanID matches a specific format
     *
     * @param spanID the spanID of an element
     * @return true or false
     */
    public static Boolean tagMatch(String spanID) {
        String regex = "u[0-9]*_line[0-9]*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(spanID);
        return matcher.matches();
    }

    /**
     * turn raw info into a list
     *
     * @param spans a list of elements
     * @return an arraylist of strings, each represents a piece of information
     */
    public static ArrayList<String> tagsToList(Elements spans) {
        ArrayList<String> infos = new ArrayList<>();
        for (Element span : spans) {
            if (tagMatch(span.id())) {
                infos.add(span.text());
            }
        }
        return infos;
    }

    /**
     * break a long arraylist into an arraylist of several lists
     *
     * @param infos arraylist of strings, each represents a piece of info
     * @return an arraylist of lists, each lists represents info of one single session
     */
    public static ArrayList<String[]> breakList(ArrayList<String> infos) {
        ArrayList<String[]> infoSessions = new ArrayList<>();
        for (int i = 0; i < infos.size(); i = i + 7) {
            String[] sublist = new String[7];
            for (int j = 0; j < 7; j++) {
                sublist[j] = infos.get(i + j);
            }
            infoSessions.add(sublist);
        }
        return infoSessions;
    }

    /**
     * remove all async courses from list infosession
     *
     * @param infoSessions an arraylist of lists, each represents info of one single session
     * @return a cleaned arraylsit of lists
     */
    public static ArrayList<String[]> removeAsync(ArrayList<String[]> infoSessions) {
        ArrayList<String[]> removeAsync = new ArrayList<>();
        for (String[] infoSession : infoSessions) {
            if (!infoSession[6].equals("ASYNC")) {
                removeAsync.add(infoSession);
            }
        }
        return removeAsync;
    }

    /**
     * divide list into three lists, each containing ino of lecs, tuts, and labs
     *
     * @param infoSessions arraylist of lists, cleaned infosession
     * @return a list of arraylist of lists, each arraylist is infosession of a single type
     */
    public static ArrayList<ArrayList<String[]>> divideList(ArrayList<String[]> infoSessions) {
        ArrayList<String[]> lecs = new ArrayList<>();
        ArrayList<String[]> tuts = new ArrayList<>();
        ArrayList<String[]> pras = new ArrayList<>();
        for (String[] infoSession : infoSessions) {
            if (infoSession[0].startsWith("Lec")) {
                lecs.add(infoSession);
            } else if (infoSession[0].startsWith("Tut")) {
                tuts.add(infoSession);
            } else {
                pras.add(infoSession);
            }
        }
        ArrayList<ArrayList<String[]>> divided = new ArrayList<>();
        divided.add(lecs);
        divided.add(tuts);
        divided.add(pras);
        return divided;
    }

    /**
     * remove tut sessions sharing same timeslots
     *
     * @param tuts arraylist of lists, each list represents info of one tut session
     * @return a new arraylist of lists with duplication removed
     */
    public static ArrayList<String[]> removeDuplicate(ArrayList<String[]> tuts) {
        ArrayList<String> time = new ArrayList<>();
        ArrayList<String[]> cleaned = new ArrayList<>();
        for (String[] tut : tuts) {
            if (!time.contains(tut[1])) {
                time.add(tut[1]);
                cleaned.add(tut);
            } else {
                for (String[] cleaned_tut : cleaned) {
                    if (cleaned_tut[1].equals(tut[1])) {
                        cleaned_tut[0] = cleaned_tut[0] + "/" + tut[0].substring(4, 8);
                        cleaned_tut[2] = "";
                        cleaned_tut[3] = "";
                        cleaned_tut[4] = "";
                        cleaned_tut[5] = "";
                        cleaned_tut[6] = "";
                    }
                }
            }
        }
        return cleaned;
    }

    /**
     * remove duplicates from all three types of infosessions
     *
     * @param divided a divided infosession, containing three separate infosessions
     * @return a cleaned list of arraylists of lists
     */
    public static ArrayList<ArrayList<String[]>> cleanList(ArrayList<ArrayList<String[]>> divided) {
        ArrayList<ArrayList<String[]>> result = new ArrayList<>();
        result.add(divided.get(0));
        result.add(removeDuplicate(divided.get(1)));
        result.add(removeDuplicate(divided.get(2)));
        return result;
    }

    /**
     * turn a string time into an integer digit format
     *
     * @param time a time in format of string
     * @return a time in format of integer
     */
    public static Integer[] toTimeslots(String time) {
        String[] list = time.split(" ");
        ArrayList<Integer> timeslots = new ArrayList<>();
        for (int i = 0; i < list.length; i = i + 2) {
            int day = DayOfWeek.valueOf(list[i]).getValue();
            int start = Integer.parseInt(list[i + 1].substring(0, 2));
            int end = Integer.parseInt(list[i + 1].substring(6, 8));
            for (int j = 0; j < end - start; j++) {
                timeslots.add(day * 10000 + (start + j) * 100 + (start + 1 + j));
            }
        }
        return timeslots.toArray(new Integer[0]);
    }

    /**
     * turn a single list into session type
     *
     * @param infoSession a list of strings, each represents an attribute of session
     * @param courseCode  the course code of the session
     * @return a session type
     */
    public static Session listToSession(String[] infoSession, String courseCode) {
        String instructor = infoSession[2];
        int end = infoSession[0].length();
        String sessionCode = (infoSession[0].substring(0, 3) +
                infoSession[0].substring(4, end)).toUpperCase();
        Integer[] timeslots = toTimeslots(infoSession[1]);
        return new Session(instructor, courseCode, sessionCode, timeslots);
    }

    /**
     * turn a cleaned list of information into a list of sessions
     *
     * @param cleaned    cleaned list of information
     * @param courseCode the course code of sessions
     * @return an arryalist of sessions
     */
    public static ArrayList<ArrayList<Session>> cleanSessions(ArrayList<ArrayList<String[]>> cleaned, String courseCode) {
        ArrayList<ArrayList<Session>> sessions = new ArrayList<>();
        ArrayList<Session> s1 = new ArrayList<>();
        ArrayList<Session> s2 = new ArrayList<>();
        ArrayList<Session> s3 = new ArrayList<>();
        sessions.add(s1);
        sessions.add(s2);
        sessions.add(s3);
        for (int i = 0; i < 3; i++) {
            for (String[] list : cleaned.get(i)) {
                sessions.get(i).add(listToSession(list, courseCode));
            }
        }
        return sessions;
    }

    /**
     * turn several sessions into a course
     *
     * @param sessions   a list of sessions
     * @param courseCode course code of the course
     * @return a NewCourse type
     */
    public static NewCourse sessionsToCourse(ArrayList<ArrayList<Session>> sessions, String courseCode) {
        String newCourseCode = courseCode;
        if (courseCode.length() == 6) {
            newCourseCode = newCourseCode + suffix;
        }
        return new NewCourse(newCourseCode, sessions.get(1), sessions.get(0), sessions.get(2));
    }

    /**
     * get a NewCourse from a single course code
     *
     * @param courseCode the course code to search with
     * @return a NewCourse type
     * @throws IOException if any helper method throws an IOException
     */
    public static NewCourse courseParse(String courseCode) throws IOException {
        Elements spans = courseToTags(courseCode);
        ArrayList<String> infos = tagsToList(spans);
        NewCourse course;
        if ((infos.size() == 0)) {
            ArrayList<Session> a = new ArrayList<>();
            course = new NewCourse("", a, a, a);
        } else {
            ArrayList<String[]> infoSessions = breakList(infos);
            ArrayList<String[]> removeAsync = removeAsync(infoSessions);
            ArrayList<ArrayList<String[]>> divided = divideList(removeAsync);
            ArrayList<ArrayList<String[]>> cleaned = cleanList(divided);
            ArrayList<ArrayList<Session>> sessions = cleanSessions(cleaned, courseCode);
            course = sessionsToCourse(sessions, courseCode);
        }
        return course;
    }

    /**
     * print information of a NewCourse with a specific pattern
     *
     * @param course the NewCourse type
     */
    public static void print(NewCourse course) {
        System.out.println(course.getCourseCode());
        for (Session session : course.getLectures()) {
            System.out.println(session.sessionCode);
        }
        System.out.println("------------");
        for (Session session : course.getTutorials()) {
            System.out.println(session.sessionCode);
        }
        System.out.println("------------");
        for (Session session : course.getLabs()) {
            System.out.println(session.sessionCode);
        }
        System.out.println("=================");
    }


}