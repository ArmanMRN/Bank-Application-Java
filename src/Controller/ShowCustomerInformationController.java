package Controller;

import Connector.DataBaseConnect;
import Model.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class ShowCustomerInformationController {


    static Stage stage;
    static Parent root;

    public void Open() throws IOException {

        stage = new Stage();

        root = FXMLLoader.load(getClass().getResource("/view/ShowCustomerInformation.fxml"));
        stage.setTitle("Customer Information");
        stage.setScene(new Scene(root , 600 , 400));
        stage.show();

    }



    @FXML
    private Button deleteAccountButton;

    @FXML
    private Button editAccountButton;

    @FXML
    private TextField fullNameTextField;

    @FXML
    private TextField nationalIDTextField;

    @FXML
    private TextField fatherNameTextField;

    @FXML
    private TextField cardIDTextField;

    @FXML
    private TextField accountBalanceTextField;

    @FXML
    private Label label;

    @FXML
    private Button searchButton;


    @FXML
    void DeleteAccountButtonAction(ActionEvent event) throws SQLException {

        DeleteAccountButtonAction();

    }

    @FXML
    void EditAccountButtonAction(ActionEvent event) throws SQLException {

        EditAccountButtonAction();

    }

    @FXML
    void SearchButtonAction(ActionEvent event) {

        SearchButtonAction();

    }



    void SearchButtonAction (){

        DataBaseConnect dataBaseConnect = new DataBaseConnect();
        dataBaseConnect.ReadInformaiton(cardIDTextField.getText());

        fullNameTextField.setText(dataBaseConnect.getFullName());
        nationalIDTextField.setText(dataBaseConnect.GetNationalID());
        fatherNameTextField.setText(dataBaseConnect.getFatherName());
        accountBalanceTextField.setText(Double.toString(dataBaseConnect.getBalance()));

        label.setText("");
    }

    void DeleteAccountButtonAction() throws SQLException {

        new DataBaseConnect().DeleteCustomer(cardIDTextField.getText());

        label.setText("Done");

        cardIDTextField.setText("");
        fullNameTextField.setText("");
        fatherNameTextField.setText("");
        nationalIDTextField.setText("");
        accountBalanceTextField.setText("");

    }

    void EditAccountButtonAction () throws SQLException {

        String newFullName = fullNameTextField.getText();
        String newfatherName = fatherNameTextField.getText();
        String newnationalID = nationalIDTextField.getText();

        DataBaseConnect dataBaseConnect = new DataBaseConnect();
        dataBaseConnect.ReadInformaiton(cardIDTextField.getText());

        dataBaseConnect.setFullName(newFullName);
        dataBaseConnect.setNationalID(newnationalID);
        dataBaseConnect.setFatherName(newfatherName);

        dataBaseConnect.DeleteCustomer(cardIDTextField.getText());
        dataBaseConnect.WriteToDataBase();

        label.setText("Done");

        cardIDTextField.setText("");
        fullNameTextField.setText("");
        fatherNameTextField.setText("");
        nationalIDTextField.setText("");
        accountBalanceTextField.setText("");

    }

}
