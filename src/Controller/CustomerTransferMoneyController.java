package Controller;

import Connector.DataBaseConnect;
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

public class CustomerTransferMoneyController {

    boolean isCardIDExiests = false;

    static Stage stage;
    Parent root;

    public void OpenPage() throws IOException {

        Customer.ReadData();
        stage = new Stage();

        root = FXMLLoader.load(getClass().getResource("/view/CustomerTransferMoney.fxml"));
        stage.setTitle("Customer Login Page");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();

    }


    @FXML
    private TextField cardIDTextField;

    @FXML
    private TextField amountTextField;

    @FXML
    private Button transferButton;

    @FXML
    private Label fullNameLabel;

    @FXML
    private Button checkButton;

    @FXML
    private Label errorLabel;

    @FXML
    void checkButtonAction(ActionEvent event) {
        checkButtonAction();
    }

    @FXML
    void transferButtonAction(ActionEvent event) throws SQLException {
        transferButtonAction();
    }

    void checkButtonAction(){

        String name = new DataBaseConnect().GetNameByCardID(cardIDTextField.getText());

        if (name != "Card ID not Find")
        {
            isCardIDExiests = true;
            fullNameLabel.setText(name);
        }

        else
        {
            fullNameLabel.setText("Card ID not Find");
            isCardIDExiests = false;
        }

    }


    void transferButtonAction() throws SQLException {

        if (isCardIDExiests)
        {

            double save = Double.parseDouble(amountTextField.getText());
            double balance = Customer.getBalance();

            if (balance >= save)
            {
                Customer.setBalance(balance-save);
                Customer.WriteData();

                DataBaseConnect dataBaseConnect = new DataBaseConnect();
                double userBalance = dataBaseConnect.ReadBalance(cardIDTextField.getText());
                dataBaseConnect.ChangeBalance(userBalance + save , cardIDTextField.getText());

                stage.close();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Done!");
                alert.show();
            }

            else
            {
                errorLabel.setText("your balance is not enough");
            }

        }

        else
        {
            errorLabel.setText("check cardID");
        }

    }



}
