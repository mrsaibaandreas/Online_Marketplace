package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class ViewActiveProductscontroller {

    @FXML
    private VBox Vbox;

    @FXML
    private Button showAllButton;

    @FXML
    private Button searchButton;

    @FXML
    private TextField textfieldSearch;

    @FXML
    void searchButtonAction(ActionEvent event) {

    }

    @FXML
    void showAllButtonAction(ActionEvent event) {

    }

    @FXML
    void textfieldSearchAction(ActionEvent event) {

    }
    @FXML
    private Button gobackButton;

    @FXML
    void gobackButtonAction(ActionEvent event) {

    }

    public void showAllButtonAction(javafx.event.ActionEvent actionEvent) {
    }

    public void searchButtonAction(javafx.event.ActionEvent actionEvent) {
    }

    public void textfieldSearchAction(javafx.event.ActionEvent actionEvent) {
    }

    public void gobackButtonAction(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent NewCustomer = FXMLLoader.load(getClass().getResource("/LoggedINCUSTOMER.fxml"));
        Scene NewCustomerScene = new Scene(NewCustomer);

        //Here we get the stage information
        Stage window=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        window.setScene(NewCustomerScene);
        window.show();
    }
}
