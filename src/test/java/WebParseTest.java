import EnterpriseBusinessRules.NewCourse;
import FrameworksDrivers.WebParse;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class WebParseTest {

    @Test(timeout = 1000000)
    public void TestSort() throws IOException {
        NewCourse csc104 = WebParse.courseParse("CSC104");
        NewCourse sta257s = WebParse.courseParse("STA257");
        NewCourse sta257 = WebParse.courseParse("STA257H1F");
        NewCourse bio130 = WebParse.courseParse("BIO130H1S");
        ArrayList<String> mat137List = WebParse.tagsToList(WebParse.halfCourseToTags("MAT137"));
        Elements tags = WebParse.halfCourseToTags("MAT137");
        Elements tags2 = WebParse.halfCourseToTags("CSC105");
        assertEquals(1055, tags.size());
        assertEquals(3, tags2.size());

        assertEquals(2, sta257.getTutorials().size());
        assertEquals(9, bio130.getLabs().size());
        assertEquals(329, mat137List.size());
        assertEquals(0, csc104.getLabs().size());
        assertEquals(9, sta257s.getCourseCode().length());
        WebParse.print(bio130);
        WebParse.print(sta257);
    }
}