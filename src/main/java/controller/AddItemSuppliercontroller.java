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


public class AddItemSuppliercontroller {

        @FXML
        private ImageView imageBackground;

        @FXML
        private Button gobackButton;
        @FXML
        private Button add;
        @FXML
        void add(ActionEvent event){

        }
        @FXML
        void gobackButtonAction(ActionEvent event) {

        }
        
    public void gobackButtonAction(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent NewCustomer = FXMLLoader.load(getClass().getResource("/LoggedINSUPPLIER.fxml"));
        Scene NewCustomerScene = new Scene(NewCustomer);

        //Here we get the stage information
        Stage window=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        window.setScene(NewCustomerScene);
        window.show();
    }
}
