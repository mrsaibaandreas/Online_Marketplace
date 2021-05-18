import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        try {
//            Parent root = FXMLLoader.load(getClass().getResource("welcomePage.fxml"));
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("welcomePage.fxml"));
            primaryStage.setTitle("Online Market Place");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}