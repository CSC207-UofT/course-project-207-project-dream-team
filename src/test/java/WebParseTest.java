import EnterpriseBusinessRules.NewCourse;
import FrameworksDrivers.WebParse;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class WebParseTest {

    @Test(timeout = 1000000)
    public void TestSort() throws IOException {

        NewCourse sta257 = WebParse.courseParse("STA257H1F");
        NewCourse bio130 = WebParse.courseParse("BIO130H1S");
        NewCourse mat137 = WebParse.courseParse("MAT137Y1Y");
        assertEquals(2, sta257.getTutorials().size());
        assertEquals(9, bio130.getLabs().size());
        assertEquals(14, mat137.getTutorials().size());
    }
}
