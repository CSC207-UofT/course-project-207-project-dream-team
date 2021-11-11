package com.example.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML
    private TextField searchField;

    @FXML
    private Button searchButton;

    public String searchButtonClicked() throws IOException {
        System.out.println("user pressed the search button");
        System.out.println(searchField.getText());
        return searchField.getText();
    }

    public void exportMenuClicked() {

    }

    public void saveMenuClicked() {

    }

    public void selectMenuClicked() {

    }

    public void fallMenuClicked() {

    }

    public void winterMenuClicked() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    public void onHelloButtonClick(ActionEvent actionEvent) {
    }
}