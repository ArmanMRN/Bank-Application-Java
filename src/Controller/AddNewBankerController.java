package Controller;

import Connector.BankerDataBaseConnect;
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

public class AddNewBankerController {

    static Stage stage;
    static Parent root;

    public void OpenPage() throws IOException {

        root = FXMLLoader.load(getClass().getResource("/view/AddNewBanker.fxml"));
        stage = new Stage();
        stage.setTitle("Add Banker");
        stage.setScene(new Scene(root,600,400));
        stage.show();

    }

    @FXML
    private TextField fullNameTextField;

    @FXML
    private TextField phoneNumberTextField;

    @FXML
    private TextField addrdssTextField;

    @FXML
    private TextField userNAmeTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private Button saveButton;

    @FXML
    private Label errorLabel;

    @FXML
    void saveButtonAction(ActionEvent event) throws SQLException {

        saveButtonAction();

    }

    void saveButtonAction() throws SQLException {

        BankerDataBaseConnect bankerDataBaseConnect = new BankerDataBaseConnect();

        bankerDataBaseConnect.setFullName(fullNameTextField.getText());
        bankerDataBaseConnect.setPhoneNumber(phoneNumberTextField.getText());
        bankerDataBaseConnect.setAddress(addrdssTextField.getText());
        bankerDataBaseConnect.setUserName(userNAmeTextField.getText());
        bankerDataBaseConnect.setPassword(passwordTextField.getText());

        //bankerDataBaseConnect.CreateDataBase();
        bankerDataBaseConnect.WriteToDataBase();

        errorLabel.setText("Done");

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Done!");
        alert.show();

    }


}
