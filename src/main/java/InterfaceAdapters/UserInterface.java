package InterfaceAdapters;

import javafx.application.Application;
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

public class UserInterface extends Application {

    Stage window;

    @Override
    public void start(Stage stage) throws IOException {

        window = stage;


        // create a scene for instructor user events
        VBox insVBox = new VBox();
        Label insAsk1 = new Label("Please enter your wanted instructors");
        insAsk1.setFont(Font.font(22));
        TextField wanted1 = new TextField("Instructor 1");
        TextField wanted2 = new TextField("Instructor 2");
        TextField wanted3 = new TextField("Instructor 3");
        Label insAsk2 = new Label("Please enter your unwanted instructors");
        insAsk2.setFont(Font.font(22));
        TextField unwanted1 = new TextField("Instructor 1");
        TextField unwanted2 = new TextField("Instructor 2");
        TextField unwanted3 = new TextField("Instructor 3");
        Button insConfirmButton = new Button("Confirm");
        Button insBackButton = new Button("Back");
        insVBox.getChildren().addAll(insAsk1, wanted1, wanted2, wanted3,
                insAsk2, unwanted1, unwanted2, unwanted3, insConfirmButton, insBackButton);
        insVBox.setAlignment(Pos.TOP_CENTER);

        insVBox.setSpacing(10);
        insVBox.setPadding(new Insets(20, 220, 20, 220));

        Scene insScene = new Scene(insVBox, 855, 516);



        // get value from the instructor scene
        wanted1.getText();
        wanted2.getText();
        wanted3.getText();
        unwanted1.getText();
        unwanted2.getText();
        unwanted3.getText();







        // create a scene for max hour user events
        VBox maxHourVBox = new VBox();
        Label maxAsk = new Label("Please enter your preferred duration of classes each day");
        TextField maxPreferred = new TextField("Ex: 3");
        Button maxConfirm = new Button("Confirm");
        maxHourVBox.getChildren().addAll(maxAsk, maxPreferred, maxConfirm);

        Scene maxScene = new Scene(maxHourVBox, 855, 516);



        // get value from the max hour scene
        maxPreferred.getText();




        // create a scene for time slot user events
        VBox timeSlotVBox = new VBox();
        Label timeAsk = new Label("Please select your unwanted timeslots");
        timeAsk.setFont(Font.font(20));
        GridPane grid = new GridPane();

        VBox box00 = new VBox();
        Label label00 = new Label("Monday");
        ListView<String> list00 = new ListView<>();
        list00.getItems().addAll("9:00 - 10:00", "10:00 - 11:00", "11:00 - 12:00", "12:00 - 13:00",
                "13:00 - 14:00", "14:00 - 15:00", "15:00 - 16:00", "16:00 - 17:00", "17:00 - 18:00", "18:00 - 19:00",
                "19:00 - 20:00", "20:00 - 21:00");
        list00.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        box00.getChildren().addAll(label00, list00);
        box00.setAlignment(Pos.CENTER);
        GridPane.setConstraints(box00, 0, 0);

        VBox box10 = new VBox();
        Label label10 = new Label("Tuesday");
        ListView<String> list10 = new ListView<>();
        list10.getItems().addAll("9:00 - 10:00", "10:00 - 11:00", "11:00 - 12:00", "12:00 - 13:00",
                "13:00 - 14:00", "14:00 - 15:00", "15:00 - 16:00", "16:00 - 17:00", "17:00 - 18:00", "18:00 - 19:00",
                "19:00 - 20:00", "20:00 - 21:00");
        list10.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        box10.getChildren().addAll(label10, list10);
        box10.setAlignment(Pos.CENTER);
        GridPane.setConstraints(box10, 1, 0);

        VBox box20 = new VBox();
        Label label20 = new Label("Wednesday");
        ListView<String> list20 = new ListView<>();
        list20.getItems().addAll("9:00 - 10:00", "10:00 - 11:00", "11:00 - 12:00", "12:00 - 13:00",
                "13:00 - 14:00", "14:00 - 15:00", "15:00 - 16:00", "16:00 - 17:00", "17:00 - 18:00", "18:00 - 19:00",
                "19:00 - 20:00", "20:00 - 21:00");
        list20.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        box20.getChildren().addAll(label20, list20);
        box20.setAlignment(Pos.CENTER);
        GridPane.setConstraints(box20, 2, 0);

        VBox box01 = new VBox();
        Label label01 = new Label("Thursday");
        ListView<String> list01 = new ListView<>();
        list01.getItems().addAll("9:00 - 10:00", "10:00 - 11:00", "11:00 - 12:00", "12:00 - 13:00",
                "13:00 - 14:00", "14:00 - 15:00", "15:00 - 16:00", "16:00 - 17:00", "17:00 - 18:00", "18:00 - 19:00",
                "19:00 - 20:00", "20:00 - 21:00");
        list01.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        box01.getChildren().addAll(label01, list01);
        box01.setAlignment(Pos.CENTER);
        GridPane.setConstraints(box01, 0, 1);

        VBox box11 = new VBox();
        Label label11 = new Label("Friday");
        ListView<String> list11 = new ListView<>();
        list11.getItems().addAll("9:00 - 10:00", "10:00 - 11:00", "11:00 - 12:00", "12:00 - 13:00",
                "13:00 - 14:00", "14:00 - 15:00", "15:00 - 16:00", "16:00 - 17:00", "17:00 - 18:00", "18:00 - 19:00",
                "19:00 - 20:00", "20:00 - 21:00");
        list11.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        box11.getChildren().addAll(label11, list11);
        box11.setAlignment(Pos.CENTER);
        GridPane.setConstraints(box11, 1, 1);


        Button timeSlotConfirm = new Button("Confirm");
        GridPane.setConstraints(timeSlotConfirm, 2, 1);

        grid.getChildren().addAll(box00, box10, box20, box01, box11, timeSlotConfirm);

        timeSlotVBox.getChildren().addAll(timeAsk, grid);
        timeSlotVBox.setAlignment(Pos.CENTER);

        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setAlignment(Pos.CENTER);

        Scene timeSlotScene = new Scene(timeSlotVBox, 885, 516);


        // get value from the timeslot scene

        list00.getSelectionModel().getSelectedItems();
        list10.getSelectionModel().getSelectedItems();
        list20.getSelectionModel().getSelectedItems();
        list01.getSelectionModel().getSelectedItems();
        list11.getSelectionModel().getSelectedItems();







        // main scene
        // The largest layer. The borderpane.
        BorderPane borderPane = new BorderPane();

        // The left side of the borderpane.
        ListView<String> leftListView = new ListView<>();
        // set the left of the border pane to be the hbox
        borderPane.setLeft(leftListView);

        leftListView.setPrefWidth(186);



        // The right side of the borderpane.
        VBox rightVBox = new VBox();
        Label rightLabel = new Label("Choose filter:");
        RadioButton insRadioButton = new RadioButton("Instructor");
        RadioButton maxHourRadioButton = new RadioButton("Max Hour");
        RadioButton timeSlotRadioButton = new RadioButton("Time Slot");

        final ToggleGroup group = new ToggleGroup();
        insRadioButton.setToggleGroup(group);
        maxHourRadioButton.setToggleGroup(group);
        timeSlotRadioButton.setToggleGroup(group);

        Button rightConfirmButton = new Button("Confirm");

        rightVBox.getChildren().addAll(rightLabel, insRadioButton, maxHourRadioButton,
                timeSlotRadioButton, rightConfirmButton);

        rightConfirmButton.setOnAction(e -> {
            if (insRadioButton.isSelected()) {
                window.setScene(insScene);
            } else if (maxHourRadioButton.isSelected()) {
                window.setScene(maxScene);
            } else { // time slot button is selected
                window.setScene(timeSlotScene);
            }
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
        Button topSearchButton = new Button("search");
        MenuBar topMenuBar = new MenuBar();
        Menu topMenuKnit = new Menu("knit");
        Menu topMenuSelect = new Menu("select timetable");
        topMenuBar.getMenus().addAll(topMenuKnit, topMenuSelect);
        topMenuBar.setPrefHeight(28);
        topMenuBar.setPrefWidth(700);

        topHBox.getChildren().addAll(topTextField, topSeparator, topSearchButton, topMenuBar);
        // set the top of the border pane to be the hbox
        borderPane.setTop(topHBox);

        topTextField.setPrefWidth(120);




        // THe bottom side of the borderpane.
        HBox botHBox = new HBox();
        Label botTeamLabel = new Label("CSC207 Dream Team 2021, All Rights Reserved.");
        botHBox.getChildren().addAll(botTeamLabel);
        // set the bottom of the border pane to be the hbox
        borderPane.setBottom(botHBox);



        // The center of the borderpane.
        TableView<TimeSlotForGUI> centerTableView = new TableView<>();

        TableColumn<TimeSlotForGUI, String> timeSlotColumn = new TableColumn<>("Time Slots");
        timeSlotColumn.setCellValueFactory(new PropertyValueFactory<>("Time Slot"));

        TableColumn<TimeSlotForGUI, String> mondayColumn = new TableColumn<>("Monday");
        mondayColumn.setCellValueFactory(new PropertyValueFactory<>("MondaySession"));

        TableColumn<TimeSlotForGUI, String> tuesdayColumn = new TableColumn<>("Tuesday");
        tuesdayColumn.setCellValueFactory(new PropertyValueFactory<>("TuesdaySession"));

        TableColumn<TimeSlotForGUI, String> wednesdayColumn = new TableColumn<>("Wednesday");
        wednesdayColumn.setCellValueFactory(new PropertyValueFactory<>("WednesdaySession"));

        TableColumn<TimeSlotForGUI, String> thursdayColumn = new TableColumn<>("Thursday");
        thursdayColumn.setCellValueFactory(new PropertyValueFactory<>("ThursdaySession"));

        TableColumn<TimeSlotForGUI, String> fridayColumn = new TableColumn<>("Friday");
        fridayColumn.setCellValueFactory(new PropertyValueFactory<>("FridaySession"));

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

        TimeSlotForGUI line1 = new TimeSlotForGUI("CSC207LEC", "CSC207TUT", null, null, null);
        TimeSlotForGUI line2 = new TimeSlotForGUI("CSC207LEC", "CSC207TUT", null, null, null);

        centerTableView.getItems().add(line1);
        centerTableView.getItems().add(line2);

        // set the table view to be the center of the border pane.
        borderPane.setCenter(centerTableView);


        Scene root = new Scene(borderPane, 885, 516);





        // create a layout
        VBox layout1 = new VBox();
        layout1.setAlignment(Pos.CENTER);
        Label askLabel = new Label("Continue from last edit?");
        Button askButton1 = new Button("Yes");
        askButton1.setOnAction(e -> {
            window.setScene(root);
        });

        Button askButton2 = new Button("No");
        askButton2.setOnAction(e -> {
            window.setScene(root);
        });

        layout1.getChildren().addAll(askLabel, askButton1, askButton2);

        // create a welcome scene
        Scene welcomeScene = new Scene(layout1, 300, 200);


        // scene interaction
        insConfirmButton.setOnAction(e -> {
            window.setScene(root);
        });

        insBackButton.setOnAction(e -> {
            window.setScene(root);
        });

        maxConfirm.setOnAction(e -> {
            window.setScene(root);
        });

        timeSlotConfirm.setOnAction(e -> {
            window.setScene(root);
        });







        stage.setTitle("Hello!");
        stage.setScene(welcomeScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}