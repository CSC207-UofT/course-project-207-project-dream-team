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
    public static Elements courseToTags(String courseCode) throws IOException{
        String url = "https://coursefinder.utoronto.ca/course-search/search/" +
                "courseInquiry?methodToCall=start&viewId=CourseDetails-" +
                "InquiryView&courseId=" + courseCode + "20219";
        Document html = Jsoup.connect(url).get();
        return html.select("span");
    }

    public static Boolean tagMatch(String spanID){
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
        for (int i=0; i<infos.size(); i = i+7) {
            String[] sublist = new String[7];
            for (int j = 0; j < 7; j++) {
                sublist[j] = infos.get(i + j);
            }
            infoSessions.add(sublist);
        }
        return infoSessions;
    }

    public static Integer[] toTimeslots(String time){
        String[] list = time.split(" ");
        Integer[] timeslots = new Integer[list.length/2];
        for (int i=0; i<list.length; i=i+2){
            String day = String.valueOf(DayOfWeek.valueOf(list[i]).getValue());
            String start = list[i+1].substring(0,2);
            String end = list[i+1].substring(6,8);
            timeslots[i/2] = Integer.parseInt(day + start + end);
        }
        return timeslots;
    }

    public static Session listToSession(String[] infoSession, String courseCode){
        String instructor = infoSession[2];
        int end = infoSession[0].length();
        String sessionCode = (infoSession[0].substring(0,3)+
                infoSession[0].substring(4,end)).toUpperCase();
        Integer[] timeslots = toTimeslots(infoSession[1]);
        return new Session(instructor, courseCode, sessionCode, timeslots);
    }

    public static NewCourse sessionsToCourse(ArrayList<Session> sessions, String courseCode){
        ArrayList<Session> tutorials = new ArrayList<>();
        ArrayList<Session> lectures = new ArrayList<>();
        ArrayList<Session> labs = new ArrayList<>();
        for (Session session: sessions){
            if (session.sessionCode.substring(0,3).equals("TUT")){
                tutorials.add(session);
            }else if (session.sessionCode.substring(0,3).equals("LEC")){
                lectures.add(session);
            }else{
                labs.add(session);
            }
        }
        return new NewCourse(courseCode, tutorials, lectures, labs);
    }

    public static NewCourse courseParse(String courseCode) throws IOException {
        Elements spans = courseToTags(courseCode);
        ArrayList<String> infos = tagsToList(spans);
        NewCourse course;
        if ((infos.size() == 0) || (infos.get(6).equals("ASYNC"))){
            ArrayList<Session> a = new ArrayList<>();
            course = new NewCourse("", a,a,a);
        }else {
            ArrayList<String[]> infoSessions = breakList(infos);
            ArrayList<Session> sessions = new ArrayList<>();
            for (String[] infoSession : infoSessions) {
                sessions.add(listToSession(infoSession, courseCode));
            }
            course = sessionsToCourse(sessions, courseCode);
        }
        return course;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(courseParse("PSY100H1F"));
    }

}