import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class WebParse{
    public static ArrayList<String[]> courseParse(String courseCode) throws IOException {
        String url = "https://coursefinder.utoronto.ca/course-search/search/" +
                "courseInquiry?methodToCall=start&viewId=CourseDetails-" +
                "InquiryView&courseId=" + courseCode + "20219";
        Document html = Jsoup.connect(url).get();
        Elements spans = html.select("span");
        ArrayList<String> infos = new ArrayList<String>();
        ArrayList<String[]> result = new ArrayList<String[]>();
        String regex = "u[0-9]*_line[0-9]*";
        Pattern pattern = Pattern.compile(regex);
        for (Element span:spans){
            Matcher matcher = pattern.matcher(span.id());
            if (matcher.matches()) {
                infos.add(span.text());
            }
        }
        for (int i=0; i<infos.size(); i = i+7) {
            String[] sublist = new String[7];
            for (int j = 0; j < 7; j++) {
                sublist[j] = infos.get(i + j);
            }
            result.add(sublist);
        }
        return result;
    }

    public static void main(String[] args) throws IOException{
        ArrayList<String[]> result = courseParse("CSC108H1F");
        for (String[] list:result){
            System.out.println(Arrays.toString(list));
        }
    }
}