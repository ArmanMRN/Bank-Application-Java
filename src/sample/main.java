package sample;


import Controller.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

        ControllerChoiceLoginType loginType = new ControllerChoiceLoginType();
        loginType.Open();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
