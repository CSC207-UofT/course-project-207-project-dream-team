package FrameworksDrivers;

import ApplicationBusinessRule.filter.Filter;
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

    public static Elements halfCourseToTags(String courseCode) throws IOException {
        String url_f = "https://coursefinder.utoronto.ca/course-search/search/" +
                "courseInquiry?methodToCall=start&viewId=CourseDetails-" +
                "InquiryView&courseId=" + courseCode + "H1F20219";
        String url_y = "https://coursefinder.utoronto.ca/course-search/search/" +
                "courseInquiry?methodToCall=start&viewId=CourseDetails-" +
                "InquiryView&courseId=" + courseCode + "Y1Y20219";
        String url_s = "https://coursefinder.utoronto.ca/course-search/search/" +
                "courseInquiry?methodToCall=start&viewId=CourseDetails-" +
                "InquiryView&courseId=" + courseCode + "H1S20221";
        String[] urls = {url_f, url_y, url_s};
        Document html = null;
        for (String url:urls){
            html = Jsoup.connect(url).get();
            Elements spans = html.select("span");
            if (html.select("span").size() > 3) {
                return spans;
            }
        }
        return html.select("span");
    }

    public static Elements courseToTags(String courseCode) throws IOException {
        if (courseCode.length() == 6){
            return halfCourseToTags(courseCode);
        } else {
            return fullCourseToTags(courseCode);
        }
    }

    public static Boolean tagMatch(String spanID) {
        String regex = "u[0-9]*_line[0-9]*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(spanID);
        return matcher.matches();
    }

    public static ArrayList<String> tagsToList(Elements spans) {
        ArrayList<String> infos = new ArrayList<>();
        for (Element span : spans) {
            if (tagMatch(span.id())) {
                infos.add(span.text());
            }
        }
        return infos;
    }

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

    public static ArrayList<String[]> removeAsync(ArrayList<String[]> infoSessions) {
        ArrayList<String[]> removeAsync = new ArrayList<>();
        for (String[] infoSession : infoSessions) {
            if (!infoSession[6].equals("ASYNC")) {
                removeAsync.add(infoSession);
            }
        }
        return infoSessions;
    }

    public static ArrayList<String[]>[] divideList(ArrayList<String[]> infoSessions) {
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
        ArrayList<String[]>[] divided = (ArrayList<String[]>[]) new ArrayList[3];
        divided[0] = lecs;
        divided[1] = tuts;
        divided[2] = pras;
        return divided;
    }

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

    public static ArrayList<String[]>[] cleanList(ArrayList<String[]>[] divided) {
        divided[1] = removeDuplicate(divided[1]);
        divided[2] = removeDuplicate(divided[2]);
        return divided;
    }

    public static Integer[] toTimeslots(String time) {
        String[] list = time.split(" ");
        ArrayList<Integer> timeslots = new ArrayList<>();
        for (int i = 0; i < list.length; i = i + 2) {
            int day = DayOfWeek.valueOf(list[i]).getValue();
            int start = Integer.parseInt(list[i + 1].substring(0, 2));
            int end = Integer.parseInt(list[i + 1].substring(6, 8));
            for (int j=0; j<end-start; j++){
                timeslots.add(day * 10000 + (start+j)*100 + (start+1+j));
            }
        }
        return timeslots.toArray(new Integer[0]);
    }


    public static Session listToSession(String[] infoSession, String courseCode) {
        String instructor = infoSession[2];
        int end = infoSession[0].length();
        String sessionCode = (infoSession[0].substring(0, 3) +
                infoSession[0].substring(4, end)).toUpperCase();
        Integer[] timeslots = toTimeslots(infoSession[1]);
        return new Session(instructor, courseCode, sessionCode, timeslots);
    }

    public static ArrayList<Session>[] cleanSessions(ArrayList<String[]>[] cleaned, String courseCode) {
        ArrayList<Session>[] sessions = (ArrayList<Session>[]) new ArrayList[3];
        sessions[0] = new ArrayList<>();
        sessions[1] = new ArrayList<>();
        sessions[2] = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (String[] list : cleaned[i]) {
                sessions[i].add(listToSession(list, courseCode));
            }
        }
        return sessions;
    }

    public static NewCourse sessionsToCourse(ArrayList<Session>[] sessions, String courseCode) {
        return new NewCourse(courseCode, sessions[1], sessions[0], sessions[2]);
    }

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
            ArrayList<String[]>[] divided = divideList(removeAsync);
            ArrayList<String[]>[] cleaned = cleanList(divided);
            ArrayList<Session>[] sessions = cleanSessions(cleaned, courseCode);
            course = sessionsToCourse(sessions, courseCode);
        }
        return course;
    }

    public static void print(NewCourse course){
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


    public static void main(String[] args) throws IOException {
        NewCourse sta257 = courseParse("STA257");
        NewCourse bio130 = courseParse("BIO130H1S");
        NewCourse mat137 = courseParse("MAT137Y1Y");
        //print(bio130);
        //print(mat137);
    }
}
