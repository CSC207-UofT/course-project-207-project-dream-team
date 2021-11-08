package com.example.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GuiMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane root=new AnchorPane();
        Scene scene=new Scene(root,600,400);
        TextField textField=new TextField("Gradle JavaFX");
        root.getChildren().add(textField);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
