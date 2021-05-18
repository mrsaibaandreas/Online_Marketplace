package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class LoggedINCUSTOMER {

    @FXML
    private ImageView backgroundImage;

    @FXML
    private Button viewProductsButton;

    @FXML
    private Button viewHistoryButton;

    @FXML
    private Button viewActiveOrdersButton;

    @FXML
    void viewActiveOrdersButtonAction(ActionEvent event) {

    }

    @FXML
    void viewHistoryButtonAction(ActionEvent event) {

    }

    @FXML
    void viewProductsButtonAction(ActionEvent event) {

    }

    public void viewProductsButtonAction(javafx.event.ActionEvent actionEvent) throws IOException{
        Parent NewCustomer = FXMLLoader.load(getClass().getResource("/viewActiveProducts.fxml"));
        Scene NewCustomerScene = new Scene(NewCustomer);

        //Here we get the stage information
        Stage window=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        window.setScene(NewCustomerScene);
        window.show();
    }

    public void viewHistoryButtonAction(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent NewCustomer = FXMLLoader.load(getClass().getResource("/viewHistoryOrdersCustomer.fxml"));
        Scene NewCustomerScene = new Scene(NewCustomer);

        //Here we get the stage information
        Stage window=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        window.setScene(NewCustomerScene);
        window.show();
    }

    public void viewActiveOrdersButtonAction(javafx.event.ActionEvent actionEvent) {
    }
}
