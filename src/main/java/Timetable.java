import java.util.ArrayList;
import java.util.HashMap;

public class Timetable {
    public HashMap<String, Session> timeTable;

    // Constructor //
    public Timetable() {
        this.timeTable = new HashMap<>();
        for (int i = 1; i <= 5; i++) {
            for (int k = 9; k <= 21; k++) {
                int num_key = i * 10000 + k * 100 + k + 1;
                String key = String.valueOf(num_key);
                this.timeTable.put(key, null);
            }
        }
    }

    // Check if the timeSpan is empty in timeTable
    public boolean isEmpty(String timeCode) {
        return true;
    }
}
