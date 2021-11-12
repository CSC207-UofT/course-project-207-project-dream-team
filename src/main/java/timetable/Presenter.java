package timetable;

import java.util.*;

// Citation: Code structure obtained from
// https://www.logicbig.com/how-to/code-snippets/jcode-java-cmd-command-line-table.html

public class Presenter {
    private static final String HORIZONTAL_SEP = "-";
    private static final String verticalSep = "|";
    private static final String joinSep = "+";
    private static final String[] headers = {"", "MON", "TUE", "WED", "THU", "FRI"};
    private final List<String[]> rows = new ArrayList<>();


    public Presenter() {

    }

    public void Present(ArrayList<String[]> presentable){
        for (String[] ss:presentable){
            addRow(ss);
        }
        print();
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


    public static ArrayList<String[]> Presentable(Timetable timetable){
        ArrayList<String[]> result = new ArrayList<>();
        result.add(new String[] {"","","","","",""});
        for (String k:timetable.occupied){
            boolean flag = false;
            for (String[] strings : result) {
                if ((strings[0].equals(k.substring(1, 5))) & (timetable.timeTable.get(k) != null)) {
                    strings[Integer.parseInt(k.substring(0, 1))] = timetable.timeTable.get(k).courseCode +
                            " " + timetable.timeTable.get(k).type;
                    flag = true;
                }
            }
            if (!flag) {
                String[] newString = new String[]{k.substring(1, 5), "", "", "", "", ""};
                newString[Integer.parseInt(k.substring(0,1))] = timetable.timeTable.get(k).courseCode+
                        " "+timetable.timeTable.get(k).type;
                result.add(newString);
            }
        }


        result.remove(0);

        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.size() - 1 - i; j++)
                if (Integer.parseInt(result.get(j)[0]) > Integer.parseInt(result.get(j + 1)[0])) {
                    Collections.swap(result, j, j + 1);
                }
        }
        return result;
    }
}
