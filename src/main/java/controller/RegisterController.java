package controller;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.stage.Stage;
import services.userService;


import java.io.IOException;


public class RegisterController {

    @FXML
    private TextField user_name;

    @FXML
    private PasswordField pass1;

    @FXML
    private PasswordField pass2;

    @FXML
    Button reg_button;

    @FXML
    public boolean handleClick(ActionEvent event) throws IOException {

    try{
        User test = new User(user_name.getText(),pass1.getText(),"user");
        userService.loadUsersFromFile();
        System.out.println("test"+test);
        return userService.addNewUser(new User(user_name.getText(), pass1.getText(), "user"));
    }
    catch(Exception e)
    {
        e.printStackTrace();
        return false;
    }



    @FXML
    public void goBackButtonAction(ActionEvent actionEvent) throws IOException{
        Parent NewCustomer = FXMLLoader.load(getClass().getResource("/customerPage.fxml"));
        Scene NewCustomerScene = new Scene(NewCustomer);

        //Here we get the stage information
        Stage window=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        window.setScene(NewCustomerScene);
        window.show();
    }
}
