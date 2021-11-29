package Controller;

import Model.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class CustomerChangePasswordController {

    static Stage stage;
    static Parent root;

    public void OpenPage() throws IOException, SQLException {

        Customer.ReadData();

        root = FXMLLoader.load(getClass().getResource("/view/CustomerChangePassword.fxml"));
        stage = new Stage();
        stage.setTitle("Change Password");
        stage.setScene(new Scene(root,600,400));
        stage.show();


    }


    @FXML
    private TextField passwordTextField1;

    @FXML
    private TextField passwordTextField2;

    @FXML
    private Button saveButton;

    @FXML
    private Label errorLabel;

    @FXML
    void saveButtonAction(ActionEvent event) {
        saveButtonAction();
    }

    void saveButtonAction(){

        if (passwordTextField1.getText().equals(passwordTextField2.getText()) &&
                !passwordTextField1.getText().equals(""))
        {
            Customer.setPassword(passwordTextField1.getText());
            Customer.WriteData();
            stage.close();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Done!");
            alert.show();
        }

        else
        {
            errorLabel.setText("Fields are not same");
        }

    }

}
