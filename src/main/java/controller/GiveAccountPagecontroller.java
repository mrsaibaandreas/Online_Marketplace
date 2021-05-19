package controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class GiveAccountPagecontroller {

        @FXML
        private ImageView imagebackgroundAccount;

        @FXML
        private Button giveAccountButton;

        @FXML
        private TextField adminUsernameField;

        @FXML
        private TextField supplierUsernameField;

        @FXML
        private PasswordField AdminpasswordField;

        @FXML
        private Button backButton;

        @FXML
        void AdminpasswordFieldAction(ActionEvent event) {

        }

        @FXML
        void adminUsernameFieldAction(ActionEvent event) {

        }

        @FXML
        void backButtonAction(ActionEvent event) {

        }

        @FXML
        void giveAccountButtonAction(ActionEvent event) {

        }

        @FXML
        void supplierUsernameFieldAction(ActionEvent event) {

        }

    public void giveAccountButtonAction(javafx.event.ActionEvent actionEvent) {
    }

    public void adminUsernameFieldAction(javafx.event.ActionEvent actionEvent) {
    }

    public void supplierUsernameFieldAction(javafx.event.ActionEvent actionEvent) {
    }

    public void AdminpasswordFieldAction(javafx.event.ActionEvent actionEvent) {
    }

    public void backButtonAction(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent NewCustomer = FXMLLoader.load(getClass().getResource("/supplierPage.fxml"));
        Scene NewCustomerScene = new Scene(NewCustomer);

        //Here we get the stage information
        Stage window=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        window.setScene(NewCustomerScene);
        window.show();
    }
}


