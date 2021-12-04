package InterfaceAdapters;

import FrameworksDrivers.UserData;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class UserInterface extends Application {

    Stage window;

    @Override
    public void start(Stage primaryStage) throws IOException {

        window = primaryStage;


        URL fxmlLocation = getClass().getResource("/main.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(fxmlLocation);
        Scene scene = new Scene(fxmlLoader.load(), 885, 516);


        // create a scene for instructor filter event
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




        // create a scene for timeslot filter event
        VBox timeSlotVBox = new VBox();
        Label timeAsk = new Label("Please select your unwanted timeslots");
        timeAsk.setFont(Font.font(20));
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);

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

        ObservableList<String> prefferedSlotMonday = list00.getSelectionModel().getSelectedItems();

        VBox box21 = new VBox();
        box21.setAlignment(Pos.CENTER);
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




        // create a scene for max hour filter event
        VBox maxHourVBox = new VBox();
        Label maxAsk = new Label("Please enter your preferred duration of classes each day");
        TextField maxPreferred = new TextField("Ex: 3");

        String preferredMax = maxPreferred.getText();

        Button maxConfirm = new Button("Confirm");
        Button maxBack = new Button("Back");
        maxHourVBox.getChildren().addAll(maxAsk, maxPreferred, maxConfirm, maxBack);

        maxHourVBox.setAlignment(Pos.TOP_CENTER);
        maxHourVBox.setPadding(new Insets(20, 220, 20, 220));
        maxHourVBox.setSpacing(8);

        Scene maxScene = new Scene(maxHourVBox, 855, 516);




        // create a layout
        VBox layout1 = new VBox();
        layout1.setAlignment(Pos.CENTER);
        layout1.setSpacing(6);
        Label askLabel = new Label("Continue from last edit?");

        Label chooseFilterLabel = new Label("Please choose your wanted filter.");

        ToggleGroup toggleGroup = new ToggleGroup();
        RadioButton rb1 = new RadioButton("Instructor");
        RadioButton rb2 = new RadioButton("Max Hour");
        RadioButton rb3 = new RadioButton("Time Slot");
        rb1.setToggleGroup(toggleGroup);
        rb2.setToggleGroup(toggleGroup);
        rb3.setToggleGroup(toggleGroup);

        Button askButton1 = new Button("Yes");

        askButton1.setOnAction(e -> {
            if (rb1.isSelected()) {
                window.setScene(insScene);
            } else if (rb2.isSelected()) {
                window.setScene(maxScene);
            } else {
                window.setScene(timeSlotScene);
            }
        });

        Button askButton2 = new Button("No");

        askButton2.setOnAction(e -> {
            if (rb1.isSelected()) {
                window.setScene(insScene);
            } else if (rb2.isSelected()) {
                window.setScene(maxScene);
            } else {
                window.setScene(timeSlotScene);
            }
        });

        layout1.getChildren().addAll(askLabel, askButton1, askButton2, chooseFilterLabel, rb1, rb2, rb3);

        // create a welcome scene
        Scene welcomeScene = new Scene(layout1, 300, 200);


        // welcome scene when input not exist
        VBox layout2 = new VBox();
        layout2.setAlignment(Pos.CENTER);
        layout2.setSpacing(6);

        ToggleGroup toggleGroup1 = new ToggleGroup();
        RadioButton rb4 = new RadioButton("Instructor");
        RadioButton rb5 = new RadioButton("Max Hour");
        RadioButton rb6 = new RadioButton("Time Slot");
        rb4.setToggleGroup(toggleGroup1);
        rb5.setToggleGroup(toggleGroup1);
        rb6.setToggleGroup(toggleGroup1);

        Button welcomeConfirmBtn = new Button("Confirm");
        Button welcomeNewBack = new Button("Back");

        welcomeConfirmBtn.setOnAction(e -> {
            if (rb4.isSelected()) {
                window.setScene(insScene);
            } else if (rb5.isSelected()) {
                window.setScene(maxScene);
            } else if (rb6.isSelected()){
                window.setScene(timeSlotScene);
            } else {
                window.setScene(scene);
            }
        });

        layout2.getChildren().addAll(rb4, rb5, rb6, welcomeConfirmBtn, welcomeNewBack);

        Scene welcomeSceneNew = new Scene(layout2, 300, 200);

        if (UserData.inputExists()) {
            window.setScene(welcomeScene);
        } else {
            window.setScene(welcomeSceneNew);
        }

        insBackButton.setOnAction(e -> {
            if (UserData.getFlag() == 1) {
                window.setScene(welcomeScene);
            } else {
                window.setScene(welcomeSceneNew);
            }
        });

        welcomeNewBack.setOnAction(e -> {
            if (UserData.getFlag() == 1) {
                window.setScene(welcomeScene);
            } else {
                window.setScene(welcomeSceneNew);
            }
        });

        timeSlotConfirm.setOnAction(e -> {
            window.setScene(scene);
        });

        timeSlotBack.setOnAction(e -> {
            if (UserData.getFlag() == 1) {
                window.setScene(welcomeScene);
            } else {
                window.setScene(welcomeSceneNew);
            }
        });

        maxConfirm.setOnAction(e -> {
            window.setScene(scene);
        });

        maxBack.setOnAction(e -> {
            if (UserData.getFlag() == 1) {
                window.setScene(welcomeScene);
            } else {
                window.setScene(welcomeSceneNew);
            }
        });



        primaryStage.setTitle("CSC207 dream team");
        primaryStage.show();
    }

}