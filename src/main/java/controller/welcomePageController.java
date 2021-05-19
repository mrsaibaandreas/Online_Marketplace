
//        Parent NewCustomer = FXMLLoader.load(getClass().getResource("customerPage.fxml"));
//        Scene NewCustomerScene = new Scene(NewCustomer);
//
//        //Here we get the stage information
//        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
//
//        window.setScene(NewCustomerScene);
//        window.show();

package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class welcomePageController {

    @FXML
    private Text welcomeText;

    @FXML
    private ImageView welcomeImage;

    @FXML
    private Text questionText;

    @FXML
    private Button custommerButton;

    @FXML
    private Button supllierButton;

    @FXML
    void customerButtonAction(ActionEvent event){
    }
    @FXML
    void supplierButtonAction(ActionEvent event){
    }
    @FXML
    private ImageView welcomeIMAGEbackground;

    public void customerButtonAction(javafx.event.ActionEvent actionEvent)  throws IOException {
        Parent NewCustomer = FXMLLoader.load(getClass().getResource("/customerPage.fxml"));
        Scene NewCustomerScene = new Scene(NewCustomer);

        //Here we get the stage information
        Stage window=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        window.setScene(NewCustomerScene);
        window.show();
    }

    public void supplierButtonAction(javafx.event.ActionEvent actionEvent) throws IOException{
        Parent NewCustomer = FXMLLoader.load(getClass().getResource("/supplierPage.fxml"));
        Scene NewCustomerScene = new Scene(NewCustomer);

        //Here we get the stage information
        Stage window=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        window.setScene(NewCustomerScene);
        window.show();
    }
}

