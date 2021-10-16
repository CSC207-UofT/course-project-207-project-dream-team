import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Citation: Code structure obtained from
// https://www.logicbig.com/how-to/code-snippets/jcode-java-cmd-command-line-table.html

public class Presenter {
    private static final String HORIZONTAL_SEP = "-";
    private static final String verticalSep = "|";
    private static final String joinSep = "+";
    private static final String[] headers = {"", "MON", "TUE", "WED", "THU", "FRI"};
    private List<String[]> rows = new ArrayList<>();

    public Presenter() {
        //Nothing here for now
        // TODO: Load course info from Timetable into Presenter
    }

    public void addRow(String... cells) {
        rows.add(cells);
    }

    public void print() {
        int[] maxWidths = Arrays.stream(headers).mapToInt(String::length).toArray();

        for (String[] cells : rows) {
            if (cells.length != maxWidths.length) {
                throw new IllegalArgumentException("Number of row-cells and headers should be consistent");
            }
            for (int i = 0; i < cells.length; i++) {
                maxWidths[i] = Math.max(maxWidths[i], cells[i].length());
            }
        }

        printLine(maxWidths); // Print the top horizontal line
        printRow(headers, maxWidths); // Print the headers
        printLine(maxWidths); // Print another horizontal line

        for (String[] cells : rows) {
            printRow(cells, maxWidths);
            printLine(maxWidths); // Newly added
        }
    }

    private void printLine(int[] columnWidths) {
        for (int i = 0; i < columnWidths.length; i++) {
            String line = String.join("", Collections.nCopies(columnWidths[i] +
                    verticalSep.length() + 1, HORIZONTAL_SEP));
            System.out.print(joinSep + line + (i == columnWidths.length - 1 ? joinSep : ""));
        }
        System.out.println();
    }

    private void printRow(String[] cells, int[] maxWidths) {
        for (int i = 0; i < cells.length; i++) {
            String s = cells[i];
            String verStrTemp = i == cells.length - 1 ? verticalSep : "";

            System.out.printf("%s %-" + maxWidths[i] + "s %s", verticalSep, s, verStrTemp);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //test code
        Presenter st = new Presenter();

        st.addRow("9-10", "", "CSC258 Lec0101", "", "CSC236 TUT0301", "EAS220 LEC0201");
        st.addRow("10-11", "", "", "MAT235 TUT0101", "MAT235 LEC0101", "RERORERO");
        st.addRow("11-12", "CSC207 LEC0301", "", "", "CSC258 PRA0103", "");
        st.print();
    }
}
