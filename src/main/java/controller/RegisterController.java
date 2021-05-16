package controller;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;

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
    public void handleClick(ActionEvent event) throws IOException {

    try{
        User test = new User(user_name.getText(),pass1.getText(),"user");
        System.out.println(test);
        userService.loadUsersFromFile();
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("user.home"));
        System.out.println(test);
        userService.addNewUser(new User(user_name.getText(),pass1.getText(),"user"));
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }

    }
}
