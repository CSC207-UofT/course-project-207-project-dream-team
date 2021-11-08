package com.example.gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {
    public static void display(){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        Button close = new Button("Close the window");
        close.setOnAction(e -> window.close());
        Label label = new Label("We detected you have an unfinished input, \n would you like to continue?");
        VBox layout = new VBox(20);
        layout.getChildren().addAll(label, close);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout, 300, 100);
        window.setTitle("Piao");
        window.setScene(scene);
        window.show();
    }
}
