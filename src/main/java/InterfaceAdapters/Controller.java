package InterfaceAdapters;

import ApplicationBusinessRule.SimpleScheduler;
import ApplicationBusinessRule.Timetable;
import EnterpriseBusinessRules.NewCourse;
import FrameworksDrivers.MakeCSV;
import FrameworksDrivers.UserData;
import FrameworksDrivers.WebParse;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;

import static FrameworksDrivers.WebParse.courseParse;

public class Controller implements Initializable {

    ArrayList<Timetable> arrangedTimetables;

    Timetable currTimetable;

    // top of the anchor pane
    @FXML
    TextField courseSearchField;

    @FXML
    Button searchButton;

    @FXML
    Menu knitToCsvMenu;

    @FXML
    Menu selectTimetableMenu;

    @FXML
    MenuItem timeTable1;

    @FXML
    MenuItem timeTable2;

    @FXML
    MenuItem timeTable3;

    @FXML
    MenuItem timeTable4;

    @FXML
    MenuItem timeTable5;

    // left of the pane
    @FXML
    ListView<String> courseListView;

    @FXML
    Button confirmButton;

    // middle of the pane
    @FXML
    TableView<TimeSlotForGUI> tableView;

    @FXML
    TableColumn<TimeSlotForGUI, String> TimeSlotColumn;

    @FXML
    TableColumn<TimeSlotForGUI, String> MondayColumn;

    @FXML
    TableColumn<TimeSlotForGUI, String> TuesdayColumn;

    @FXML
    TableColumn<TimeSlotForGUI, String> WednesdayColumn;

    @FXML
    TableColumn<TimeSlotForGUI, String> ThursdayColumn;

    @FXML
    TableColumn<TimeSlotForGUI, String> FridayColumn;



    // click events
    @FXML
    public void searchButtonClicked() {
        String course = courseSearchField.getText();
        try {
            NewCourse foundedCourse = courseParse(course);
            String foundedString = foundedCourse.getCourseCode();
            courseListView.getItems().add(foundedString);
        } catch (IOException c) {
            c.printStackTrace();
            AlertBox.display("Course not found error", "The course is not found");
        }
    }

    @FXML
    public void knitClicked() {
        MakeCSV.makeCSV(currTimetable.getTimeTable());
    }

    @FXML
    public void timeTable1Clicked() {
        currTimetable = arrangedTimetables.get(0);
    }

    @FXML
    public void timeTable2Clicked() {
        currTimetable = arrangedTimetables.get(1);
    }

    @FXML
    public void timeTable3Clicked() {
        currTimetable = arrangedTimetables.get(2);
    }

    @FXML
    public void timeTable4Clicked() {
        currTimetable = arrangedTimetables.get(3);
    }

    @FXML
    public void timeTable5Clicked() {
        currTimetable = arrangedTimetables.get(4);
    }

    @FXML
    public void confirmButtonClicked() throws IOException {
        ArrayList<String> courseNameList = new ArrayList<>(courseListView.getItems());
        ArrayList<NewCourse> newCourseList = new ArrayList<>();
        for (String courseName: courseNameList) {
            NewCourse parsedCourse = WebParse.courseParse(courseName);
            newCourseList.add(parsedCourse);
        }
        SimpleScheduler Ss = new SimpleScheduler(newCourseList);
        ArrayList<Timetable> arranged = Ss.arrange(new Timetable(), new HashSet<>());
        if (arranged.size() > 5) {
            arrangedTimetables = (ArrayList<Timetable>) arranged.subList(0, 4);
        } else {
            arrangedTimetables = arranged;
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // read in the previous courses
        try {
            ArrayList<String> loadedCoursesName = UserData.readCourses();
            for (String courseName: loadedCoursesName) {
                courseListView.getItems().add(courseName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        final ObservableList<TimeSlotForGUI> data = FXCollections.observableArrayList(
                new TimeSlotForGUI("9:00", "CSC207LEC", "CSC207TUT", null, null, null),
                new TimeSlotForGUI("10:00", "CSC207LEC", "CSC207TUT", null, null, null)
        );

        TimeSlotColumn.setCellValueFactory(new PropertyValueFactory<TimeSlotForGUI, String>("TimeSlot"));
        MondayColumn.setCellValueFactory(new PropertyValueFactory<TimeSlotForGUI, String>("MondaySession"));
        TuesdayColumn.setCellValueFactory(new PropertyValueFactory<TimeSlotForGUI, String>("TuesdaySession"));
        WednesdayColumn.setCellValueFactory(new PropertyValueFactory<TimeSlotForGUI, String>("WednesdaySession"));
        ThursdayColumn.setCellValueFactory(new PropertyValueFactory<TimeSlotForGUI, String>("ThursdaySession"));
        FridayColumn.setCellValueFactory(new PropertyValueFactory<TimeSlotForGUI, String>("FridaySession"));

        // add data inside table
        tableView.setItems(data);
    }

    public static void main(String[] args) {
        Application.launch(UserInterface.class, args);
    }
}