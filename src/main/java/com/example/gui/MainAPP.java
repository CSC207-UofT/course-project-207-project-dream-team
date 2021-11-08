package com.example.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainAPP extends Application {
    @Override
    public void start(Stage stage1) throws IOException {
        Button button = new Button();
        button.setText("click me");
        button.setOnAction(e -> AlertBox.display());
        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 300, 300);

        stage1.setScene(scene);
        stage1.setTitle("Piao");
        stage1.show();
    }


    public static void main(String[] args) {
        launch();
    }
}