package InterfaceAdapters;

import ApplicationBusinessRule.*;
import EnterpriseBusinessRules.NewCourse;
import FrameworksDrivers.UserData;
import FrameworksDrivers.WebParse;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class UserInterface extends Application {

    Stage window;

    @Override
    public void start(Stage stage) throws IOException {

        window = stage;


        // create a scene for instructor user events
        VBox insVBox = new VBox();

        Label insAsk2 = new Label("Please enter your unwanted instructors");
        insAsk2.setFont(Font.font(22));
        TextField unwanted1 = new TextField("Instructor 1");
        TextField unwanted2 = new TextField("Instructor 2");
        TextField unwanted3 = new TextField("Instructor 3");
        TextField unwanted4 = new TextField("Instructor 4");
        TextField unwanted5 = new TextField("Instructor 5");
        TextField unwanted6 = new TextField("Instructor 6");
        Button insConfirmButton = new Button("Confirm");
        Button insBackButton = new Button("Back");

        insVBox.getChildren().addAll(insAsk2, unwanted1, unwanted2, unwanted3,
                unwanted4, unwanted5, unwanted6, insConfirmButton, insBackButton);
        insVBox.setAlignment(Pos.TOP_CENTER);

        insVBox.setSpacing(10);
        insVBox.setPadding(new Insets(20, 220, 20, 220));

        Scene insScene = new Scene(insVBox, 855, 516);



        // get value from the instructor scene
        String ins1 = unwanted1.getText();
        String ins2 = unwanted2.getText();
        String ins3 = unwanted3.getText();
        String ins4 = unwanted4.getText();
        String ins5 = unwanted5.getText();
        String ins6 = unwanted6.getText();

        ArrayList<String> insSelected = new ArrayList<>();
        insSelected.add(ins1);
        insSelected.add(ins2);
        insSelected.add(ins3);
        insSelected.add(ins4);
        insSelected.add(ins5);
        insSelected.add(ins6);





        // create a scene for max hour user events
        VBox maxHourVBox = new VBox();
        Label maxAsk = new Label("Please enter your preferred duration of classes each day");
        TextField maxPreferred = new TextField("Ex: 3");
        Button maxConfirm = new Button("Confirm");
        Button maxBack = new Button("Back");
        maxHourVBox.getChildren().addAll(maxAsk, maxPreferred, maxConfirm, maxBack);

        maxHourVBox.setAlignment(Pos.TOP_CENTER);
        maxHourVBox.setPadding(new Insets(20, 220, 20, 220));
        maxHourVBox.setSpacing(8);

        Scene maxScene = new Scene(maxHourVBox, 855, 516);



        // get value from the max hour scene
        String maxSelected = maxPreferred.getText();



        // create a scene for time slot user events
        VBox timeSlotVBox = new VBox();
        Label timeAsk = new Label("Please select your unwanted timeslots");
        timeAsk.setFont(Font.font(20));
        GridPane grid = new GridPane();

        VBox box00 = new VBox();
        Label label00 = new Label("Monday");
        ListView<String> list00 = new ListView<>();
        list00.getItems().addAll("09:00 - 10:00", "10:00 - 11:00", "11:00 - 12:00", "12:00 - 13:00",
                "13:00 - 14:00", "14:00 - 15:00", "15:00 - 16:00", "16:00 - 17:00", "17:00 - 18:00", "18:00 - 19:00",
                "19:00 - 20:00", "20:00 - 21:00");
        list00.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        box00.getChildren().addAll(label00, list00);
        box00.setAlignment(Pos.CENTER);
        GridPane.setConstraints(box00, 0, 0);

        VBox box10 = new VBox();
        Label label10 = new Label("Tuesday");
        ListView<String> list10 = new ListView<>();
        list10.getItems().addAll("09:00 - 10:00", "10:00 - 11:00", "11:00 - 12:00", "12:00 - 13:00",
                "13:00 - 14:00", "14:00 - 15:00", "15:00 - 16:00", "16:00 - 17:00", "17:00 - 18:00", "18:00 - 19:00",
                "19:00 - 20:00", "20:00 - 21:00");
        list10.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        box10.getChildren().addAll(label10, list10);
        box10.setAlignment(Pos.CENTER);
        GridPane.setConstraints(box10, 1, 0);

        VBox box20 = new VBox();
        Label label20 = new Label("Wednesday");
        ListView<String> list20 = new ListView<>();
        list20.getItems().addAll("09:00 - 10:00", "10:00 - 11:00", "11:00 - 12:00", "12:00 - 13:00",
                "13:00 - 14:00", "14:00 - 15:00", "15:00 - 16:00", "16:00 - 17:00", "17:00 - 18:00", "18:00 - 19:00",
                "19:00 - 20:00", "20:00 - 21:00");
        list20.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        box20.getChildren().addAll(label20, list20);
        box20.setAlignment(Pos.CENTER);
        GridPane.setConstraints(box20, 2, 0);

        VBox box01 = new VBox();
        Label label01 = new Label("Thursday");
        ListView<String> list01 = new ListView<>();
        list01.getItems().addAll("09:00 - 10:00", "10:00 - 11:00", "11:00 - 12:00", "12:00 - 13:00",
                "13:00 - 14:00", "14:00 - 15:00", "15:00 - 16:00", "16:00 - 17:00", "17:00 - 18:00", "18:00 - 19:00",
                "19:00 - 20:00", "20:00 - 21:00");
        list01.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        box01.getChildren().addAll(label01, list01);
        box01.setAlignment(Pos.CENTER);
        GridPane.setConstraints(box01, 0, 1);

        VBox box11 = new VBox();
        Label label11 = new Label("Friday");
        ListView<String> list11 = new ListView<>();
        list11.getItems().addAll("09:00 - 10:00", "10:00 - 11:00", "11:00 - 12:00", "12:00 - 13:00",
                "13:00 - 14:00", "14:00 - 15:00", "15:00 - 16:00", "16:00 - 17:00", "17:00 - 18:00", "18:00 - 19:00",
                "19:00 - 20:00", "20:00 - 21:00");
        list11.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        box11.getChildren().addAll(label11, list11);
        box11.setAlignment(Pos.CENTER);
        GridPane.setConstraints(box11, 1, 1);

        VBox box21 = new VBox();
        Button timeSlotConfirm = new Button("Confirm");
        Button timeSlotBack = new Button("Back");
        box21.setSpacing(8);
        box21.getChildren().addAll(timeSlotConfirm, timeSlotBack);
        GridPane.setConstraints(box21, 2, 1);

        grid.getChildren().addAll(box00, box10, box20, box01, box11, box21);

        timeSlotVBox.getChildren().addAll(timeAsk, grid);
        timeSlotVBox.setAlignment(Pos.CENTER);

        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setAlignment(Pos.CENTER);

        Scene timeSlotScene = new Scene(timeSlotVBox, 885, 516);


        // get value from the timeslot scene
        // mon
        ObservableList<String> monitems = list00.getSelectionModel().getSelectedItems();
        ArrayList<String> monListItems = new ArrayList<>();
        for (String item: monitems) {
            monListItems.add(item);
        }

        ArrayList<String> slotsSelected = new ArrayList<>();
        for (String slot: monitems) {
            String res = "1" + slot.substring(0, 2) + slot.substring(8, 10);
            slotsSelected.add(res);
        }

        // tue
        ObservableList<String> tueitems = list00.getSelectionModel().getSelectedItems();
        ArrayList<String> tueListItems = new ArrayList<>();
        for (String item: tueitems) {
            tueListItems.add(item);
        }

        for (String slot: tueitems) {
            String res = "2" + slot.substring(0, 2) + slot.substring(8, 10);
            slotsSelected.add(res);
        }

        // wed
        ObservableList<String> weditems = list00.getSelectionModel().getSelectedItems();
        ArrayList<String> wedListItems = new ArrayList<>();
        for (String item: weditems) {
            wedListItems.add(item);
        }

        for (String slot: weditems) {
            String res = "3" + slot.substring(0, 2) + slot.substring(8, 10);
            slotsSelected.add(res);
        }

        // thu
        ObservableList<String> thuitems = list00.getSelectionModel().getSelectedItems();
        ArrayList<String> thuListItems = new ArrayList<>();
        for (String item: thuitems) {
            thuListItems.add(item);
        }

        for (String slot: thuitems) {
            String res = "4" + slot.substring(0, 2) + slot.substring(8, 10);
            slotsSelected.add(res);
        }

        // fri
        ObservableList<String> fritems = list00.getSelectionModel().getSelectedItems();
        ArrayList<String> friListItems = new ArrayList<>();
        for (String item: fritems) {
            friListItems.add(item);
        }

        for (String slot: fritems) {
            String res = "5" + slot.substring(0, 2) + slot.substring(8, 10);
            slotsSelected.add(res);
        }



        // main scene
        // The largest layer. The borderpane.
        BorderPane borderPane = new BorderPane();

        // The left side of the borderpane.
        VBox leftVBox = new VBox();

        ListView<String> leftListView = new ListView<>();
        Button leftClear = new Button("Clear Courses");
        leftVBox.setSpacing(8);
        leftVBox.getChildren().addAll(leftListView, leftClear);

        leftListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        leftClear.setOnAction(e -> {
            String courseName = leftListView.getItems().remove(0);
            try {
                UserData.removeCourse(courseName);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        // set the left of the border pane to be the hbox
        borderPane.setLeft(leftVBox);

        leftListView.setPrefWidth(186);


        // The center of the borderpane.
        TableView<TimeSlotForGUI> centerTableView = new TableView<>();

        TableColumn<TimeSlotForGUI, String> timeSlotColumn = new TableColumn<>("Time Slots");
        timeSlotColumn.setCellValueFactory(new PropertyValueFactory<>("TimeSlot"));
        timeSlotColumn.setStyle("-fx-alignment: CENTER");

        TableColumn<TimeSlotForGUI, String> mondayColumn = new TableColumn<>("Monday");
        mondayColumn.setCellValueFactory(new PropertyValueFactory<>("MondaySession"));
        mondayColumn.setStyle("-fx-alignment: CENTER");

        TableColumn<TimeSlotForGUI, String> tuesdayColumn = new TableColumn<>("Tuesday");
        tuesdayColumn.setCellValueFactory(new PropertyValueFactory<>("TuesdaySession"));
        tuesdayColumn.setStyle("-fx-alignment: CENTER");

        TableColumn<TimeSlotForGUI, String> wednesdayColumn = new TableColumn<>("Wednesday");
        wednesdayColumn.setCellValueFactory(new PropertyValueFactory<>("WednesdaySession"));
        wednesdayColumn.setStyle("-fx-alignment: CENTER");

        TableColumn<TimeSlotForGUI, String> thursdayColumn = new TableColumn<>("Thursday");
        thursdayColumn.setCellValueFactory(new PropertyValueFactory<>("ThursdaySession"));
        thursdayColumn.setStyle("-fx-alignment: CENTER");

        TableColumn<TimeSlotForGUI, String> fridayColumn = new TableColumn<>("Friday");
        fridayColumn.setCellValueFactory(new PropertyValueFactory<>("FridaySession"));
        fridayColumn.setStyle("-fx-alignment: CENTER");

        centerTableView.getColumns().add(timeSlotColumn);
        centerTableView.getColumns().add(mondayColumn);
        centerTableView.getColumns().add(tuesdayColumn);
        centerTableView.getColumns().add(wednesdayColumn);
        centerTableView.getColumns().add(thursdayColumn);
        centerTableView.getColumns().add(fridayColumn);

        timeSlotColumn.setPrefWidth(80);
        mondayColumn.setPrefWidth(90);
        tuesdayColumn.setPrefWidth(90);
        wednesdayColumn.setPrefWidth(90);
        thursdayColumn.setPrefWidth(90);
        fridayColumn.setPrefWidth(90);


        // set the table view to be the center of the border pane.
        borderPane.setCenter(centerTableView);


        Scene root = new Scene(borderPane, 885, 385);




        // The right side of the borderpane.
        VBox rightVBox = new VBox();
        Label rightLabel = new Label("Choose filter:");
        Label rightLabel2 = new Label("Empty filter is allowed");
        RadioButton insRadioButton = new RadioButton("Instructor");
        RadioButton maxHourRadioButton = new RadioButton("Max Hour");
        RadioButton timeSlotRadioButton = new RadioButton("Time Slot");

        final ToggleGroup group = new ToggleGroup();
        insRadioButton.setToggleGroup(group);
        maxHourRadioButton.setToggleGroup(group);
        timeSlotRadioButton.setToggleGroup(group);

        Button rightConfirmButton = new Button("Confirm");

        Button rightClearBtn = new Button("Clear");

        rightVBox.getChildren().addAll(rightLabel, rightLabel2, insRadioButton, maxHourRadioButton,
                timeSlotRadioButton, rightConfirmButton, rightClearBtn);


        // right Confirm Button
        rightConfirmButton.setOnAction(e -> {

            ObservableList<String> selectedCourses = leftListView.getSelectionModel().getSelectedItems();
            ArrayList<String> selectedArrayList = new ArrayList<>();
            for (String item: selectedCourses) {
                selectedArrayList.add(item);
            }
            ArrayList<NewCourse> newCourses = new ArrayList<>();
            for (String course: selectedArrayList) {
                try {
                    newCourses.add(WebParse.courseParse(course));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            SimpleScheduler ss1 = new SimpleScheduler(newCourses);
            Timetable tb = new Timetable();
            Set<String> seen = new HashSet<>();
            ArrayList<Timetable> noFilterRes = ss1.arrange(tb, seen);


            if (insRadioButton.isSelected()) {
                InstructorFilter insFilter = new InstructorFilter(noFilterRes, insSelected);
                ArrayList<Timetable> insFiltered = insFilter.sort();

                for (Timetable tt: insFiltered) {
                    ArrayList<ArrayList<String>> listOfListOfRows = ConvertToUI.convertToUI(tt.getTimeTable());
                    ArrayList<String> slot9 = new ArrayList<>(listOfListOfRows.get(0));
                    slot9.add(0, "9:00");

                    TimeSlotForGUI row9 = new TimeSlotForGUI(slot9.get(0), slot9.get(1), slot9.get(2), slot9.get(3), slot9.get(4), slot9.get(5));

                    ArrayList<String> slot10 = new ArrayList<>(listOfListOfRows.get(1));
                    slot10.add(0, "10:00");

                    TimeSlotForGUI row10 = new TimeSlotForGUI(slot10.get(0), slot10.get(1), slot10.get(2), slot10.get(3), slot10.get(4), slot10.get(5));

                    ArrayList<String> slot11 = new ArrayList<>(listOfListOfRows.get(2));
                    slot11.add(0, "11:00");

                    TimeSlotForGUI row11 = new TimeSlotForGUI(slot11.get(0), slot11.get(1), slot11.get(2), slot11.get(3), slot11.get(4), slot11.get(5));

                    ArrayList<String> slot12 = new ArrayList<>(listOfListOfRows.get(3));
                    slot12.add(0, "12:00");

                    TimeSlotForGUI row12 = new TimeSlotForGUI(slot12.get(0), slot12.get(1), slot12.get(2), slot12.get(3), slot12.get(4), slot12.get(5));

                    ArrayList<String> slot13 = new ArrayList<>(listOfListOfRows.get(4));
                    slot13.add(0, "13:00");

                    TimeSlotForGUI row13 = new TimeSlotForGUI(slot13.get(0), slot13.get(1), slot13.get(2), slot13.get(3), slot13.get(4), slot13.get(5));

                    ArrayList<String> slot14 = new ArrayList<>(listOfListOfRows.get(5));
                    slot14.add(0, "14:00");

                    TimeSlotForGUI row14 = new TimeSlotForGUI(slot14.get(0), slot14.get(1), slot14.get(2), slot14.get(3), slot14.get(4), slot14.get(5));

                    ArrayList<String> slot15 = new ArrayList<>(listOfListOfRows.get(6));
                    slot15.add(0, "15:00");

                    TimeSlotForGUI row15 = new TimeSlotForGUI(slot15.get(0), slot15.get(1), slot15.get(2), slot15.get(3), slot15.get(4), slot15.get(5));

                    ArrayList<String> slot16 = new ArrayList<>(listOfListOfRows.get(7));
                    slot16.add(0, "16:00");

                    TimeSlotForGUI row16 = new TimeSlotForGUI(slot16.get(0), slot16.get(1), slot16.get(2), slot16.get(3), slot16.get(4), slot16.get(5));

                    ArrayList<String> slot17 = new ArrayList<>(listOfListOfRows.get(8));
                    slot17.add(0, "17:00");

                    TimeSlotForGUI row17 = new TimeSlotForGUI(slot17.get(0), slot17.get(1), slot17.get(2), slot17.get(3), slot17.get(4), slot17.get(5));

                    ArrayList<String> slot18 = new ArrayList<>(listOfListOfRows.get(9));
                    slot18.add(0, "18:00");

                    TimeSlotForGUI row18 = new TimeSlotForGUI(slot18.get(0), slot18.get(1), slot18.get(2), slot18.get(3), slot18.get(4), slot18.get(5));

                    ArrayList<String> slot19 = new ArrayList<>(listOfListOfRows.get(10));
                    slot19.add(0, "19:00");

                    TimeSlotForGUI row19 = new TimeSlotForGUI(slot19.get(0), slot19.get(1), slot19.get(2), slot19.get(3), slot19.get(4), slot19.get(5));

                    ArrayList<String> slot20 = new ArrayList<>(listOfListOfRows.get(11));
                    slot20.add(0, "20:00");

                    TimeSlotForGUI row20 = new TimeSlotForGUI(slot20.get(0), slot20.get(1), slot20.get(2), slot20.get(3), slot20.get(4), slot20.get(5));

//                    ArrayList<String> slot21 = new ArrayList<>(listOfListOfRows.get(12));
//                    slot21.add(0, "21:00");
//
//                    TimeSlotForGUI row21 = new TimeSlotForGUI(slot21.get(0), slot21.get(1), slot21.get(2), slot21.get(3), slot21.get(4), slot21.get(5));

                    centerTableView.getItems().add(row9);
                    centerTableView.getItems().add(row10);
                    centerTableView.getItems().add(row11);
                    centerTableView.getItems().add(row12);
                    centerTableView.getItems().add(row13);
                    centerTableView.getItems().add(row14);
                    centerTableView.getItems().add(row15);
                    centerTableView.getItems().add(row16);
                    centerTableView.getItems().add(row17);
                    centerTableView.getItems().add(row18);
                    centerTableView.getItems().add(row19);
                    centerTableView.getItems().add(row20);


                window.setScene(insScene);
                }

            } else if (maxHourRadioButton.isSelected()) {
                ArrayList<String> maxSelectedList = new ArrayList<>();
                maxSelectedList.add(maxSelected);

                MaximumHourFilter mhf = new MaximumHourFilter(noFilterRes, maxSelectedList);
                ArrayList<Timetable> mhfFiltered = mhf.sort();

                for (Timetable tt: noFilterRes) {
                    ArrayList<ArrayList<String>> listOfListOfRows = ConvertToUI.convertToUI(tt.getTimeTable());
                    ArrayList<String> slot9 = new ArrayList<>(listOfListOfRows.get(0));
                    slot9.add(0, "9:00");

                    TimeSlotForGUI row9 = new TimeSlotForGUI(slot9.get(0), slot9.get(1), slot9.get(2), slot9.get(3), slot9.get(4), slot9.get(5));

                    ArrayList<String> slot10 = new ArrayList<>(listOfListOfRows.get(1));
                    slot10.add(0, "10:00");

                    TimeSlotForGUI row10 = new TimeSlotForGUI(slot10.get(0), slot10.get(1), slot10.get(2), slot10.get(3), slot10.get(4), slot10.get(5));

                    ArrayList<String> slot11 = new ArrayList<>(listOfListOfRows.get(2));
                    slot11.add(0, "11:00");

                    TimeSlotForGUI row11 = new TimeSlotForGUI(slot11.get(0), slot11.get(1), slot11.get(2), slot11.get(3), slot11.get(4), slot11.get(5));

                    ArrayList<String> slot12 = new ArrayList<>(listOfListOfRows.get(3));
                    slot12.add(0, "12:00");

                    TimeSlotForGUI row12 = new TimeSlotForGUI(slot12.get(0), slot12.get(1), slot12.get(2), slot12.get(3), slot12.get(4), slot12.get(5));

                    ArrayList<String> slot13 = new ArrayList<>(listOfListOfRows.get(4));
                    slot13.add(0, "13:00");

                    TimeSlotForGUI row13 = new TimeSlotForGUI(slot13.get(0), slot13.get(1), slot13.get(2), slot13.get(3), slot13.get(4), slot13.get(5));

                    ArrayList<String> slot14 = new ArrayList<>(listOfListOfRows.get(5));
                    slot14.add(0, "14:00");

                    TimeSlotForGUI row14 = new TimeSlotForGUI(slot14.get(0), slot14.get(1), slot14.get(2), slot14.get(3), slot14.get(4), slot14.get(5));

                    ArrayList<String> slot15 = new ArrayList<>(listOfListOfRows.get(6));
                    slot15.add(0, "15:00");

                    TimeSlotForGUI row15 = new TimeSlotForGUI(slot15.get(0), slot15.get(1), slot15.get(2), slot15.get(3), slot15.get(4), slot15.get(5));

                    ArrayList<String> slot16 = new ArrayList<>(listOfListOfRows.get(7));
                    slot16.add(0, "16:00");

                    TimeSlotForGUI row16 = new TimeSlotForGUI(slot16.get(0), slot16.get(1), slot16.get(2), slot16.get(3), slot16.get(4), slot16.get(5));

                    ArrayList<String> slot17 = new ArrayList<>(listOfListOfRows.get(8));
                    slot17.add(0, "17:00");

                    TimeSlotForGUI row17 = new TimeSlotForGUI(slot17.get(0), slot17.get(1), slot17.get(2), slot17.get(3), slot17.get(4), slot17.get(5));

                    ArrayList<String> slot18 = new ArrayList<>(listOfListOfRows.get(9));
                    slot18.add(0, "18:00");

                    TimeSlotForGUI row18 = new TimeSlotForGUI(slot18.get(0), slot18.get(1), slot18.get(2), slot18.get(3), slot18.get(4), slot18.get(5));

                    ArrayList<String> slot19 = new ArrayList<>(listOfListOfRows.get(10));
                    slot19.add(0, "19:00");

                    TimeSlotForGUI row19 = new TimeSlotForGUI(slot19.get(0), slot19.get(1), slot19.get(2), slot19.get(3), slot19.get(4), slot19.get(5));

                    ArrayList<String> slot20 = new ArrayList<>(listOfListOfRows.get(11));
                    slot20.add(0, "20:00");

                    TimeSlotForGUI row20 = new TimeSlotForGUI(slot20.get(0), slot20.get(1), slot20.get(2), slot20.get(3), slot20.get(4), slot20.get(5));

//                    ArrayList<String> slot21 = new ArrayList<>(listOfListOfRows.get(12));
//                    slot21.add(0, "21:00");
//
//                    TimeSlotForGUI row21 = new TimeSlotForGUI(slot21.get(0), slot21.get(1), slot21.get(2), slot21.get(3), slot21.get(4), slot21.get(5));

                    centerTableView.getItems().add(row9);
                    centerTableView.getItems().add(row10);
                    centerTableView.getItems().add(row11);
                    centerTableView.getItems().add(row12);
                    centerTableView.getItems().add(row13);
                    centerTableView.getItems().add(row14);
                    centerTableView.getItems().add(row15);
                    centerTableView.getItems().add(row16);
                    centerTableView.getItems().add(row17);
                    centerTableView.getItems().add(row18);
                    centerTableView.getItems().add(row19);
                    centerTableView.getItems().add(row20);
                }


                window.setScene(maxScene);

                // time slot button is selected
            } else if (timeSlotRadioButton.isSelected()) {
                TimeslotFilter tsf = new TimeslotFilter(noFilterRes, slotsSelected);
                ArrayList<Timetable> tsfFiltered = tsf.sort();

                for (Timetable tt: noFilterRes) {
                    ArrayList<ArrayList<String>> listOfListOfRows = ConvertToUI.convertToUI(tt.getTimeTable());
                    ArrayList<String> slot9 = new ArrayList<>(listOfListOfRows.get(0));
                    slot9.add(0, "9:00");

                    TimeSlotForGUI row9 = new TimeSlotForGUI(slot9.get(0), slot9.get(1), slot9.get(2), slot9.get(3), slot9.get(4), slot9.get(5));

                    ArrayList<String> slot10 = new ArrayList<>(listOfListOfRows.get(1));
                    slot10.add(0, "10:00");

                    TimeSlotForGUI row10 = new TimeSlotForGUI(slot10.get(0), slot10.get(1), slot10.get(2), slot10.get(3), slot10.get(4), slot10.get(5));

                    ArrayList<String> slot11 = new ArrayList<>(listOfListOfRows.get(2));
                    slot11.add(0, "11:00");

                    TimeSlotForGUI row11 = new TimeSlotForGUI(slot11.get(0), slot11.get(1), slot11.get(2), slot11.get(3), slot11.get(4), slot11.get(5));

                    ArrayList<String> slot12 = new ArrayList<>(listOfListOfRows.get(3));
                    slot12.add(0, "12:00");

                    TimeSlotForGUI row12 = new TimeSlotForGUI(slot12.get(0), slot12.get(1), slot12.get(2), slot12.get(3), slot12.get(4), slot12.get(5));

                    ArrayList<String> slot13 = new ArrayList<>(listOfListOfRows.get(4));
                    slot13.add(0, "13:00");

                    TimeSlotForGUI row13 = new TimeSlotForGUI(slot13.get(0), slot13.get(1), slot13.get(2), slot13.get(3), slot13.get(4), slot13.get(5));

                    ArrayList<String> slot14 = new ArrayList<>(listOfListOfRows.get(5));
                    slot14.add(0, "14:00");

                    TimeSlotForGUI row14 = new TimeSlotForGUI(slot14.get(0), slot14.get(1), slot14.get(2), slot14.get(3), slot14.get(4), slot14.get(5));

                    ArrayList<String> slot15 = new ArrayList<>(listOfListOfRows.get(6));
                    slot15.add(0, "15:00");

                    TimeSlotForGUI row15 = new TimeSlotForGUI(slot15.get(0), slot15.get(1), slot15.get(2), slot15.get(3), slot15.get(4), slot15.get(5));

                    ArrayList<String> slot16 = new ArrayList<>(listOfListOfRows.get(7));
                    slot16.add(0, "16:00");

                    TimeSlotForGUI row16 = new TimeSlotForGUI(slot16.get(0), slot16.get(1), slot16.get(2), slot16.get(3), slot16.get(4), slot16.get(5));

                    ArrayList<String> slot17 = new ArrayList<>(listOfListOfRows.get(8));
                    slot17.add(0, "17:00");

                    TimeSlotForGUI row17 = new TimeSlotForGUI(slot17.get(0), slot17.get(1), slot17.get(2), slot17.get(3), slot17.get(4), slot17.get(5));

                    ArrayList<String> slot18 = new ArrayList<>(listOfListOfRows.get(9));
                    slot18.add(0, "18:00");

                    TimeSlotForGUI row18 = new TimeSlotForGUI(slot18.get(0), slot18.get(1), slot18.get(2), slot18.get(3), slot18.get(4), slot18.get(5));

                    ArrayList<String> slot19 = new ArrayList<>(listOfListOfRows.get(10));
                    slot19.add(0, "19:00");

                    TimeSlotForGUI row19 = new TimeSlotForGUI(slot19.get(0), slot19.get(1), slot19.get(2), slot19.get(3), slot19.get(4), slot19.get(5));

                    ArrayList<String> slot20 = new ArrayList<>(listOfListOfRows.get(11));
                    slot20.add(0, "20:00");

                    TimeSlotForGUI row20 = new TimeSlotForGUI(slot20.get(0), slot20.get(1), slot20.get(2), slot20.get(3), slot20.get(4), slot20.get(5));

//                    ArrayList<String> slot21 = new ArrayList<>(listOfListOfRows.get(12));
//                    slot21.add(0, "21:00");
//
//                    TimeSlotForGUI row21 = new TimeSlotForGUI(slot21.get(0), slot21.get(1), slot21.get(2), slot21.get(3), slot21.get(4), slot21.get(5));

                    centerTableView.getItems().add(row9);
                    centerTableView.getItems().add(row10);
                    centerTableView.getItems().add(row11);
                    centerTableView.getItems().add(row12);
                    centerTableView.getItems().add(row13);
                    centerTableView.getItems().add(row14);
                    centerTableView.getItems().add(row15);
                    centerTableView.getItems().add(row16);
                    centerTableView.getItems().add(row17);
                    centerTableView.getItems().add(row18);
                    centerTableView.getItems().add(row19);
                    centerTableView.getItems().add(row20);
                }

                window.setScene(timeSlotScene);
            }

                int numOfTimeTable = noFilterRes.size();

                for (Timetable tt: noFilterRes) {
                    ArrayList<ArrayList<String>> listOfListOfRows = ConvertToUI.convertToUI(tt.getTimeTable());
                    ArrayList<String> slot9 = new ArrayList<>(listOfListOfRows.get(0));
                    slot9.add(0, "9:00");

                    TimeSlotForGUI row9 = new TimeSlotForGUI(slot9.get(0), slot9.get(1), slot9.get(2), slot9.get(3), slot9.get(4), slot9.get(5));

                    ArrayList<String> slot10 = new ArrayList<>(listOfListOfRows.get(1));
                    slot10.add(0, "10:00");

                    TimeSlotForGUI row10 = new TimeSlotForGUI(slot10.get(0), slot10.get(1), slot10.get(2), slot10.get(3), slot10.get(4), slot10.get(5));

                    ArrayList<String> slot11 = new ArrayList<>(listOfListOfRows.get(2));
                    slot11.add(0, "11:00");

                    TimeSlotForGUI row11 = new TimeSlotForGUI(slot11.get(0), slot11.get(1), slot11.get(2), slot11.get(3), slot11.get(4), slot11.get(5));

                    ArrayList<String> slot12 = new ArrayList<>(listOfListOfRows.get(3));
                    slot12.add(0, "12:00");

                    TimeSlotForGUI row12 = new TimeSlotForGUI(slot12.get(0), slot12.get(1), slot12.get(2), slot12.get(3), slot12.get(4), slot12.get(5));

                    ArrayList<String> slot13 = new ArrayList<>(listOfListOfRows.get(4));
                    slot13.add(0, "13:00");

                    TimeSlotForGUI row13 = new TimeSlotForGUI(slot13.get(0), slot13.get(1), slot13.get(2), slot13.get(3), slot13.get(4), slot13.get(5));

                    ArrayList<String> slot14 = new ArrayList<>(listOfListOfRows.get(5));
                    slot14.add(0, "14:00");

                    TimeSlotForGUI row14 = new TimeSlotForGUI(slot14.get(0), slot14.get(1), slot14.get(2), slot14.get(3), slot14.get(4), slot14.get(5));

                    ArrayList<String> slot15 = new ArrayList<>(listOfListOfRows.get(6));
                    slot15.add(0, "15:00");

                    TimeSlotForGUI row15 = new TimeSlotForGUI(slot15.get(0), slot15.get(1), slot15.get(2), slot15.get(3), slot15.get(4), slot15.get(5));

                    ArrayList<String> slot16 = new ArrayList<>(listOfListOfRows.get(7));
                    slot16.add(0, "16:00");

                    TimeSlotForGUI row16 = new TimeSlotForGUI(slot16.get(0), slot16.get(1), slot16.get(2), slot16.get(3), slot16.get(4), slot16.get(5));

                    ArrayList<String> slot17 = new ArrayList<>(listOfListOfRows.get(8));
                    slot17.add(0, "17:00");

                    TimeSlotForGUI row17 = new TimeSlotForGUI(slot17.get(0), slot17.get(1), slot17.get(2), slot17.get(3), slot17.get(4), slot17.get(5));

                    ArrayList<String> slot18 = new ArrayList<>(listOfListOfRows.get(9));
                    slot18.add(0, "18:00");

                    TimeSlotForGUI row18 = new TimeSlotForGUI(slot18.get(0), slot18.get(1), slot18.get(2), slot18.get(3), slot18.get(4), slot18.get(5));

                    ArrayList<String> slot19 = new ArrayList<>(listOfListOfRows.get(10));
                    slot19.add(0, "19:00");

                    TimeSlotForGUI row19 = new TimeSlotForGUI(slot19.get(0), slot19.get(1), slot19.get(2), slot19.get(3), slot19.get(4), slot19.get(5));

                    ArrayList<String> slot20 = new ArrayList<>(listOfListOfRows.get(11));
                    slot20.add(0, "20:00");

                    TimeSlotForGUI row20 = new TimeSlotForGUI(slot20.get(0), slot20.get(1), slot20.get(2), slot20.get(3), slot20.get(4), slot20.get(5));

//                    ArrayList<String> slot21 = new ArrayList<>(listOfListOfRows.get(12));
//                    slot21.add(0, "21:00");
//
//                    TimeSlotForGUI row21 = new TimeSlotForGUI(slot21.get(0), slot21.get(1), slot21.get(2), slot21.get(3), slot21.get(4), slot21.get(5));

                    centerTableView.getItems().add(row9);
                    centerTableView.getItems().add(row10);
                    centerTableView.getItems().add(row11);
                    centerTableView.getItems().add(row12);
                    centerTableView.getItems().add(row13);
                    centerTableView.getItems().add(row14);
                    centerTableView.getItems().add(row15);
                    centerTableView.getItems().add(row16);
                    centerTableView.getItems().add(row17);
                    centerTableView.getItems().add(row18);
                    centerTableView.getItems().add(row19);
                    centerTableView.getItems().add(row20);
//                    centerTableView.getItems().add(row21);



            }


        });

        rightClearBtn.setOnAction(event -> {
            centerTableView.getItems().clear();
        });

        rightVBox.setPrefWidth(170);
        rightVBox.setPrefHeight(376);
        rightVBox.setPadding(new Insets(8, 8, 8, 8));
        rightVBox.setSpacing(10);
        rightVBox.setAlignment(Pos.TOP_CENTER);


        // set the right side of the border pane to be the right vbox.
        borderPane.setRight(rightVBox);







        // The top side of the borderpane.
        HBox topHBox = new HBox();
        TextField topTextField = new TextField("search courses");
        Separator topSeparator = new Separator();
        Button topConfirmButton = new Button("Confirm");
        MenuBar topMenuBar = new MenuBar();
//        Menu topMenuKnit = new Menu("knit");

        Menu topMenuSelect1 = new Menu("timetable1");
        Menu topMenuSelect2 = new Menu("timetable2");
        Menu topMenuSelect3 = new Menu("timetable3");
        Menu topMenuSelect4 = new Menu("timetable4");
        Menu topMenuSelect5 = new Menu("timetable5");

        topMenuBar.getMenus().addAll(topMenuSelect1, topMenuSelect2, topMenuSelect3, topMenuSelect4, topMenuSelect5);
        topMenuBar.setPrefHeight(28);
        topMenuBar.setPrefWidth(700);

        topHBox.getChildren().addAll(topTextField, topSeparator, topConfirmButton, topMenuBar);
        // set the top of the border pane to be the hbox
        borderPane.setTop(topHBox);

        topTextField.setPrefWidth(110);

        topConfirmButton.setOnAction(e -> {
            String confirmedString = topTextField.getText();
            try {
                NewCourse confirmedCourse = WebParse.courseParse(confirmedString);
                if (!confirmedCourse.getCourseCode().equals("")) {
                    leftListView.getItems().add(confirmedString);
                    UserData.inputCourse(confirmedString);
                    System.out.println(confirmedCourse);
                } else {
                    AlertBox.display("Error course code", "The course code you entered is invalid");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });




        // THe bottom side of the borderpane.
        HBox botHBox = new HBox();
        Label botTeamLabel = new Label("CSC207 Dream Team 2021, All Rights Reserved.");
        botHBox.setAlignment(Pos.CENTER);
        botTeamLabel.setAlignment(Pos.CENTER);
        botHBox.getChildren().addAll(botTeamLabel);
        // set the bottom of the border pane to be the hbox
        borderPane.setBottom(botHBox);








        // create a layout
        VBox layout1 = new VBox();
        layout1.setAlignment(Pos.CENTER);
        Label askLabel = new Label("Continue from last edit?");
        Button askButton1 = new Button("Yes");
        askButton1.setOnAction(e -> {
            try {
                ArrayList<String> loadedCourse = UserData.readCourses();
                for (String course: loadedCourse) {
                    leftListView.getItems().add(course);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            window.setScene(root);
        });

        Button askButton2 = new Button("No");
        askButton2.setOnAction(e -> {

            try {
                UserData.initInput();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            window.setScene(root);
        });

        layout1.getChildren().addAll(askLabel, askButton1, askButton2);

        // create a welcome scene
        Scene welcomeScene = new Scene(layout1, 300, 200);


        // scene interaction
        insConfirmButton.setOnAction(e -> {
            try {
                UserData.inputInstructor(insSelected);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            window.setScene(root);
        });

        insBackButton.setOnAction(e -> {
            window.setScene(root);
        });

        maxConfirm.setOnAction(e -> {
            try {
                UserData.inputMaxDuration(maxSelected);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            window.setScene(root);
        });

        maxBack.setOnAction(e -> {
            window.setScene(root);
        });

        timeSlotConfirm.setOnAction(e -> {
            try {
                UserData.inputTimeslot(slotsSelected);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            window.setScene(root);
        });

        timeSlotBack.setOnAction(e -> {
            window.setScene(root);
        });


        topMenuSelect1.setOnAction(e -> {

        });

        topMenuSelect2.setOnAction(e -> {

        });

        topMenuSelect3.setOnAction(e -> {

        });

        topMenuSelect4.setOnAction(e -> {

        });

        topMenuSelect5.setOnAction(e -> {

        });





        stage.setTitle("Course Schedule System");

        if (UserData.inputExists()) {
            stage.setScene(welcomeScene);
        } else {
            stage.setScene(root);
        }

        stage.show();
    }

}