package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import services.userService;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class LoginSupplierController {
        @FXML
        private PasswordField writePassword;

        @FXML
        private TextField writeUsername;

        @FXML
        private Label usernameText;

        @FXML
        private Label passwordText;

        @FXML
        private Button loginButton;

        @FXML
        private ImageView imageCenter;

        @FXML
        private Button backButton;

        @FXML
        void backButtonAction(ActionEvent event){

        }

        @FXML
        void loginButtonAction(ActionEvent event) {

        }

        @FXML
        void writePasswordAction(ActionEvent event) {

        }

        @FXML
        void writeUsernameAction(ActionEvent event) {

        }

        public void backButtonAction(javafx.event.ActionEvent actionEvent) throws IOException {
            Parent NewCustomer = FXMLLoader.load(getClass().getResource("/supplierPage.fxml"));
            Scene NewCustomerScene = new Scene(NewCustomer);

            //Here we get the stage information
            Stage window=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();

            window.setScene(NewCustomerScene);
            window.show();
        }

        public void writePasswordAction(javafx.event.ActionEvent actionEvent) {
        }

        public void writeUsernameAction(javafx.event.ActionEvent actionEvent) {
        }

        public void loginButtonAction(javafx.event.ActionEvent actionEvent) throws IOException{
            // !--------------------------   MODIFICA ANDREAS   --------------------------!  // pt login cu cont de la admin pt supplier

                Parent NewCustomer = FXMLLoader.load(getClass().getResource("/LoggedINSUPPLIER.fxml"));
                Scene NewCustomerScene = new Scene(NewCustomer);

                //Here we get the stage information
                Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

                window.setScene(NewCustomerScene);
                window.show();
            }
}

