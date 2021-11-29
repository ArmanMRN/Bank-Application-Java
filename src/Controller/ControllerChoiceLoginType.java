package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerChoiceLoginType{

    static Stage stage;
    static Parent root;

    public void Open() throws IOException {

        stage = new Stage();

        root = FXMLLoader.load(getClass().getResource("/view/ChoiceLoginType.fxml"));
        stage.setTitle("Login");
        stage.setScene(new Scene(root , 600 , 400));
        stage.show();

    }

    @FXML
    private Button managerLoginButton;

    @FXML
    private Button bankerLoginButton;

    @FXML
    void bankerLoginButtonAction(ActionEvent event) throws IOException {

        stage.close();
        BankerLoginPageController loginPage = new BankerLoginPageController();
        loginPage.OpenPage();
    }

    @FXML
    void managerLoginButtonAction(ActionEvent event) throws IOException {

        stage.close();
        ManagerLoginPageController loginPage = new ManagerLoginPageController();
        loginPage.OpenPage();

    }

}
