import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Presenter {
    private static final String HORIZONTAL_SEP = "-";
    private String verticalSep;
    private String joinSep;
    private static final String[] headers = {"MON", "TUE", "WED", "THU", "FRI"};
    private List<String[]> rows = new ArrayList<>();
    private boolean rightAlign;

    public Presenter() {
        setShowVerticalLines(false);
    }

    public void setRightAlign(boolean rightAlign) {
        this.rightAlign = rightAlign;
    }

    public void setShowVerticalLines(boolean showVerticalLines) {
        verticalSep = showVerticalLines ? "|" : "";
        joinSep = showVerticalLines ? "+" : " ";
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
            if (rightAlign) {
                System.out.printf("%s %" + maxWidths[i] + "s %s", verticalSep, s, verStrTemp);
            } else {
                System.out.printf("%s %-" + maxWidths[i] + "s %s", verticalSep, s, verStrTemp);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //test code
        Presenter st = new Presenter();
        //st.setRightAlign(true);//if true then cell text is right aligned
        st.setShowVerticalLines(true);//if false (default) then no vertical lines are shown

        st.addRow(" ", "broccoli", "flexible", "I love you", "Chicken breast");
        st.addRow(" ", "announcement", "reflection", "RRRUAAA", "RERORERO");
        st.addRow("logic", " ", "wild", "Salmon", " ");
        st.print();
    }
}
