package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class customerPageController {

    @FXML
    private Pane pane;

    @FXML
    private ImageView imagerightcorner;

    @FXML
    private ImageView imageCenter;

    @FXML
    private Button registerButton;

    @FXML
    private Button loginButton;

    @FXML
    void loginButtonAction(ActionEvent event) {
    }

    @FXML
    private Button goBackButton;

    @FXML
    void goBackButtonAction(ActionEvent event) {

    }

    @FXML
    void registerButtonAction(ActionEvent event) {

    }

    public void registerButtonAction(javafx.event.ActionEvent actionEvent) throws IOException{
        Parent NewCustomer = FXMLLoader.load(getClass().getResource("/register.fxml"));
        Scene NewCustomerScene = new Scene(NewCustomer);

        //Here we get the stage information
        Stage window=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        window.setScene(NewCustomerScene);
        window.show();
    }

    public void loginButtonAction(javafx.event.ActionEvent actionEvent)  throws IOException {
        Parent NewCustomer = FXMLLoader.load(getClass().getResource("/login.fxml"));
        Scene NewCustomerScene = new Scene(NewCustomer);

        //Here we get the stage information
        Stage window=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        window.setScene(NewCustomerScene);
        window.show();
    }

    public void goBackButtonAction(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent NewCustomer = FXMLLoader.load(getClass().getResource("/welcomePage.fxml"));
        Scene NewCustomerScene = new Scene(NewCustomer);

        //Here we get the stage information
        Stage window=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        window.setScene(NewCustomerScene);
        window.show();
    }
}
