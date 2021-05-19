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

public class LoggedINSUPPLIER {

        @FXML
        private ImageView backgroundSUPPLIER;

        @FXML
        private Button viewItemsListedButton;

        @FXML
        private Button logOutButton;

        @FXML
        void logOutButtonAction(ActionEvent event) {

        }
    @FXML
    private Button viewActiveOrdersButton;

    @FXML
    private Button addItemButton;

        @FXML
        void viewItemsListedButtonAction(ActionEvent event) {

        }

    public void viewItemsListedButtonAction(javafx.event.ActionEvent actionEvent) throws IOException{
        Parent NewCustomer = FXMLLoader.load(getClass().getResource("/viewItemsListed.fxml"));
        Scene NewCustomerScene = new Scene(NewCustomer);

        //Here we get the stage information
        Stage window=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        window.setScene(NewCustomerScene);
        window.show();
    }

    public void logOutButtonAction(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent NewCustomer = FXMLLoader.load(getClass().getResource("/welcomePage.fxml"));
        Scene NewCustomerScene = new Scene(NewCustomer);

        //Here we get the stage information
        Stage window=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        window.setScene(NewCustomerScene);
        window.show();
    }

    public void viewActiveOrdersButtonAction(javafx.event.ActionEvent actionEvent) throws IOException{
        Parent NewCustomer = FXMLLoader.load(getClass().getResource("/activeOrdersSupplier.fxml"));
        Scene NewCustomerScene = new Scene(NewCustomer);

        //Here we get the stage information
        Stage window=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        window.setScene(NewCustomerScene);
        window.show();
    }

    public void addItemButtonAction(javafx.event.ActionEvent actionEvent) throws IOException{
        Parent NewCustomer = FXMLLoader.load(getClass().getResource("/addItemSupplier.fxml"));
        Scene NewCustomerScene = new Scene(NewCustomer);

        //Here we get the stage information
        Stage window=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        window.setScene(NewCustomerScene);
        window.show();
    }
}
