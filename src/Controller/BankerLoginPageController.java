package Controller;

import Connector.UserNamePasswordCheck;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class BankerLoginPageController {

    static Stage stage;
    Parent root;

    public void OpenPage() throws IOException {

        stage = new Stage();

        root = FXMLLoader.load(getClass().getResource("/view/BankerLoginPage.fxml"));
        stage.setTitle("Banker Login Page");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();

    }

    @FXML
    private Text cardIDDD;

    @FXML
    private TextField userNameText;

    @FXML
    private PasswordField passwordText;

    @FXML
    private Button loginButton;

    @FXML
    private Label errorLabel;

    @FXML
    void LoginAction(ActionEvent event) throws IOException, SQLException {

        ButtonAction();

    }


    void ButtonAction() throws IOException, SQLException {

        String userName = userNameText.getText();
        String password = passwordText.getText();
        UserNamePasswordCheck userNamePasswordCheck = new UserNamePasswordCheck();

        boolean isTrue = userNamePasswordCheck.Banker(userName,password);

        if (isTrue == true)
        {
            ControllerBankerPanel bankerPanel = new ControllerBankerPanel();
            bankerPanel.OpenPage();
            this.stage.close();
        }
        else
        {
            errorLabel.setText("UserName or password is wrong");
            errorLabel.setTextFill(Color.RED);
        }

    }
}
