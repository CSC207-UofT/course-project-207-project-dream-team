package InterfaceAdapters;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import EnterpriseBusinessRules.Session;


import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.TreeMap;


public class MakePDF {

    public static void makePDF(TreeMap<String, Session> timetable){
        Document document = new Document();

        try {
            PdfWriter.getInstance(document,
                    new FileOutputStream("FallWinterTimetable.pdf"));

            document.open();

            Font font = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL);

            PdfPTable table = new PdfPTable(new float[] {1, 2, 2, 2, 2, 2}); // 6 columns.

            // set how much of the page the whole table takes horizontally
            table.setWidthPercentage(90);

            PdfPCell titleCell = new PdfPCell();
            titleCell.setColspan(6);
            titleCell.addElement(new Paragraph("Title content", font)); // composite mode

            // Column titles
            PdfPCell timeslotTitle = new PdfPCell(new Paragraph("Time", font));
            PdfPCell MondayTitle = new PdfPCell(new Paragraph("Monday", font));
            PdfPCell TuesdayTitle = new PdfPCell(new Paragraph("Tuesday", font));
            PdfPCell WednesdayTitle = new PdfPCell(new Paragraph("Wednesday", font));
            PdfPCell ThursdayTitle = new PdfPCell(new Paragraph("Thursday", font));
            PdfPCell FridayTitle = new PdfPCell(new Paragraph("Friday", font));

            table.addCell(timeslotTitle);
            table.addCell(MondayTitle);
            table.addCell(TuesdayTitle);
            table.addCell(WednesdayTitle);
            table.addCell(ThursdayTitle);
            table.addCell(FridayTitle);


            ArrayList<Integer> boxed = new ArrayList<>();
            PdfPCell emptyCell = new PdfPCell();

            for (int yCoords = 9; yCoords < 21; yCoords ++){
                // Every row has a time mark
                String timeslot = yCoords + ":00\n\n" + (yCoords + 1) + ":00";
                PdfPCell timeslotCell = new PdfPCell();
                timeslotCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                timeslotCell.setHorizontalAlignment(Element.ALIGN_MIDDLE);
                timeslotCell.addElement(new Paragraph(timeslot, font)); // composite mode
                table.addCell(timeslotCell);

                for (int xCoords = 1; xCoords < 6; xCoords ++){
                    // convert the position of the current cell to timetable key format
                    String strY = String.valueOf(yCoords);
                    if (strY.length() < 2){
                        strY = "0" + strY;
                    }
                    String singleHrKey = xCoords + strY + (yCoords + 1);
                    String dualHrKey = xCoords + strY + (yCoords + 2);
                    String tripleHrKey = xCoords + strY + (yCoords + 3);


                    // Case for when this time has activity representation in timeslot
                    if (timetable.containsKey(singleHrKey)){
                        String content = timetable.get(singleHrKey).courseCode + "\n" +
                                timetable.get(singleHrKey).sessionCode + "\n" +
                                timetable.get(singleHrKey).instructor + "\n";
                        PdfPCell contentCell = new PdfPCell();
                        contentCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        contentCell.setHorizontalAlignment(Element.ALIGN_MIDDLE);
                        contentCell.addElement(new Paragraph(content, font)); // composite mode
                        table.addCell(contentCell);
                    } else if (timetable.containsKey(dualHrKey)) {
                        String content = timetable.get(dualHrKey).courseCode + "\n" +
                                timetable.get(dualHrKey).sessionCode + "\n" +
                                timetable.get(dualHrKey).instructor + "\n";
                        PdfPCell contentCell = new PdfPCell();
                        contentCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        contentCell.setHorizontalAlignment(Element.ALIGN_MIDDLE);
                        contentCell.setRowspan(2);
                        boxed.add(xCoords);
                        contentCell.addElement(new Paragraph(content, font)); // composite mode
                        table.addCell(contentCell);
                    } else if (timetable.containsKey(tripleHrKey)) {
                        String content = timetable.get(tripleHrKey).courseCode + "\n" +
                                timetable.get(tripleHrKey).sessionCode + "\n" +
                                timetable.get(tripleHrKey).instructor + "\n";
                        PdfPCell contentCell = new PdfPCell();
                        contentCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        contentCell.setHorizontalAlignment(Element.ALIGN_MIDDLE);
                        contentCell.setRowspan(3);
                        boxed.add(xCoords);
                        boxed.add(xCoords);
                        contentCell.addElement(new Paragraph(content, font)); // composite mode
                        table.addCell(contentCell);
                    } else {
                        if (boxed.contains(xCoords)) {
                            boxed.remove(Integer.valueOf(xCoords));
                        } else {
                            table.addCell(emptyCell);
                        }
                    }
                }
            }

            document.add(table);

            document.close();
        } catch(Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Integer[] sessionTime = {41820};
        Session CSC207 = new Session("Paul", "CSC207H1F", "LEC0401", sessionTime);
        Session COG250 = new Session("John", "COG250H1Y", "LEC0101", sessionTime);
        TreeMap<String, Session> sampleTimetable = new TreeMap<>();
        sampleTimetable.put("40912", CSC207);
        sampleTimetable.put("41314", COG250);
        sampleTimetable.put("41416", COG250);
        sampleTimetable.put("31416", COG250);
        makePDF(sampleTimetable);

    }
}