package InterfaceAdapters;

import FrameworksDrivers.UserData;
import InterfaceAdapters.ConvertToUI;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class UserInterface extends Application {

    Stage window;

    @Override
    public void start(Stage primaryStage) throws IOException {

        window = primaryStage;


        URL fxmlLocation = getClass().getResource("/main.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(fxmlLocation);
        Scene scene = new Scene(fxmlLoader.load(), 764, 390);


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

        ArrayList<String> unwantedInsList = new ArrayList<>();
        unwantedInsList.add(unwanted1.getText());
        unwantedInsList.add(unwanted2.getText());
        unwantedInsList.add(unwanted3.getText());
        unwantedInsList.add(unwanted4.getText());
        unwantedInsList.add(unwanted5.getText());
        unwantedInsList.add(unwanted6.getText());

        Button insConfirmButton = new Button("Confirm");
        Button insBackButton = new Button("Back");

        insVBox.getChildren().addAll(insAsk2, unwanted1, unwanted2, unwanted3,
                unwanted4, unwanted5, unwanted6, insConfirmButton, insBackButton);
        insVBox.setAlignment(Pos.TOP_CENTER);

        insVBox.setSpacing(10);
        insVBox.setPadding(new Insets(20, 200, 20, 200));

        Scene insScene = new Scene(insVBox, 764, 390);




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

        ArrayList<String> prefferedListMon = new ArrayList<>(list00.getItems());
        ArrayList<String> prefferedListTue = new ArrayList<>(list10.getItems());
        ArrayList<String> prefferedListWed = new ArrayList<>(list20.getItems());
        ArrayList<String> prefferedListThu = new ArrayList<>(list01.getItems());
        ArrayList<String> prefferedListFri = new ArrayList<>(list11.getItems());

        ArrayList<String> prefferedList1 = ConvertToUI.timeslotToUI(1, prefferedListMon);
        ArrayList<String> prefferedList2 = ConvertToUI.timeslotToUI(2, prefferedListTue);
        ArrayList<String> prefferedList3 = ConvertToUI.timeslotToUI(3, prefferedListWed);
        ArrayList<String> prefferedList4 = ConvertToUI.timeslotToUI(4, prefferedListThu);
        ArrayList<String> prefferedList5 = ConvertToUI.timeslotToUI(5, prefferedListFri);

        prefferedList1.addAll(prefferedList2);
        prefferedList1.addAll(prefferedList3);
        prefferedList1.addAll(prefferedList4);
        prefferedList1.addAll(prefferedList5);

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

        Scene timeSlotScene = new Scene(timeSlotVBox, 764, 390);




        // create a scene for max hour filter event
        VBox maxHourVBox = new VBox();
        Label maxAsk = new Label("Please enter your preferred duration of classes each day");
        TextField maxPreferred = new TextField();

        String preferredMax = maxPreferred.getText();

        Button maxConfirm = new Button("Confirm");
        Button maxBack = new Button("Back");
        maxHourVBox.getChildren().addAll(maxAsk, maxPreferred, maxConfirm, maxBack);

        maxHourVBox.setAlignment(Pos.TOP_CENTER);
        maxHourVBox.setPadding(new Insets(20, 220, 20, 220));
        maxHourVBox.setSpacing(8);

        Scene maxScene = new Scene(maxHourVBox, 764, 390);




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
            } else if (rb3.isSelected()){
                window.setScene(timeSlotScene);
            } else {
                window.setScene(scene);
            }
        });

        Button askButton2 = new Button("No");

        askButton2.setOnAction(e -> {
            try {
                UserData.initInput();
                UserData.clearCourses();
                UserData.removeAll();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            if (rb1.isSelected()) {
                window.setScene(insScene);
            } else if (rb2.isSelected()) {
                window.setScene(maxScene);
            } else if (rb3.isSelected()) {
                window.setScene(timeSlotScene);
            } else {
                window.setScene(scene);
            }
        });

        Button highContrastBtn = new Button("High Contrast Mode");
        highContrastBtn.setStyle("-fx-background-color: #0027FF; -fx-text-fill: #FBFF00");

        layout1.getChildren().addAll(askLabel, askButton1, askButton2, chooseFilterLabel, rb1, rb2, rb3, highContrastBtn);

        // create a welcome scene
        Scene welcomeScene = new Scene(layout1, 300, 250);


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

        Button highContrastBtnNew = new Button("High Contrast Mode");
        highContrastBtnNew.setStyle("-fx-background-color: #0027FF; -fx-text-fill: #FBFF00");

        layout2.getChildren().addAll(rb4, rb5, rb6, welcomeConfirmBtn, welcomeNewBack, highContrastBtnNew);

        Scene welcomeSceneNew = new Scene(layout2, 300, 250);

        if (UserData.inputExists()) {
            window.setScene(welcomeScene);
        } else {
            window.setScene(welcomeSceneNew);
        }

        insConfirmButton.setOnAction(e -> {
            try {
                UserData.inputInstructor(unwantedInsList);
            } catch (IOException c) {
                c.printStackTrace();
            }
            window.setScene(scene);
        });

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
            try {

                UserData.inputTimeslot(prefferedList1);
            } catch (IOException c) {
                c.printStackTrace();
            }
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
            try {
                UserData.inputMaxDuration(preferredMax);
            } catch (IOException c) {
                c.printStackTrace();
            }
            window.setScene(scene);
        });

        maxBack.setOnAction(e -> {
            if (UserData.getFlag() == 1) {
                window.setScene(welcomeScene);
            } else {
                window.setScene(welcomeSceneNew);
            }
        });

        highContrastBtn.setOnAction(e -> {
            BackgroundFill background_fill = new BackgroundFill(Color.web("#0027FF"),
                    CornerRadii.EMPTY, Insets.EMPTY);
            Background bkg = new Background(background_fill);
            layout1.setBackground(bkg);
            layout2.setBackground(bkg);
            maxHourVBox.setBackground(bkg);
            insVBox.setBackground(bkg);
            timeSlotVBox.setBackground(bkg);

            // welcome
            askLabel.setStyle("-fx-text-fill: #FBFF00");
            chooseFilterLabel.setStyle("-fx-text-fill: #FBFF00");
            rb1.setStyle("-fx-text-fill: #FBFF00");
            rb2.setStyle("-fx-text-fill: #FBFF00");
            rb3.setStyle("-fx-text-fill: #FBFF00");
            rb4.setStyle("-fx-text-fill: #FBFF00");
            rb5.setStyle("-fx-text-fill: #FBFF00");
            rb6.setStyle("-fx-text-fill: #FBFF00");

            // ins
            insAsk2.setStyle("-fx-text-fill: #FBFF00");
            unwanted1.setStyle("-fx-text-fill: #FBFF00");
            unwanted2.setStyle("-fx-text-fill: #FBFF00");
            unwanted3.setStyle("-fx-text-fill: #FBFF00");
            unwanted4.setStyle("-fx-text-fill: #FBFF00");
            unwanted5.setStyle("-fx-text-fill: #FBFF00");
            unwanted6.setStyle("-fx-text-fill: #FBFF00");
            insConfirmButton.setStyle("-fx-background-color: #0027FF; -fx-text-fill: #FBFF00");
            insBackButton.setStyle("-fx-background-color: #0027FF; -fx-text-fill: #FBFF00");

            //timeSlot
            timeAsk.setStyle("-fx-text-fill: #FBFF00");
            label00.setStyle("-fx-text-fill: #FBFF00");
            label10.setStyle("-fx-text-fill: #FBFF00");
            label20.setStyle("-fx-text-fill: #FBFF00");
            label01.setStyle("-fx-text-fill: #FBFF00");
            label11.setStyle("-fx-text-fill: #FBFF00");
            timeSlotConfirm.setStyle("-fx-background-color: #0027FF; -fx-text-fill: #FBFF00");
            timeSlotBack.setStyle("-fx-background-color: #0027FF; -fx-text-fill: #FBFF00");

            //max
            maxAsk.setStyle("-fx-text-fill: #FBFF00");
            maxConfirm.setStyle("-fx-background-color: #0027FF; -fx-text-fill: #FBFF00");
            maxBack.setStyle("-fx-background-color: #0027FF; -fx-text-fill: #FBFF00");

        });

        highContrastBtnNew.setOnAction(e -> {
            BackgroundFill background_fill = new BackgroundFill(Color.web("#0027FF"),
                    CornerRadii.EMPTY, Insets.EMPTY);
            Background bkg = new Background(background_fill);
            layout1.setBackground(bkg);
            layout2.setBackground(bkg);
            maxHourVBox.setBackground(bkg);
            insVBox.setBackground(bkg);
            timeSlotVBox.setBackground(bkg);

            // welcome
            askLabel.setStyle("-fx-text-fill: #FBFF00");
            chooseFilterLabel.setStyle("-fx-text-fill: #FBFF00");
            rb1.setStyle("-fx-text-fill: #FBFF00");
            rb2.setStyle("-fx-text-fill: #FBFF00");
            rb3.setStyle("-fx-text-fill: #FBFF00");
            rb4.setStyle("-fx-text-fill: #FBFF00");
            rb5.setStyle("-fx-text-fill: #FBFF00");
            rb6.setStyle("-fx-text-fill: #FBFF00");

            // ins
            insAsk2.setStyle("-fx-text-fill: #FBFF00");
            unwanted1.setStyle("-fx-text-fill: #FBFF00");
            unwanted2.setStyle("-fx-text-fill: #FBFF00");
            unwanted3.setStyle("-fx-text-fill: #FBFF00");
            unwanted4.setStyle("-fx-text-fill: #FBFF00");
            unwanted5.setStyle("-fx-text-fill: #FBFF00");
            unwanted6.setStyle("-fx-text-fill: #FBFF00");
            insConfirmButton.setStyle("-fx-background-color: #0027FF; -fx-text-fill: #FBFF00");
            insBackButton.setStyle("-fx-background-color: #0027FF; -fx-text-fill: #FBFF00");

            //timeSlot
            timeAsk.setStyle("-fx-text-fill: #FBFF00");
            label00.setStyle("-fx-text-fill: #FBFF00");
            label10.setStyle("-fx-text-fill: #FBFF00");
            label20.setStyle("-fx-text-fill: #FBFF00");
            label01.setStyle("-fx-text-fill: #FBFF00");
            label11.setStyle("-fx-text-fill: #FBFF00");
            timeSlotConfirm.setStyle("-fx-background-color: #0027FF; -fx-text-fill: #FBFF00");
            timeSlotBack.setStyle("-fx-background-color: #0027FF; -fx-text-fill: #FBFF00");

            //max
            maxAsk.setStyle("-fx-text-fill: #FBFF00");
            maxConfirm.setStyle("-fx-background-color: #0027FF; -fx-text-fill: #FBFF00");
            maxBack.setStyle("-fx-background-color: #0027FF; -fx-text-fill: #FBFF00");
        });

        primaryStage.setTitle("Course Schedule and Recommendation System");
        primaryStage.show();
    }

}